package base.dao;

import base.model.Log;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lou on 16/12/13.
 */
public interface LogDAO {
    List<Log> selectAll(int start, int end);
    List<Log> selectLogByUserid(int userid, int start, int end);
    Log selectCount();
    Log selectCountByUserid(int userid);
    boolean save(Log log);
    boolean delete(int id);
    boolean deleteThisUser(int userid);
    boolean deleteAll();
}
