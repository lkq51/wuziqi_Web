package base.dao;

import base.model.Log;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lou on 16/12/13.
 */
@Service(value = "logDAO")
public interface LogDAO {
    List<Log> selectAll(@Param("start") int start,@Param("end") int end);
    List<Log> selectLogByUserid(@Param("userid") String userid,@Param("start") int start,@Param("end") int end);
    Log selectCount();
    Log selectCountByUserid(@Param("userid") String userid);
    boolean insert(Log log);
    boolean delete(int id);
    boolean deleteThisUser(int userid);
    boolean deleteAll();
}
