package base.serviceImpl;

import base.dao.UserInfoDAO;
import base.model.UserInfo;
import base.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lkq on 2017/6/19.
 */
@Service(value = "userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
    @Resource private UserInfoDAO userInfoDAO;

    @Override
    public List<UserInfo> selectAll(int page, int pageSize) {
        return userInfoDAO.selectAll(page, pageSize);
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDAO.getUserInfoByUserId(userId);
    }

    @Override
    public UserInfo getUserInfoByUserName(String username) {
        return userInfoDAO.getUserInfoByUserName(username);
    }

    @Override
    public int selectCount(int pageSize) {
        int pageCount = userInfoDAO.selectCount();
        return pageCount % pageSize == 0 ? pageCount/pageSize:pageCount/pageSize + 1;
    }

    @Override
    public boolean save(UserInfo userInfo) {
        return userInfoDAO.save(userInfo);
    }

    @Override
    public boolean update(UserInfo userInfo) {
        return userInfoDAO.update(userInfo);
    }

    @Override
    public boolean delete(int userId) {
        return userInfoDAO.delete(userId);
    }

    public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    public UserInfoDAO getUserInfoDAO() {
        return userInfoDAO;
    }
}
