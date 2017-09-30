package com.gs.common;


import javax.servlet.http.HttpServletRequest;
import java.io.File;

public class PathUtils {
    /**
     * 上传文件方法
     * */
    public static String uploadDir(HttpServletRequest request){
        String rootDir = request.getServletContext().getRealPath("/");
        File file = new File(rootDir,"uploads");
        if(!file.exists()){
            file.mkdir();
        }
        return file.getAbsolutePath();
    }
}
