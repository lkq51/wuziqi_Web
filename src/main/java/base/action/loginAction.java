package base.action;

import base.model.User;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import base.service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lkq on 2016/10/12.
 */
public class loginAction extends ActionSupport{
    private String userName;
    private String password;
    @Resource
    private UserService userService;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() throws Exception{
        this.request= ServletActionContext.getRequest();
        this.session=this.request.getSession();

        String ret="";
        User user=new User();
        if (userName!=""&&password!="") {
            user = this.userService.login(userName, password);
            if (user == null) {
                this.request.setAttribute("msg", "用户不存在");
                ret = "restart";
            } else {
                //this.session.setAttribute();
                if (user.isAdmin()) {
                    ret = "admin";
                } else {
                    ret = "user";
                }
            }
        }else {
            this.request.setAttribute("msg","用户名与密码为空!!");
            ret="restart";
        }
        return ret;
    }
}
