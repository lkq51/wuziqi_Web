package base.service;

import base.model.Log;

import java.util.List;

/**
 * Created by lou on 16/12/13.
 */
public interface LogService {
    List<Log> selectAll(int page, int pageSize);
    List<Log> selectLogByUserName(String username, int page, int pageSize);
    int selectCount(int pageSize);
    int selectLogByUserName(String username, int pageSize);
    boolean save(Log log);
    boolean delete(int id);
    boolean deleteThisUser(int id);
    boolean deleteAll();
}
