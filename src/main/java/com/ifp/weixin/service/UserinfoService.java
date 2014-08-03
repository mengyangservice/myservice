package com.ifp.weixin.service;

import com.ifp.weixin.DAO.BaseDAO;
import com.ifp.weixin.ORM.Userinfo;
import java.util.List;

public abstract interface UserinfoService
{
  public abstract List<Userinfo> browseUserinfo();

  public abstract Userinfo loadUserinfo(Integer paramInteger);

  public abstract Userinfo loadUserinfoByuserid(String paramString);

  public abstract boolean delUserinfo(Integer paramInteger);

  public abstract boolean saveOrUpdateUserinfo(Userinfo paramUserinfo);

  public abstract BaseDAO getMyDao();
}

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.service.UserinfoService
 * JD-Core Version:    0.6.2
 */