/*     */ package com.ifp.weixin.ORM;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Newuser
/*     */   implements Serializable
/*     */ {
/*     */   String userid;
/*     */   String openid;
/*     */   String name;
/*     */   String nickname;
/*     */   String state1;
/*     */   String sex;
/*     */   String age;
/*     */   String state2;
/*     */   String province;
/*     */   String city;
/*     */   String type;
/*     */   String level;
/*     */   String priceoff;
/*     */   String phone1;
/*     */   String phone2;
/*     */   String weixin;
/*     */   String qq;
/*     */   String ww;
/*     */   String address;
/*     */   String buygoods;
/*     */   String buyprice;
/*     */   String score;
/*     */   String damondlike;
/*     */   String lifelike;
/*     */   String recommanderid;
/*     */   String recommander;
/*     */   Integer id;
/*     */ 
/*     */   public String getRecommanderid()
/*     */   {
/*  12 */     return this.recommanderid;
/*     */   }
/*     */   public void setRecommanderid(String recommanderid) {
/*  15 */     this.recommanderid = recommanderid;
/*     */   }
/*     */ 
/*     */   public String getUserid() {
/*  19 */     return this.userid;
/*     */   }
/*     */   public void setUserid(String userid) {
/*  22 */     this.userid = userid;
/*     */   }
/*     */   public String getOpenid() {
/*  25 */     return this.openid;
/*     */   }
/*     */   public void setOpenid(String openid) {
/*  28 */     this.openid = openid;
/*     */   }
/*     */   public String getName() {
/*  31 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/*  34 */     this.name = name;
/*     */   }
/*     */   public String getNickname() {
/*  37 */     return this.nickname;
/*     */   }
/*     */   public void setNickname(String nickname) {
/*  40 */     this.nickname = nickname;
/*     */   }
/*     */   public String getState1() {
/*  43 */     return this.state1;
/*     */   }
/*     */   public void setState1(String state1) {
/*  46 */     this.state1 = state1;
/*     */   }
/*     */   public String getSex() {
/*  49 */     return this.sex;
/*     */   }
/*     */   public void setSex(String sex) {
/*  52 */     this.sex = sex;
/*     */   }
/*     */   public String getAge() {
/*  55 */     return this.age;
/*     */   }
/*     */   public void setAge(String age) {
/*  58 */     this.age = age;
/*     */   }
/*     */   public String getState2() {
/*  61 */     return this.state2;
/*     */   }
/*     */   public void setState2(String state2) {
/*  64 */     this.state2 = state2;
/*     */   }
/*     */   public String getProvince() {
/*  67 */     return this.province;
/*     */   }
/*     */   public void setProvince(String province) {
/*  70 */     this.province = province;
/*     */   }
/*     */   public String getCity() {
/*  73 */     return this.city;
/*     */   }
/*     */   public void setCity(String city) {
/*  76 */     this.city = city;
/*     */   }
/*     */   public String getType() {
/*  79 */     return this.type;
/*     */   }
/*     */   public void setType(String type) {
/*  82 */     this.type = type;
/*     */   }
/*     */   public String getLevel() {
/*  85 */     return this.level;
/*     */   }
/*     */   public void setLevel(String level) {
/*  88 */     this.level = level;
/*     */   }
/*     */   public String getPriceoff() {
/*  91 */     return this.priceoff;
/*     */   }
/*     */   public void setPriceoff(String priceoff) {
/*  94 */     this.priceoff = priceoff;
/*     */   }
/*     */   public String getPhone1() {
/*  97 */     return this.phone1;
/*     */   }
/*     */   public void setPhone1(String phone1) {
/* 100 */     this.phone1 = phone1;
/*     */   }
/*     */   public String getPhone2() {
/* 103 */     return this.phone2;
/*     */   }
/*     */   public void setPhone2(String phone2) {
/* 106 */     this.phone2 = phone2;
/*     */   }
/*     */   public String getWeixin() {
/* 109 */     return this.weixin;
/*     */   }
/*     */   public void setWeixin(String weixin) {
/* 112 */     this.weixin = weixin;
/*     */   }
/*     */   public String getQq() {
/* 115 */     return this.qq;
/*     */   }
/*     */   public void setQq(String qq) {
/* 118 */     this.qq = qq;
/*     */   }
/*     */   public String getWw() {
/* 121 */     return this.ww;
/*     */   }
/*     */   public void setWw(String ww) {
/* 124 */     this.ww = ww;
/*     */   }
/*     */   public String getAddress() {
/* 127 */     return this.address;
/*     */   }
/*     */   public void setAddress(String address) {
/* 130 */     this.address = address;
/*     */   }
/*     */   public String getBuygoods() {
/* 133 */     return this.buygoods;
/*     */   }
/*     */   public void setBuygoods(String buygoods) {
/* 136 */     this.buygoods = buygoods;
/*     */   }
/*     */   public String getBuyprice() {
/* 139 */     return this.buyprice;
/*     */   }
/*     */   public void setBuyprice(String buyprice) {
/* 142 */     this.buyprice = buyprice;
/*     */   }
/*     */   public String getScore() {
/* 145 */     return this.score;
/*     */   }
/*     */   public void setScore(String score) {
/* 148 */     this.score = score;
/*     */   }
/*     */   public String getDamondlike() {
/* 151 */     return this.damondlike;
/*     */   }
/*     */   public void setDamondlike(String damondlike) {
/* 154 */     this.damondlike = damondlike;
/*     */   }
/*     */   public String getLifelike() {
/* 157 */     return this.lifelike;
/*     */   }
/*     */   public void setLifelike(String lifelike) {
/* 160 */     this.lifelike = lifelike;
/*     */   }
/*     */ 
/*     */   public String getRecommander()
/*     */   {
/* 165 */     return this.recommander;
/*     */   }
/*     */   public void setRecommander(String recommander) {
/* 168 */     this.recommander = recommander;
/*     */   }
/*     */   public Integer getId() {
/* 171 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/* 174 */     this.id = id;
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Newuser
 * JD-Core Version:    0.6.2
 */