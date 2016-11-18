package base.dao;

import base.model.User;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public class UserDAOimpl extends BaseDAOImpl implements UserDAO {
   @Override
    public User loginCheck(String userName, String password) {
        String hql= String.format("from User u where u.username ='%s' and u.password= '%s'", userName, password);
        List<User> list= (List<User>) this.getHibernateTemplate().find(hql);
       //String hql=String.format("from User u");
       //List<User> list=(List<User>) this.getHibernateTemplate().find(hql);
       //System.out.println(list.get(0).getUsername());
        if (list!=null&&list.size()>0){
            super.logger.info("login check succ,user.username="+list.get(0).getUsername());
            return list.get(0);
        }else {
            return null;
        }
    }

    public void save(User user) {
        super.saveEntity(user);
    }
}
