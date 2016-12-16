package base.dao;

import base.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
@Repository(value = "UserDAO")
public interface UserDAO extends BaseDAO{
    List<User> selectAll(int start,int end);
    User selectUserByUserid(int userid);
    User selectUserByUserName(String username);
    User selectCount();
    boolean insert (User user);
    boolean update (User user);
    boolean delete (int userid);
}
