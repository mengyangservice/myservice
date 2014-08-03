/*    */ package com.ifp.weixin.service.impl;
/*    */ 
/*    */ import com.ifp.weixin.DAO.BaseDAO;
/*    */ import com.ifp.weixin.ORM.Newuser;
/*    */ import com.ifp.weixin.service.NewuserService;
/*    */ import java.util.List;
/*    */ 
/*    */ public class NewuserServiceImpl
/*    */   implements NewuserService
/*    */ {
/*    */   BaseDAO dao;
/*    */ 
/*    */   public boolean saveOrUpdateNewuser(Newuser userinfo)
/*    */   {
/* 19 */     boolean status = false;
/*    */     try {
/* 21 */       this.dao.saveOrUpdate(userinfo);
/* 22 */       status = true;
/*    */     } catch (Exception ex) {
/* 24 */       ex.printStackTrace();
/*    */     }
/* 26 */     return status;
/*    */   }
/*    */ 
/*    */   public List<Newuser> browseNewuser()
/*    */   {
/* 32 */     return this.dao.listAll("Newuser");
/*    */   }
/*    */ 
/*    */   public boolean delNewuser(Integer id)
/*    */   {
/* 37 */     boolean status = false;
/*    */     try {
/* 39 */       this.dao.delById(Newuser.class, id);
/* 40 */       status = true;
/*    */     } catch (Exception ex) {
/* 42 */       ex.printStackTrace();
/*    */     }
/* 44 */     return status;
/*    */   }
/*    */ 
/*    */   public Newuser loadNewuser(Integer id)
/*    */   {
/* 49 */     return (Newuser)this.dao.loadById(Newuser.class, id);
/*    */   }
/*    */ 
/*    */   public BaseDAO getDao() {
/* 53 */     return this.dao;
/*    */   }
/*    */ 
/*    */   public void setDao(BaseDAO dao) {
/* 57 */     this.dao = dao;
/*    */   }
/*    */ 
/*    */   public Newuser loadNewuserByuserid(String userid)
/*    */   {
/* 63 */     List list = this.dao.query("from Newuser u where u.openid='" + userid + "'");
/* 64 */     if ((list != null) && (list.size() > 0)) {
/* 65 */       return (Newuser)list.get(0);
/*    */     }
/* 67 */     return null;
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.impl.NewuserServiceImpl
 * JD-Core Version:    0.6.2
 */