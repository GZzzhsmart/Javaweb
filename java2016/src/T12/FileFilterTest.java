package T12;

import java.io.*;

public class FileFilterTest {

    public static void main(String args[]) {
        //用File 对象表示一个目录
        File dir = new File("D://FeigeDownLoad/Java\\T12 src");
        //生成一个名为java的过滤器
        Filter filter = new Filter("java");
        
        System.out.println("list java files in directory " + dir);

        //列出目录dir下，文件后缀名为java的所有文件
        String files[] = dir.list(filter);

        for (int i = 0; i < files.length; i++) {
            //为目录dir 下的文件或目录创建一个File 对象
            File f = new File(dir, files[i]);

            //如果该对象为后缀为java的文件则打印文件名
            if (f.isFile()) {
                System.out.println("file " + f);
            }else {
                System.out.println("sub directory " + f); //如果是目录则打印目录名
            }
        }
    }
}


class Filter implements FilenameFilter {
    String extent;
    public Filter(String extent) {
        this.extent = extent;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith("." + extent); //返回文件的后缀名
    }
}
