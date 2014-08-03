package com.ifp.weixin.service;

import com.ifp.weixin.ORM.Newuser;
import java.util.List;

public abstract interface NewuserService
{
  public abstract List<Newuser> browseNewuser();

  public abstract Newuser loadNewuser(Integer paramInteger);

  public abstract Newuser loadNewuserByuserid(String paramString);

  public abstract boolean delNewuser(Integer paramInteger);

  public abstract boolean saveOrUpdateNewuser(Newuser paramNewuser);
}

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.NewuserService
 * JD-Core Version:    0.6.2
 */