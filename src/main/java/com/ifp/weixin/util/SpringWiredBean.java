/*    */ package com.ifp.weixin.util;
/*    */ 
/*    */ import org.springframework.beans.factory.BeanFactory;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.context.support.SpringBeanAutowiringSupport;
/*    */ 
/*    */ public class SpringWiredBean extends SpringBeanAutowiringSupport
/*    */ {
/*    */ 
/*    */   @Autowired
/*    */   private BeanFactory beanFactory;
/* 24 */   private static SpringWiredBean instance = new SpringWiredBean();
/*    */ 
/*    */   public Object getBeanById(String beanId)
/*    */   {
/* 35 */     return this.beanFactory.getBean(beanId);
/*    */   }
/*    */ 
/*    */   public static SpringWiredBean getInstance() {
/* 39 */     return instance;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.util.SpringWiredBean
 * JD-Core Version:    0.6.2
 */