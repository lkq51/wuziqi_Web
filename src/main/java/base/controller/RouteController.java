package base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lou on 16/12/21.
 */
@Controller
public class RouteController {
    @RequestMapping(value = "")
    public String index(){return "login";}


    @RequestMapping(value = "login")
    public String login(){return "login";}

    @RequestMapping(value = "about")
    public String about(){return "jsp/about";}

    @RequestMapping(value = "help")
    public String help(){return "jsp/help";}
}
