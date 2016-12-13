package utils;

import base.model.Log;


/**
 * Created by lkq on 2016/12/13.
 */
public class LogUtil {
    public Log setLog(int userid, String username, String time, String type, String detail, String ip){
        Log log = new Log();
        log.setUserid(userid);
        log.setUsername(username);
        log.setTime(time);
        log.setType(type);
        log.setDetail(detail);
        log.setIp(ip);

        return log;
    }

}
