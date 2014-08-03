/*    */ package com.ifp.weixin.entity.Message.resp;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class NewsMessage extends BaseMessage
/*    */ {
/*    */   private int ArticleCount;
/*    */   private List<Article> Articles;
/*    */ 
/*    */   public int getArticleCount()
/*    */   {
/* 21 */     return this.ArticleCount;
/*    */   }
/*    */ 
/*    */   public void setArticleCount(int articleCount) {
/* 25 */     this.ArticleCount = articleCount;
/*    */   }
/*    */ 
/*    */   public List<Article> getArticles() {
/* 29 */     return this.Articles;
/*    */   }
/*    */ 
/*    */   public void setArticles(List<Article> articles) {
/* 33 */     this.Articles = articles;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.entity.Message.resp.NewsMessage
 * JD-Core Version:    0.6.2
 */