/*    */ package com.ifp.weixin.ORM;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Admin
/*    */   implements Serializable
/*    */ {
/*    */   private Integer id;
/*    */   private String loginName;
/*    */   private String loginPwd;
/*    */   private String privileges;
/*    */ 
/*    */   public Admin()
/*    */   {
/*    */   }
/*    */ 
/*    */   public Admin(String loginName, String loginPwd, String privileges)
/*    */   {
/* 22 */     this.loginName = loginName;
/* 23 */     this.loginPwd = loginPwd;
/* 24 */     this.privileges = privileges;
/*    */   }
/*    */ 
/*    */   public Integer getId()
/*    */   {
/* 30 */     return this.id;
/*    */   }
/*    */ 
/*    */   public void setId(Integer id) {
/* 34 */     this.id = id;
/*    */   }
/*    */ 
/*    */   public String getLoginName() {
/* 38 */     return this.loginName;
/*    */   }
/*    */ 
/*    */   public void setLoginName(String loginName) {
/* 42 */     this.loginName = loginName;
/*    */   }
/*    */ 
/*    */   public String getLoginPwd() {
/* 46 */     return this.loginPwd;
/*    */   }
/*    */ 
/*    */   public void setLoginPwd(String loginPwd) {
/* 50 */     this.loginPwd = loginPwd;
/*    */   }
/*    */ 
/*    */   public String getPrivileges() {
/* 54 */     return this.privileges;
/*    */   }
/*    */ 
/*    */   public void setPrivileges(String privileges) {
/* 58 */     this.privileges = privileges;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.ORM.Admin
 * JD-Core Version:    0.6.2
 */