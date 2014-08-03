/*    */ package com.ifp.weixin.entity.Message.resp;
/*    */ 
/*    */ public class Article
/*    */ {
/*    */   private String Title;
/*    */   private String Description;
/*    */   private String PicUrl;
/*    */   private String Url;
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 30 */     return this.Title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 34 */     this.Title = title;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 38 */     return this.Description == null ? "" : this.Description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 42 */     this.Description = description;
/*    */   }
/*    */ 
/*    */   public String getPicUrl() {
/* 46 */     return this.PicUrl == null ? "" : this.PicUrl;
/*    */   }
/*    */ 
/*    */   public void setPicUrl(String picUrl) {
/* 50 */     this.PicUrl = picUrl;
/*    */   }
/*    */ 
/*    */   public String getUrl() {
/* 54 */     return this.Url == null ? "" : this.Url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url) {
/* 58 */     this.Url = url;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.entity.Message.resp.Article
 * JD-Core Version:    0.6.2
 */