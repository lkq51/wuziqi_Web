package base.service;

import base.model.User;

/**
 * Created by lkq on 2016/10/12.
 */
public interface UserService {
    public User login(String name, String password);

    public void add(User user);

}
