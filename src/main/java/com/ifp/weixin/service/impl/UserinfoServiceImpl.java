/*    */ package com.ifp.weixin.service.impl;
/*    */ 
/*    */ import com.ifp.weixin.DAO.BaseDAO;
/*    */ import com.ifp.weixin.ORM.Userinfo;
/*    */ import com.ifp.weixin.service.UserinfoService;
/*    */ import java.util.List;
/*    */ 
/*    */ public class UserinfoServiceImpl
/*    */   implements UserinfoService
/*    */ {
/*    */   BaseDAO dao;
/*    */ 
/*    */   public boolean saveOrUpdateUserinfo(Userinfo userinfo)
/*    */   {
/* 20 */     boolean status = false;
/*    */     try {
/* 22 */       this.dao.saveOrUpdate(userinfo);
/* 23 */       status = true;
/*    */     } catch (Exception ex) {
/* 25 */       ex.printStackTrace();
/*    */     }
/* 27 */     return status;
/*    */   }
/*    */ 
/*    */   public List<Userinfo> browseUserinfo()
/*    */   {
/* 33 */     return this.dao.listAll("Userinfo");
/*    */   }
/*    */ 
/*    */   public boolean delUserinfo(Integer id)
/*    */   {
/* 38 */     boolean status = false;
/*    */     try {
/* 40 */       this.dao.delById(Userinfo.class, id);
/* 41 */       status = true;
/*    */     } catch (Exception ex) {
/* 43 */       ex.printStackTrace();
/*    */     }
/* 45 */     return status;
/*    */   }
/*    */ 
/*    */   public Userinfo loadUserinfo(Integer id)
/*    */   {
/* 50 */     return (Userinfo)this.dao.loadById(Userinfo.class, id);
/*    */   }
/*    */ 
/*    */   public BaseDAO getDao() {
/* 54 */     return this.dao;
/*    */   }
/*    */ 
/*    */   public void setDao(BaseDAO dao) {
/* 58 */     this.dao = dao;
/*    */   }
/*    */ 
/*    */   public Userinfo loadUserinfoByuserid(String userid)
/*    */   {
/* 64 */     List list = this.dao.query("from Userinfo u where u.openid='" + userid + "'");
/* 65 */     if ((list != null) && (list.size() > 0)) {
/* 66 */       return (Userinfo)list.get(0);
/*    */     }
/* 68 */     return null;
/*    */   }
/*    */ 
/*    */   public BaseDAO getMyDao()
/*    */   {
/* 75 */     return getDao();
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.impl.UserinfoServiceImpl
 * JD-Core Version:    0.6.2
 */