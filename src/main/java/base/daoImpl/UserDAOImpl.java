package base.daoImpl;

import base.dao.UserDAO;
import base.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lkq on 2016/12/16.
 */
@Repository(value = "userDAO")
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    @Override
    public List<User> selectAll(int page,int pageSize) {
        String hql = "from User";
        int real = selectCount();
        List<User> users = getByPage(hql,page,pageSize,real);
        return users;
    }

    @Override
    public User selectUserByUserId(int userId)
    {
        String hql = "from User where User.userid = ?";
        return (User) this.getHibernateTemplate().find(hql,userId);
    }

    @Override
    public User selectUserByUserName(String userName) {
        String hql = "from User user where user.username = ?";
        List<User> users =(List<User>) this.getHibernateTemplate().find(hql,userName);
        if (null != users && users.size() > 0 ){
            User user = users.get(0);
            return user;
        }
        return null;
    }

    /**
     *
     * @return  返回记录行数
     */
    @Override
    public int selectCount()
    {
        String hql = "from User";
        return realPage(hql);
    }

    @Override
    public boolean save(User user) {
        try {
            saveEntity(user);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user)
    {
        try {
            updateEntity(user);
        }catch (DataAccessResourceFailureException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int userId) {
        try {
            User user = selectUserByUserId(userId);
            deleteEntityById(User.class,String.valueOf(user.getId()));
        }catch (DataAccessResourceFailureException e){
            return false;
        }
        return true;
    }
}
