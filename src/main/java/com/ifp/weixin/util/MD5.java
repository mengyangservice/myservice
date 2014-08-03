/*    */ package com.ifp.weixin.util;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ 
/*    */ public class MD5
/*    */ {
/*  8 */   private static final String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
/*    */ 
/*    */   private static String byteArrayToHexString(byte[] b) {
/* 11 */     StringBuffer resultSb = new StringBuffer();
/* 12 */     for (int i = 0; i < b.length; i++) {
/* 13 */       resultSb.append(byteToHexString(b[i]));
/*    */     }
/* 15 */     return resultSb.toString();
/*    */   }
/*    */ 
/*    */   private static String byteToHexString(byte b) {
/* 19 */     int n = b;
/* 20 */     if (n < 0) n += 256;
/* 21 */     int d1 = n / 16;
/* 22 */     int d2 = n % 16;
/* 23 */     return hexDigits[d1] + hexDigits[d2];
/*    */   }
/*    */ 
/*    */   public static String MD5Encode(String origin) {
/* 27 */     String resultString = null;
/*    */     try {
/* 29 */       resultString = new String(origin);
/* 30 */       MessageDigest md = MessageDigest.getInstance("MD5");
/* 31 */       resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
/*    */     }
/*    */     catch (Exception ex) {
/* 34 */       ex.printStackTrace();
/*    */     }
/* 36 */     return resultString;
/*    */   }
/*    */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.util.MD5
 * JD-Core Version:    0.6.2
 */