package base.controller;

import base.model.Log;
import base.model.User;
import base.service.LogService;
import base.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public String login(String username, String password, HttpSession session, RedirectAttributes attributes, WordDefined defined, CommonDate date, LogUtil logUtil, NetUtil netUtil, HttpServletRequest request){
        user = userService.selectUserByUserName(username);
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
                    logService.insert(logUtil.setLog(user.getId(),username,date.getTime24(),defined.LOG_TYPE_LOGIN,defined.LOG_DETAIL_USER_LOGIN,netUtil.getIpAddress(request)));
                    session.setAttribute("username",username);
                    session.setAttribute("login_status",true);
                    user.setLastlogintime(date.getTime24());
                    userService.update(user);
                    attributes.addFlashAttribute("message",defined.LOGIN_SUCCESS);
                    return "redirect:/chat";
                }
            }
        }
    }
}
