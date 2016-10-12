package action;

import com.opensymphony.xwork2.ActionSupport;
import model.Administrator;
import model.User;
import org.apache.struts2.ServletActionContext;
import service.UserService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lkq on 2016/10/12.
 */
public class loginAction extends ActionSupport{
    private String username;
    private String password;
    private UserService userService;
    private HttpServletRequest request;
    private HttpSession session;
    private ServletContext application;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        User user=this.userService.login(username,password);

        if (user==null){
            this.request.setAttribute("msg","用户不存在");

            ret="restart";
        }else {
            //this.session.setAttribute();
            if(user instanceof Administrator){
                ret="admin";
            }else {
                ret="user";
            }
        }
        return ret;
    }
}
