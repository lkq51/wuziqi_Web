package base.dao;

import base.model.Log;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by lkq on 2016/12/14.
 */
@Repository(value = "logDAO")
public class LogDAOImpl  extends BaseDAOImpl implements LogDAO{

    @Override
    public List<Log> selectAll(int start, int end) {
        String hql = "Select * from Log (select A.*,Rownum RN from (select * from Log Order by Desc)A) where RN between :start and :end";
        return null;
    }

    @Override
    public List<Log> selectLogByUserid(int userid, int start, int end) {
        return null;
    }

    @Override
    public Log selectCount() {
        return null;
    }

    @Override
    public Log selectCountByUserid(int userid) {
        return null;
    }

    @Override
    public boolean insert(Log log) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        deleteEmtityById(Log.class,String.valueOf(id));
        return false;
    }

    @Override
    public boolean deleteThisUser(int userid) {
        String hql ="From Log";
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
