/*    */ package com.ifp.weixin.ORM;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Submodify
/*    */   implements Serializable
/*    */ {
/*    */   String modifyid;
/*    */   String time;
/*    */   String openid;
/*    */   String nickname;
/*    */   String type;
/*    */   String subcontent;
/*    */   String feedback;
/*    */   Integer id;
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 10 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 14 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getModifyid() {
/* 18 */     return this.modifyid;
/*    */   }
/*    */ 
/*    */   public void setModifyid(String modifyid) {
/* 22 */     this.modifyid = modifyid;
/*    */   }
/*    */ 
/*    */   public String getTime() {
/* 26 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(String time) {
/* 30 */     this.time = time;
/*    */   }
/*    */ 
/*    */   public String getOpenid() {
/* 34 */     return this.openid;
/*    */   }
/*    */ 
/*    */   public void setOpenid(String openid) {
/* 38 */     this.openid = openid;
/*    */   }
/*    */ 
/*    */   public String getNickname() {
/* 42 */     return this.nickname;
/*    */   }
/*    */ 
/*    */   public void setNickname(String nickname) {
/* 46 */     this.nickname = nickname;
/*    */   }
/*    */ 
/*    */   public String getType() {
/* 50 */     return this.type;
/*    */   }
/*    */ 
/*    */   public void setType(String type) {
/* 54 */     this.type = type;
/*    */   }
/*    */ 
/*    */   public String getSubcontent() {
/* 58 */     return this.subcontent;
/*    */   }
/*    */ 
/*    */   public void setSubcontent(String subcontent) {
/* 62 */     this.subcontent = subcontent;
/*    */   }
/*    */ 
/*    */   public String getFeedback() {
/* 66 */     return this.feedback;
/*    */   }
/*    */ 
/*    */   public void setFeedback(String feedback) {
/* 70 */     this.feedback = feedback;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.ORM.Submodify
 * JD-Core Version:    0.6.2
 */