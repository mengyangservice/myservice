package com.ifp.weixin.DAO;

import java.io.Serializable;
import java.util.List;

public abstract interface BaseDAO
{
  public abstract Object loadById(Class paramClass, Serializable paramSerializable);

  public abstract Object loadObject(String paramString);

  public abstract void delById(Class paramClass, Serializable paramSerializable);

  public abstract void saveOrUpdate(Object paramObject);

  public abstract List listAll(String paramString);

  public abstract List listAll(String paramString, int paramInt1, int paramInt2);

  public abstract int countAll(String paramString);

  public abstract List query(String paramString);

  public abstract List query(String paramString, int paramInt1, int paramInt2);

  public abstract int countQuery(String paramString);

  public abstract int update(String paramString);

  public abstract int exeSql(String paramString);
}

/* Location:           
 * Qualified Name:     com.ifp.weixin.DAO.BaseDAO
 * JD-Core Version:    0.6.2
 */