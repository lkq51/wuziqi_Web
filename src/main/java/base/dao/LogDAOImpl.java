package base.dao;

import base.model.Log;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lkq on 2016/12/14.
 */
@Repository(value = "logDAO")
public class LogDAOImpl  extends BaseDAOImpl implements LogDAO{

    @Override
    public List<Log> selectAll(int page, int pageSize) {
      String hql = "from Log";
      int real = selectCount();
      List<Log> logs = getByPage(hql,page,pageSize,real);
      return logs;
    }

    @Override
    public List<Log> selectLogByUserName(String username, int page, int pageSize)
    {
        String hql = "from Log log where log.username = "+"'"+username+"'";
        List<Log> logs = getByPage(hql,page,pageSize,realPage(hql));
        return logs;
    }

    /**
     * @return 返回记录行数
     */
    @Override
    public int selectCount()
    {
        String hql = "from Log";
        return  realPage(hql);
    }

    /**
     * @param username
     * @return
     */
    @Override
    public int selectLogByUserName(String username) {
        String hql = "from Log log where log.username ="+"'"+username+"'";
        return realPage(hql);
    }

    @Override
    public boolean save(Log log)
    {
        try {
            this.getHibernateTemplate().save(log);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        String hql = "from Log where Log.id = ?";
        try {
            List<Log> logs=(List<Log>) this.getHibernateTemplate().find(hql,id);
            this.getHibernateTemplate().delete(logs.get(0));
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteThisUser(int userid) {
        String hql ="from Log where Log .userid = ?";
       try {
           List<Log> logs =(List<Log>) this.getHibernateTemplate().find(hql,userid);
           this.getHibernateTemplate().deleteAll(logs);
       }catch (DataAccessException e){
           return false;
       }
        return true;
    }

    @Override
    public boolean deleteAll() {
        String hql = "from Log";
        try {
            List<Log> logs=(List<Log>) this.getHibernateTemplate().find(hql);
            this.getHibernateTemplate().deleteAll(logs);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }
}
