package dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public interface BaseDAO {
    public <T> void saveEntity(T entity);

    public <T> void deleteEntity(T entity);

    public <T> void deleteEmtityById(Class <T> entityClass, Serializable id);

    public <T> void updateEntity(T entity);

    public <T> List<T> getAllEntity(String entityName);

    public <T> T getEntityById(Class<T> entityClass,Serializable id);

    public <T> List<T> getByPage(String hql,int pageNo,int pageSize,int real);

    public <T> int realPage(String hql);
}
