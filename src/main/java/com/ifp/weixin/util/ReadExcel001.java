/*     */ package com.ifp.weixin.util;
/*     */ 
/*     */ import com.ifp.weixin.DAO.BaseDAO;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.hssf.usermodel.HSSFCell;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRow;
/*     */ import org.apache.poi.hssf.usermodel.HSSFSheet;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.ss.usermodel.Cell;
/*     */ import org.apache.poi.ss.usermodel.Row;
/*     */ import org.apache.poi.ss.usermodel.Sheet;
/*     */ import org.apache.poi.ss.usermodel.Workbook;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ public class ReadExcel001
/*     */ {
/*  30 */   static int index = 0;
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/*  25 */     System.out.println("-------------");
/*     */   }
/*     */ 
/*     */   public static void delTable(String tablename, BaseDAO dao)
/*     */   {
/*  34 */     if (tablename.equals("商品表"))
/*     */     {
/*  37 */       dao.exeSql("delete from Goods;");
/*     */     }
/*     */ 
/*  42 */     if (tablename.equals("销售订单表"))
/*     */     {
/*  45 */       dao.exeSql("delete from orders;");
/*     */     }
/*     */ 
/*  49 */     if (tablename.equals("镶嵌任务表"))
/*     */     {
/*  51 */       dao.exeSql("delete from imbedtask;");
/*     */     }
/*     */ 
/*  55 */     if (tablename.equals("用户表"))
/*     */     {
/*  58 */       dao.exeSql("delete from Userinfo;");
/*     */     }
/*     */ 
/*  62 */     if (tablename.equals("设计师表"))
/*     */     {
/*  65 */       dao.exeSql("delete from Designer;");
/*     */     }
/*     */ 
/*  69 */     if (tablename.equals("镶嵌样式表"))
/*     */     {
/*  73 */       dao.exeSql("delete from styles;");
/*     */     }
/*     */ 
/*  76 */     if (tablename.equals("工厂表"))
/*     */     {
/*  79 */       dao.exeSql("delete from factory;");
/*     */     }
/*     */ 
/*  83 */     if (tablename.equals("普通任务表"))
/*     */     {
/*  86 */       dao.exeSql("delete from tasks");
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String handleTable(String tablename, String sql, BaseDAO dao)
/*     */   {
/*  92 */     String returnsql = "";
/*  93 */     if (tablename.equals("商品表"))
/*     */     {
/*  95 */       returnsql = "INSERT INTO Goods  VALUES (" + index++ + ",";
/*  96 */       returnsql = returnsql + sql.substring(0, sql.length() - 4) + ");";
/*  97 */       System.out.println(returnsql);
/*     */ 
/*  99 */       dao.exeSql(returnsql);
/*     */     }
/*     */ 
/* 104 */     if (tablename.equals("销售订单表"))
/*     */     {
/* 106 */       returnsql = "INSERT INTO Orders VALUES (" + index++ + ",";
/* 107 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 110 */       System.out.println(returnsql);
/* 111 */       dao.exeSql(returnsql);
/*     */     }
/*     */ 
/* 115 */     if (tablename.equals("镶嵌任务表"))
/*     */     {
/* 117 */       returnsql = "INSERT INTO imbedtask  VALUES (" + index++ + ",";
/* 118 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 121 */       dao.exeSql(returnsql);
/* 122 */       System.out.println(returnsql);
/*     */     }
/*     */ 
/* 125 */     if (tablename.equals("用户表"))
/*     */     {
/* 127 */       returnsql = "INSERT INTO Userinfo  VALUES (" + index++ + ",";
/* 128 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 131 */       dao.exeSql(returnsql);
/* 132 */       System.out.println(returnsql);
/*     */     }
/*     */ 
/* 135 */     if (tablename.equals("设计师表"))
/*     */     {
/* 137 */       returnsql = "INSERT INTO Designer  VALUES (" + index++ + ",";
/* 138 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 141 */       dao.exeSql(returnsql);
/* 142 */       System.out.println(returnsql);
/*     */     }
/*     */ 
/* 145 */     if (tablename.equals("镶嵌样式表"))
/*     */     {
/* 147 */       returnsql = "INSERT INTO Styles  VALUES (" + index++ + ",";
/* 148 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 151 */       dao.exeSql(returnsql);
/* 152 */       System.out.println(returnsql);
/*     */     }
/* 154 */     if (tablename.equals("工厂表"))
/*     */     {
/* 156 */       returnsql = "INSERT INTO Factory  VALUES (" + index++ + ",";
/* 157 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 160 */       dao.exeSql(returnsql);
/* 161 */       System.out.println(returnsql);
/*     */     }
/*     */ 
/* 164 */     if (tablename.equals("普通任务表"))
/*     */     {
/* 166 */       returnsql = "INSERT INTO tasks  VALUES (" + index++ + ",";
/* 167 */       returnsql = returnsql + sql.substring(0, sql.length() - 1) + ");";
/*     */ 
/* 170 */       dao.exeSql(returnsql);
/* 171 */       System.out.println(returnsql);
/*     */     }
/* 173 */     return returnsql;
/*     */   }
/*     */ 
/*     */   public static void export(String[] sheetName, String[][][] data, String name)
/*     */   {
/* 183 */     String xlsName = name;
/*     */     try {
/* 185 */       FileOutputStream fOut = new FileOutputStream(xlsName);
/*     */ 
/* 187 */       HSSFWorkbook workbook = new HSSFWorkbook();
/*     */ 
/* 189 */       for (int i = 0; i < sheetName.length; i++)
/*     */       {
/* 191 */         HSSFSheet sheet = workbook.createSheet(sheetName[i]);
/* 192 */         HSSFRow rowFirst = sheet.createRow(0);
/*     */ 
/* 195 */         int nColumn = data[i][0].length;
/*     */ 
/* 197 */         for (int j = 0; j < nColumn; j++)
/*     */         {
/* 199 */           HSSFCell cell = rowFirst.createCell(j);
/*     */ 
/* 201 */           cell.setCellValue(data[i][0][j]);
/*     */         }
/*     */ 
/* 205 */         int rows = data[i].length;
/* 206 */         for (int x = 1; x < rows; x++)
/*     */         {
/* 208 */           HSSFRow therow = sheet.createRow(x);
/*     */ 
/* 210 */           for (int j = 0; j < nColumn; j++)
/*     */           {
/* 213 */             HSSFCell cell = therow.createCell(j);
/*     */ 
/* 215 */             cell.setCellValue(data[i][x][j]);
/*     */           }
/*     */ 
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 224 */       workbook.write(fOut);
/* 225 */       fOut.flush();
/* 226 */       fOut.close();
/*     */     }
/*     */     catch (Exception e) {
/* 229 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public static String readXml(String fileName, BaseDAO dao)
/*     */   {
/* 239 */     boolean isE2007 = false;
/* 240 */     String resql = "";
/* 241 */     if (fileName.endsWith("xlsx"))
/* 242 */       isE2007 = true;
/*     */     try {
/* 244 */       InputStream input = new FileInputStream(fileName);
/* 245 */       Workbook wb = null;
/*     */ 
/* 247 */       if (isE2007)
/* 248 */         wb = new XSSFWorkbook(input);
/*     */       else {
/* 250 */         wb = new HSSFWorkbook(input);
/*     */       }
/* 252 */       int sheet_numbers = wb.getNumberOfSheets();
/* 253 */       String[] sheetnames = new String[sheet_numbers];
/* 254 */       sheet_numbers = 8;
/* 255 */       for (int i = 0; i < sheet_numbers; i++) {
/* 256 */         ArrayList ls_a = new ArrayList();
/*     */ 
/* 260 */         Sheet sheet = wb.getSheetAt(i);
/* 261 */         sheetnames[i] = sheet.getSheetName();
/* 262 */         System.out.println("------>>>---正在读取Excel表数据，当前表：" + sheetnames[i]);
/* 263 */         String tablename = sheetnames[i];
/*     */ 
/* 265 */         delTable(tablename, dao);
/*     */ 
/* 267 */         Iterator rows = sheet.rowIterator();
/* 268 */         Row row = (Row)rows.next();
/* 269 */         int colnum = row.getLastCellNum();
/* 270 */         while (rows.hasNext()) {
/* 271 */           row = (Row)rows.next();
/* 272 */           System.out.println("Row #" + row.getRowNum());
/*     */ 
/* 274 */           String rowSql = "";
/* 275 */           for (int columns = 0; columns < colnum; columns++) {
/* 276 */             Cell cell = row.getCell(columns);
/*     */ 
/* 278 */             if (cell == null) {
/* 279 */               rowSql = rowSql + "''" + ",";
/* 280 */               System.out.println("Cell #" + columns);
/*     */             }
/*     */             else {
/* 283 */               System.out.println("Cell #" + cell.getColumnIndex());
/* 284 */               switch (cell.getCellType())
/*     */               {
/*     */               case 0:
/* 287 */                 rowSql = rowSql + "'" + cell.getNumericCellValue() + "',";
/* 288 */                 break;
/*     */               case 1:
/* 291 */                 rowSql = rowSql + "'" + cell.getStringCellValue() + "',";
/* 292 */                 break;
/*     */               case 4:
/* 295 */                 rowSql = rowSql + "'" + cell.getBooleanCellValue() + "',";
/* 296 */                 break;
/*     */               case 2:
/* 299 */                 rowSql = rowSql + "'" + cell.getCellFormula() + "',";
/* 300 */                 break;
/*     */               case 3:
/*     */               default:
/* 303 */                 rowSql = rowSql + "''" + ",";
/*     */               }
/*     */             }
/*     */ 
/*     */           }
/*     */ 
/* 309 */           resql = resql + handleTable(tablename, rowSql, dao);
/* 310 */           System.out.println(rowSql);
/*     */         }
/*     */       }
/*     */     }
/*     */     catch (IOException ex) {
/* 315 */       ex.printStackTrace();
/*     */     }
/* 317 */     return resql;
/*     */   }
/*     */ }

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.util.ReadExcel001
 * JD-Core Version:    0.6.2
 */