package upload;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class FileRenameUtil implements FileRenamePolicy {  
	  
    public File rename(File file) {  
        String body = "";  
        String ext = "";  
        Date date = new Date();  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        //取得文件名和后缀分割点 
        int pot = file.getName().lastIndexOf("."); 
        //说明后缀存在 
        if (pot != -1) { 
        	//采用时间的形式命名  
            //body = date.getTime() + "";
            body = sdf.format(date);
            ext = file.getName().substring(pot);//截取后缀名  
        } else {  
            body = (new Date()).getTime() + "";  
            ext = "";  
        }  
        Random rand = new Random();
        int rnd = Math.abs(rand.nextInt(9000))+1000;
        String newName = body +rnd + ext;  
        file = new File(file.getParent(), newName);//对文件进行重命名  
        return file;  
  
    }  
  
}  
