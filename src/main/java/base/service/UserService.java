package base.service;

import base.model.User;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public interface UserService {
    List<User> selectAll(int page,int pageSize);
    User selectUserByUserid(String userid);
    int selectCount(int pageSize);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);

}
