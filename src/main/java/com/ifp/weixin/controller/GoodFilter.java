/*     */ package com.ifp.weixin.controller;
/*     */ 
/*     */ import com.ifp.weixin.DAO.BaseDAO;
/*     */ import com.ifp.weixin.ORM.Goods;
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
/*     */ @RequestMapping({"/goodfilter.action"})
/*     */ public class GoodFilter
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
/*  50 */     if ((v == null) || (v.length() <= 0)) return sql;
/*  51 */     if (sql.indexOf("where") >= 0)
/*     */     {
/*  53 */       if (col.equals("goldweight"))
/*     */       {
/*  55 */         Double b = Double.valueOf(Double.parseDouble(v));
/*  56 */         Double e = Double.valueOf(b.doubleValue() - 1.0D);
/*  57 */         String bv = String.format("%05d.4f", new Object[] { b });
/*  58 */         String ev = String.format("%05d.4f", new Object[] { e });
/*  59 */         sql = sql + " and " + col + ">'" + b + "' and " + col + "<'" + e + "'";
/*     */       }
/*     */       else {
/*  62 */         sql = sql + " and " + col + "='" + v + "'";
/*     */       }
/*     */ 
/*     */     }
/*  66 */     else if (col.equals("goldweight"))
/*     */     {
/*  68 */       Double b = Double.valueOf(Double.parseDouble(v));
/*  69 */       Double e = Double.valueOf(b.doubleValue() - 1.0D);
/*  70 */       String bv = String.format("% 10.5f", new Object[] { b });
/*  71 */       String ev = String.format("% 10.5f", new Object[] { e });
/*  72 */       sql = sql + " where " + col + ">'" + b + "' and " + col + "<'" + e + "'";
/*     */     }
/*     */     else {
/*  75 */       sql = sql + " where " + col + "='" + v + "'";
/*     */     }
/*  77 */     return sql;
/*     */   }
/*     */ 
/*     */   public String handleStr(String value)
/*     */   {
/*     */     try
/*     */     {
/*  84 */       return new String(value.getBytes("utf-8"), "ISO8859_1");
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/*  87 */       e.printStackTrace();
/*     */     }
/*  89 */     return "";
/*     */   }
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void get(HttpServletRequest request, HttpServletResponse response) {
/*     */     try {
/*  94 */       System.out.println("begin");
/*  95 */       String diatype = request.getParameter("diatype");
/*  96 */       if (diatype == null) diatype = "";
/*  97 */       diatype = new String(diatype.getBytes("ISO8859_1"), "utf-8");
/*  98 */       String figuer = request.getParameter("figuer");
/*  99 */       if (figuer == null) figuer = "";
/* 100 */       figuer = new String(figuer.getBytes("ISO8859_1"), "utf-8");
/*     */ 
/* 103 */       String weight = request.getParameter("weight");
/* 104 */       if (weight == null) weight = "";
/* 105 */       weight = new String(weight.getBytes("ISO8859_1"), "utf-8");
/*     */ 
/* 107 */       String clear = request.getParameter("clear");
/* 108 */       if (clear == null) clear = "";
/* 109 */       clear = new String(clear.getBytes("ISO8859_1"), "utf-8");
/*     */ 
/* 112 */       String openid = request.getParameter("openid");
/*     */ 
/* 116 */       System.out.println(diatype);
/*     */ 
/* 118 */       String sql = "From Goods";
/*     */ 
/* 120 */       sql = addPara(sql, "ditype", diatype);
/* 121 */       sql = addPara(sql, "figure", figuer);
/* 122 */       sql = addPara(sql, "clear", clear);
/* 123 */       sql = addPara(sql, "goldweight", weight);
/*     */ 
/* 125 */       System.out.println("sql=" + sql);
/* 126 */       List maplist = this.tasksService.getMyDao().query(sql);
/* 127 */       if (maplist == null) maplist = new ArrayList();
/* 128 */       int mpsize = maplist.size();
/*     */ 
/* 130 */       String itemurl = "/view.jsp?total=" + mpsize;
/* 131 */       itemurl = itemurl + "&diatype=" + diatype;
/* 132 */       itemurl = itemurl + "&openid=" + openid;
/* 133 */       itemurl = itemurl + "&figuer=" + figuer;
/* 134 */       itemurl = itemurl + "&clear=" + clear;
/* 135 */       itemurl = itemurl + "&weight=" + weight;
/* 136 */       request.setAttribute("total", Integer.valueOf(mpsize));
/* 137 */       for (int i = 0; i < mpsize; i++)
/*     */       {
/* 141 */         Goods mymap = (Goods)maplist.get(i);
/*     */ 
/* 143 */         itemurl = itemurl + "&" + i + "pic1=" + URLEncoder.encode(mymap.getPic1());
/* 144 */         itemurl = itemurl + "&" + i + "pic2=" + URLEncoder.encode(mymap.getPic2());
/* 145 */         itemurl = itemurl + "&" + i + "pic3=" + URLEncoder.encode(mymap.getPic3());
/* 146 */         itemurl = itemurl + "&" + i + "pic4=" + URLEncoder.encode(mymap.getPic4());
/* 147 */         itemurl = itemurl + "&" + i + "p" + 0 + "=" + handleStr("名字") + "&" + i + "p" + 1 + "=" + handleStr(mymap.getName());
/* 148 */         itemurl = itemurl + "&" + i + "p" + 2 + "=" + handleStr("名字") + "&" + i + "p" + 3 + "=" + handleStr(mymap.getName());
/* 149 */         itemurl = itemurl + "&" + i + "p" + 4 + "=" + handleStr("颜色") + "&" + i + "p" + 5 + "=" + handleStr(mymap.getColor());
/* 150 */         itemurl = itemurl + "&" + i + "p" + 6 + "=" + handleStr("形状") + "&" + i + "p" + 7 + "=" + handleStr(mymap.getFigure());
/* 151 */         itemurl = itemurl + "&" + i + "p" + 8 + "=" + handleStr("产地") + "&" + i + "p" + 9 + "=" + handleStr(mymap.getProductaddr());
/*     */       }
/*     */ 
/* 165 */       System.out.println(itemurl);
/*     */ 
/* 167 */       request.setCharacterEncoding("UTF-8");
/*     */ 
/* 169 */       request.getRequestDispatcher(itemurl).forward(request, response);
/*     */     }
/*     */     catch (Exception e) {
/* 172 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   @RequestMapping(method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void post(HttpServletRequest request, HttpServletResponse response)
/*     */   {
/* 180 */     System.out.println("post");
/*     */     try {
/* 182 */       request.setCharacterEncoding("UTF-8");
/*     */     } catch (UnsupportedEncodingException e) {
/* 184 */       e.printStackTrace();
/*     */     }
/* 186 */     response.setCharacterEncoding("UTF-8");
/*     */ 
/* 189 */     String respMessage = this.coreService.processRequest(request);
/*     */ 
/* 192 */     PrintWriter out = null;
/*     */     try {
/* 194 */       out = response.getWriter();
/* 195 */       out.print(respMessage);
/*     */     } catch (IOException e) {
/* 197 */       e.printStackTrace();
/*     */     } finally {
/* 199 */       out.close();
/* 200 */       out = null;
/*     */     }
/*     */   }
/*     */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.controller.GoodFilter
 * JD-Core Version:    0.6.2
 */