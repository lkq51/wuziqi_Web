package base.dao;

import base.model.UserInfo;

import java.util.List;

/**
 * Created by lkq on 2017/6/19.
 */

public interface UserInfoDAO {
    List<UserInfo> selectAll(int page, int pageSize);
    UserInfo getUserInfoByUserId(int userid);
    UserInfo getUserInfoByUserName(String userName);
    int selectCount();
    boolean save(UserInfo userInfo);
    boolean update(UserInfo userInfo);
    boolean delete(int userId);
}
