package com.ifp.weixin.biz.core;

import javax.servlet.http.HttpServletRequest;

public abstract interface CoreService
{
  public abstract void exportExcel(String paramString);

  public abstract String processRequest(HttpServletRequest paramHttpServletRequest);

  public abstract String getAccessToken(String paramString1, String paramString2);
}

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.biz.core.CoreService
 * JD-Core Version:    0.6.2
 */