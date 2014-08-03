/*    */ package com.ifp.weixin.entity.Message.req;
/*    */ 
/*    */ public class BaseMessage
/*    */ {
/*    */   private String ToUserName;
/*    */   private String FromUserName;
/*    */   private long CreateTime;
/*    */   private String MsgType;
/*    */   private long MsgId;
/*    */ 
/*    */   public String getToUserName()
/*    */   {
/* 28 */     return this.ToUserName;
/*    */   }
/*    */ 
/*    */   public void setToUserName(String toUserName) {
/* 32 */     this.ToUserName = toUserName;
/*    */   }
/*    */ 
/*    */   public String getFromUserName() {
/* 36 */     return this.FromUserName;
/*    */   }
/*    */ 
/*    */   public void setFromUserName(String fromUserName) {
/* 40 */     this.FromUserName = fromUserName;
/*    */   }
/*    */ 
/*    */   public long getCreateTime() {
/* 44 */     return this.CreateTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(long createTime) {
/* 48 */     this.CreateTime = createTime;
/*    */   }
/*    */ 
/*    */   public String getMsgType() {
/* 52 */     return this.MsgType;
/*    */   }
/*    */ 
/*    */   public void setMsgType(String msgType) {
/* 56 */     this.MsgType = msgType;
/*    */   }
/*    */ 
/*    */   public long getMsgId() {
/* 60 */     return this.MsgId;
/*    */   }
/*    */ 
/*    */   public void setMsgId(long msgId) {
/* 64 */     this.MsgId = msgId;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.entity.Message.req.BaseMessage
 * JD-Core Version:    0.6.2
 */