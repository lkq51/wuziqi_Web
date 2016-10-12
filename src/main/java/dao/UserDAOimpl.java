package dao;

import model.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public class UserDAOimpl extends BaseDAOImpl implements UserDAO {
    public User loginCheck(String name, String password) {
        String hql= String.format("from model.User u where u.name ='%s' and u.password= '%s'", name, password);
        List<User> list= (List<User>) this.getHibernateTemplate().find(hql);
        if (list!=null&&list.size()>0){
            super.logger.info("login check succ,user.name="+list.get(0).getUserName());
            return list.get(0);
        }else {
            return null;
        }
    }

    public void save(User user) {
        super.saveEntity(user);
    }
}
