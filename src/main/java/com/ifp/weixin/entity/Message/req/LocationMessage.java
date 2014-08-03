/*    */ package com.ifp.weixin.entity.Message.req;
/*    */ 
/*    */ public class LocationMessage extends BaseMessage
/*    */ {
/*    */   private String Location_X;
/*    */   private String Location_Y;
/*    */   private String Scale;
/*    */   private String Label;
/*    */ 
/*    */   public String getLocation_X()
/*    */   {
/* 30 */     return this.Location_X;
/*    */   }
/*    */ 
/*    */   public void setLocation_X(String location_X) {
/* 34 */     this.Location_X = location_X;
/*    */   }
/*    */ 
/*    */   public String getLocation_Y() {
/* 38 */     return this.Location_Y;
/*    */   }
/*    */ 
/*    */   public void setLocation_Y(String location_Y) {
/* 42 */     this.Location_Y = location_Y;
/*    */   }
/*    */ 
/*    */   public String getScale() {
/* 46 */     return this.Scale;
/*    */   }
/*    */ 
/*    */   public void setScale(String scale) {
/* 50 */     this.Scale = scale;
/*    */   }
/*    */ 
/*    */   public String getLabel() {
/* 54 */     return this.Label;
/*    */   }
/*    */ 
/*    */   public void setLabel(String label) {
/* 58 */     this.Label = label;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.entity.Message.req.LocationMessage
 * JD-Core Version:    0.6.2
 */