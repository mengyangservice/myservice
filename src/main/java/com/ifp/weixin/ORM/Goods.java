/*     */ package com.ifp.weixin.ORM;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Goods
/*     */   implements Serializable
/*     */ {
/*     */   String goodid;
/*     */   String name;
/*     */   String type;
/*     */   String ditype;
/*     */   String weight;
/*     */   String price;
/*     */   String totalprice;
/*     */   String figure;
/*     */   String surface;
/*     */   String color;
/*     */   String clear;
/*     */   String certification;
/*     */   String handle;
/*     */   String productaddr;
/*     */   String keepaddr;
/*     */   String saletype;
/*     */   String pic1;
/*     */   String pic2;
/*     */   String pic3;
/*     */   String pic4;
/*     */   String pic5;
/*     */   String material;
/*     */   String owner;
/*     */   String minitype;
/*     */   String miniweight;
/*     */   String goldweight;
/*     */   private Integer id;
/*     */ 
/*     */   public String getMinitype()
/*     */   {
/*  11 */     return this.minitype;
/*     */   }
/*     */ 
/*     */   public void setMinitype(String minitype) {
/*  15 */     this.minitype = minitype;
/*     */   }
/*     */ 
/*     */   public String getMiniweight() {
/*  19 */     return this.miniweight;
/*     */   }
/*     */ 
/*     */   public void setMiniweight(String miniweight) {
/*  23 */     this.miniweight = miniweight;
/*     */   }
/*     */ 
/*     */   public String getGoldweight() {
/*  27 */     return this.goldweight;
/*     */   }
/*     */ 
/*     */   public void setGoldweight(String goldweight) {
/*  31 */     this.goldweight = goldweight;
/*     */   }
/*     */ 
/*     */   public String getDitype() {
/*  35 */     return this.ditype;
/*     */   }
/*     */ 
/*     */   public void setDitype(String ditype) {
/*  39 */     this.ditype = ditype;
/*     */   }
/*     */ 
/*     */   public String getMaterial() {
/*  43 */     return this.material;
/*     */   }
/*     */ 
/*     */   public void setMaterial(String material) {
/*  47 */     this.material = material;
/*     */   }
/*     */ 
/*     */   public String getOwner() {
/*  51 */     return this.owner;
/*     */   }
/*     */ 
/*     */   public void setOwner(String owner) {
/*  55 */     this.owner = owner;
/*     */   }
/*     */ 
/*     */   public String getGoodid()
/*     */   {
/*  61 */     return this.goodid;
/*     */   }
/*     */ 
/*     */   public void setGoodid(String goodid) {
/*  65 */     this.goodid = goodid;
/*     */   }
/*     */ 
/*     */   public String getName() {
/*  69 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String name) {
/*  73 */     this.name = name;
/*     */   }
/*     */ 
/*     */   public String getType() {
/*  77 */     return this.type;
/*     */   }
/*     */ 
/*     */   public void setType(String type) {
/*  81 */     this.type = type;
/*     */   }
/*     */ 
/*     */   public String getWeight() {
/*  85 */     return this.weight;
/*     */   }
/*     */ 
/*     */   public void setWeight(String weight) {
/*  89 */     this.weight = weight;
/*     */   }
/*     */ 
/*     */   public String getPrice() {
/*  93 */     return this.price;
/*     */   }
/*     */ 
/*     */   public void setPrice(String price) {
/*  97 */     this.price = price;
/*     */   }
/*     */ 
/*     */   public String getTotalprice() {
/* 101 */     return this.totalprice;
/*     */   }
/*     */ 
/*     */   public void setTotalprice(String totalprice) {
/* 105 */     this.totalprice = totalprice;
/*     */   }
/*     */ 
/*     */   public String getFigure() {
/* 109 */     return this.figure;
/*     */   }
/*     */ 
/*     */   public void setFigure(String figure) {
/* 113 */     this.figure = figure;
/*     */   }
/*     */ 
/*     */   public String getSurface() {
/* 117 */     return this.surface;
/*     */   }
/*     */ 
/*     */   public void setSurface(String surface) {
/* 121 */     this.surface = surface;
/*     */   }
/*     */ 
/*     */   public String getColor() {
/* 125 */     return this.color;
/*     */   }
/*     */ 
/*     */   public void setColor(String color) {
/* 129 */     this.color = color;
/*     */   }
/*     */ 
/*     */   public String getClear() {
/* 133 */     return this.clear;
/*     */   }
/*     */ 
/*     */   public void setClear(String clear) {
/* 137 */     this.clear = clear;
/*     */   }
/*     */ 
/*     */   public String getCertification() {
/* 141 */     return this.certification;
/*     */   }
/*     */ 
/*     */   public void setCertification(String certification) {
/* 145 */     this.certification = certification;
/*     */   }
/*     */ 
/*     */   public String getHandle() {
/* 149 */     return this.handle;
/*     */   }
/*     */ 
/*     */   public void setHandle(String handle) {
/* 153 */     this.handle = handle;
/*     */   }
/*     */ 
/*     */   public String getProductaddr() {
/* 157 */     return this.productaddr;
/*     */   }
/*     */ 
/*     */   public void setProductaddr(String productaddr) {
/* 161 */     this.productaddr = productaddr;
/*     */   }
/*     */ 
/*     */   public String getKeepaddr() {
/* 165 */     return this.keepaddr;
/*     */   }
/*     */ 
/*     */   public void setKeepaddr(String keepaddr) {
/* 169 */     this.keepaddr = keepaddr;
/*     */   }
/*     */ 
/*     */   public String getSaletype() {
/* 173 */     return this.saletype;
/*     */   }
/*     */ 
/*     */   public void setSaletype(String saletype) {
/* 177 */     this.saletype = saletype;
/*     */   }
/*     */ 
/*     */   public String getPic1() {
/* 181 */     return this.pic1;
/*     */   }
/*     */ 
/*     */   public void setPic1(String pic1) {
/* 185 */     this.pic1 = pic1;
/*     */   }
/*     */ 
/*     */   public String getPic2() {
/* 189 */     return this.pic2;
/*     */   }
/*     */ 
/*     */   public void setPic2(String pic2) {
/* 193 */     this.pic2 = pic2;
/*     */   }
/*     */ 
/*     */   public String getPic3() {
/* 197 */     return this.pic3;
/*     */   }
/*     */ 
/*     */   public void setPic3(String pic3) {
/* 201 */     this.pic3 = pic3;
/*     */   }
/*     */ 
/*     */   public String getPic4() {
/* 205 */     return this.pic4;
/*     */   }
/*     */ 
/*     */   public void setPic4(String pic4) {
/* 209 */     this.pic4 = pic4;
/*     */   }
/*     */ 
/*     */   public String getPic5() {
/* 213 */     return this.pic5;
/*     */   }
/*     */ 
/*     */   public void setPic5(String pic5) {
/* 217 */     this.pic5 = pic5;
/*     */   }
/*     */ 
/*     */   public Integer getId() {
/* 221 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(Integer id) {
/* 225 */     this.id = id;
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Goods
 * JD-Core Version:    0.6.2
 */