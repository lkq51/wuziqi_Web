package base.dao;

import base.model.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lkq on 2016/12/14.
 */
@Repository(value = "logDAO")
public class LogDAOImpl  extends BaseDAOImpl implements LogDAO{

    @Override
    public List<Log> selectAll(int start, int end) {
        /*String hql = "from Log (select A,Rownum RN from (from Log Order by Desc) as A) where RN between :start and :end";*/
        String hql ="from Log ";
        return (List<Log>)  this.getHibernateTemplate().find(hql);
    }

    @Override
    public List<Log> selectLogByUserid(int userid, int start, int end)
    {
        String hql = "from Log log where log.userid = "+userid;
        return (List<Log>) this.getHibernateTemplate().find(hql);
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
    public Log selectCountByUserid(int userid) {
        String hql = "select count(*) from Log where Log.userid= "+userid;
        return (Log) this.getHibernateTemplate().find(hql);
    }

    @Override
    public boolean save(Log log)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HibernateTemplate hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
        hibernateTemplate.save(log);
        return false;
    }

    @Override
    public boolean delete(int id) {
        deleteEmtityById(Log.class,String.valueOf(id));
        return false;
    }

    @Override
    public boolean deleteThisUser(int userid) {
        String hql ="from Log where Log .userid = :userid";
        List<Log> logs =(List<Log>) this.getHibernateTemplate().find(hql);
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
