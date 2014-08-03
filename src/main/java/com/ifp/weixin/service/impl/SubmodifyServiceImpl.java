/*    */ package com.ifp.weixin.service.impl;
/*    */ 
/*    */ import com.ifp.weixin.DAO.BaseDAO;
/*    */ import com.ifp.weixin.ORM.Submodify;
/*    */ import com.ifp.weixin.service.SubmodifyService;
/*    */ import java.util.List;
/*    */ 
/*    */ public class SubmodifyServiceImpl
/*    */   implements SubmodifyService
/*    */ {
/*    */   BaseDAO dao;
/*    */ 
/*    */   public boolean saveOrUpdateSubmodify(Submodify submodify)
/*    */   {
/* 20 */     boolean status = false;
/*    */     try {
/* 22 */       this.dao.saveOrUpdate(submodify);
/* 23 */       status = true;
/*    */     } catch (Exception ex) {
/* 25 */       ex.printStackTrace();
/*    */     }
/* 27 */     return status;
/*    */   }
/*    */ 
/*    */   public List<Submodify> browseSubmodify()
/*    */   {
/* 33 */     return this.dao.listAll("Submodify");
/*    */   }
/*    */ 
/*    */   public boolean delSubmodify(Integer id)
/*    */   {
/* 38 */     boolean status = false;
/*    */     try {
/* 40 */       this.dao.delById(Submodify.class, id);
/* 41 */       status = true;
/*    */     } catch (Exception ex) {
/* 43 */       ex.printStackTrace();
/*    */     }
/* 45 */     return status;
/*    */   }
/*    */ 
/*    */   public Submodify loadSubmodify(Integer id)
/*    */   {
/* 50 */     return (Submodify)this.dao.loadById(Submodify.class, id);
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
/*    */   public Submodify loadSubmodifyByuserid(String userid)
/*    */   {
/* 64 */     List list = this.dao.query("from Submodify u where u.openid='" + userid + "'");
/* 65 */     if ((list != null) && (list.size() > 0)) {
/* 66 */       return (Submodify)list.get(0);
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
 * Qualified Name:     com.ifp.weixin.service.impl.SubmodifyServiceImpl
 * JD-Core Version:    0.6.2
 */