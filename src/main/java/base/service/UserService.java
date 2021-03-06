package base.service;

import base.model.User;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public interface UserService {
    List<User> selectAll(int page, int pageSize);
    User selectUserByUserId(int userId);
    User selectUserByUserName(String username);
    int selectCount(int pageSize);
    boolean save(User user);
    boolean update(User user);
    boolean delete(int userId);

}
