/*    */ package com.ifp.weixin.entity.Message.req;
/*    */ 
/*    */ public class LinkMessage extends BaseMessage
/*    */ {
/*    */   private String Title;
/*    */   private String Description;
/*    */   private String Url;
/*    */ 
/*    */   public String getTitle()
/*    */   {
/* 18 */     return this.Title;
/*    */   }
/*    */ 
/*    */   public void setTitle(String title) {
/* 22 */     this.Title = title;
/*    */   }
/*    */ 
/*    */   public String getDescription() {
/* 26 */     return this.Description;
/*    */   }
/*    */ 
/*    */   public void setDescription(String description) {
/* 30 */     this.Description = description;
/*    */   }
/*    */ 
/*    */   public String getUrl() {
/* 34 */     return this.Url;
/*    */   }
/*    */ 
/*    */   public void setUrl(String url) {
/* 38 */     this.Url = url;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.entity.Message.req.LinkMessage
 * JD-Core Version:    0.6.2
 */