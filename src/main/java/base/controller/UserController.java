package base.controller;

import base.model.User;
import base.service.UserService;
import utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * Created by lkq on 2016/12/13.
 */
@Controller
@SessionAttributes("userid")
public class UserController {
    @Resource private User user;
    @Resource private UserService userService;

    /**
     * 聊天主页
     * @return
     */
    @RequestMapping(value = "chat")
    public ModelAndView getIndex(){
        ModelAndView view = new ModelAndView("apps/index");
        return view;
    }

    /**
    * 显示个人信息页面
    * @param userid
    * @param sessionid
    * @return
    */
    @RequestMapping(value = "{userid}",method = RequestMethod.GET)
    public ModelAndView selectUserByUserid(@PathVariable("userid")String userid, @ModelAttribute("userid")String sessionid){
        ModelAndView view =new ModelAndView("apps/information");
        user = userService.selectUserByUserid(userid);
        view.addObject("user",user);
        return view;
    }

    /**
    * 更新用户信息
    * @param userid
    * @param sessionid
    * @return
    */
    @RequestMapping(value = "{userid}/update",method = RequestMethod.POST)
    public String update(@PathVariable("userid") String userid, @ModelAttribute("userid") String sessionid, User user, RedirectAttributes attributes,NetUtil netUil,)

}
