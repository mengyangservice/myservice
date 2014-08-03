/*      */ package com.ifp.weixin.biz.core.impl;
/*      */ 
/*      */ import com.ifp.weixin.DAO.BaseDAO;
/*      */ import com.ifp.weixin.ORM.Newuser;
/*      */ import com.ifp.weixin.ORM.Submodify;
/*      */ import com.ifp.weixin.ORM.Tasks;
/*      */ import com.ifp.weixin.ORM.Userinfo;
/*      */ import com.ifp.weixin.biz.core.CoreService;
/*      */ import com.ifp.weixin.entity.Message.resp.Article;
/*      */ import com.ifp.weixin.entity.Message.resp.NewsMessage;
/*      */ import com.ifp.weixin.entity.Message.resp.TextMessage;
/*      */ import com.ifp.weixin.service.NewuserService;
/*      */ import com.ifp.weixin.service.SubmodifyService;
/*      */ import com.ifp.weixin.service.TasksService;
/*      */ import com.ifp.weixin.service.UserinfoService;
/*      */ import com.ifp.weixin.util.HttpPostUtils;
/*      */ import com.ifp.weixin.util.MessageUtil;
/*      */ import com.ifp.weixin.util.ReadExcel001;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.lang.reflect.InvocationTargetException;
/*      */ import java.net.HttpURLConnection;
/*      */ import java.net.URL;
/*      */ import java.net.URLEncoder;
/*      */ import java.text.DateFormat;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Date;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.annotation.Resource;
/*      */ import javax.servlet.http.HttpServletRequest;
/*      */ import net.sf.json.JSONArray;
/*      */ import net.sf.json.JSONObject;
/*      */ import org.apache.commons.beanutils.BeanUtils;
/*      */ import org.apache.log4j.Logger;
/*      */ import org.springframework.stereotype.Service;
/*      */ 
/*      */ @Service("coreService")
/*      */ public class CoreServiceImpl
/*      */   implements CoreService
/*      */ {
/*   54 */   public static Logger log = Logger.getLogger(CoreServiceImpl.class);
/*      */ 
/*   56 */   public static Map<String, String> sessionMap = new HashMap();
/*      */ 
/*      */   @Resource(name="userinfoService")
/*      */   private UserinfoService userinfoService;
/*      */ 
/*      */   @Resource(name="tasksService")
/*      */   private TasksService tasksService;
/*      */ 
/*      */   @Resource(name="newuserService")
/*      */   private NewuserService newuserService;
/*      */ 
/*      */   @Resource(name="submodifyService")
/*      */   private SubmodifyService submodifyService;
/*      */ 
/*      */   private String printImg(String picurl, String check)
/*      */   {
/*   76 */     String ticket = "";
/*      */ 
/*   78 */     String url_str = "http://42.96.203.228/weixinprint/upload!printimg.action?image1FileName=" + check + "&image2FileName=" + picurl;
/*   79 */     String ticket_url = url_str + ticket;
/*      */     try {
/*   81 */       URL myurl = new URL(ticket_url);
/*      */ 
/*   84 */       HttpURLConnection connection = (HttpURLConnection)myurl.openConnection();
/*      */ 
/*   86 */       connection.connect();
/*      */ 
/*   88 */       int code = connection.getResponseCode();
/*   89 */       if (code == 404) {
/*   90 */         System.out.println("认证无效，找不到此次认证的会话信息！");
/*      */       }
/*   92 */       if (code == 500) {
/*   93 */         System.out.println("认证服务器发生内部错误！");
/*      */       }
/*   95 */       if (code != 200) {
/*   96 */         System.out.println("发生其它错误，认证服务器返回 " + code);
/*      */       }
/*   98 */       InputStream is = connection.getInputStream();
/*   99 */       byte[] response = new byte[is.available()];
/*  100 */       is.read(response);
/*  101 */       is.close();
/*  102 */       if ((response == null) || (response.length == 0)) {
/*  103 */         System.out.println("认证无效，找不到此次认证的会话信息！");
/*      */       }
/*  105 */       String userId = new String(response, "utf-8");
/*  106 */       System.out.println(userId);
/*  107 */       return userId;
/*      */     }
/*      */     catch (IOException e) {
/*  110 */       e.printStackTrace();
/*      */     }
/*  112 */     return "";
/*      */   }
/*      */ 
/*      */   boolean isModify(String msg)
/*      */   {
/*  120 */     return true;
/*      */   }
/*      */ 
/*      */   Userinfo getUserStatus(String userid, String scenNum)
/*      */   {
/*  126 */     Userinfo user = this.userinfoService.loadUserinfoByuserid(userid);
/*  127 */     Newuser newuser = this.newuserService.loadNewuserByuserid(userid);
/*  128 */     if ((user == null) && (newuser == null))
/*      */     {
/*  131 */       String token = getAccessToken("wxab2c9ffb3c60ff14", "b3b5985710adabcfbce1daed8b156b29");
/*      */ 
/*  134 */       String[] para = new String[3];
/*  135 */       para[0] = ("access_token=" + URLEncoder.encode(token));
/*  136 */       para[1] = ("openid=" + userid);
/*  137 */       para[2] = "&lang=zh_CN";
/*      */ 
/*  140 */       String posturl = "https://api.weixin.qq.com/cgi-bin/user/info";
/*      */ 
/*  143 */       String reJson = HttpPostUtils.httpsGet(posturl, para);
/*  144 */       System.out.println("json=" + reJson);
/*  145 */       JSONObject reObj = JSONObject.fromObject(reJson);
/*      */ 
/*  147 */       String nickname = (String)reObj.get("nickname");
/*      */ 
/*  149 */       String language = (String)reObj.get("language");
/*  150 */       String city = (String)reObj.get("city");
/*  151 */       String province = (String)reObj.get("province");
/*  152 */       String country = (String)reObj.get("country");
/*      */ 
/*  155 */       Newuser nuser = new Newuser();
/*  156 */       nuser.setNickname(nickname);
/*  157 */       nuser.setCity(city);
/*  158 */       nuser.setState2(country);
/*  159 */       nuser.setProvince(province);
/*      */ 
/*  162 */       nuser.setOpenid(userid);
/*  163 */       nuser.setType("客户");
/*  164 */       if ((scenNum != null) && (scenNum.length() > 0))
/*      */       {
/*  166 */         List<Userinfo> userlist = this.userinfoService.browseUserinfo();
/*      */ 
/*  168 */         for (int j = 0; j < userlist.size(); j++)
/*      */         {
/*  170 */           Userinfo u = (Userinfo)userlist.get(j);
/*  171 */           int num = getScenNumByID(u.getUserid());
/*  172 */           System.out.println("num=" + num + "," + scenNum);
/*  173 */           if (String.valueOf(num) .equals( scenNum) )
/*      */           {
/*  175 */             nuser.setRecommander(u.getUserid());
/*  176 */             nuser.setRecommanderid(u.getUserid());
/*      */           }
/*      */         }
/*      */       }
/*  180 */       DateFormat format2 = new SimpleDateFormat("yyyyMMdd");
/*  181 */       String reTime = format2.format(new Date());
/*  182 */       int maxscen = getMaxScenNum("new");
/*  183 */       nuser.setUserid(reTime + maxscen);
/*  184 */       this.newuserService.saveOrUpdateNewuser(nuser);
/*      */       try
/*      */       {
/*  187 */         user = new Userinfo();
/*  188 */         BeanUtils.copyProperties(user, nuser);
/*      */       }
/*      */       catch (IllegalAccessException e) {
/*  191 */         e.printStackTrace();
/*      */       }
/*      */       catch (InvocationTargetException e) {
/*  194 */         e.printStackTrace();
/*      */       }
/*  196 */       return user;
/*      */     }
/*      */ 
/*  199 */     if (user != null) return user;
/*  200 */     if (newuser != null) {
/*      */       try {
/*  202 */         user = new Userinfo();
/*  203 */         BeanUtils.copyProperties(user, newuser);
/*  204 */         return user;
/*      */       }
/*      */       catch (IllegalAccessException e) {
/*  207 */         e.printStackTrace();
/*      */       } 
/*      */       catch (InvocationTargetException e) {
	/*  207 */         e.printStackTrace();
/*      */       } 
/*      */     }
/*      */ 
/*  211 */     return user;
/*      */   }
/*      */ 
/*      */   public String getAccessToken(String appid, String secret)
/*      */   {
/*  216 */     String[] para = new String[3];
/*  217 */     para[0] = "grant_type=client_credential";
/*  218 */     para[1] = ("appid=" + appid);
/*  219 */     para[2] = ("secret=" + secret);
/*      */ 
/*  221 */     String posturl = "https://api.weixin.qq.com/cgi-bin/token";
/*      */ 
/*  224 */     System.out.println("post=" + posturl + ":" + para.toString());
/*  225 */     String reJson = HttpPostUtils.httpsGet(posturl, para);
/*  226 */     JSONObject reObj = JSONObject.fromObject(reJson);
/*  227 */     String token = (String)reObj.get("access_token");
/*  228 */     return token;
/*      */   }
/*      */ 
/*      */   String handleTasks(List<Tasks> ts, String str, String openid) {
/*  232 */     String result = "";
/*  233 */     if (ts.size() == 0) return "您好，有什么可以帮到您？没有找到可以执行的任务.";
/*  234 */     if (ts.size() == 1)
/*      */     {
/*  236 */       Tasks t = (Tasks)ts.get(0);
/*  237 */       result = exeTask(t, str, openid);
/*      */     }
/*      */     else
/*      */     {
/*  242 */       result = result + "有多个任务，如下:";
/*  243 */       for (int i = 0; i < ts.size(); i++)
/*      */       {
/*  245 */         Tasks t = (Tasks)ts.get(i);
/*  246 */         result = result + i + "." + t.getName() + ",id为" + t.getTaskid() + ";";
/*      */       }
/*      */     }
/*      */ 
/*  250 */     System.out.println("result=" + result);
/*  251 */     return result;
/*      */   }
/*      */ 
/*      */   String addsqlstr(String sql, String str, String table) {
/*  255 */     System.out.println("para=" + str);
/*  256 */     if (sql.equals("")) sql = "t." + getPara(table, str);
/*      */     else
/*  258 */       sql = sql + "," + "t." + getPara(table, str);
/*  259 */     return sql;
/*      */   }
/*      */ 
/*      */   public static String getTable(String tablename)
/*      */   {
/*  264 */     if (tablename.equals("商品表"))
/*      */     {
/*  267 */       return "Goods";
/*      */     }
/*      */ 
/*  272 */     if (tablename.equals("销售订单表"))
/*      */     {
/*  275 */       return "Orders";
/*      */     }
/*      */ 
/*  279 */     if (tablename.equals("镶嵌任务表"))
/*      */     {
/*  281 */       return "Imbedtask";
/*      */     }
/*      */ 
/*  285 */     if (tablename.equals("用户表"))
/*      */     {
/*  288 */       return "Userinfo";
/*      */     }
/*      */ 
/*  292 */     if (tablename.equals("设计师表"))
/*      */     {
/*  295 */       return "Designer";
/*      */     }
/*      */ 
/*  299 */     if (tablename.equals("镶嵌样式表"))
/*      */     {
/*  303 */       return "Styles";
/*      */     }
/*      */ 
/*  306 */     if (tablename.equals("工厂表"))
/*      */     {
/*  309 */       return "Factory";
/*      */     }
/*      */ 
/*  313 */     if (tablename.equals("普通任务表"))
/*      */     {
/*  316 */       return "Tasks";
/*      */     }
/*      */ 
/*  320 */     if (tablename.equals("新用户表"))
/*      */     {
/*  323 */       return "Newuser";
/*      */     }
/*      */ 
/*  328 */     if (tablename.equals("修改申请表"))
/*      */     {
/*  331 */       return "Submodify";
/*      */     }
/*      */ 
/*  334 */     return tablename;
/*      */   }
/*      */ 
/*      */   int findIndex(String[] cn, String target) {
/*  338 */     for (int i = 0; i < cn.length; i++)
/*  339 */       if (cn[i].equals(target)) return i;
/*  340 */     return -1;
/*      */   }
/*      */ 
/*      */   public String[][] readdate(String table)
/*      */   {
/*  346 */     String Sql = " From " + getTable(table) + " t";
/*  347 */     String[] heads = getTableHead(table, "en");
/*  348 */     String headsql = "Select ";
/*  349 */     for (int i = 0; i < heads.length; i++)
/*      */     {
/*  351 */       headsql = headsql + "t." + heads[i] + ",";
/*      */     }
/*  353 */     headsql = headsql.substring(0, headsql.length() - 1);
/*  354 */     List l = this.tasksService.getMyDao().query(headsql + Sql);
/*  355 */     String[][] reTxt = new String[l.size() + 1][];
/*      */ 
/*  357 */     int row = 1;
/*  358 */     String[] head = getTableHead(table, "cn");
/*      */ 
/*  360 */     reTxt[0] = new String[head.length];
/*  361 */     for (int i = 0; i < head.length; i++)
/*  362 */       reTxt[0][i] = head[i];
/*  363 */     for (Iterator tempIterator = l.iterator(); tempIterator.hasNext(); )
/*      */     {
/*  365 */       Object[] le = (Object[])tempIterator.next();
/*      */ 
/*  368 */       reTxt[row] = new String[le.length];
/*  369 */       for (int i = 0; i < le.length; i++)
/*      */       {
/*  371 */         reTxt[row][i] = ((String)le[i]);
/*      */       }
/*      */ 
/*  376 */       row++;
/*      */     }
/*  378 */     return reTxt;
/*      */   }
/*      */ 
/*      */   public void exportExcel(String name) {
/*  382 */     String[][][] data = null;
/*  383 */     String[] tables = getTables("cn");
/*  384 */     data = new String[tables.length][][];
/*  385 */     for (int i = 0; i < tables.length; i++)
/*      */     {
/*  387 */       data[i] = readdate(tables[i]);
/*      */     }
/*  389 */     ReadExcel001.export(getTables("cn"), data, name);
/*      */   }
/*      */ 
/*      */   String[] getTables(String isCn) {
/*  393 */     String[] en = { "Newuser", "Submodify" };
/*  394 */     String[] cn = { "新用户表", "修改申请表" };
/*      */ 
/*  398 */     if (isCn.equals("cn")) return cn;
/*      */ 
/*  400 */     return en;
/*      */   }
/*      */ 
/*      */   String[] getTableHead(String table, String isCn)
/*      */   {
/*  405 */     if ((table == null) || (table.trim().length() <= 0)) return null;
/*  406 */     if (table.equals("销售订单表"))
/*      */     {
/*  408 */       String[] en = { "orderid", "orderdesc", "customerid", "goodsid", "saler", "price", "priceoff", "pay", "nopay", "status", "orderdata", "isimbed", "imbedstyleid", "imbedtaskid", "imbedsize", "imbedcolor", "imbedtype1", "imbedtype2", "imbedurgent", "imbedmax", "pic1", "pic2" };
/*  409 */       String[] cn = { "订单编码", "订单简述", "客户编码", "商品编码", "销售人", "交易价格", "折扣", "已付定金", "未付尾款", "交易状态", "下单日期", "是否镶嵌", "镶嵌样式编码", "镶嵌任务编码", "镶嵌手寸", "镶嵌K金颜色", "镶嵌特殊刻字", "镶嵌精工", "镶嵌加急", "镶嵌预算上限", "定稿图片1", "定稿图片2" };
/*      */ 
/*  411 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  413 */       return en;
/*      */     }
/*      */ 
/*  417 */     if (table.equals("修改申请表"))
/*      */     {
/*  419 */       String[] en = { "modifyid", "time", "openid", "nickname", "type", "subcontent", "feedback" };
/*  420 */       String[] cn = { "修改编码", "时间", "openid", "昵称", "类型", "提交内容", "反馈" };
/*      */ 
/*  422 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  424 */       return en;
/*      */     }
/*      */ 
/*  429 */     if (table.equals("用户表"))
/*      */     {
/*  431 */       String[] en = { "userid", "openid", "name", "nickname", "state1", "sex", "age", "state2", "province", "city", "type", "level", "priceoff", "phone1", "phone2", "weixin", "qq", "ww", "address", "buygoods", "buyprice", "score", "damondlike", "lifelike", "recommanderid", "recommander" };
/*  432 */       String[] cn = { "用户编码", "OpenID", "姓名", "微信昵称", "关注状态", "性别", "年龄", "国家", "省份", "城市", "身份", "客户级别", "折扣率", "联系电话1", "联系电话2", "微信", "QQ", "旺旺", "收货地址", "已购买商品", "已购买额度", "积分", "珠宝偏好", "生活偏好", "引荐人编码", "前级引荐人编码" };
/*  433 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  435 */       return en;
/*      */     }
/*  437 */     if (table.equals("新用户表"))
/*      */     {
/*  439 */       String[] en = { "userid", "openid", "name", "nickname", "state1", "sex", "age", "state2", "province", "city", "type", "level", "priceoff", "phone1", "phone2", "weixin", "qq", "ww", "address", "buygoods", "buyprice", "score", "damondlike", "lifelike", "recommanderid", "recommander" };
/*  440 */       String[] cn = { "用户编码", "OpenID", "姓名", "微信昵称", "关注状态", "性别", "年龄", "国家", "省份", "城市", "身份", "客户级别", "折扣率", "联系电话1", "联系电话2", "微信", "QQ", "旺旺", "收货地址", "已购买商品", "已购买额度", "积分", "珠宝偏好", "生活偏好", "引荐人编码", "前级引荐人编码" };
/*  441 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  443 */       return en;
/*      */     }
/*      */ 
/*  446 */     if (table.equals("镶嵌任务表"))
/*      */     {
/*  448 */       String[] en = { "taskid", "facid", "userid", "handerid", "goodid", "orderid", "imbedstyle", "imbedsize", "imbedcolor", "imbedspeical", "imbeddetail", "imbedurgent", "imbedprice", "others", "begindate", "maybeprice", "status", "askdate", "plandate", "pic1", "pic2", "compic1", "compic2", "compic3" };
/*  449 */       String[] cn = { "镶嵌任务编码", "工厂编码", "客户编码", "经手人编码", "商品编码", "订单编码", "镶嵌样式编码", "镶嵌手寸", "镶嵌K金颜色", "镶嵌特殊刻字", "镶嵌精工", "镶嵌加急", "镶嵌预算上限", "其他备注", "送镶日期", "预计定制费用", "当前状态", "客户要求竣工日期", "预计竣工日期", "定稿图片1", "定稿图片2", "电脑图片1", "电脑图片2", "电脑图片3" };
/*  450 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  452 */       return en;
/*      */     }
/*  454 */     if (table.equals("商品表"))
/*      */     {
/*  456 */       String[] en = { "goodid", "name", "type", "ditype", "weight", "minitype", "miniweight", "goldweight", "price", "totalprice", "figure", "surface", "color", "clear", "certification", "handle", "productaddr", "material", "owner", "keepaddr", "saletype", "pic1", "pic2", "pic3", "pic4", "pic5" };
/*  457 */       String[] cn = { "商品编码", "名称", "商品类型", "宝石类型", "裸石重量", "配石类型", "配石总重", "金重", "单价", "总价", "形状", "刻/素面", "颜色", "净度", "证书", "优化处理", "产地", "镶嵌材质", "货品所有人", "存货地点", "销售状态", "照片1", "照片2", "照片3", "照片4", "照片5" };
/*  458 */       if (isCn.equals("cn")) return cn;
/*      */ 
/*  460 */       return en;
/*      */     }
/*  462 */     return null;
/*      */   }
/*      */ 
/*      */   String getPara(String table, String para) {
/*  466 */     if ((para == null) || (para.trim().length() <= 0)) return "";
/*  467 */     if (table.equals("销售订单表"))
/*      */     {
/*  469 */       String[] en = { "orderid", "orderdesc", "customerid", "goodsid", "saler", "price", "priceoff", "pay", "nopay", "status", "orderdata", "isimbed", "imbedstyleid", "imbedtaskid", "imbedsize", "imbedcolor", "imbedtype1", "imbedtype2", "imbedurgent", "imbedmax", "pic1", "pic2" };
/*  470 */       String[] cn = { "订单编码", "订单简述", "客户编码", "商品编码", "销售人", "交易价格", "折扣", "已付定金", "未付尾款", "交易状态", "下单日期", "是否镶嵌", "镶嵌样式编码", "镶嵌任务编码", "镶嵌手寸", "镶嵌K金颜色", "镶嵌特殊刻字", "镶嵌精工", "镶嵌加急", "镶嵌预算上限", "定稿图片1", "定稿图片2" };
/*  471 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  475 */     if (table.equals("用户表"))
/*      */     {
/*  477 */       String[] en = { "userid", "openid", "name", "nickname", "state1", "sex", "age", "state2", "province", "city", "type", "level", "priceoff", "phone1", "phone2", "weixin", "qq", "ww", "address", "buygoods", "buyprice", "score", "damondlike", "lifelike", "recommanderid", "recommander" };
/*  478 */       String[] cn = { "用户编码", "OpenID", "姓名", "微信昵称", "关注状态", "性别", "年龄", "国家", "省份", "城市", "身份", "客户级别", "折扣率", "联系电话1", "联系电话2", "微信", "QQ", "旺旺", "收货地址", "已购买商品", "已购买额度", "积分", "珠宝偏好", "生活偏好", "引荐人编码", "前级引荐人编码" };
/*  479 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  482 */     if (table.equals("镶嵌任务表"))
/*      */     {
/*  484 */       String[] en = { "taskid", "facid", "userid", "handerid", "goodid", "orderid", "imbedstyle", "imbedsize", "imbedcolor", "imbedspeical", "imbeddetail", "imbedurgent", "imbedprice", "others", "begindate", "maybeprice", "status", "askdate", "plandate", "pic1", "pic2", "compic1", "compic2", "compic3" };
/*  485 */       String[] cn = { "镶嵌任务编码", "工厂编码", "客户编码", "经手人编码", "商品编码", "订单编码", "镶嵌样式编码", "镶嵌手寸", "镶嵌K金颜色", "镶嵌特殊刻字", "镶嵌精工", "镶嵌加急", "镶嵌预算上限", "其他备注", "送镶日期", "预计定制费用", "当前状态", "客户要求竣工日期", "预计竣工日期", "定稿图片1", "定稿图片2", "电脑图片1", "电脑图片2", "电脑图片3" };
/*  486 */       return en[findIndex(cn, para)];
/*      */     }
/*  488 */     if (table.equals("商品表"))
/*      */     {
/*  490 */       String[] en = { "goodid", "name", "type", "ditype", "weight", "minitype", "miniweight", "goldweight", "price", "totalprice", "figure", "surface", "color", "clear", "certification", "handle", "productaddr", "material", "owner", "keepaddr", "saletype", "pic1", "pic2", "pic3", "pic4", "pic5" };
/*  491 */       String[] cn = { "商品编码", "名称", "商品类型", "宝石类型", "裸石重量", "配石类型", "配石总重", "金重", "单价", "总价", "形状", "刻/素面", "颜色", "净度", "证书", "优化处理", "产地", "镶嵌材质", "货品所有人", "存货地点", "销售状态", "照片1", "照片2", "照片3", "照片4", "照片5" };
/*  492 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  495 */     if (table.equals("设计师表"))
/*      */     {
/*  497 */       String[] en = { "designerid", "level", "name", "sex", "age", "style", "designtype", "resume", "cardid", "phone1", "phone2", "weixin", "qq", "ww", "address", "pic", "demo1", "demo2", "demo3", "demo4" };
/*  498 */       String[] cn = { "设计师编码", "级别", "姓名", "性别", "年龄", "设计风格", "设计理念", "个人简介", "身份证号码", "联系电话1", "联系电话2", "微信", "QQ", "旺旺", "居住地", "照片", "设计稿展示1", "设计稿展示2", "设计稿展示3", "设计稿展示4" };
/*  499 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  502 */     if (table.equals("镶嵌样式表"))
/*      */     {
/*  504 */       String[] en = { "styleid", "usedfor", "stylecolor", "type", "type1", "forage", "forplace", "material", "figure", "figuresize", "preprice", "pic1", "pic2", "pic3", "pic4", "pic5", "memo" };
/*  505 */       String[] cn = { "样式编码", "用途", "镶石示意颜色", "风格", "适合性格", "佩戴年龄段", "佩戴场合", "建议材质", "镶石形状", "镶石大小", "预计价格", "图片1", "图片2", "图片3", "图片4", "图片5", "备注" };
/*  506 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  509 */     if (table.equals("工厂表"))
/*      */     {
/*  511 */       String[] en = { "factoryid", "serlevel", "name", "address", "contact", "phone1", "phone2", "weixin", "qq", "ww" };
/*  512 */       String[] cn = { "工厂编码", "服务级别", "名称", "地址", "联系人", "联系电话1", "联系电话2", "微信", "QQ", "旺旺" };
/*  513 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  516 */     if (table.equals("修改申请表"))
/*      */     {
/*  518 */       String[] en = { "modifyid", "time", "openid", "nickname", "type", "subcontent", "feedback" };
/*  519 */       String[] cn = { "修改编码", "时间", "openid", "昵称", "类型", "提交内容", "反馈" };
/*      */ 
/*  521 */       return en[findIndex(cn, para)];
/*      */     }
/*      */ 
/*  534 */     return "";
/*      */   }
/*      */ 
/*      */   String getCondition(String c1, String p1, String c2, String p2, String c3, String p3)
/*      */   {
/*  549 */     String sql = "";
/*  550 */     if ((p1 != null) && (p1.length() > 0))
/*      */     {
/*  552 */       sql = sql + "t." + c1 + "='" + p1 + "'";
/*      */     }
/*  554 */     if ((p2 != null) && (p2.length() > 0))
/*      */     {
/*  556 */       sql = sql + " and t." + c2 + "='" + p2 + "'";
/*      */     }
/*  558 */     if ((p3 != null) && (p3.length() > 0))
/*      */     {
/*  560 */       sql = sql + " and t." + c3 + "='" + p3 + "'";
/*      */     }
/*  562 */     return sql;
/*      */   }
/*      */ 
/*      */   String exeTask(Tasks t, String str, String openid)
/*      */   {
/*  567 */     String[] thep = str.split("-");
/*  568 */     String[] parameters = new String[4];
/*  569 */     for (int i = 0; i < 4; i++)
/*      */     {
/*  571 */       if (thep.length > i) parameters[i] = thep[i];
/*      */       else {
/*  573 */         parameters[i] = new String("");
/*      */       }
/*      */     }
/*      */ 
/*  577 */     String table = getTable(t.getThetable());
/*  578 */     String col1 = t.getReturn1();
/*  579 */     String col2 = t.getReturn2();
/*  580 */     String col3 = t.getReturn3();
/*  581 */     String col4 = t.getReturn4();
/*  582 */     String col5 = t.getReturn5();
/*  583 */     String conditionco1 = t.getIsmatchid();
/*  584 */     String conditionco2 = getPara(t.getThetable(), t.getIdmatchstr());
/*  585 */     String returnTxt = t.getReturntxt();
/*  586 */     String conditionco3 = getPara(t.getThetable(), t.getFilter1());
/*      */ 
/*  589 */     String conditionco5 = getPara(t.getThetable(), t.getFilter2());
/*      */ 
/*  591 */     String conditionco7 = getPara(t.getThetable(), t.getFilter3());
/*      */ 
/*  593 */     String re = "";
/*  594 */     String sql = "";
/*  595 */     if (returnTxt.equals("submodify"))
/*      */     {
/*  597 */       Submodify s = new Submodify();
/*  598 */       s.setOpenid(openid);
/*  599 */       s.setTime(new Date().toLocaleString());
/*  600 */       Userinfo user = this.userinfoService.loadUserinfoByuserid(openid);
/*  601 */       s.setNickname(user.getNickname());
/*  602 */       s.setSubcontent(parameters[1]);
/*  603 */       this.submodifyService.saveOrUpdateSubmodify(s);
/*  604 */       return "成功提交";
/*      */     }
/*  606 */     if (returnTxt.equals("img"))
/*      */     {
/*  609 */       String cols = "";
/*  610 */       if ((col1 != null) && (!col1.trim().equals(""))) cols = cols + col3.trim() + ";";
/*  611 */       if ((col2 != null) && (!col2.trim().equals(""))) cols = cols + col4.trim() + ";";
/*  612 */       if ((col3 != null) && (!col3.trim().equals(""))) cols = cols + col5.trim() + ";";
/*      */ 
/*  614 */       String[] colsitem = cols.split(";");
/*      */ 
/*  616 */       int cnnum = 0;
/*  617 */       String[] cnnames = new String[colsitem.length];
/*  618 */       for (int i = 0; i < colsitem.length; i++)
/*      */       {
/*  620 */         if ((colsitem[i] != null) && (colsitem[i].length() > 0))
/*      */         {
/*  622 */           sql = addsqlstr(sql, colsitem[i], t.getThetable());
/*  623 */           cnnames[(cnnum++)] = colsitem[i];
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  629 */       sql = "select " + sql + " from " + table + " t ";
/*  630 */       if (conditionco1.equals("是"))
/*      */       {
/*  632 */         sql = sql + " where t." + conditionco2 + "='" + openid + "'";
/*      */       }
/*      */ 
/*  635 */       if (thep.length > 1)
/*      */       {
/*  639 */         if (sql.indexOf("where") < 0)
/*      */         {
/*  641 */           sql = sql + " where " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */         else
/*      */         {
/*  645 */           sql = sql + "and " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  651 */       List l = this.tasksService.getMyDao().query(sql);
/*  652 */       if ((l == null) || (l.size() <= 0)) return "没有符合要求的项目";
/*  653 */       HashMap remap = new HashMap();
/*  654 */       remap.put("pic", t.getReturn1());
/*  655 */       remap.put("title", t.getReturn2());
/*  656 */       List list = new ArrayList();
/*  657 */       for (Iterator tempIterator = l.iterator(); tempIterator.hasNext(); )
/*      */       {
/*  659 */         Object[] le = (Object[])tempIterator.next();
/*      */ 
/*  661 */         HashMap tempMap = new HashMap();
/*      */ 
/*  665 */         for (int i = 0; i < le.length; i++)
/*      */         {
/*  667 */           tempMap.put("cn" + i, cnnames[i]);
/*  668 */           tempMap.put(i, (String)le[i]);
/*      */         }
/*      */ 
/*  671 */         list.add(tempMap);
/*      */       }
/*      */ 
/*  675 */       remap.put("list", list);
/*      */       try {
/*  677 */         re = JSONObject.fromObject(remap).toString();
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/*  681 */         e.printStackTrace();
/*      */       }
/*      */ 
/*      */     }
/*  686 */     else if (returnTxt.equals("style"))
/*      */     {
/*  689 */       String cols = "";
/*  690 */       if ((col1 != null) && (!col1.trim().equals(""))) cols = cols + col3.trim() + ";";
/*  691 */       if ((col2 != null) && (!col2.trim().equals(""))) cols = cols + col4.trim() + ";";
/*  692 */       if ((col3 != null) && (!col3.trim().equals(""))) cols = cols + col5.trim() + ";";
/*      */ 
/*  694 */       String[] colsitem = cols.split(";");
/*      */ 
/*  696 */       int cnnum = 0;
/*  697 */       String[] cnnames = new String[colsitem.length];
/*  698 */       for (int i = 0; i < colsitem.length; i++)
/*      */       {
/*  700 */         if ((colsitem[i] != null) && (colsitem[i].length() > 0))
/*      */         {
/*  702 */           sql = addsqlstr(sql, colsitem[i], t.getThetable());
/*  703 */           cnnames[(cnnum++)] = colsitem[i];
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  709 */       sql = "select " + sql + " from " + table + " t ";
/*  710 */       if (conditionco1.equals("是"))
/*      */       {
/*  712 */         sql = sql + " where t." + conditionco2 + "='" + openid + "'";
/*      */       }
/*      */ 
/*  715 */       if (thep.length > 1)
/*      */       {
/*  719 */         if (sql.indexOf("where") < 0)
/*      */         {
/*  721 */           sql = sql + " where " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */         else
/*      */         {
/*  725 */           sql = sql + "and " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  731 */       List l = this.tasksService.getMyDao().query(sql);
/*  732 */       if ((l == null) || (l.size() <= 0)) return "没有符合要求的项目";
/*  733 */       System.out.println(sql);
/*  734 */       HashMap remap = new HashMap();
/*  735 */       remap.put("style", "true");
/*  736 */       remap.put("pic", t.getReturn1());
/*  737 */       remap.put("title", t.getReturn2());
/*  738 */       List list = new ArrayList();
/*  739 */       for (Iterator tempIterator = l.iterator(); tempIterator.hasNext(); )
/*      */       {
/*  741 */         Object[] le = (Object[])tempIterator.next();
/*      */ 
/*  743 */         HashMap tempMap = new HashMap();
/*      */ 
/*  747 */         for (int i = 0; i < le.length; i++)
/*      */         {
/*  749 */           tempMap.put("cn" + i, cnnames[i]);
/*  750 */           tempMap.put(i, (String)le[i]);
/*      */         }
/*      */ 
/*  753 */         list.add(tempMap);
/*      */       }
/*      */ 
/*  757 */       remap.put("list", list);
/*      */       try {
/*  759 */         re = JSONObject.fromObject(remap).toString();
/*      */       }
/*      */       catch (Exception e)
/*      */       {
/*  763 */         e.printStackTrace();
/*      */       }
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*  771 */       if ((col1 != null) && (!col1.trim().equals(""))) sql = addsqlstr(sql, col1.trim(), t.getThetable());
/*  772 */       if ((col2 != null) && (!col2.trim().equals(""))) sql = addsqlstr(sql, col2.trim(), t.getThetable());
/*  773 */       if ((col3 != null) && (!col3.trim().equals(""))) sql = addsqlstr(sql, col3.trim(), t.getThetable());
/*  774 */       if ((col4 != null) && (!col4.trim().equals(""))) sql = addsqlstr(sql, col4.trim(), t.getThetable());
/*  775 */       if ((col5 != null) && (!col5.trim().equals(""))) sql = addsqlstr(sql, col5.trim(), t.getThetable());
/*      */ 
/*  777 */       sql = "select " + sql + " from " + table + " t ";
/*  778 */       if (conditionco1.equals("是"))
/*      */       {
/*  780 */         sql = sql + " where t." + conditionco2 + "='" + openid + "'";
/*      */       }
/*      */ 
/*  783 */       if (thep.length > 1)
/*      */       {
/*  787 */         if (sql.indexOf("where") < 0)
/*      */         {
/*  789 */           sql = sql + " where " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */         else
/*      */         {
/*  793 */           sql = sql + "and " + getCondition(conditionco3, parameters[1], conditionco5, parameters[2], conditionco7, parameters[3]);
/*      */         }
/*      */       }
/*      */ 
/*  797 */       System.out.println("exesql====" + sql);
/*  798 */       List l = this.tasksService.getMyDao().query(sql);
/*  799 */       if ((l == null) || (l.size() <= 0)) return "没有符合要求的项目";
/*  800 */       for (Iterator tempIterator = l.iterator(); tempIterator.hasNext(); )
/*      */       {
/*  802 */         Object[] le = (Object[])tempIterator.next();
/*      */ 
/*  804 */         String tempTxt = returnTxt;
/*      */ 
/*  806 */         for (int i = 0; i < le.length; i++)
/*      */         {
/*  808 */           tempTxt = tempTxt.replaceFirst("返回字段" + (i + 1), (String)le[i]);
/*      */         }
/*      */ 
/*  811 */         re = re + tempTxt + ";";
/*      */       }
/*  813 */       re = t.getGole() + ":" + re;
/*      */     }
/*      */ 
/*  816 */     System.out.println("exesql====" + re);
/*  817 */     return re;
/*      */   }
/*      */ 
/*      */   int myindexof(String src, String des, int value)
/*      */   {
/*  844 */     if ((des == null) || (des.trim().length() <= 0)) return 0;
/*  845 */     if (src.indexOf(des) >= 0) return value;
/*  846 */     return 0;
/*      */   }
/*      */ 
/*      */   List<Tasks> getTaskList(String userType, String inputStr) {
/*  850 */     String[] theinput = inputStr.split(",");
/*  851 */     String matchkey = theinput[0];
/*  852 */     List returnTask = new ArrayList();
/*  853 */     List task = this.tasksService.browseTasks();
/*      */ 
/*  855 */     int max = 0;
/*  856 */     for (int i = 0; i < task.size(); i++)
/*      */     {
/*  858 */       Tasks t = (Tasks)task.get(i);
/*      */ 
/*  860 */       if ((userType.equals(t.getExe1())) || (userType.equals(t.getExe2())) || (userType.equals(t.getExe3())) || (userType.equals(t.getExe4())) || (userType.equals(t.getExe5())))
/*      */       {
/*  862 */         if (matchkey.trim().equals(t.getTaskid()))
/*      */         {
/*  864 */           returnTask.add(t);
/*  865 */           return returnTask;
/*      */         }
/*  867 */         int tempvalue = myindexof(matchkey, t.getKey1(), 3) + myindexof(matchkey, t.getKey2(), 2) + myindexof(matchkey, t.getKey3(), 1) + myindexof(matchkey, t.getKey4(), 1) + myindexof(matchkey, t.getKey5(), 1);
/*  868 */         if (tempvalue >= max) max = tempvalue;
/*      */       }
/*      */ 
/*      */     }
/*      */ 
/*  873 */     for (int i = 0; i < task.size(); i++)
/*      */     {
/*  875 */       if (max == 0) break;
/*  876 */       Tasks t = (Tasks)task.get(i);
/*  877 */       int tempvalue = myindexof(matchkey, t.getKey1(), 3) + myindexof(matchkey, t.getKey2(), 2) + myindexof(matchkey, t.getKey3(), 1) + myindexof(matchkey, t.getKey4(), 1) + myindexof(matchkey, t.getKey5(), 1);
/*  878 */       if ((tempvalue == max) && ((userType.equals(t.getExe1())) || (userType.equals(t.getExe2())) || (userType.equals(t.getExe3())) || (userType.equals(t.getExe4())) || (userType.equals(t.getExe5())))) returnTask.add(t);
/*      */     }
/*      */ 
/*  881 */     return returnTask;
/*      */   }
/*      */ 
/*      */   public static Map<String, Object> parseJSON2Map(String jsonStr) {
/*  885 */     Map map = new HashMap();
/*      */ 
/*  887 */     JSONObject json = JSONObject.fromObject(jsonStr);
/*  888 */     for (Iterator localIterator1 = json.keySet().iterator(); localIterator1.hasNext(); ) { Object k = localIterator1.next();
/*  889 */       Object v = json.get(k);
/*      */ 
/*  891 */       if ((v instanceof JSONArray)) {
/*  892 */         List list = new ArrayList();
/*  893 */         Iterator it = ((JSONArray)v).iterator();
/*  894 */         while (it.hasNext()) {
/*  895 */           JSONObject json2 = (JSONObject)it.next();
/*  896 */           list.add(parseJSON2Map(json2.toString()));
/*      */         }
/*  898 */         map.put(k.toString(), list);
/*      */       } else {
/*  900 */         map.put(k.toString(), v);
/*      */       }
/*      */     }
/*  903 */     return map;
/*      */   }
/*      */ 
/*      */   public int getScenNumByID(String ID) {
/*  907 */     String scennum = "-1";
/*  908 */     if ((ID != null) && (ID.length() >= 8)) {
/*  909 */       scennum = ID.substring(8);
/*      */     }
/*  911 */     return Integer.parseInt(scennum);
/*      */   }
/*      */ 
/*      */   public int getMaxScenNum(String openid) {
/*  915 */     int max = 0;
/*  916 */     List ulist = this.userinfoService.browseUserinfo();
/*  917 */     for (int i = 0; i < ulist.size(); i++)
/*      */     {
/*  919 */       Userinfo u = (Userinfo)ulist.get(i);
/*  920 */       int scennum = getScenNumByID(u.getUserid());
/*  921 */       if (scennum > max) max = scennum;
/*  922 */       if (u.getOpenid().equals(openid)) return getScenNumByID(u.getUserid());
/*      */     }
/*      */ 
/*  925 */     List newList = this.newuserService.browseNewuser();
/*  926 */     for (int i = 0; i < newList.size(); i++)
/*      */     {
/*  928 */       Newuser u = (Newuser)newList.get(i);
/*  929 */       int scennum = getScenNumByID(u.getUserid());
/*  930 */       if (scennum > max) max = scennum;
/*  931 */       if (u.getOpenid().equals(openid)) return getScenNumByID(u.getUserid());
/*      */     }
/*  933 */     if (max < 10000) max += 10000;
/*  934 */     return max + 1;
/*      */   }
/*      */ 
/*      */   public String processRequest(HttpServletRequest request)
/*      */   {
/*  939 */     System.out.println("processRequest");
/*  940 */     System.setProperty("jsse.enableSNIExtension", "false");
/*      */ 
/* 1016 */     String respMessage = null;
/*      */     try
/*      */     {
/* 1021 */       Map requestMap = MessageUtil.parseXml(request);
/*      */ 
/* 1024 */       String fromUserName = (String)requestMap.get("FromUserName");
/*      */ 
/* 1026 */       String toUserName = (String)requestMap.get("ToUserName");
/*      */ 
/* 1028 */       String msgType = (String)requestMap.get("MsgType");
/*      */ 
/* 1034 */       if (msgType.equals("text")) {
/* 1035 */         String content = (String)requestMap.get("Content");
/* 1036 */         Userinfo user = getUserStatus(fromUserName, null);
/* 1037 */         if (user == null)
/*      */         {
/* 1040 */           TextMessage textMessage = new TextMessage();
/* 1041 */           textMessage.setToUserName(fromUserName);
/* 1042 */           textMessage.setFromUserName(toUserName);
/* 1043 */           textMessage.setCreateTime(new Date().getTime());
/* 1044 */           textMessage.setMsgType("text");
/* 1045 */           textMessage.setFuncFlag(0);
/*      */ 
/* 1048 */           textMessage.setContent("新用户，还不能执行任务，请联系管理员！");
/*      */ 
/* 1050 */           respMessage = MessageUtil.textMessageToXml(textMessage);
/* 1051 */           System.out.println(respMessage);
/* 1052 */           return respMessage;
/*      */         }
/* 1054 */         String userStatue = user.getType();
/* 1055 */         if ((userStatue == null) || (userStatue.equals("")))
/*      */         {
/* 1057 */           return "";
/*      */         }
/*      */ 
/* 1061 */         List theTasks1 = getTaskList(userStatue, content);
/* 1062 */         String txt = handleTasks(theTasks1, content, fromUserName);
/*      */ 
/* 1064 */         System.out.println(txt);
/* 1065 */         String beinChar = txt.substring(0, 1);
/* 1066 */         if (beinChar.equals("{"))
/*      */         {
/* 1068 */           NewsMessage newmessage = new NewsMessage();
/* 1069 */           newmessage.setToUserName(fromUserName);
/* 1070 */           newmessage.setFromUserName(toUserName);
/* 1071 */           newmessage.setCreateTime(new Date().getTime());
/* 1072 */           newmessage.setMsgType("news");
/* 1073 */           newmessage.setFuncFlag(0);
/*      */ 
/* 1075 */           List articleList = new ArrayList();
/* 1076 */           Map themap = parseJSON2Map(txt);
/* 1077 */           String title = (String)themap.get("titile");
/* 1078 */           String style = (String)themap.get("style");
/* 1079 */           String picurl = (String)themap.get("pic");
/* 1080 */           List maplist = (List)themap.get("list");
/*      */ 
/* 1083 */           String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
/*      */ 
/* 1085 */           Article article = new Article();
/* 1086 */           article.setPicUrl(picurl);
/*      */ 
/* 1088 */           int mpsize = maplist.size();
/*      */ 
/* 1090 */           String itemurl = "";
/* 1091 */           if ((style != null) && (style.equals("true"))) {
/* 1092 */             itemurl = "/viewstyle.jsp?total=" + mpsize + "&openid=" + fromUserName;
/*      */           }
/*      */           else {
/* 1095 */             itemurl = "/view.jsp?total=" + mpsize + "&openid=" + fromUserName;
/*      */           }
/*      */ 
/* 1098 */           for (int i = 0; i < mpsize; i++)
/*      */           {
/* 1102 */             Map mymap = (Map)maplist.get(i);
/*      */ 
/* 1104 */             itemurl = itemurl + "&" + i + "pic1=" + URLEncoder.encode((String)mymap.get("0"));
/*      */ 
/* 1106 */             itemurl = itemurl + "&" + i + "pic2=" + URLEncoder.encode((String)mymap.get("1"));
/* 1107 */             itemurl = itemurl + "&" + i + "pic3=" + URLEncoder.encode((String)mymap.get("2"));
/* 1108 */             itemurl = itemurl + "&" + i + "pic4=" + URLEncoder.encode((String)mymap.get("3"));
/*      */ 
/* 1112 */             int pnum = 0;
/* 1113 */             for (int j = 0; j < mymap.keySet().size() / 2; j++)
/*      */             {
/* 1115 */               String colcn = URLEncoder.encode((String)mymap.get("cn" + j));
/* 1116 */               String colvalue = URLEncoder.encode((String)mymap.get(j));
/*      */ 
/* 1118 */               itemurl = itemurl + "&" + i + "p" + pnum + "=" + colcn + "&" + i + "p" + (pnum + 1) + "=" + colvalue;
/* 1119 */               pnum += 2;
/*      */             }
/*      */ 
/*      */           }
/*      */ 
/* 1124 */           article.setUrl(basePath + itemurl);
/* 1125 */           System.out.println("mymap=" + article.getUrl());
/* 1126 */           articleList.add(article);
/*      */ 
/* 1134 */           newmessage.setArticleCount(articleList.size());
/*      */ 
/* 1137 */           newmessage.setArticles(articleList);
/*      */ 
/* 1141 */           respMessage = MessageUtil.newsMessageToXml(newmessage);
/* 1142 */           System.out.println(respMessage);
/*      */         }
/*      */         else
/*      */         {
/* 1147 */           TextMessage textMessage = new TextMessage();
/* 1148 */           textMessage.setToUserName(fromUserName);
/* 1149 */           textMessage.setFromUserName(toUserName);
/* 1150 */           textMessage.setCreateTime(new Date().getTime());
/* 1151 */           textMessage.setMsgType("text");
/* 1152 */           textMessage.setFuncFlag(0);
/*      */ 
/* 1155 */           textMessage.setContent(txt);
/* 1156 */           respMessage = MessageUtil.textMessageToXml(textMessage);
/* 1157 */           System.out.println(respMessage);
/*      */         }
/*      */ 
/*      */       }
/* 1165 */       else if (msgType.equals("event"))
/*      */       {
/* 1168 */         String eventType = (String)requestMap.get("Event");
/* 1169 */         String eventKey = (String)requestMap.get("EventKey");
/* 1170 */         String respContent = "";
/* 1171 */         System.out.println(eventType + "," + eventKey);
/* 1172 */         if (eventType.equals("subscribe"))
/*      */         {
/* 1174 */           System.out.println("感谢您关注偶");
/* 1175 */           respContent = "感谢您关注偶,这里会给您提供最新的公司资讯和公告！\n";
/*      */ 
/* 1183 */           String token = getAccessToken("wxab2c9ffb3c60ff14", "b3b5985710adabcfbce1daed8b156b29");
/* 1184 */           String posturl = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=" + URLEncoder.encode(token);
/* 1185 */           JSONObject obj = new JSONObject();
/*      */ 
/* 1187 */           JSONObject scene = new JSONObject();
/* 1188 */           JSONObject sceneid = new JSONObject();
/* 1189 */           if ((eventKey != null) && (eventKey.length() >= 8)) eventKey = eventKey.substring(8);
/* 1190 */           int maxNum = getMaxScenNum(fromUserName);
/*      */ 
/* 1200 */           sceneid.element("scene_id", maxNum);
/* 1201 */           scene.element("scene", sceneid);
/*      */ 
/* 1203 */           obj.element("action_name", "QR_LIMIT_SCENE");
/* 1204 */           obj.element("action_info", scene);
/* 1205 */           System.out.println("post=" + posturl + ":" + obj.toString());
/* 1206 */           String reJson = HttpPostUtils.httpsPostJson(posturl, obj);
/* 1207 */           JSONObject reObj = JSONObject.fromObject(reJson);
/* 1208 */           String ticket = (String)reObj.get("ticket");
/* 1209 */           if ((ticket == null) || (ticket.length() <= 0))
/*      */           {
/* 1211 */             System.out.println("ticket=" + ticket);
/* 1212 */             respContent = "错误";
/*      */           }
/*      */ 
/* 1215 */           String path = request.getRealPath("/upload");
/* 1216 */           System.out.println("path : " + path);
/* 1217 */           String imageurl = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(ticket);
/*      */ 
/* 1219 */           String myimgurl = HttpPostUtils.saveImageToDisk(imageurl, path);
/*      */ 
/* 1223 */           String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
/*      */ 
/* 1226 */           String mypicurl = basePath + "/upload/" + myimgurl;
/*      */ 
/* 1228 */           NewsMessage newmessage = new NewsMessage();
/* 1229 */           newmessage.setToUserName(fromUserName);
/* 1230 */           newmessage.setFromUserName(toUserName);
/* 1231 */           newmessage.setCreateTime(new Date().getTime());
/* 1232 */           newmessage.setMsgType("news");
/* 1233 */           newmessage.setFuncFlag(0);
/*      */ 
/* 1235 */           Userinfo u = getUserStatus(fromUserName, eventKey);
/*      */ 
/* 1237 */           List articleList = new ArrayList();
/*      */ 
/* 1241 */           Article article = new Article();
/* 1242 */           article.setPicUrl(mypicurl);
/*      */ 
/* 1246 */           article.setTitle("您的用户编码是：" + u.getUserid() + ",二维码如下");
/* 1247 */           article.setDescription("您的用户编码是：" + u.getUserid() + ",二维码如下,请保存二维码图片以作为会员卡使用，通过自己的二维码介绍给其他朋友关注时，可增加积分!");
/*      */ 
/* 1249 */           article.setUrl(mypicurl);
/*      */ 
/* 1251 */           articleList.add(article);
/*      */ 
/* 1262 */           newmessage.setArticleCount(articleList.size());
/*      */ 
/* 1265 */           newmessage.setArticles(articleList);
/*      */ 
/* 1269 */           respMessage = MessageUtil.newsMessageToXml(newmessage);
/* 1270 */           System.out.println(respMessage);
/*      */         }
/* 1275 */         else if (!eventType.equals("unsubscribe"))
/*      */         {
/* 1278 */           eventType.equals("CLICK");
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*      */     }
/*      */     catch (Exception e)
/*      */     {
/* 1301 */       e.printStackTrace();
/*      */     }
/* 1303 */     return respMessage;
/*      */   }
/*      */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.biz.core.impl.CoreServiceImpl
 * JD-Core Version:    0.6.2
 */