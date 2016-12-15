package utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by lkq on 2016/12/15.
 */
public class UploadUtil {
    /**
     * 返回处理过的path+fileName
     * @param request
     * @param folder
     * @param userid
     * @return
     */
    public String upload(HttpServletRequest request,String folder,int userid){
        FileUtil fileUtil = new FileUtil();
        String file_url = "";
        //创建一个通用的多部分解析器
      CommonsMultipartResolver multipartResolver = new  CommonsMultipartResolver(request.getSession().getServletContext());
      //判断request是否有文件上传,即多部请求
        if (multipartResolver.isMultipart(request)){
            //转换成多部分request
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            //取得request中所有的文件名
            Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
            while (iterator.hasNext()){
                //取得上传文件
                MultipartFile file = multipartHttpServletRequest.getFile(iterator.next());
                String prefix = fileUtil.getFilePrefix(file);
                if (file!=null){
                    //取得当前上传文件的文件名称
                    String myFileName = file.getOriginalFilename();
                    //如果名称不为"",说明该文件存在,否则说明该文件不存在
                    if (myFileName.trim()!=""){
                        System.out.println(myFileName);
                        //重命名上传后的文件名
                        String fileName = userid + "." +prefix;
                        //定义上传路径,格式为 upload/base/hello.jpg
                        String path = request.getServletContext().getRealPath("/")+folder+"/"+userid;
                        File localFile = new File(path, fileName);
                        if (!localFile.exists()){
                            localFile.mkdirs();
                        }
                        try {
                            file.transferTo(localFile);
                            file_url = folder + "/" + userid + "/" +fileName;
                        }catch (IOException e){
                            e.printStackTrace();
                        }

                    }

                }
            }
        }
        return file_url;
    }
}
