/*     */ package com.ifp.weixin.controller;
/*     */ 
/*     */ import com.ifp.weixin.ORM.Userinfo;
/*     */ import com.ifp.weixin.biz.core.CoreService;
/*     */ import com.ifp.weixin.service.TasksService;
/*     */ import com.ifp.weixin.service.UserinfoService;
/*     */ import com.ifp.weixin.util.HttpPostUtils;
/*     */ import com.ifp.weixin.util.MD5;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import net.sf.json.JSONObject;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/ordergoods.action"})
/*     */ public class OrderGoods
/*     */ {
/*     */ 
/*     */   @Resource(name="coreService")
/*     */   private CoreService coreService;
/*     */ 
/*     */   @Resource(name="userinfoService")
/*     */   private UserinfoService userinfoService;
/*     */ 
/*     */   @Resource(name="tasksService")
/*     */   private TasksService tasksService;
/*     */ 
/*     */   public void sendTxt(String openid, String txt)
/*     */   {
/*  57 */     JSONObject scene = new JSONObject();
/*     */ 
/*  59 */     JSONObject content = new JSONObject();
/*  60 */     String token = this.coreService.getAccessToken("wx6cd8ba6f1933a62b", "1a8b831f4e4502ffccd16f6eec41c5df");
/*     */     try
/*     */     {
/*  64 */       scene.element("touser", openid);
/*     */ 
/*  66 */       scene.element("msgtype", "text");
/*     */ 
/*  68 */       content.element("content", new String(txt.getBytes(), "UTF-8"));
/*  69 */       scene.element("text", content);
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/*  72 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  78 */     String posturl = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + URLEncoder.encode(token);
/*     */ 
/*  80 */     String reJson = HttpPostUtils.httpsPostJson(posturl, scene);
/*     */   }
/*     */ 
/*     */   public static String isCharsetName(String txt) {
/*  84 */     Map<String, Charset> charsets = Charset.availableCharsets();
/*  85 */     for (Map.Entry entry : charsets.entrySet()) {
/*     */       try
/*     */       {
/*  88 */         String pTxt = new String(txt.getBytes((String)entry.getKey()));
/*  89 */         System.out.println(pTxt + "," + (String)entry.getKey());
/*     */       }
/*     */       catch (UnsupportedEncodingException e) {
/*  92 */         e.printStackTrace();
/*     */       }
/*     */ 
/*     */     }
/*     */ 
/*  98 */     return "";
/*     */   }
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void get(HttpServletRequest request, HttpServletResponse response) {
/* 103 */     System.out.println("begin");
/*     */ 
/* 105 */     String openid = request.getParameter("openid");
/* 106 */     String handleid = request.getParameter("handleid");
/* 107 */     String goodid = request.getParameter("goodid");
/*     */ 
/* 109 */     String msg = "用户openid为" + openid + "订购商品" + goodid;
/*     */ 
/* 111 */     sendTxt(handleid, msg);
/* 112 */     msg = "订购商品" + goodid + "成功!";
/*     */ 
/* 114 */     sendTxt(openid, msg);
/*     */ 
/* 120 */     Userinfo user = this.userinfoService.loadUserinfoByuserid(handleid);
/* 121 */     System.out.println(handleid);
/*     */ 
/* 123 */     long thetime = System.currentTimeMillis();
/* 124 */     String pwd = "password_" + thetime + "_topsky";
/* 125 */     String[] para = new String[5];
/* 126 */     para[0] = "cpid=259";
/* 127 */     para[1] = ("password=" + MD5.MD5Encode(pwd));
/* 128 */     para[2] = ("timestamp=" + thetime);
/* 129 */     para[3] = ("msg=用户openid为" + openid + "订购商品" + goodid);
/* 130 */     para[4] = ("tele=" + user.getPhone1());
/*     */ 
/* 133 */     String posturlsms = "http://admin.sms9.net/houtai/sms.php";
/*     */ 
/* 136 */     String sms = HttpPostUtils.httpGet(posturlsms, para);
/* 137 */     System.out.println("json=" + sms);
/*     */   }
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void post(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 149 */     System.out.println("post");
/*     */     try {
/* 151 */       request.setCharacterEncoding("UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/* 153 */       e.printStackTrace();
/*     */     }
/* 155 */     response.setCharacterEncoding("UTF-8");
/*     */ 
/* 158 */     String respMessage = this.coreService.processRequest(request);
/*     */ 
/* 161 */     PrintWriter out = null;
/*     */     try {
/* 163 */       out = response.getWriter();
/* 164 */       out.print(respMessage);
/*     */     } catch (IOException e) {
/* 166 */       e.printStackTrace();
/*     */     } finally {
/* 168 */       out.close();
/* 169 */       out = null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.controller.OrderGoods
 * JD-Core Version:    0.6.2
 */