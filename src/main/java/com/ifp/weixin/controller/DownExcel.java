/*    */ package com.ifp.weixin.controller;
/*    */ 
/*    */ import com.ifp.weixin.biz.core.CoreService;
/*    */ import com.ifp.weixin.service.NewuserService;
/*    */ import com.ifp.weixin.service.UserinfoService;
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.BufferedOutputStream;
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.OutputStream;
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import javax.annotation.Resource;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/download.action"})
/*    */ public class DownExcel
/*    */ {
/*    */ 
/*    */   @Resource(name="coreService")
/*    */   private CoreService coreService;
/*    */ 
/*    */   @Resource(name="userinfoService")
/*    */   private UserinfoService userinfoService;
/*    */ 
/*    */   @Resource(name="newuserService")
/*    */   private NewuserService newuserService;
/*    */  
/*    */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public void get(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 42 */     System.out.println("begin");
/* 43 */     String name = "/upload/test.xls";
/* 44 */     this.coreService.exportExcel(request.getRealPath("/") + "/" + name);
/*    */     try
/*    */     {
/* 48 */       File file = new File(request.getRealPath("/") + "/" + name);
/*    */ 
/* 50 */       String filename = file.getName();
/*    */ 
/* 55 */       InputStream fis = new BufferedInputStream(new FileInputStream(file));
/* 56 */       byte[] buffer = new byte[fis.available()];
/* 57 */       fis.read(buffer);
/* 58 */       fis.close();
/*    */ 
/* 60 */       response.reset();
/*    */ 
/* 62 */       response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"), "ISO-8859-1"));
/* 63 */       response.addHeader("Content-Length", String.valueOf(file.length()));
/* 64 */       OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
/* 65 */       response.setContentType("application/octet-stream");
/* 66 */       toClient.write(buffer);
/* 67 */       toClient.flush();
/* 68 */       toClient.close();
/*    */     } catch (IOException ex) {
/* 70 */       ex.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/*    */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void post(HttpServletRequest request, HttpServletResponse response)
/*    */   {
/* 77 */     System.out.println("post");
/*    */     try {
/* 79 */       request.setCharacterEncoding("UTF-8");
/*    */     } catch (UnsupportedEncodingException e) {
/* 81 */       e.printStackTrace();
/*    */     }
/* 83 */     response.setCharacterEncoding("UTF-8");
/*    */ 
/* 86 */     String respMessage = this.coreService.processRequest(request);
/*    */ 
/* 89 */     PrintWriter out = null;
/*    */     try {
/* 91 */       out = response.getWriter();
/* 92 */       out.print(respMessage);
/*    */     } catch (IOException e) {
/* 94 */       e.printStackTrace();
/*    */     } finally {
/* 96 */       out.close();
/* 97 */       out = null;
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.controller.DownExcel
 * JD-Core Version:    0.6.2
 */