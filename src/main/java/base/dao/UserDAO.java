package base.dao;

import base.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
@Service(value = "userDAO")
public interface UserDAO extends BaseDAO{
    List<User> selectAll(@Param("start") int start,@Param("end") int end);
    User selectUserByUserid(int userid);
    //User selectCount();
    boolean insert (User user);
    boolean update (User user);
    boolean delete (int userid);
}
