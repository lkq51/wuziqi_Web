package base.daoImpl;

import base.dao.UserInfoDAO;
import base.model.UserInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;

import java.util.List;

/**
 * Created by lkq on 2017/6/19.
 */
public class UserInfoDAOImpl extends BaseDAOImpl implements UserInfoDAO {
    @Override
    public List<UserInfo> selectAll(int page, int pageSize) {
        String hql = "from UserInfo";
        int real = selectCount();
        List<UserInfo> userInfos = getByPage(hql, page, pageSize, real);
        return userInfos;
    }

    @Override
    public UserInfo getUserInfoByUserId(int userid) {
        String hql = "from UserInfo where UserInfo.userid = ?";
        return (UserInfo) this.getHibernateTemplate().find(hql, userid);
    }
    /**
     *
     * @return  返回记录行数
     */
    @Override
    public int selectCount() {
        String hql = "from UserInfo";
        return realPage(hql);
    }

    @Override
    public boolean save(UserInfo userInfo) {
        try {
            saveEntity(userInfo);
        }catch (DataAccessException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserInfo userInfo) {
        try {
            updateEntity(userInfo);
        }catch (DataAccessResourceFailureException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(int userId) {
        try {
            UserInfo userInfo = getUserInfoByUserId(userId);
            deleteEntityById(UserInfo.class, String.valueOf(userInfo.getId()));
        }catch (DataAccessResourceFailureException e){
            return false;
        }
        return true;
    }
}
