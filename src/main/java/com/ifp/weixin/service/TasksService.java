package com.ifp.weixin.service;

import com.ifp.weixin.DAO.BaseDAO;
import com.ifp.weixin.ORM.Tasks;
import java.util.List;

public abstract interface TasksService
{
  public abstract List<Tasks> browseTasks();

  public abstract Tasks loadTasks(Integer paramInteger);

  public abstract boolean delTasks(Integer paramInteger);

  public abstract boolean saveOrUpdateTasks(Tasks paramTasks);

  public abstract List<Tasks> getAvailTasks(String paramString);

  public abstract BaseDAO getMyDao();
}

/* Location:           /Users/geek/myweixin/WEB-INF/classes/
 * Qualified Name:     com.ifp.weixin.service.TasksService
 * JD-Core Version:    0.6.2
 */