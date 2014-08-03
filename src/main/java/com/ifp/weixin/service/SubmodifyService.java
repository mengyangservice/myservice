package com.ifp.weixin.service;

import com.ifp.weixin.DAO.BaseDAO;
import com.ifp.weixin.ORM.Submodify;
import java.util.List;

public abstract interface SubmodifyService
{
  public abstract List<Submodify> browseSubmodify();

  public abstract Submodify loadSubmodify(Integer paramInteger);

  public abstract Submodify loadSubmodifyByuserid(String paramString);

  public abstract boolean delSubmodify(Integer paramInteger);

  public abstract boolean saveOrUpdateSubmodify(Submodify paramSubmodify);

  public abstract BaseDAO getMyDao();
}

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.SubmodifyService
 * JD-Core Version:    0.6.2
 */