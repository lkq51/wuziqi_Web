package base.serviceImpl;

import base.model.UserInfo;
import base.service.UserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lkq on 2017/6/19.
 */
@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService{

    @Override
    public List<UserInfo> selectAll(int page, int pageSize) {
        return null;
    }

    @Override
    public UserInfo selectUserByUserId(int userId) {
        return null;
    }

    @Override
    public UserInfo selectUserByUserName(String username) {
        return null;
    }

    @Override
    public int selectCount(int pageSize) {
        return 0;
    }

    @Override
    public boolean save(UserInfo userInfo) {
        return false;
    }

    @Override
    public boolean update(UserInfo userInfo) {
        return false;
    }

    @Override
    public boolean delete(int userId) {
        return false;
    }
}
