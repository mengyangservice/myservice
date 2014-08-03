/*    */ package com.ifp.weixin.service.impl;
/*    */ 
/*    */ import com.ifp.weixin.DAO.BaseDAO;
/*    */ import com.ifp.weixin.ORM.Tasks;
/*    */ import com.ifp.weixin.service.TasksService;
/*    */ import java.util.List;
/*    */ import javax.annotation.Resource;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("tasksService")
/*    */ public class TasksServiceImpl
/*    */   implements TasksService
/*    */ {
/*    */ 
/*    */   @Resource(name="dao")
/*    */   BaseDAO dao;
/*    */ 
/*    */   public boolean saveOrUpdateTasks(Tasks admin)
/*    */   {
/* 24 */     boolean status = false;
/*    */     try {
/* 26 */       this.dao.saveOrUpdate(admin);
/* 27 */       status = true;
/*    */     } catch (Exception ex) {
/* 29 */       ex.printStackTrace();
/*    */     }
/* 31 */     return status;
/*    */   }
/*    */ 
/*    */   public List<Tasks> browseTasks()
/*    */   {
/* 37 */     return this.dao.listAll("Tasks");
/*    */   }
/*    */ 
/*    */   public boolean delTasks(Integer id)
/*    */   {
/* 42 */     boolean status = false;
/*    */     try {
/* 44 */       this.dao.delById(Tasks.class, id);
/* 45 */       status = true;
/*    */     } catch (Exception ex) {
/* 47 */       ex.printStackTrace();
/*    */     }
/* 49 */     return status;
/*    */   }
/*    */ 
/*    */   public Tasks loadTasks(Integer id)
/*    */   {
/* 54 */     return (Tasks)this.dao.loadById(Tasks.class, id);
/*    */   }
/*    */ 
/*    */   public BaseDAO getDao() {
/* 58 */     return this.dao;
/*    */   }
/*    */ 
/*    */   public void setDao(BaseDAO dao) {
/* 62 */     this.dao = dao;
/*    */   }
/*    */ 
/*    */   public List<Tasks> getAvailTasks(String hql)
/*    */   {
/* 70 */     return this.dao.query(hql);
/*    */   }
/*    */ 
/*    */   public BaseDAO getMyDao()
/*    */   {
/* 76 */     return getDao();
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.impl.TasksServiceImpl
 * JD-Core Version:    0.6.2
 */