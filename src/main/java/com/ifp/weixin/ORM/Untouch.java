/*    */ package com.ifp.weixin.ORM;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Untouch
/*    */   implements Serializable
/*    */ {
/*    */   String openid;
/*    */   String customerid;
/*    */   String time;
/*    */ 
/*    */   public String getOpenid()
/*    */   {
/* 10 */     return this.openid;
/*    */   }
/*    */ 
/*    */   public void setOpenid(String openid) {
/* 14 */     this.openid = openid;
/*    */   }
/*    */ 
/*    */   public String getCustomerid() {
/* 18 */     return this.customerid;
/*    */   }
/*    */ 
/*    */   public void setCustomerid(String customerid) {
/* 22 */     this.customerid = customerid;
/*    */   }
/*    */ 
/*    */   public String getTime() {
/* 26 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(String time) {
/* 30 */     this.time = time;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Untouch
 * JD-Core Version:    0.6.2
 */