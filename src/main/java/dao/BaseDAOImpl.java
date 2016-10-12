package dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import org.apache.log4j.Logger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public class BaseDAOImpl implements BaseDAO {
    private HibernateTemplate hibernateTemplate;

    protected Logger logger=Logger.getLogger(this.getClass());

    public HibernateTemplate getHibernateTemplate(){
        return hibernateTemplate;
    }
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate=hibernateTemplate;
    }

    public <T> void saveEntity(T entity) {
        this.hibernateTemplate.saveOrUpdate(entity);
    }

    public <T> void deleteEntity(T entity) {
        this.hibernateTemplate.delete(entity);
    }

    public <T> void deleteEmtityById(Class<T> entityClass, Serializable id) {
        this.hibernateTemplate.delete(this.getEntityById(entityClass,id));
    }

    public <T> void updateEntity(T entity) {
        this.hibernateTemplate.saveOrUpdate(entity);
    }

    public <T> List<T> getAllEntity(String entityName) {
        return (List<T>) this.hibernateTemplate.find("from"+" "+entityName);
    }

    public <T> T getEntityById(Class<T> entityClass, Serializable id) {
        return (T) this.hibernateTemplate.get(entityClass,id);
    }

    public <T> List<T> getByPage(String hql, int pageNo, int pageSize, int real) {
        List<T> list=new ArrayList<T>();
        int begin=(pageNo-1)*pageSize;
        int end=(pageNo)*pageSize;

        if (end>real){
            end=real;
        }
        list= (List<T>) this.hibernateTemplate.find(hql).subList(begin,end);

        return list;
    }

    public <T> int realPage(String hql) {
        int count=0;
        count=this.hibernateTemplate.find(hql).size();
        return count;
    }
}
