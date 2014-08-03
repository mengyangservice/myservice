/*     */ package com.ifp.weixin.controller;
/*     */ 
/*     */ import com.ifp.weixin.DAO.BaseDAO;
/*     */ import com.ifp.weixin.ORM.Styles;
/*     */ import com.ifp.weixin.biz.core.CoreService;
/*     */ import com.ifp.weixin.service.TasksService;
/*     */ import com.ifp.weixin.service.UserinfoService;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.URLEncoder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.annotation.Resource;
/*     */ import javax.servlet.RequestDispatcher;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/stylefilter.action"})
/*     */ public class StyleFilter
/*     */ {
/*     */ 
/*     */   @Resource(name="coreService")
/*     */   private CoreService coreService;
/*     */ 
/*     */   @Resource(name="userinfoService")
/*     */   private UserinfoService userinfoService;
/*     */ 
/*     */   @Resource(name="tasksService")
/*     */   private TasksService tasksService;
/*     */ 
/*     */   public String addPara(String sql, String col, String v)
/*     */   {
/*  51 */     if ((v == null) || (v.length() <= 0)) return sql;
/*  52 */     if (sql.indexOf("where") >= 0)
/*     */     {
/*  54 */       sql = sql + " and " + col + "='" + v + "'";
/*     */     }
/*     */     else
/*     */     {
/*  58 */       sql = sql + " where " + col + "='" + v + "'";
/*     */     }
/*  60 */     return sql;
/*     */   }
/*     */ 
/*     */   public String handleStr(String value)
/*     */   {
/*     */     try {
/*  66 */       return new String(value.getBytes("utf-8"), "ISO8859_1");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/*  69 */       e.printStackTrace();
/*     */     }
/*  71 */     return "";
/*     */   }
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void get(HttpServletRequest request, HttpServletResponse response) {
/*     */     try {
/*  76 */       System.out.println("begin");
/*  77 */       String usedfor = request.getParameter("usedfor");
/*  78 */       if (usedfor == null) usedfor = "";
/*  79 */       usedfor = new String(usedfor.getBytes("ISO8859_1"), "utf-8");
/*  80 */       String figuer = request.getParameter("figuer");
/*  81 */       if (figuer == null) figuer = "";
/*  82 */       figuer = new String(figuer.getBytes("ISO8859_1"), "utf-8");
/*     */ 
/*  84 */       String weight = request.getParameter("weight");
/*  85 */       String clear = request.getParameter("clear");
/*  86 */       String openid = request.getParameter("openid");
/*     */ 
/*  90 */       System.out.println(usedfor);
/*     */ 
/*  92 */       String sql = "From Styles";
/*     */ 
/*  94 */       sql = addPara(sql, "usedfor", usedfor);
/*  95 */       sql = addPara(sql, "figure", figuer);
/*  96 */       System.out.println("sql=" + sql);
/*  97 */       List maplist = this.tasksService.getMyDao().query(sql);
/*  98 */       if (maplist == null) maplist = new ArrayList();
/*  99 */       int mpsize = maplist.size();
/*     */ 
/* 101 */       String itemurl = "/viewstyle.jsp?total=" + mpsize;
/* 102 */       itemurl = itemurl + "&usedfor=" + usedfor;
/* 103 */       itemurl = itemurl + "&openid=" + openid;
/* 104 */       itemurl = itemurl + "&figuer=" + figuer;
/* 105 */       request.setAttribute("total", Integer.valueOf(mpsize));
/* 106 */       for (int i = 0; i < mpsize; i++)
/*     */       {
/* 110 */         Styles mymap = (Styles)maplist.get(i);
/*     */ 
/* 112 */         itemurl = itemurl + "&" + i + "pic=" + URLEncoder.encode(mymap.getPic1());
/* 113 */         itemurl = itemurl + "&" + i + "p" + 0 + "=" + handleStr("形状") + "&" + i + "p" + 1 + "=" + handleStr(mymap.getFigure());
/* 114 */         itemurl = itemurl + "&" + i + "p" + 2 + "=" + handleStr("材料") + "&" + i + "p" + 3 + "=" + handleStr(mymap.getMaterial());
/* 115 */         itemurl = itemurl + "&" + i + "p" + 4 + "=" + handleStr("用途") + "&" + i + "p" + 5 + "=" + handleStr(mymap.getUsedfor());
/* 116 */         itemurl = itemurl + "&" + i + "p" + 6 + "=" + handleStr("形状") + "&" + i + "p" + 7 + "=" + handleStr(mymap.getFigure());
/* 117 */         itemurl = itemurl + "&" + i + "p" + 8 + "=" + handleStr("价格") + "&" + i + "p" + 9 + "=" + handleStr(mymap.getPreprice());
/*     */       }
/*     */ 
/* 131 */       System.out.println(itemurl);
/*     */ 
/* 133 */       request.setCharacterEncoding("UTF-8");
/*     */ 
/* 135 */       request.getRequestDispatcher(itemurl).forward(request, response);
/*     */     }
/*     */     catch (Exception e) {
/* 138 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void post(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 146 */     System.out.println("post");
/*     */     try {
/* 148 */       request.setCharacterEncoding("UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/* 150 */       e.printStackTrace();
/*     */     }
/* 152 */     response.setCharacterEncoding("UTF-8");
/*     */ 
/* 155 */     String respMessage = this.coreService.processRequest(request);
/*     */ 
/* 158 */     PrintWriter out = null;
/*     */     try {
/* 160 */       out = response.getWriter();
/* 161 */       out.print(respMessage);
/*     */     } catch (IOException e) {
/* 163 */       e.printStackTrace();
/*     */     } finally {
/* 165 */       out.close();
/* 166 */       out = null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.controller.StyleFilter
 * JD-Core Version:    0.6.2
 */