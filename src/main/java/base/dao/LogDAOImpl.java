package base.dao;

import base.model.Log;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lkq on 2016/12/14.
 */
@Repository(value = "logDAO")
public class LogDAOImpl  extends BaseDAOImpl implements LogDAO{

    @Override
    public List<Log> selectAll(int start, int end) {
      /*  String hql = "from Log";
        getByPage(hql,end-start+1,)
        return (List<Log>) ;*/
    }

    @Override
    public List<Log> selectLogByUserName(String username, int start, int end)
    {
        String hql = "from Log log where log.username = ?";
        return (List<Log>) this.getHibernateTemplate().find(hql,username);
    }
    
    //有问题
    @Override
    public Log selectCount()
    {
        String hql = "select count(*) from Log";
        return (Log) this.getHibernateTemplate().find(hql);
    }
    //有问题
    @Override
    public Log selectLogByUserName(String username) {
        String hql = "from Log where Log.username= ?";
        return (Log) this.getHibernateTemplate().find(hql,username);
    }

    @Override
    public boolean save(Log log)
    {
        this.getHibernateTemplate().save(log);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.getHibernateTemplate().findByCriteria()
        return false;
    }

    @Override
    public boolean deleteThisUser(int userid) {
        String hql ="from Log where Log .userid = ?";
        List<Log> logs =(List<Log>) this.getHibernateTemplate().find(hql,userid);
        this.getHibernateTemplate().deleteAll(logs);
        return false;
    }

    @Override
    public boolean deleteAll() {
        String hql = "from Log";
        List<Log> logs=(List<Log>) this.getHibernateTemplate().find(hql);
        this.getHibernateTemplate().deleteAll(logs);
        return false;
    }
}
