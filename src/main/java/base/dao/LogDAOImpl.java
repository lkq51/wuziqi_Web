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
    public List<Log> selectAll() {
        return getAllEntity("Log");
    }

    @Override
    public List<Log> selectLogByUserid(int userid) {
        return (List<Log>)getEntityById(Log.class,String.valueOf(userid));

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

        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
