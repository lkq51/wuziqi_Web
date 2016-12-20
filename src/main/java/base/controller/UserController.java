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
@SessionAttributes("userid")
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
        ModelAndView view = new ModelAndView("jsp/chat");
        return view;
    }

    /**
    * 显示个人信息页面
    * @param userid
    * @param sessionid
    * @return
    */
    @RequestMapping(value = "{userid}",method = RequestMethod.GET)
    public ModelAndView selectUserByUserid(@PathVariable("userid")int userid, @ModelAttribute("userid")String sessionid){
        ModelAndView view =new ModelAndView("jsp/information");
        user = userService.selectUserByUserid(userid);
        view.addObject("user",user);
        return view;
    }

    /**
    * 更新用户信息
    * @param userid
    * @param sessionid
    * @param username
    * @return
    */
    @RequestMapping(value = "{userid}/update",method = RequestMethod.POST)
    public String update(@PathVariable("userid") int userid, @ModelAttribute("username") String username,@ModelAttribute("userid") String sessionid, User user, RedirectAttributes attributes, NetUtil netUil, LogUtil logUtil, CommonDate date, WordDefined defined, HttpServletRequest request){
        boolean flag = userService.update(user);
        if (flag){
            logService.insert(logUtil.setLog(userid,username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PROFILE,netUil.getIpAddress(request)));
            attributes.addFlashAttribute("message","["+userid+"]资料更新成功!");
        }else {
            attributes.addFlashAttribute("error","["+userid+"]资料更新失败!");
        }
        return "redirect:/{userid}/config";
    }
    /**
     * 修改密码
     * @param userid
     * @param oldpass
     * @param newpass
     * @return
     */
    @RequestMapping(value = "{userid}/pass",method = RequestMethod.POST)
    public String changePassword(@PathVariable("userid") int userid,@ModelAttribute("username") String username, String oldpass, String newpass,RedirectAttributes attributes,NetUtil netUtil,LogUtil logUtil,CommonDate date,WordDefined defined,HttpServletRequest request){
        user = userService.selectUserByUserid(userid);
        if(oldpass.equals(user.getPassword())){
            user.setPassword(newpass);
            boolean flag = userService.update(user);
            if (flag){
                logService.insert(logUtil.setLog(userid,username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PASSWORD,netUtil.getIpAddress(request)));
                attributes.addFlashAttribute("message","["+userid+"]密码更新成功!");
            }else {
                attributes.addFlashAttribute("error","["+userid+"]密码更新失败!");
            }
        }else {
            attributes.addFlashAttribute("error","["+userid+"]密码更新失败!");
        }
        return "redirect:/{userid}/config";
    }
    /**
     * 头像上传
     *@param userid
     *@param file
     *@param request
     *@return
     */
    @RequestMapping(value = "{userid}/upload")
    public String upload(@PathVariable("userid") int userid, String username,MultipartFile file,HttpServletRequest request,UploadUtil uploadUtil,RedirectAttributes attributes,NetUtil netUtil,LogUtil logUtil,CommonDate date,WordDefined defined){
        try {
            String fileurl = uploadUtil.upload(request,"upload",userid);
            user = userService.selectUserByUserid(userid);
            user.setProfilehead(fileurl);
            boolean flag = userService.update(user);
            if (flag){
                logService.insert(logUtil.setLog(userid,username,date.getTime24(),defined.LOG_TYPE_UPDATE,defined.LOG_DETAIL_UPDATE_PROFILEHEAD,netUtil.getIpAddress(request)));
                attributes.addFlashAttribute("message","["+userid+"]头像更新成功!");
            }
        }catch (Exception e){
            attributes.addFlashAttribute("error","["+userid+"]头像更新失败!");
        }
        return "redirect:/{userid}/config";
    }

    /**
     * 获取用户头像
     * @param userid
     */
    @RequestMapping(value = "{userid}/head")
    @ResponseBody
    public void head(@PathVariable("userid") int userid, HttpServletRequest request, HttpServletResponse response){
        try {
            user =userService.selectUserByUserid(userid);
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
