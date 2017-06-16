package base.dao;

import base.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public interface UserDAO extends BaseDAO{
    List<User> selectAll(int page,int pageSize);
    User selectUserByUserId(int userId);
    User selectUserByUserName(String username);
    int selectCount();
    boolean save (User user);
    boolean update (User user);
    boolean delete (int userId);
}
