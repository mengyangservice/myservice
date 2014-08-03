/*     */ package com.ifp.weixin.controller;
/*     */ 
/*     */ import com.ifp.weixin.DAO.BaseDAO;
/*     */ import com.ifp.weixin.biz.core.CoreService;
/*     */ import com.ifp.weixin.service.NewuserService;
/*     */ import com.ifp.weixin.service.UserinfoService;
/*     */ import com.ifp.weixin.util.ReadExcel001;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.fileupload.FileItem;
/*     */ import org.apache.commons.fileupload.disk.DiskFileItemFactory;
/*     */ import org.apache.commons.fileupload.servlet.ServletFileUpload;
/*     */ import org.apache.tools.zip.ZipEntry;
/*     */ import org.apache.tools.zip.ZipFile;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/processUpload.action"})
/*     */ public class ProcessUpload
/*     */ {
/*     */ 
/*     */   @Resource(name="coreService")
/*     */   private CoreService coreService;
/*     */ 
/*     */   @Resource(name="userinfoService")
/*     */   private UserinfoService userinfoService;
/*     */ 
/*     */   @Resource(name="newuserService")
/*     */   private NewuserService newuserService;
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void get(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  42 */     post(request, response);
/*     */   }
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void post(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/*  49 */     System.out.println("I am a serlvet to process upload!!!");
/*     */     try
/*     */     {
/*  53 */       request.setCharacterEncoding("UTF-8");
/*     */     }
/*     */     catch (UnsupportedEncodingException e1) {
/*  56 */       e1.printStackTrace();
/*     */     }
/*     */ 
/*  60 */     DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
/*     */ 
/*  63 */     String path = request.getRealPath("/upload");
/*  64 */     System.out.println("path : " + path);
/*     */ 
/*  66 */     new File(path).mkdir();
/*     */ 
/*  72 */     diskFileItemFactory.setRepository(new File(path));
/*     */ 
/*  74 */     diskFileItemFactory.setSizeThreshold(1048576);
/*     */ 
/*  77 */     ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
/*     */     try
/*     */     {
/*  81 */       List<FileItem> list = upload.parseRequest(request);
/*     */ 
/*  83 */       for (FileItem item : list)
/*     */       {
/*  86 */         String name = item.getFieldName();
/*     */ 
/*  89 */         if (item.isFormField())
/*     */         {
/*  91 */           String value = item.getString();
/*  92 */           System.out.println(name + "=" + value);
/*     */         }
/*     */         else
/*     */         {
/*  98 */           String value = item.getName();
/*  99 */           int start = value.lastIndexOf("\\");
/* 100 */           String filename = value.substring(start + 1);
/*     */ 
/* 102 */           System.out.println(name + "=" + value);
/*     */ 
/* 104 */           File file = null;
/*     */           do
/*     */           {
/* 107 */             start = filename.lastIndexOf(".");
/* 108 */             filename = filename.substring(0, start) + 
/* 109 */               UUID.randomUUID().toString() + 
/* 110 */               filename.substring(start);
/* 111 */             file = new File(path, filename);
/* 112 */           }while (file.exists());
/*     */ 
/* 114 */           System.out.println("filename=" + filename);
/*     */ 
/* 119 */           item.write(file);
/*     */ 
/* 121 */           System.out.println("the upload file's size:" + item.getSize());
/* 122 */           if (filename.indexOf(".xlsx") >= 0)
/*     */           {
/* 124 */             BaseDAO dao = this.userinfoService.getMyDao();
/* 125 */             ReadExcel001.readXml(file.getAbsolutePath(), dao);
/*     */           }
/* 127 */           if (filename.indexOf(".zip") >= 0)
/*     */           {
/* 129 */             unZipFiles(new File(file.getAbsolutePath()), request.getRealPath("/upload"));
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 141 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static void unZipFiles(File zipFile, String descDir)
/*     */     throws IOException
/*     */   {
/* 148 */     File pathFile = new File(descDir);
/* 149 */     if (!pathFile.exists()) {
/* 150 */       pathFile.mkdirs();
/*     */     }
/* 152 */     ZipFile zip = new ZipFile(zipFile);
/* 153 */     for (Enumeration entries = zip.getEntries(); entries.hasMoreElements(); ) {
/* 154 */       ZipEntry entry = (ZipEntry)entries.nextElement();
/* 155 */       String zipEntryName = entry.getName();
/* 156 */       InputStream in = zip.getInputStream(entry);
/* 157 */       String outPath = (descDir + File.separator + zipEntryName).replaceAll("\\*", File.separator);
/*     */ 
/* 160 */       File file = new File(outPath.substring(0, outPath.lastIndexOf(File.separator)));
/* 161 */       if (!file.exists()) {
/* 162 */         file.mkdirs();
/*     */       }
/*     */ 
/* 165 */       if (!new File(outPath).isDirectory())
/*     */       {
/* 169 */         System.out.println(outPath);
/*     */ 
/* 171 */         OutputStream out = new FileOutputStream(outPath);
/* 172 */         byte[] buf1 = new byte[1024];
/*     */         int len;
/* 174 */         while ((len = in.read(buf1)) > 0)
/*     */         {
/* 175 */           out.write(buf1, 0, len);
/*     */         }
/* 177 */         in.close();
/* 178 */         out.close();
/*     */       }
/*     */     }
/* 180 */     System.out.println("******************解压完毕********************");
/*     */   }
/*     */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.controller.ProcessUpload
 * JD-Core Version:    0.6.2
 */