package base.dao;

import base.model.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by lkq on 2016/10/12.
 */
public class UserDAOimpl extends BaseDAOImpl implements UserDAO {

    @Override
    public List<User> selectAll(@Param("start") int start, @Param("end") int end) {
        return null;
    }

    @Override
    public User selectUserByUserid(int userid) {
        return null;
    }

    @Override
    public User selectCount() {
        return null;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int userid) {
        return false;
    }
}
