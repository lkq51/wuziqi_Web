package base.serviceImpl;

import base.dao.UserDAO;
import base.model.User;
import base.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource private UserDAO userDAO;

    @Override
    public List<User> selectAll(int page, int pageSize) {
        return userDAO.selectAll(page, pageSize);
    }

    @Override
    public User selectUserByUserid(int userid) {
        return userDAO.selectUserByUserid(userid);
    }

    @Override
    public User selectUserByUserName(String username) {
        return userDAO.selectUserByUserName(username);
    }

    @Override
    public int selectCount(int pageSize) {
        int pageCount = userDAO.selectCount();
        return pageCount % pageSize == 0 ? pageCount/pageSize:pageCount/pageSize + 1;
    }

    @Override
    public boolean save(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(int userid) {
        return userDAO.delete(userid);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }
}
