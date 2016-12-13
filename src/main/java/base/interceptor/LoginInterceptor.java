package base.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * Created by lkq on 2016/12/13.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private static final String[] IGNORE_URI = {"user/login","/login","/user/logout"};   //忽略的URI
    private static final String LOGIN_URI = "/login"; //登录URI


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        String contextPath = request.getContextPath();
        for (String s : IGNORE_URI){
            if (url.contains(s)){
                return true;
            }
        }
        HttpSession session = request.getSession();
        if (session != null&&session.getAttribute("login_status")!= null){
            return true;
        }else {
            response.sendRedirect(contextPath+"login?timeout=true");
            return false;
        }
    }

    public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView)throws Exception{
        super.postHandle(request,response,handler,modelAndView);
    }
}
