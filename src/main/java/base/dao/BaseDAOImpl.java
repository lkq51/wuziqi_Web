package base.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
@Repository(value = "BaseDAO")
public class BaseDAOImpl extends DaoSupport implements BaseDAO {
    protected Logger logger=Logger.getLogger(this.getClass());
    private SessionFactory sessionFactory;
    private HibernateTemplate hibernateTemplate;
    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public final void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate=hibernateTemplate;
    }

    public final HibernateTemplate getHibernateTemplate() {
        return this.hibernateTemplate;
    }
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.hibernateTemplate = createHibernateTemplate(sessionFactory);
    }
    public Session getSession(){
        if (this.sessionFactory == null){
            throw  new HibernateException("Session Create Fail,SessionFactory is null");
        }
        return this.sessionFactory.getCurrentSession();
    }
    protected HibernateTemplate createHibernateTemplate(SessionFactory sessionFactory){
        return new HibernateTemplate(sessionFactory);
    }

    @Override
    protected void checkDaoConfig() throws IllegalArgumentException {
        if (this.hibernateTemplate == null){
            throw new IllegalArgumentException("'sessionFactory' or 'hibernateTemplate' is required");
        }
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

    /**
     * @param hql
     * @param pageNo  查询的页数
     * @param pageSize 每页的大小
     * @param real     实际的最大数据序号
     * @param <T>
     * @return
     */
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
