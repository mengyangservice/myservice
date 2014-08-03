package com.ifp.weixin.service;

import com.ifp.weixin.ORM.Admin;
import java.util.List;

public abstract interface AdminService
{
  public abstract Admin adminLogin(String paramString1, String paramString2);

  public abstract List<Admin> browseAdmin();

  public abstract Admin loadAdmin(Integer paramInteger);

  public abstract boolean delAdmin(Integer paramInteger);

  public abstract boolean saveOrUpdateAdmin(Admin paramAdmin);
}

/* Location:           
 * Qualified Name:     com.ifp.weixin.service.AdminService
 * JD-Core Version:    0.6.2
 */