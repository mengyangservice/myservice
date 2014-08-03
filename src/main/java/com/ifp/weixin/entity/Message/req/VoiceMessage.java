/*    */ package com.ifp.weixin.entity.Message.req;
/*    */ 
/*    */ public class VoiceMessage extends BaseMessage
/*    */ {
/*    */   private String MediaId;
/*    */   private String Format;
/*    */ 
/*    */   public String getMediaId()
/*    */   {
/* 20 */     return this.MediaId;
/*    */   }
/*    */ 
/*    */   public void setMediaId(String mediaId) {
/* 24 */     this.MediaId = mediaId;
/*    */   }
/*    */ 
/*    */   public String getFormat() {
/* 28 */     return this.Format;
/*    */   }
/*    */ 
/*    */   public void setFormat(String format) {
/* 32 */     this.Format = format;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.entity.Message.req.VoiceMessage
 * JD-Core Version:    0.6.2
 */