package base.serviceImpl;

import base.dao.LogDAO;
import base.model.Log;
import base.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lou on 16/12/13.
 */
@Service(value = "logService")
public class LogServiceImpl implements LogService {
    @Resource private LogDAO logDAO;
    @Resource private Log log;


    @Override
    public List<Log> selectAll(int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if (page != 1){
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return logDAO.selectAll(start,end);
    }

    @Override
    public List<Log> selectLogByUserid(int userid, int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if (page != 1){
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return logDAO.selectLogByUserid(userid, start, end);
    }

    @Override
    public int selectCount(int pageSize) {
        int pageCount = logDAO.selectCount().getId();
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize +1;
    }

    @Override
    public int selecrCountByUserid(int userid, int pageSize) {
        int pageCount = logDAO.selectCountByUserid(userid).getUserid();
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize +1;
    }

    @Override
    public boolean insert(Log log) {
        return logDAO.insert(log);
    }

    @Override
    public boolean delete(int id) {
        return logDAO.delete(id);
    }

    @Override
    public boolean deleteThisUser(int id) {
        return logDAO.deleteThisUser(id);
    }

    @Override
    public boolean deleteAll() {
        return logDAO.deleteAll();
    }
}
