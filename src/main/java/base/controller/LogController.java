package base.controller;

import base.model.Log;
import base.service.LogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lou on 16/12/21.
 */
@Controller
public class LogController {
    @Resource private Log log;
    @Resource private LogService logService;

    @RequestMapping(value = "{username}/log")
    public ModelAndView selectAll(@PathVariable("username") String username, @RequestParam(defaultValue = "1") int page){
        int pagesize = 5;
        ModelAndView view = new ModelAndView("jsp/log");
        List<Log> logs = logService.selectLogByUserName(username, page,pagesize);
        int count = logService.selectLogByUserName(username, page);
        view.addObject("list",logs);
        view.addObject("count",count);
        return  view;
    }
}
