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
        int start =1;
        int end = pageSize;
        if (page !=1){
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return userDAO.selectAll(start, end);
    }

    @Override
    public User selectUserByUserid(String userid) {
        return userDAO.selectUserByUserid(userid);
    }

    @Override
    public int selectCount(int pageSize) {
        int pageCount = userDAO.selectCount().getId();
        return pageCount % pageSize == 0 ? pageCount/pageSize:pageCount/pageSize + 1;
    }

    @Override
    public boolean insert(User user) {
        return userDAO.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean delete(String userid) {
        return userDAO.delete(userid);
    }
}
