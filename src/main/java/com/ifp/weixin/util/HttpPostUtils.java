/*     */ package com.ifp.weixin.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.PrintStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
/*     */ import java.util.UUID;
/*     */ import javax.net.ssl.HttpsURLConnection;
/*     */ import net.sf.json.JSONObject;
/*     */ 
/*     */ public class HttpPostUtils
/*     */ {
/*     */   public static String saveImageToDisk(String imageurl, String path)
/*     */     throws IOException
/*     */   {
/*  35 */     new File(path).mkdir();
/*  36 */     String filename = UUID.randomUUID().toString() + ".jpg";
/*     */ 
/*  38 */     File file = new File(path, filename);
/*     */ 
/*  42 */     InputStream inputStream = getInputStream(imageurl);
/*  43 */     byte[] data = new byte[1024];
/*  44 */     int len = 0;
/*  45 */     FileOutputStream fileOutputStream = null;
/*     */     try {
/*  47 */       fileOutputStream = new FileOutputStream(file);
/*  48 */       while ((len = inputStream.read(data)) != -1)
/*  49 */         fileOutputStream.write(data, 0, len);
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/*  53 */       e.printStackTrace();
/*     */ 
/*  55 */       if (inputStream != null) {
/*     */         try {
/*  57 */           inputStream.close();
/*     */         }
/*     */         catch (Exception ex) {
/*  60 */           ex.printStackTrace();
/*     */         }
/*     */       }
/*  63 */       if (fileOutputStream != null)
/*     */         try {
/*  65 */           fileOutputStream.close();
/*     */         }
/*     */         catch (Exception ex) {
/*  68 */           ex.printStackTrace();
/*     */         }
/*     */     }
/*     */     finally
/*     */     {
/*  55 */       if (inputStream != null) {
/*     */         try {
/*  57 */           inputStream.close();
/*     */         }
/*     */         catch (Exception e) {
/*  60 */           e.printStackTrace();
/*     */         }
/*     */       }
/*  63 */       if (fileOutputStream != null) {
/*     */         try {
/*  65 */           fileOutputStream.close();
/*     */         }
/*     */         catch (Exception e) {
/*  68 */           e.printStackTrace();
/*     */         }
/*     */       }
/*     */     }
/*  72 */     return filename;
/*     */   }
/*     */ 
/*     */   public static InputStream getInputStream(String imgUrl)
/*     */     throws IOException
/*     */   {
/*  83 */     InputStream inputStream = null;
/*  84 */     HttpsURLConnection httpURLConnection = null;
/*     */     try {
/*  86 */       URL url = new URL(imgUrl);
/*  87 */       if (url != null) {
/*  88 */         httpURLConnection = (HttpsURLConnection)url.openConnection();
/*     */ 
/*  90 */         httpURLConnection.setConnectTimeout(3000);
/*  91 */         httpURLConnection.setDoInput(true);
/*     */ 
/*  93 */         httpURLConnection.setRequestMethod("GET");
/*  94 */         int responseCode = httpURLConnection.getResponseCode();
/*  95 */         if (responseCode == 200)
/*     */         {
/*  97 */           inputStream = httpURLConnection.getInputStream();
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (MalformedURLException e) {
/* 102 */       e.printStackTrace();
/*     */     }
/*     */ 
/* 105 */     return inputStream;
/*     */   }
/*     */ 
/*     */   public static String httpsPostJson(String urlAddress, JSONObject obj)
/*     */   {
/*     */     try
/*     */     {
/* 112 */       URL url = new URL(urlAddress);
/* 113 */       HttpsURLConnection connection = (HttpsURLConnection)url
/* 114 */         .openConnection();
/* 115 */       connection.setDoOutput(true);
/* 116 */       connection.setDoInput(true);
/* 117 */       connection.setRequestMethod("POST");
/* 118 */       connection.setUseCaches(false);
/* 119 */       String para = obj.toString();
/*     */ 
/* 123 */       connection.setInstanceFollowRedirects(true);
/* 124 */       connection.setRequestProperty("Content-Type", "application/x-javascript; charset=utf-8");
/*     */ 
/* 134 */       connection.connect();
/*     */ 
/* 137 */       DataOutputStream out = new DataOutputStream(
/* 138 */         connection.getOutputStream());
/*     */ 
/* 141 */       out.writeBytes(obj.toString());
/* 142 */       out.flush();
/* 143 */       out.close();
/*     */ 
/* 148 */       System.out.println(para);
/*     */ 
/* 150 */       BufferedReader reader = new BufferedReader(new InputStreamReader(
/* 151 */         connection.getInputStream()));
/*     */ 
/* 153 */       StringBuffer sb = new StringBuffer("");
/*     */       String lines;
/* 154 */       while ((lines = reader.readLine()) != null) {
/* 155 */         lines = new String(lines.getBytes(), "utf-8");
/* 156 */         sb.append(lines);
/*     */       }
/* 158 */       System.out.println(sb);
/* 159 */       reader.close();
/*     */ 
/* 162 */       connection.disconnect();
/* 163 */       return sb.toString();
/*     */     }
/*     */     catch (MalformedURLException e) {
/* 166 */       e.printStackTrace();
/*     */     }
/*     */     catch (UnsupportedEncodingException e) {
/* 169 */       e.printStackTrace();
/*     */     }
/*     */     catch (IOException e) {
/* 172 */       e.printStackTrace();
/*     */     }
/* 174 */     return "";
/*     */   }
/*     */ 
/*     */   // ERROR //
/*     */   public static String httpsGet(String urlAddress, String[] params)
/*     */   {
///*     */     // Byte code:
///*     */     //   0: aconst_null
///*     */     //   1: astore_2
///*     */     //   2: aconst_null
///*     */     //   3: astore_3
///*     */     //   4: aconst_null
///*     */     //   5: astore 4
///*     */     //   7: new 207	java/lang/StringBuffer
///*     */     //   10: dup
///*     */     //   11: invokespecial 254	java/lang/StringBuffer:<init>	()V
///*     */     //   14: astore 5
///*     */     //   16: new 105	java/net/URL
///*     */     //   19: dup
///*     */     //   20: aload_0
///*     */     //   21: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
///*     */     //   24: astore_2
///*     */     //   25: aload_2
///*     */     //   26: invokevirtual 108	java/net/URL:openConnection	()Ljava/net/URLConnection;
///*     */     //   29: checkcast 112	javax/net/ssl/HttpsURLConnection
///*     */     //   32: astore_3
///*     */     //   33: aload_3
///*     */     //   34: iconst_0
///*     */     //   35: invokevirtual 151	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
///*     */     //   38: aload_3
///*     */     //   39: iconst_1
///*     */     //   40: invokevirtual 146	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
///*     */     //   43: aload_3
///*     */     //   44: ldc 122
///*     */     //   46: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
///*     */     //   49: ldc 209
///*     */     //   51: astore 6
///*     */     //   53: aload_1
///*     */     //   54: dup
///*     */     //   55: astore 10
///*     */     //   57: arraylength
///*     */     //   58: istore 9
///*     */     //   60: iconst_0
///*     */     //   61: istore 8
///*     */     //   63: goto +59 -> 122
///*     */     //   66: aload 10
///*     */     //   68: iload 8
///*     */     //   70: aaload
///*     */     //   71: astore 7
///*     */     //   73: aload 7
///*     */     //   75: ifnull +44 -> 119
///*     */     //   78: ldc 209
///*     */     //   80: aload 7
///*     */     //   82: invokevirtual 255	java/lang/String:trim	()Ljava/lang/String;
///*     */     //   85: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
///*     */     //   88: ifne +31 -> 119
///*     */     //   91: new 28	java/lang/StringBuilder
///*     */     //   94: dup
///*     */     //   95: aload 6
///*     */     //   97: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
///*     */     //   100: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
///*     */     //   103: ldc_w 262
///*     */     //   106: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
///*     */     //   109: aload 7
///*     */     //   111: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
///*     */     //   114: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
///*     */     //   117: astore 6
///*     */     //   119: iinc 8 1
///*     */     //   122: iload 8
///*     */     //   124: iload 9
///*     */     //   126: if_icmplt -60 -> 66
///*     */     //   129: getstatic 186	java/lang/System:out	Ljava/io/PrintStream;
///*     */     //   132: new 28	java/lang/StringBuilder
///*     */     //   135: dup
///*     */     //   136: invokespecial 264	java/lang/StringBuilder:<init>	()V
///*     */     //   139: aload_2
///*     */     //   140: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
///*     */     //   143: aload 6
///*     */     //   145: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
///*     */     //   148: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
///*     */     //   151: invokevirtual 192	java/io/PrintStream:println	(Ljava/lang/String;)V
///*     */     //   154: aload 6
///*     */     //   156: invokevirtual 212	java/lang/String:getBytes	()[B
///*     */     //   159: astore 7
///*     */     //   161: aload_3
///*     */     //   162: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
///*     */     //   165: aload 7
///*     */     //   167: iconst_0
///*     */     //   168: aload 7
///*     */     //   170: arraylength
///*     */     //   171: invokevirtual 268	java/io/OutputStream:write	([BII)V
///*     */     //   174: aload_3
///*     */     //   175: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
///*     */     //   178: invokevirtual 271	java/io/OutputStream:flush	()V
///*     */     //   181: aload_3
///*     */     //   182: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
///*     */     //   185: invokevirtual 272	java/io/OutputStream:close	()V
///*     */     //   188: new 197	java/io/BufferedReader
///*     */     //   191: dup
///*     */     //   192: new 199	java/io/InputStreamReader
///*     */     //   195: dup
///*     */     //   196: aload_3
///*     */     //   197: invokevirtual 131	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
///*     */     //   200: invokespecial 201	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
///*     */     //   203: invokespecial 204	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
///*     */     //   206: astore 4
///*     */     //   208: aload 4
///*     */     //   210: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
///*     */     //   213: astore 8
///*     */     //   215: aload 8
///*     */     //   217: ifnonnull +6 -> 223
///*     */     //   220: goto +85 -> 305
///*     */     //   223: aload 5
///*     */     //   225: aload 8
///*     */     //   227: invokevirtual 221	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
///*     */     //   230: pop
///*     */     //   231: goto -23 -> 208
///*     */     //   234: astore 6
///*     */     //   236: aload 6
///*     */     //   238: invokevirtual 238	java/io/IOException:printStackTrace	()V
///*     */     //   241: aload 4
///*     */     //   243: ifnull +8 -> 251
///*     */     //   246: aload 4
///*     */     //   248: invokevirtual 230	java/io/BufferedReader:close	()V
///*     */     //   251: aload_3
///*     */     //   252: ifnull +81 -> 333
///*     */     //   255: aload_3
///*     */     //   256: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
///*     */     //   259: goto +74 -> 333
///*     */     //   262: astore 12
///*     */     //   264: aload 12
///*     */     //   266: invokevirtual 238	java/io/IOException:printStackTrace	()V
///*     */     //   269: goto +64 -> 333
///*     */     //   272: astore 11
///*     */     //   274: aload 4
///*     */     //   276: ifnull +8 -> 284
///*     */     //   279: aload 4
///*     */     //   281: invokevirtual 230	java/io/BufferedReader:close	()V
///*     */     //   284: aload_3
///*     */     //   285: ifnull +17 -> 302
///*     */     //   288: aload_3
///*     */     //   289: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
///*     */     //   292: goto +10 -> 302
///*     */     //   295: astore 12
///*     */     //   297: aload 12
///*     */     //   299: invokevirtual 238	java/io/IOException:printStackTrace	()V
///*     */     //   302: aload 11
///*     */     //   304: athrow
///*     */     //   305: aload 4
///*     */     //   307: ifnull +8 -> 315
///*     */     //   310: aload 4
///*     */     //   312: invokevirtual 230	java/io/BufferedReader:close	()V
///*     */     //   315: aload_3
///*     */     //   316: ifnull +17 -> 333
///*     */     //   319: aload_3
///*     */     //   320: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
///*     */     //   323: goto +10 -> 333
///*     */     //   326: astore 12
///*     */     //   328: aload 12
///*     */     //   330: invokevirtual 238	java/io/IOException:printStackTrace	()V
///*     */     //   333: aload 5
///*     */     //   335: invokevirtual 234	java/lang/StringBuffer:toString	()Ljava/lang/String;
///*     */     //   338: areturn
///*     */     //
///*     */     // Exception table:
///*     */     //   from	to	target	type
///*     */     //   16	234	234	java/io/IOException
///*     */     //   241	259	262	java/io/IOException
///*     */     //   16	241	272	finally
///*     */     //   274	292	295	java/io/IOException
///*     */     //   305	323	326	java/io/IOException
	           return "";
/*     */   }
/*     */ 
/*     */   // ERROR //
/*     */   public static String httpGet(String urlAddress, String[] params)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_2
/*     */     //   2: aconst_null
/*     */     //   3: astore_3
/*     */     //   4: aconst_null
/*     */     //   5: astore 4
/*     */     //   7: new 207	java/lang/StringBuffer
/*     */     //   10: dup
/*     */     //   11: invokespecial 254	java/lang/StringBuffer:<init>	()V
/*     */     //   14: astore 5
/*     */     //   16: new 105	java/net/URL
/*     */     //   19: dup
/*     */     //   20: aload_0
/*     */     //   21: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
/*     */     //   24: astore_2
/*     */     //   25: aload_2
/*     */     //   26: invokevirtual 108	java/net/URL:openConnection	()Ljava/net/URLConnection;
/*     */     //   29: checkcast 284	java/net/HttpURLConnection
/*     */     //   32: astore_3
/*     */     //   33: aload_3
/*     */     //   34: iconst_0
/*     */     //   35: invokevirtual 286	java/net/HttpURLConnection:setUseCaches	(Z)V
/*     */     //   38: aload_3
/*     */     //   39: iconst_1
/*     */     //   40: invokevirtual 287	java/net/HttpURLConnection:setDoOutput	(Z)V
/*     */     //   43: aload_3
/*     */     //   44: ldc 122
/*     */     //   46: invokevirtual 288	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
/*     */     //   49: ldc 209
/*     */     //   51: astore 6
/*     */     //   53: aload_1
/*     */     //   54: dup
/*     */     //   55: astore 10
/*     */     //   57: arraylength
/*     */     //   58: istore 9
/*     */     //   60: iconst_0
/*     */     //   61: istore 8
/*     */     //   63: goto +59 -> 122
/*     */     //   66: aload 10
/*     */     //   68: iload 8
/*     */     //   70: aaload
/*     */     //   71: astore 7
/*     */     //   73: aload 7
/*     */     //   75: ifnull +44 -> 119
/*     */     //   78: ldc 209
/*     */     //   80: aload 7
/*     */     //   82: invokevirtual 255	java/lang/String:trim	()Ljava/lang/String;
/*     */     //   85: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   88: ifne +31 -> 119
/*     */     //   91: new 28	java/lang/StringBuilder
/*     */     //   94: dup
/*     */     //   95: aload 6
/*     */     //   97: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   100: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   103: ldc_w 262
/*     */     //   106: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   109: aload 7
/*     */     //   111: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   114: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   117: astore 6
/*     */     //   119: iinc 8 1
/*     */     //   122: iload 8
/*     */     //   124: iload 9
/*     */     //   126: if_icmplt -60 -> 66
/*     */     //   129: getstatic 186	java/lang/System:out	Ljava/io/PrintStream;
/*     */     //   132: new 28	java/lang/StringBuilder
/*     */     //   135: dup
/*     */     //   136: invokespecial 264	java/lang/StringBuilder:<init>	()V
/*     */     //   139: aload_2
/*     */     //   140: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   143: aload 6
/*     */     //   145: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   148: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   151: invokevirtual 192	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   154: aload 6
/*     */     //   156: invokevirtual 212	java/lang/String:getBytes	()[B
/*     */     //   159: astore 7
/*     */     //   161: aload_3
/*     */     //   162: invokevirtual 289	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   165: aload 7
/*     */     //   167: iconst_0
/*     */     //   168: aload 7
/*     */     //   170: arraylength
/*     */     //   171: invokevirtual 268	java/io/OutputStream:write	([BII)V
/*     */     //   174: aload_3
/*     */     //   175: invokevirtual 289	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   178: invokevirtual 271	java/io/OutputStream:flush	()V
/*     */     //   181: aload_3
/*     */     //   182: invokevirtual 289	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   185: invokevirtual 272	java/io/OutputStream:close	()V
/*     */     //   188: new 197	java/io/BufferedReader
/*     */     //   191: dup
/*     */     //   192: new 199	java/io/InputStreamReader
/*     */     //   195: dup
/*     */     //   196: aload_3
/*     */     //   197: invokevirtual 290	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
/*     */     //   200: invokespecial 201	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
/*     */     //   203: invokespecial 204	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*     */     //   206: astore 4
/*     */     //   208: aload 4
/*     */     //   210: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*     */     //   213: astore 8
/*     */     //   215: aload 8
/*     */     //   217: ifnonnull +6 -> 223
/*     */     //   220: goto +85 -> 305
/*     */     //   223: aload 5
/*     */     //   225: aload 8
/*     */     //   227: invokevirtual 221	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
/*     */     //   230: pop
/*     */     //   231: goto -23 -> 208
/*     */     //   234: astore 6
/*     */     //   236: aload 6
/*     */     //   238: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   241: aload 4
/*     */     //   243: ifnull +8 -> 251
/*     */     //   246: aload 4
/*     */     //   248: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   251: aload_3
/*     */     //   252: ifnull +81 -> 333
/*     */     //   255: aload_3
/*     */     //   256: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
/*     */     //   259: goto +74 -> 333
/*     */     //   262: astore 12
/*     */     //   264: aload 12
/*     */     //   266: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   269: goto +64 -> 333
/*     */     //   272: astore 11
/*     */     //   274: aload 4
/*     */     //   276: ifnull +8 -> 284
/*     */     //   279: aload 4
/*     */     //   281: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   284: aload_3
/*     */     //   285: ifnull +17 -> 302
/*     */     //   288: aload_3
/*     */     //   289: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
/*     */     //   292: goto +10 -> 302
/*     */     //   295: astore 12
/*     */     //   297: aload 12
/*     */     //   299: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   302: aload 11
/*     */     //   304: athrow
/*     */     //   305: aload 4
/*     */     //   307: ifnull +8 -> 315
/*     */     //   310: aload 4
/*     */     //   312: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   315: aload_3
/*     */     //   316: ifnull +17 -> 333
/*     */     //   319: aload_3
/*     */     //   320: invokevirtual 291	java/net/HttpURLConnection:disconnect	()V
/*     */     //   323: goto +10 -> 333
/*     */     //   326: astore 12
/*     */     //   328: aload 12
/*     */     //   330: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   333: aload 5
/*     */     //   335: invokevirtual 234	java/lang/StringBuffer:toString	()Ljava/lang/String;
/*     */     //   338: areturn
/*     */     //
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   16	234	234	java/io/IOException
/*     */     //   241	259	262	java/io/IOException
/*     */     //   16	241	272	finally
/*     */     //   274	292	295	java/io/IOException
/*     */     //   305	323	326	java/io/IOException
	          return "";
/*     */   }
/*     */ 
/*     */   // ERROR //
/*     */   public static String httpsPost(String urlAddress, String[] params)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: aconst_null
/*     */     //   1: astore_2
/*     */     //   2: aconst_null
/*     */     //   3: astore_3
/*     */     //   4: aconst_null
/*     */     //   5: astore 4
/*     */     //   7: new 207	java/lang/StringBuffer
/*     */     //   10: dup
/*     */     //   11: invokespecial 254	java/lang/StringBuffer:<init>	()V
/*     */     //   14: astore 5
/*     */     //   16: new 105	java/net/URL
/*     */     //   19: dup
/*     */     //   20: aload_0
/*     */     //   21: invokespecial 107	java/net/URL:<init>	(Ljava/lang/String;)V
/*     */     //   24: astore_2
/*     */     //   25: aload_2
/*     */     //   26: invokevirtual 108	java/net/URL:openConnection	()Ljava/net/URLConnection;
/*     */     //   29: checkcast 112	javax/net/ssl/HttpsURLConnection
/*     */     //   32: astore_3
/*     */     //   33: aload_3
/*     */     //   34: iconst_0
/*     */     //   35: invokevirtual 151	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
/*     */     //   38: aload_3
/*     */     //   39: iconst_1
/*     */     //   40: invokevirtual 146	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
/*     */     //   43: aload_3
/*     */     //   44: ldc 149
/*     */     //   46: invokevirtual 124	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
/*     */     //   49: ldc 209
/*     */     //   51: astore 6
/*     */     //   53: aload_1
/*     */     //   54: dup
/*     */     //   55: astore 10
/*     */     //   57: arraylength
/*     */     //   58: istore 9
/*     */     //   60: iconst_0
/*     */     //   61: istore 8
/*     */     //   63: goto +59 -> 122
/*     */     //   66: aload 10
/*     */     //   68: iload 8
/*     */     //   70: aaload
/*     */     //   71: astore 7
/*     */     //   73: aload 7
/*     */     //   75: ifnull +44 -> 119
/*     */     //   78: ldc 209
/*     */     //   80: aload 7
/*     */     //   82: invokevirtual 255	java/lang/String:trim	()Ljava/lang/String;
/*     */     //   85: invokevirtual 258	java/lang/String:equals	(Ljava/lang/Object;)Z
/*     */     //   88: ifne +31 -> 119
/*     */     //   91: new 28	java/lang/StringBuilder
/*     */     //   94: dup
/*     */     //   95: aload 6
/*     */     //   97: invokestatic 40	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   100: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   103: ldc_w 262
/*     */     //   106: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   109: aload 7
/*     */     //   111: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   114: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   117: astore 6
/*     */     //   119: iinc 8 1
/*     */     //   122: iload 8
/*     */     //   124: iload 9
/*     */     //   126: if_icmplt -60 -> 66
/*     */     //   129: getstatic 186	java/lang/System:out	Ljava/io/PrintStream;
/*     */     //   132: new 28	java/lang/StringBuilder
/*     */     //   135: dup
/*     */     //   136: invokespecial 264	java/lang/StringBuilder:<init>	()V
/*     */     //   139: aload_2
/*     */     //   140: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*     */     //   143: aload 6
/*     */     //   145: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   148: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   151: invokevirtual 192	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   154: aload 6
/*     */     //   156: invokevirtual 212	java/lang/String:getBytes	()[B
/*     */     //   159: astore 7
/*     */     //   161: aload_3
/*     */     //   162: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   165: aload 7
/*     */     //   167: iconst_0
/*     */     //   168: aload 7
/*     */     //   170: arraylength
/*     */     //   171: invokevirtual 268	java/io/OutputStream:write	([BII)V
/*     */     //   174: aload_3
/*     */     //   175: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   178: invokevirtual 271	java/io/OutputStream:flush	()V
/*     */     //   181: aload_3
/*     */     //   182: invokevirtual 172	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
/*     */     //   185: invokevirtual 272	java/io/OutputStream:close	()V
/*     */     //   188: new 197	java/io/BufferedReader
/*     */     //   191: dup
/*     */     //   192: new 199	java/io/InputStreamReader
/*     */     //   195: dup
/*     */     //   196: aload_3
/*     */     //   197: invokevirtual 131	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
/*     */     //   200: invokespecial 201	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
/*     */     //   203: invokespecial 204	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
/*     */     //   206: astore 4
/*     */     //   208: aload 4
/*     */     //   210: invokevirtual 224	java/io/BufferedReader:readLine	()Ljava/lang/String;
/*     */     //   213: astore 8
/*     */     //   215: aload 8
/*     */     //   217: ifnonnull +6 -> 223
/*     */     //   220: goto +85 -> 305
/*     */     //   223: aload 5
/*     */     //   225: aload 8
/*     */     //   227: invokevirtual 221	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
/*     */     //   230: pop
/*     */     //   231: goto -23 -> 208
/*     */     //   234: astore 6
/*     */     //   236: aload 6
/*     */     //   238: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   241: aload 4
/*     */     //   243: ifnull +8 -> 251
/*     */     //   246: aload 4
/*     */     //   248: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   251: aload_3
/*     */     //   252: ifnull +81 -> 333
/*     */     //   255: aload_3
/*     */     //   256: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
/*     */     //   259: goto +74 -> 333
/*     */     //   262: astore 12
/*     */     //   264: aload 12
/*     */     //   266: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   269: goto +64 -> 333
/*     */     //   272: astore 11
/*     */     //   274: aload 4
/*     */     //   276: ifnull +8 -> 284
/*     */     //   279: aload 4
/*     */     //   281: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   284: aload_3
/*     */     //   285: ifnull +17 -> 302
/*     */     //   288: aload_3
/*     */     //   289: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
/*     */     //   292: goto +10 -> 302
/*     */     //   295: astore 12
/*     */     //   297: aload 12
/*     */     //   299: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   302: aload 11
/*     */     //   304: athrow
/*     */     //   305: aload 4
/*     */     //   307: ifnull +8 -> 315
/*     */     //   310: aload 4
/*     */     //   312: invokevirtual 230	java/io/BufferedReader:close	()V
/*     */     //   315: aload_3
/*     */     //   316: ifnull +17 -> 333
/*     */     //   319: aload_3
/*     */     //   320: invokevirtual 231	javax/net/ssl/HttpsURLConnection:disconnect	()V
/*     */     //   323: goto +10 -> 333
/*     */     //   326: astore 12
/*     */     //   328: aload 12
/*     */     //   330: invokevirtual 238	java/io/IOException:printStackTrace	()V
/*     */     //   333: aload 5
/*     */     //   335: invokevirtual 234	java/lang/StringBuffer:toString	()Ljava/lang/String;
/*     */     //   338: areturn
/*     */     //
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   16	234	234	java/io/IOException
/*     */     //   241	259	262	java/io/IOException
/*     */     //   16	241	272	finally
/*     */     //   274	292	295	java/io/IOException
/*     */     //   305	323	326	java/io/IOException
          	return "";
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.util.HttpPostUtils
 * JD-Core Version:    0.6.2
 */