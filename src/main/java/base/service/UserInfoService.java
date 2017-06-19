package base.service;

import base.model.UserInfo;

import java.util.List;

/**
 * Created by lkq on 2017/6/19.
 */

public interface UserInfoService {
    List<UserInfo> selectAll(int page, int pageSize);
    UserInfo selectUserByUserId(int userId);
    UserInfo selectUserByUserName(String username);
    int selectCount(int pageSize);
    boolean save(UserInfo userInfo);
    boolean update(UserInfo userInfo);
    boolean delete(int userId);
}
