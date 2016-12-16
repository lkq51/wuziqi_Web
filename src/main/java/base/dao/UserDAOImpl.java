package base.dao;

import base.model.User;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lkq on 2016/12/16.
 */
@Repository(value = "UserDAO")
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    @Override
    public List<User> selectAll(int start,int end) {
        String hql = "from User ";
        return (List<User>) this.getHibernateTemplate().find(hql);
    }
    //有问题
    @Override
    public User selectUserByUserid(int userid)
    {
        String hql = "from User where User.id = :userid";
        return (User) this.getHibernateTemplate().find(hql);
    }

    @Override
    public User selectUserByUserName(String username) {
        String hql = "from User where User.username=:username";
        return (User) this.getHibernateTemplate().find(hql);
    }

    //有问题
    @Override
    public User selectCount()
    {
        String hql = "";
        return (User) this.getHibernateTemplate().find(hql);
    }

    @Override
    public boolean insert(User user) {
        this.getHibernateTemplate().save(user);
        return false;
    }

    @Override
    public boolean update(User user)
    {
        this.getHibernateTemplate().update(user);
        return false;
    }

    @Override
    public boolean delete(int userid) {
        deleteEmtityById(User.class,String.valueOf(userid));
        return false;
    }
}
