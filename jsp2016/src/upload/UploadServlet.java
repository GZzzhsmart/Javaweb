package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        // 保存文件的路径，必须是tomcat里面当前项目下的子路径 
        String filePath = getServletContext().getRealPath("/") + "upload";  
        //输出存放上传文件所到的路径  
        System.out.println(filePath);
        File uploadPath = new File(filePath);  
        // 检查文件夹是否存在 不存在 创建一个  
        if (!uploadPath.exists()) {  
        	//创建文件夹
            uploadPath.mkdir();  
        }  
        // 文件最大容量 3M  
        int fileMaxSize = 3 * 1024 * 1024;  
        // 存放文件描述  
        @SuppressWarnings("unused")  
        String[] fileDiscription = { null, null };  
        // 文件名  
        String fileName = null;  
        // 上传文件数  
        int fileCount = 0;  
        // 重命名策略  
        FileRenameUtil rfrp = new FileRenameUtil();  
        // 上传文件  
        MultipartRequest mulit = new MultipartRequest(request, filePath, fileMaxSize, "UTF-8", rfrp);//取得上传文件  
        //获取普通控件的值，不能使用request对象
        String userName = mulit.getParameter("userName");  
        System.out.println(userName);  
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        //取得上传的所有文件(相当于标识)
        Enumeration filesname = mulit.getFileNames();   
        while (filesname.hasMoreElements()) {  
        	//控件名称
            String name = (String) filesname.nextElement();//标识  
            System.out.println(name);  
            fileName = mulit.getFilesystemName(name); 
            //取得文件名  
            String contentType = mulit.getContentType(name);
            //工具标识取得的文件类型  
            if (fileName != null) {  
                fileCount++;  
            }  
            System.out.println("文件名：" + fileName);  
            System.out.println("文件类型： " + contentType);   
            //在页面显示上传成功的图片
            out.println("<img src='upload/"+fileName+"' />");
        }  
        System.out.println("共上传" + fileCount + "个文件！");   
        out.close();
        
	}

}
