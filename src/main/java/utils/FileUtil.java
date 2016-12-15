package utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by lkq on 2016/12/15.
 */
public class FileUtil {
    /**
     * 按照分隔符将地址字符串切割开，然后拼装为File数组
     * @param files
     * @param splitSign
     * @return
     */
    public File[] getFileArrayByString(String files,String splitSign){
        String[] files_parts = files.split(splitSign);
        File[] attachments = new File[files_parts.length];
        for (int i = 0;i<files_parts.length;i++){
            attachments[i] = new File(files_parts[i]);
        }
        return attachments;
    }

    public String getFilePrefix(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf(".")+1);
        return prefix;
    }
}
