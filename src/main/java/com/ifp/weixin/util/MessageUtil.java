/*     */ package com.ifp.weixin.util;
/*     */ 
/*     */ import com.ifp.weixin.entity.Message.resp.Article;
/*     */ import com.ifp.weixin.entity.Message.resp.MusicMessage;
/*     */ import com.ifp.weixin.entity.Message.resp.NewsMessage;
/*     */ import com.ifp.weixin.entity.Message.resp.TextMessage;
/*     */ import com.thoughtworks.xstream.XStream;
/*     */ import com.thoughtworks.xstream.core.util.QuickWriter;
/*     */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*     */ import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
/*     */ import com.thoughtworks.xstream.io.xml.XppDriver;
/*     */ import java.io.InputStream;
/*     */ import java.io.Writer;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.dom4j.Document;
/*     */ import org.dom4j.Element;
/*     */ import org.dom4j.io.SAXReader;
/*     */ 
/*     */ public class MessageUtil
/*     */ {
/*  97 */   private static XStream xstream = new XStream(new XppDriver() {
/*     */     public HierarchicalStreamWriter createWriter(Writer out) {
/*  99 */       return new PrettyPrintWriter(out)
/*     */       {
/* 101 */         boolean cdata = true;
/*     */ 
/* 103 */         protected void writeText(QuickWriter writer, String text) { if (this.cdata) {
/* 104 */             writer.write("<![CDATA[");
/* 105 */             writer.write(text);
/* 106 */             writer.write("]]>");
/*     */           } else {
/* 108 */             writer.write(text);
/*     */           }
/*     */         }
/*     */       };
/*     */     }
/*     */   });
/*     */ 
/*     */   public static Map<String, String> parseXml(HttpServletRequest request)
/*     */     throws Exception
/*     */   {
/*  36 */     Map map = new HashMap();
/*     */ 
/*  38 */     InputStream inputStream = request.getInputStream();
/*     */ 
/*  40 */     SAXReader reader = new SAXReader();
/*  41 */     Document document = reader.read(inputStream);
/*     */ 
/*  43 */     Element root = document.getRootElement();
/*     */ 
/*  47 */     List<Element> elementList = root.elements();
/*     */ 
/*  50 */     for (Element e : elementList) {
/*  51 */       map.put(e.getName(), e.getText());
/*     */     }
/*  53 */     inputStream.close();
/*  54 */     inputStream = null;
/*     */ 
/*  56 */     return map;
/*     */   }
/*     */ 
/*     */   public static String textMessageToXml(TextMessage textMessage)
/*     */   {
/*  66 */     xstream.alias("xml", textMessage.getClass());
/*  67 */     return xstream.toXML(textMessage);
/*     */   }
/*     */ 
/*     */   public static String musicMessageToXml(MusicMessage musicMessage)
/*     */   {
/*  77 */     xstream.alias("xml", musicMessage.getClass());
/*  78 */     return xstream.toXML(musicMessage);
/*     */   }
/*     */ 
/*     */   public static String newsMessageToXml(NewsMessage newsMessage)
/*     */   {
/*  88 */     xstream.alias("xml", newsMessage.getClass());
/*  89 */     xstream.alias("item", new Article().getClass());
/*  90 */     return xstream.toXML(newsMessage);
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.util.MessageUtil
 * JD-Core Version:    0.6.2
 */