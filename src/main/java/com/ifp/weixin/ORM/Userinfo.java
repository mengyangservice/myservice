/*     */ package com.ifp.weixin.ORM;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ public class Userinfo
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
/*  11 */     return this.recommanderid;
/*     */   }
/*     */   public void setRecommanderid(String recommanderid) {
/*  14 */     this.recommanderid = recommanderid;
/*     */   }
/*     */ 
/*     */   public String getUserid() {
/*  18 */     return this.userid;
/*     */   }
/*     */   public void setUserid(String userid) {
/*  21 */     this.userid = userid;
/*     */   }
/*     */   public String getOpenid() {
/*  24 */     return this.openid;
/*     */   }
/*     */   public void setOpenid(String openid) {
/*  27 */     this.openid = openid;
/*     */   }
/*     */   public String getName() {
/*  30 */     return this.name;
/*     */   }
/*     */   public void setName(String name) {
/*  33 */     this.name = name;
/*     */   }
/*     */   public String getNickname() {
/*  36 */     return this.nickname;
/*     */   }
/*     */   public void setNickname(String nickname) {
/*  39 */     this.nickname = nickname;
/*     */   }
/*     */   public String getState1() {
/*  42 */     return this.state1;
/*     */   }
/*     */   public void setState1(String state1) {
/*  45 */     this.state1 = state1;
/*     */   }
/*     */   public String getSex() {
/*  48 */     return this.sex;
/*     */   }
/*     */   public void setSex(String sex) {
/*  51 */     this.sex = sex;
/*     */   }
/*     */   public String getAge() {
/*  54 */     return this.age;
/*     */   }
/*     */   public void setAge(String age) {
/*  57 */     this.age = age;
/*     */   }
/*     */   public String getState2() {
/*  60 */     return this.state2;
/*     */   }
/*     */   public void setState2(String state2) {
/*  63 */     this.state2 = state2;
/*     */   }
/*     */   public String getProvince() {
/*  66 */     return this.province;
/*     */   }
/*     */   public void setProvince(String province) {
/*  69 */     this.province = province;
/*     */   }
/*     */   public String getCity() {
/*  72 */     return this.city;
/*     */   }
/*     */   public void setCity(String city) {
/*  75 */     this.city = city;
/*     */   }
/*     */   public String getType() {
/*  78 */     return this.type;
/*     */   }
/*     */   public void setType(String type) {
/*  81 */     this.type = type;
/*     */   }
/*     */   public String getLevel() {
/*  84 */     return this.level;
/*     */   }
/*     */   public void setLevel(String level) {
/*  87 */     this.level = level;
/*     */   }
/*     */   public String getPriceoff() {
/*  90 */     return this.priceoff;
/*     */   }
/*     */   public void setPriceoff(String priceoff) {
/*  93 */     this.priceoff = priceoff;
/*     */   }
/*     */   public String getPhone1() {
/*  96 */     return this.phone1;
/*     */   }
/*     */   public void setPhone1(String phone1) {
/*  99 */     this.phone1 = phone1;
/*     */   }
/*     */   public String getPhone2() {
/* 102 */     return this.phone2;
/*     */   }
/*     */   public void setPhone2(String phone2) {
/* 105 */     this.phone2 = phone2;
/*     */   }
/*     */   public String getWeixin() {
/* 108 */     return this.weixin;
/*     */   }
/*     */   public void setWeixin(String weixin) {
/* 111 */     this.weixin = weixin;
/*     */   }
/*     */   public String getQq() {
/* 114 */     return this.qq;
/*     */   }
/*     */   public void setQq(String qq) {
/* 117 */     this.qq = qq;
/*     */   }
/*     */   public String getWw() {
/* 120 */     return this.ww;
/*     */   }
/*     */   public void setWw(String ww) {
/* 123 */     this.ww = ww;
/*     */   }
/*     */   public String getAddress() {
/* 126 */     return this.address;
/*     */   }
/*     */   public void setAddress(String address) {
/* 129 */     this.address = address;
/*     */   }
/*     */   public String getBuygoods() {
/* 132 */     return this.buygoods;
/*     */   }
/*     */   public void setBuygoods(String buygoods) {
/* 135 */     this.buygoods = buygoods;
/*     */   }
/*     */   public String getBuyprice() {
/* 138 */     return this.buyprice;
/*     */   }
/*     */   public void setBuyprice(String buyprice) {
/* 141 */     this.buyprice = buyprice;
/*     */   }
/*     */   public String getScore() {
/* 144 */     return this.score;
/*     */   }
/*     */   public void setScore(String score) {
/* 147 */     this.score = score;
/*     */   }
/*     */   public String getDamondlike() {
/* 150 */     return this.damondlike;
/*     */   }
/*     */   public void setDamondlike(String damondlike) {
/* 153 */     this.damondlike = damondlike;
/*     */   }
/*     */   public String getLifelike() {
/* 156 */     return this.lifelike;
/*     */   }
/*     */   public void setLifelike(String lifelike) {
/* 159 */     this.lifelike = lifelike;
/*     */   }
/*     */ 
/*     */   public String getRecommander()
/*     */   {
/* 164 */     return this.recommander;
/*     */   }
/*     */   public void setRecommander(String recommander) {
/* 167 */     this.recommander = recommander;
/*     */   }
/*     */   public Integer getId() {
/* 170 */     return this.id;
/*     */   }
/*     */   public void setId(Integer id) {
/* 173 */     this.id = id;
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Userinfo
 * JD-Core Version:    0.6.2
 */