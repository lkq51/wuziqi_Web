package base.controller;

import base.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;

/**
 * Created by lkq on 2016/12/13.
 */
@Controller
@SessionAttributes("userid")
public class UserController {
    @Resource private User user;
    @Resource private
}
