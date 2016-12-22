package base.controller;

import base.model.Log;
import base.model.User;
import base.service.LogService;
import base.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.CommonDate;
import utils.LogUtil;
import utils.NetUtil;
import utils.WordDefined;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lkq on 2016/12/16.
 */
@Controller
@RequestMapping(value = "user")
public class LoginController {
    @Resource private User user;
    @Resource private UserService userService;
    @Resource private Log log;
    @Resource private LogService logService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,@RequestParam("password") String password, HttpSession session, RedirectAttributes attributes, WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request){
        user = userService.selectUserByUserName(userName);
        if (user == null){
            attributes.addFlashAttribute("error",defined.LOGIN_USERID_ERROR);
            return "redirect:/login";
        }else {
            if (!user.getPassword().equals(password)){
                attributes.addFlashAttribute("error",defined.LOGIN_PASSWORD_ERROR);
                return "redirect:/login";
            }else {
                if (!user.isStatus()){
                    attributes.addFlashAttribute("error",defined.LOGIN_USERID_DISABLED);
                    return "redirect:/login";
                }else {
                    logService.save(logUtil.setLog(user.getId(),userName,date.getTime24(),defined.LOG_TYPE_LOGIN,defined.LOG_DETAIL_USER_LOGIN,netUtil.getIpAddress(request)));
                    session.setAttribute("userid",user.getId());
                    session.setAttribute("username",userName);
                    session.setAttribute("login_status",true);
                    user.setLastlogintime(date.getTime24());
                    userService.update(user);
                    attributes.addFlashAttribute("message",defined.LOGIN_SUCCESS);
                    return "redirect:/chat";
                }
            }
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session, RedirectAttributes attributes, WordDefined defined){
        session.removeAttribute("username");
        session.removeAttribute("login_status");
        attributes.addFlashAttribute("message", defined.LOGOUT_SUCCESS);
        return "redirect:/login";
    }
}
