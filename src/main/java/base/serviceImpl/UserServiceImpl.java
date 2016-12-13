package base.serviceImpl;

import base.dao.UserDAO;
import base.model.User;
import base.service.UserService;

/**
 * Created by lkq on 2016/10/12.
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User login(String userName, String password) {
        return userDAO.loginCheck(userName,password);
    }

    public void add(User user) {
        this.userDAO.save(user);
    }
}
