/*     */ package com.ifp.weixin.ORM;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Orders
/*     */   implements Serializable
/*     */ {
/*     */   String orderid;
/*     */   String orderdesc;
/*     */   String customerid;
/*     */   String goodsid;
/*     */   String price;
/*     */   String priceoff;
/*     */   String pay;
/*     */   String nopay;
/*     */   String status;
/*     */   String orderdata;
/*     */   String isimbed;
/*     */   String imbedstyleid;
/*     */   String imbedtaskid;
/*     */   String imbedsize;
/*     */   String imbedcolor;
/*     */   String imbedtype1;
/*     */   String imbedtype2;
/*     */   String imbedurgent;
/*     */   String imbedmax;
/*     */   String pic1;
/*     */   String pic2;
/*     */   String saler;
/*     */   Integer id;
/*     */ 
/*     */   public String getSaler()
/*     */   {
/*  10 */     return this.saler;
/*     */   }
/*     */ 
/*     */   public void setSaler(String saler) {
/*  14 */     this.saler = saler;
/*     */   }
/*     */ 
/*     */   public Integer getId() {
/*  18 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/*  22 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getOrderid() {
/*  26 */     return this.orderid;
/*     */   }
/*     */ 
/*     */   public void setOrderid(String orderid) {
/*  30 */     this.orderid = orderid;
/*     */   }
/*     */ 
/*     */   public String getOrderdesc() {
/*  34 */     return this.orderdesc;
/*     */   }
/*     */ 
/*     */   public void setOrderdesc(String orderdesc) {
/*  38 */     this.orderdesc = orderdesc;
/*     */   }
/*     */ 
/*     */   public String getCustomerid() {
/*  42 */     return this.customerid;
/*     */   }
/*     */ 
/*     */   public void setCustomerid(String customerid) {
/*  46 */     this.customerid = customerid;
/*     */   }
/*     */ 
/*     */   public String getGoodsid() {
/*  50 */     return this.goodsid;
/*     */   }
/*     */ 
/*     */   public void setGoodsid(String goodsid) {
/*  54 */     this.goodsid = goodsid;
/*     */   }
/*     */ 
/*     */   public String getPrice() {
/*  58 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(String price) {
/*  62 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getPriceoff() {
/*  66 */     return this.priceoff;
/*     */   }
/*     */ 
/*     */   public void setPriceoff(String priceoff) {
/*  70 */     this.priceoff = priceoff;
/*     */   }
/*     */ 
/*     */   public String getPay() {
/*  74 */     return this.pay;
/*     */   }
/*     */ 
/*     */   public void setPay(String pay) {
/*  78 */     this.pay = pay;
/*     */   }
/*     */ 
/*     */   public String getNopay() {
/*  82 */     return this.nopay;
/*     */   }
/*     */ 
/*     */   public void setNopay(String nopay) {
/*  86 */     this.nopay = nopay;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  90 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  94 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public String getOrderdata() {
/*  98 */     return this.orderdata;
/*     */   }
/*     */ 
/*     */   public void setOrderdata(String orderdata) {
/* 102 */     this.orderdata = orderdata;
/*     */   }
/*     */ 
/*     */   public String getIsimbed() {
/* 106 */     return this.isimbed;
/*     */   }
/*     */ 
/*     */   public void setIsimbed(String isimbed) {
/* 110 */     this.isimbed = isimbed;
/*     */   }
/*     */ 
/*     */   public String getImbedstyleid() {
/* 114 */     return this.imbedstyleid;
/*     */   }
/*     */ 
/*     */   public void setImbedstyleid(String imbedstyleid) {
/* 118 */     this.imbedstyleid = imbedstyleid;
/*     */   }
/*     */ 
/*     */   public String getImbedtaskid() {
/* 122 */     return this.imbedtaskid;
/*     */   }
/*     */ 
/*     */   public void setImbedtaskid(String imbedtaskid) {
/* 126 */     this.imbedtaskid = imbedtaskid;
/*     */   }
/*     */ 
/*     */   public String getImbedsize() {
/* 130 */     return this.imbedsize;
/*     */   }
/*     */ 
/*     */   public void setImbedsize(String imbedsize) {
/* 134 */     this.imbedsize = imbedsize;
/*     */   }
/*     */ 
/*     */   public String getImbedcolor() {
/* 138 */     return this.imbedcolor;
/*     */   }
/*     */ 
/*     */   public void setImbedcolor(String imbedcolor) {
/* 142 */     this.imbedcolor = imbedcolor;
/*     */   }
/*     */ 
/*     */   public String getImbedtype1() {
/* 146 */     return this.imbedtype1;
/*     */   }
/*     */ 
/*     */   public void setImbedtype1(String imbedtype1) {
/* 150 */     this.imbedtype1 = imbedtype1;
/*     */   }
/*     */ 
/*     */   public String getImbedtype2() {
/* 154 */     return this.imbedtype2;
/*     */   }
/*     */ 
/*     */   public void setImbedtype2(String imbedtype2) {
/* 158 */     this.imbedtype2 = imbedtype2;
/*     */   }
/*     */ 
/*     */   public String getImbedurgent() {
/* 162 */     return this.imbedurgent;
/*     */   }
/*     */ 
/*     */   public void setImbedurgent(String imbedurgent) {
/* 166 */     this.imbedurgent = imbedurgent;
/*     */   }
/*     */ 
/*     */   public String getImbedmax() {
/* 170 */     return this.imbedmax;
/*     */   }
/*     */ 
/*     */   public void setImbedmax(String imbedmax) {
/* 174 */     this.imbedmax = imbedmax;
/*     */   }
/*     */ 
/*     */   public String getPic1() {
/* 178 */     return this.pic1;
/*     */   }
/*     */ 
/*     */   public void setPic1(String pic1) {
/* 182 */     this.pic1 = pic1;
/*     */   }
/*     */ 
/*     */   public String getPic2() {
/* 186 */     return this.pic2;
/*     */   }
/*     */ 
/*     */   public void setPic2(String pic2) {
/* 190 */     this.pic2 = pic2;
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Orders
 * JD-Core Version:    0.6.2
 */