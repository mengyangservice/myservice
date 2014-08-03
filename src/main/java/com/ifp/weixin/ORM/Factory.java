/*    */ package com.ifp.weixin.ORM;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Factory
/*    */   implements Serializable
/*    */ {
/*    */   String factoryid;
/*    */   String serlevel;
/*    */   String name;
/*    */   String address;
/*    */   String contact;
/*    */   String phone1;
/*    */   String phone2;
/*    */   String weixin;
/*    */   String qq;
/*    */   String ww;
/*    */   Integer id;
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 11 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 15 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getFactoryid() {
/* 19 */     return this.factoryid;
/*    */   }
/*    */ 
/*    */   public void setFactoryid(String factoryid) {
/* 23 */     this.factoryid = factoryid;
/*    */   }
/*    */ 
/*    */   public String getSerlevel() {
/* 27 */     return this.serlevel;
/*    */   }
/*    */ 
/*    */   public void setSerlevel(String serlevel) {
/* 31 */     this.serlevel = serlevel;
/*    */   }
/*    */ 
/*    */   public String getName() {
/* 35 */     return this.name;
/*    */   }
/*    */ 
/*    */   public void setName(String name) {
/* 39 */     this.name = name;
/*    */   }
/*    */ 
/*    */   public String getAddress() {
/* 43 */     return this.address;
/*    */   }
/*    */ 
/*    */   public void setAddress(String address) {
/* 47 */     this.address = address;
/*    */   }
/*    */ 
/*    */   public String getContact() {
/* 51 */     return this.contact;
/*    */   }
/*    */ 
/*    */   public void setContact(String contact) {
/* 55 */     this.contact = contact;
/*    */   }
/*    */ 
/*    */   public String getPhone1() {
/* 59 */     return this.phone1;
/*    */   }
/*    */ 
/*    */   public void setPhone1(String phone1) {
/* 63 */     this.phone1 = phone1;
/*    */   }
/*    */ 
/*    */   public String getPhone2() {
/* 67 */     return this.phone2;
/*    */   }
/*    */ 
/*    */   public void setPhone2(String phone2) {
/* 71 */     this.phone2 = phone2;
/*    */   }
/*    */ 
/*    */   public String getWeixin() {
/* 75 */     return this.weixin;
/*    */   }
/*    */ 
/*    */   public void setWeixin(String weixin) {
/* 79 */     this.weixin = weixin;
/*    */   }
/*    */ 
/*    */   public String getQq() {
/* 83 */     return this.qq;
/*    */   }
/*    */ 
/*    */   public void setQq(String qq) {
/* 87 */     this.qq = qq;
/*    */   }
/*    */ 
/*    */   public String getWw() {
/* 91 */     return this.ww;
/*    */   }
/*    */ 
/*    */   public void setWw(String ww) {
/* 95 */     this.ww = ww;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Factory
 * JD-Core Version:    0.6.2
 */