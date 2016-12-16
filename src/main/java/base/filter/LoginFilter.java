package base.filter;

import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.FilterChain;
import java.io.IOException;

/**
 * Created by lkq on 2016/12/13.
 */
public class LoginFilter extends OncePerRequestFilter {
    private static final String LOGIN_URL = "/login";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String[] notFilter = new String[]{"login","login.jsp","user/logout","user/login"};   //不过滤的URL
        String contextPath = request.getContextPath(); //主路径
        String uri = request.getRequestURI();     //请求的URI
        //uri中包含jsp时才进行过滤
        if (uri.indexOf("jsp")!=-1){
            //是否过滤
            boolean doFilter = true;
            for (String s:notFilter){
                if (uri.indexOf(s)!=-1){
                    doFilter = false;
                    break;
                }
            }
            if (doFilter){
                //执行过滤
                if (null == request.getSession().getAttribute("login_status")){
                    response.sendRedirect(contextPath + "/login?timeout=true");
                }else {
                    //如果session中存在登录者实体，则继续
                    filterChain.doFilter(request, response);
                }
            }else {
                //如果不执行过滤，则继续
                filterChain.doFilter(request, response);
            }
        }else {
            //如果uri中不包含jsp,则继续
            filterChain.doFilter(request, response);
        }
    }
}
