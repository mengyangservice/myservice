/*    */ package com.ifp.weixin.entity.Message.resp;
/*    */ 
/*    */ public class BaseMessage
/*    */ {
/*    */   private String ToUserName;
/*    */   private String FromUserName;
/*    */   private long CreateTime;
/*    */   private String MsgType;
/*    */   private int FuncFlag;
/*    */ 
/*    */   public String getToUserName()
/*    */   {
/* 32 */     return this.ToUserName;
/*    */   }
/*    */ 
/*    */   public void setToUserName(String toUserName) {
/* 36 */     this.ToUserName = toUserName;
/*    */   }
/*    */ 
/*    */   public String getFromUserName() {
/* 40 */     return this.FromUserName;
/*    */   }
/*    */ 
/*    */   public void setFromUserName(String fromUserName) {
/* 44 */     this.FromUserName = fromUserName;
/*    */   }
/*    */ 
/*    */   public long getCreateTime() {
/* 48 */     return this.CreateTime;
/*    */   }
/*    */ 
/*    */   public void setCreateTime(long createTime) {
/* 52 */     this.CreateTime = createTime;
/*    */   }
/*    */ 
/*    */   public String getMsgType() {
/* 56 */     return this.MsgType;
/*    */   }
/*    */ 
/*    */   public void setMsgType(String msgType) {
/* 60 */     this.MsgType = msgType;
/*    */   }
/*    */ 
/*    */   public int getFuncFlag() {
/* 64 */     return this.FuncFlag;
/*    */   }
/*    */ 
/*    */   public void setFuncFlag(int funcFlag) {
/* 68 */     this.FuncFlag = funcFlag;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.entity.Message.resp.BaseMessage
 * JD-Core Version:    0.6.2
 */