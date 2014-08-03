/*    */ package com.ifp.weixin.controller;
/*    */ 
/*    */ import com.ifp.weixin.biz.core.CoreService;
/*    */ import com.ifp.weixin.service.NewuserService;
/*    */ import com.ifp.weixin.service.UserinfoService;
/*    */ import com.ifp.weixin.util.SignUtil;
/*    */ import java.io.IOException;
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
/*    */ @RequestMapping({"/weixinCore.action"})
/*    */ public class WeixinController
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
/* 36 */     System.out.println("begin");
/*    */ 
/* 40 */     String signature = request.getParameter("signature");
/*    */ 
/* 42 */     String timestamp = request.getParameter("timestamp");
/*    */ 
/* 44 */     String nonce = request.getParameter("nonce");
/*    */ 
/* 46 */     String echostr = request.getParameter("echostr");
/*    */ 
/* 48 */     PrintWriter out = null;
/*    */     try {
/* 50 */       out = response.getWriter();
/*    */ 
/* 52 */       if (SignUtil.checkSignature(signature, timestamp, nonce).booleanValue())
/* 53 */         out.print(echostr);
/*    */     }
/*    */     catch (IOException e) {
/* 56 */       e.printStackTrace();
/*    */     } finally {
/* 58 */       out.close();
/* 59 */       out = null;
/*    */     }
/*    */   }
/*    */ 
/*    */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void post(HttpServletRequest request, HttpServletResponse response) {
/* 65 */     System.out.println("post");
/*    */     try {
/* 67 */       request.setCharacterEncoding("UTF-8");
/*    */     } catch (UnsupportedEncodingException e) {
/* 69 */       e.printStackTrace();
/*    */     }
/* 71 */     response.setCharacterEncoding("UTF-8");
/*    */ 
/* 74 */     String respMessage = this.coreService.processRequest(request);
/*    */ 
/* 77 */     PrintWriter out = null;
/*    */     try {
/* 79 */       out = response.getWriter();
/* 80 */       out.print(respMessage);
/*    */     } catch (IOException e) {
/* 82 */       e.printStackTrace();
/*    */     } finally {
/* 84 */       out.close();
/* 85 */       out = null;
/*    */     }
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.controller.WeixinController
 * JD-Core Version:    0.6.2
 */