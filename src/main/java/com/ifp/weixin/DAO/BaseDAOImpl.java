/*     */ package com.ifp.weixin.DAO;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import org.hibernate.Hibernate;
/*     */ import org.hibernate.HibernateException;
/*     */ import org.hibernate.Query;
/*     */ import org.hibernate.SQLQuery;
/*     */ import org.hibernate.Session;
/*     */ import org.hibernate.SessionFactory;
/*     */ import org.springframework.orm.hibernate3.HibernateCallback;
/*     */ import org.springframework.orm.hibernate3.HibernateTemplate;
/*     */ import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("dao")
/*     */ public class BaseDAOImpl extends HibernateDaoSupport
/*     */   implements BaseDAO
/*     */ {
/*     */ 
/*     */   @Resource
/*     */   HibernateTemplate hibernateTemplate;
/*     */ 
/*     */   public int countAll(String clazz)
/*     */   {
/*  24 */     final String hql = "select count(*) from " + clazz + " as a";
/*  25 */     Long count = (Long)this.hibernateTemplate.execute(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/*  27 */         Query query = session.createQuery(hql);
/*  28 */         query.setMaxResults(1);
/*  29 */         return query.uniqueResult();
/*     */       }
/*     */     });
/*  32 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public int countQuery(String hql)
/*     */   {
/*  37 */     final String counthql = hql;
/*  38 */     Long count = (Long)this.hibernateTemplate.execute(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/*  40 */         Query query = session.createQuery(counthql);
/*  41 */         query.setMaxResults(1);
/*  42 */         return query.uniqueResult();
/*     */       }
/*     */     });
/*  45 */     return count.intValue();
/*     */   }
/*     */ 
/*     */   public void delById(Class clazz, Serializable id)
/*     */   {
/*  50 */     this.hibernateTemplate.delete(this.hibernateTemplate.load(clazz, id));
/*     */   }
/*     */ 
/*     */   public List listAll(String clazz)
/*     */   {
/*  55 */     return this.hibernateTemplate.find("from " + clazz + " as a order by a.id desc");
/*     */   }
/*     */ 
/*     */   public List listAll(String clazz, int pageNo, int pageSize)
/*     */   {
/*  60 */     final int pNo = pageNo;
/*  61 */     final int pSize = pageSize;
/*  62 */     final String hql = "from " + clazz + " as a order by a.id desc";
/*  63 */     List list = this.hibernateTemplate.executeFind(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/*  65 */         Query query = session.createQuery(hql);
/*  66 */         query.setMaxResults(pSize);
/*  67 */         query.setFirstResult((pNo - 1) * pSize);
/*  68 */         List result = query.list();
/*  69 */         if (!Hibernate.isInitialized(result)) Hibernate.initialize(result);
/*  70 */         return result;
/*     */       }
/*     */     });
/*  73 */     return list;
/*     */   }
/*     */ 
/*     */   public Object loadById(Class clazz, Serializable id)
/*     */   {
/*  78 */     System.out.println(clazz + "," + id);
/*  79 */     return this.hibernateTemplate.get(clazz, id);
/*     */   }
/*     */ 
/*     */   public Object loadObject(String hql)
/*     */   {
/*  84 */     final String hql1 = hql;
/*  85 */     Object obj = null;
/*  86 */     List list = this.hibernateTemplate.executeFind(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/*  88 */         Query query = session.createQuery(hql1);
/*  89 */         return query.list();
/*     */       }
/*     */     });
/*  92 */     if (list.size() > 0) obj = list.get(0);
/*  93 */     return obj;
/*     */   }
/*     */ 
/*     */   public List query(String hql)
/*     */   {
/*  98 */     final String hql1 = hql;
/*  99 */     return this.hibernateTemplate.executeFind(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/* 101 */         Query query = session.createQuery(hql1);
/* 102 */         return query.list();
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public List query(String hql, int pageNo, int pageSize)
/*     */   {
/* 109 */     final int pNo = pageNo;
/* 110 */     final int pSize = pageSize;
/* 111 */     final String hql1 = hql;
/* 112 */     return this.hibernateTemplate.executeFind(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/* 114 */         Query query = session.createQuery(hql1);
/* 115 */         query.setMaxResults(pSize);
/* 116 */         query.setFirstResult((pNo - 1) * pSize);
/* 117 */         List result = query.list();
/* 118 */         if (!Hibernate.isInitialized(result)) Hibernate.initialize(result);
/* 119 */         return result;
/*     */       }
/*     */     });
/*     */   }
/*     */ 
/*     */   public int update(String hql)
/*     */   {
/* 128 */     final String hql1 = hql;
/* 129 */     return ((Integer)this.hibernateTemplate.execute(new HibernateCallback() {
/*     */       public Object doInHibernate(Session session) throws HibernateException {
/* 131 */         Query query = session.createQuery(hql1);
/* 132 */         return Integer.valueOf(query.executeUpdate());
/*     */       }
/*     */     })).intValue();
/*     */   }
/*     */ 
/*     */   public void saveOrUpdate(Object obj)
/*     */   {
/* 141 */     getHibernateTemplate().saveOrUpdate(obj);
/*     */   }
/*     */ 
/*     */   public int exeSql(String sql)
/*     */   {
/* 148 */     Session session = this.hibernateTemplate.getSessionFactory().openSession();
/* 149 */     SQLQuery sqlQuery = session.createSQLQuery(sql);
/* 150 */     sqlQuery.executeUpdate();
/* 151 */     session.close();
/* 152 */     return 0;
/*     */   }
/*     */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.DAO.BaseDAOImpl
 * JD-Core Version:    0.6.2
 */