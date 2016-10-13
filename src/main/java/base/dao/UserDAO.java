package base.dao;

import base.model.User;

/**
 * Created by lkq on 2016/10/12.
 */
public interface UserDAO extends BaseDAO{
    public User loginCheck(String name, String password);

    public void save( User user );


}
