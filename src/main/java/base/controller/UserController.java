package base.controller;

import base.model.User;
import base.service.LogService;
import base.service.UserService;
import org.springframework.web.multipart.MultipartFile;
import utils.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by lkq on 2016/12/13.
 */
@Controller
@SessionAttributes("username")
public class UserController {
    @Resource private User user;
    @Resource private UserService userService;
    @Resource private LogService logService;

    /**
     * 聊天主页
     * @return
     */
    @RequestMapping(value = "chat")
    public ModelAndView getIndex(){
        ModelAndView view = new ModelAndView("jsp/index");
        return view;
    }

    /**
    * 显示个人信息页面
    * @param username
    * @param sessionid
    * @return
    */
    @RequestMapping(value = "{username}",method = RequestMethod.GET)
    public ModelAndView selectUserByusername(@PathVariable("username")String username, @ModelAttribute("username")String sessionid){
        ModelAndView view = new ModelAndView("jsp/information");
        user = userService.selectUserByUserName(username);
        view.addObject("user",user);
        return view;
    }
    /**
     * 显示个人信息编辑页面
     * @param username
     * @param sessionid
     * @return
     */
    @RequestMapping(value = "{username}/config")
    public ModelAndView setting(@PathVariable("username") String username, @ModelAttribute("username") String sessionid){
        ModelAndView view = new ModelAndView("jsp/info-setting");
        user = userService.selectUserByUserName(username);
        view.addObject("user", user);
        return view;
    }
    /**
    * 更新用户信息
    * @param username
    * @param sessionid
    * @param username
    * @return
    */
    @RequestMapping(value = "{username}/update",method = RequestMethod.POST)
    public String update(@PathVariable("username") String username, @ModelAttribute("username") String sessionid, User user, RedirectAttributes attributes, NetUtil netUil, LogUtil logUtil, CommonDate date, WordDefined defined, HttpServletRequest request){
        boolean flag = false;
        try{
            flag = userService.update(user);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (flag){
            logService.save(logUtil.setLog(user.getId(),username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PROFILE,netUil.getIpAddress(request)));
            attributes.addFlashAttribute("message","["+username+"]资料更新成功!");
        }else {
            attributes.addFlashAttribute("error","["+username+"]资料更新失败!");
        }
        return "redirect:/{username}/config";
    }
    /**
     * 修改密码
     * @param username
     * @param oldpass
     * @param newpass
     * @return
     */
    @RequestMapping(value = "{username}/pass",method = RequestMethod.POST)
    public String changePassword(@PathVariable("username") String username, String oldpass, String newpass,RedirectAttributes attributes,NetUtil netUtil,LogUtil logUtil,CommonDate date,WordDefined defined,HttpServletRequest request){
        user = userService.selectUserByUserName(username);
        if(oldpass.equals(user.getPassword())){
            user.setPassword(newpass);
            boolean flag = userService.update(user);
            if (flag){
                logService.save(logUtil.setLog(user.getId(),username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PASSWORD,netUtil.getIpAddress(request)));
                attributes.addFlashAttribute("message","["+username+"]密码更新成功!");
            }else {
                attributes.addFlashAttribute("error","["+username+"]密码更新失败!");
            }
        }else {
            attributes.addFlashAttribute("error","["+username+"]密码更新失败!");
        }
        return "redirect:/{username}/config";
    }
    /**
     * 头像上传
     *@param username
     *@param file
     *@param request
     *@return
     */
    @RequestMapping(value = "{username}/upload")
    public String upload(@PathVariable("username") String username,MultipartFile file,HttpServletRequest request,UploadUtil uploadUtil,RedirectAttributes attributes,NetUtil netUtil,LogUtil logUtil,CommonDate date,WordDefined defined){
        try {
            String fileurl = uploadUtil.upload(request,"upload",username);
            user = userService.selectUserByUserName(username);
            user.setProfilehead(fileurl);
            boolean flag = userService.update(user);
            if (flag){
                logService.save(logUtil.setLog(user.getId(),username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PROFILEHEAD,netUtil.getIpAddress(request)));
                attributes.addFlashAttribute("message","["+username+"]头像更新成功!");
            }
        }catch (Exception e){
            attributes.addFlashAttribute("error","["+username+"]头像更新失败!");
        }
        return "redirect:/{username}/config";
    }

    /**
     * 获取用户头像
     * @param username
     */
    @RequestMapping(value = "{username}/head")
    @ResponseBody
    public void head(@PathVariable("username") String username, HttpServletRequest request, HttpServletResponse response){
        try {
            user = userService.selectUserByUserName(username);
            String path = user.getProfilehead();
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            String picturePath = rootPath + path;
            response.setContentType("image/jpeg;charset=utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            FileInputStream inputStream = new FileInputStream(picturePath);
            byte[] buffer = new byte[1024];
            int i = -1;
            while ((i=inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,i);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
            outputStream = null;
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
