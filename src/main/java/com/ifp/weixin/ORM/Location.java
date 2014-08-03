/*    */ package com.ifp.weixin.ORM;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Location
/*    */   implements Serializable
/*    */ {
/*    */   String openid;
/*    */   String time;
/*    */   String lon;
/*    */   String lat;
/*    */   String precise;
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
/*    */   public String getTime() {
/* 18 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(String time) {
/* 22 */     this.time = time;
/*    */   }
/*    */ 
/*    */   public String getLon() {
/* 26 */     return this.lon;
/*    */   }
/*    */ 
/*    */   public void setLon(String lon) {
/* 30 */     this.lon = lon;
/*    */   }
/*    */ 
/*    */   public String getLat() {
/* 34 */     return this.lat;
/*    */   }
/*    */ 
/*    */   public void setLat(String lat) {
/* 38 */     this.lat = lat;
/*    */   }
/*    */ 
/*    */   public String getPrecise() {
/* 42 */     return this.precise;
/*    */   }
/*    */ 
/*    */   public void setPrecise(String precise) {
/* 46 */     this.precise = precise;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Location
 * JD-Core Version:    0.6.2
 */