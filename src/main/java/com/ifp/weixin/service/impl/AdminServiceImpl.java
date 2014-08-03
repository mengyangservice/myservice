/*    */ package com.ifp.weixin.service.impl;
/*    */ 
/*    */ import com.ifp.weixin.DAO.BaseDAO;
/*    */ import com.ifp.weixin.ORM.Admin;
/*    */ import com.ifp.weixin.service.AdminService;
/*    */ import java.util.List;
/*    */ 
/*    */ public class AdminServiceImpl
/*    */   implements AdminService
/*    */ {
/*    */   BaseDAO dao;
/*    */ 
/*    */   public Admin adminLogin(String loginName, String loginPwd)
/*    */   {
/* 15 */     String hql = "from Admin as a where a.loginName='" + loginName + "' and a.loginPwd='" + loginPwd + "'";
/* 16 */     return (Admin)this.dao.loadObject(hql);
/*    */   }
/*    */ 
/*    */   public boolean saveOrUpdateAdmin(Admin admin)
/*    */   {
/* 21 */     boolean status = false;
/*    */     try {
/* 23 */       this.dao.saveOrUpdate(admin);
/* 24 */       status = true;
/*    */     } catch (Exception ex) {
/* 26 */       ex.printStackTrace();
/*    */     }
/* 28 */     return status;
/*    */   }
/*    */ 
/*    */   public List<Admin> browseAdmin()
/*    */   {
/* 34 */     return this.dao.listAll("Admin");
/*    */   }
/*    */ 
/*    */   public boolean delAdmin(Integer id)
/*    */   {
/* 39 */     boolean status = false;
/*    */     try {
/* 41 */       this.dao.delById(Admin.class, id);
/* 42 */       status = true;
/*    */     } catch (Exception ex) {
/* 44 */       ex.printStackTrace();
/*    */     }
/* 46 */     return status;
/*    */   }
/*    */ 
/*    */   public Admin loadAdmin(Integer id)
/*    */   {
/* 51 */     return (Admin)this.dao.loadById(Admin.class, id);
/*    */   }
/*    */ 
/*    */   public BaseDAO getDao() {
/* 55 */     return this.dao;
/*    */   }
/*    */ 
/*    */   public void setDao(BaseDAO dao) {
/* 59 */     this.dao = dao;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.impl.AdminServiceImpl
 * JD-Core Version:    0.6.2
 */