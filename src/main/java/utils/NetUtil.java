package utils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lkq on 2016/12/13.
 */
public class NetUtil {
    public String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("x-forwandred-for");
        if (ip == null||ip.length() == 0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null||ip.length() == 0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null||ip.length() == 0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null||ip.length() == 0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("HTTP_X_FORWARDED_IP");
        }
        if (ip == null||ip.length() == 0||"unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
