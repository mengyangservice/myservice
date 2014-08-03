/*    */ package com.ifp.weixin.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.UnsupportedEncodingException;
/*    */ import java.security.MessageDigest;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import java.util.Comparator;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Tools
/*    */ {
/* 18 */   private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', 
/* 19 */     '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*    */ 
/*    */   public static final String inputStream2String(InputStream in)
/*    */     throws UnsupportedEncodingException, IOException
/*    */   {
/* 23 */     if (in == null) {
/* 24 */       return "";
/*    */     }
/* 26 */     StringBuffer out = new StringBuffer();
/* 27 */     byte[] b = new byte[4096];
/*    */     int n;
/* 28 */     while ((n = in.read(b)) != -1)
/*    */     {
/* 29 */       out.append(new String(b, 0, n, "UTF-8"));
/*    */     }
/* 31 */     return out.toString();
/*    */   }
/*    */ 
/*    */   public static final boolean checkSignature(String signature, String timestamp, String nonce)
/*    */   {
/* 44 */     List<String> params = new ArrayList<String>();
/* 45 */     String token = "weixintest";
/* 46 */     params.add(token);
/* 47 */     params.add(timestamp);
/* 48 */     params.add(nonce);
/* 49 */     Collections.sort(params, new Comparator<String>() {
/*    */       public int compare(String o1, String o2) {
/* 52 */         return o1.compareTo(o2);
/*    */       }
/*    */     });
/* 55 */     String temp = (String)params.get(0) + (String)params.get(1) + (String)params.get(2);
/* 56 */     return encode(temp).equals(signature);
/*    */   }
/*    */ 
/*    */   private static String getFormattedText(byte[] bytes)
/*    */   {
/* 67 */     int len = bytes.length;
/* 68 */     StringBuilder buf = new StringBuilder(len * 2);
/*    */ 
/* 70 */     for (int j = 0; j < len; j++) {
/* 71 */       buf.append(HEX_DIGITS[(bytes[j] >> 4 & 0xF)]);
/* 72 */       buf.append(HEX_DIGITS[(bytes[j] & 0xF)]);
/*    */     }
/* 74 */     return buf.toString();
/*    */   }
/*    */ 
/*    */   private static final String encode(String str)
/*    */   {
/* 83 */     if (str == null)
/* 84 */       return null;
/*    */     try
/*    */     {
/* 87 */       MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
/* 88 */       messageDigest.update(str.getBytes());
/* 89 */       return getFormattedText(messageDigest.digest());
/*    */     } catch (Exception e) {
/* 91 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.util.Tools
 * JD-Core Version:    0.6.2
 */