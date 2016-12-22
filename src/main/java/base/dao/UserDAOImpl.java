package base.dao;

import base.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;
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
        String hql = "from User where User.id = ?";
        return (User) this.getHibernateTemplate().find(hql,userid);
    }

    @Override
    public User selectUserByUserName(String username) {
        String hql = "from User user where user.username = ?";
        List<User> users =(List<User>) this.getHibernateTemplate().find(hql,username);
        User user = users.get(0);
        return user;
    }

    //有问题
    @Override
    public User selectCount()
    {
        String hql = "";
        return (User) this.getHibernateTemplate().find(hql);
    }

    @Override
    public boolean save(User user) {
        this.getHibernateTemplate().save(user);
        return false;
    }

    @Override
    public boolean update(User user)
    {
        this.getHibernateTemplate().update(user);
        return true;
    }

    @Override
    public boolean delete(int userid) {
        deleteEmtityById(User.class,String.valueOf(userid));
        return false;
    }
}
