/*   */ package com.ifp.weixin.util;
/*   */ 
/*   */ public class SignUtil
/*   */ {
/*   */   public static Boolean checkSignature(String signature, String timestamp, String nonce)
/*   */   {
/* 9 */     return Boolean.valueOf(Tools.checkSignature(signature, timestamp, nonce));
/*   */   }
/*   */ }

/* Location:           
 * Qualified Name:     com.ifp.weixin.util.SignUtil
 * JD-Core Version:    0.6.2
 */