package T12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.sun.imageio.spi.RAFImageInputStreamSpi;

public class RandomAccessFileDemo {
	public static void main(String[] args)  {
		File file = new File("D:\\File");
		if(!file.exists()){
			file.mkdir();
		}
		try{
			RandomAccessFile rbf = new RandomAccessFile("d:\\File\\test.txt","rw");
			//写内容
			int a=111;
			float f=1.11f;
			double d=1.222;
			rbf.writeInt(a);
			rbf.writeDouble(d);
			rbf.writeFloat(f);
			
			rbf.close();//关闭文件
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		//读取文件的内容
		try{
			RandomAccessFile raf = new RandomAccessFile("d:\\File\\test.txt","r");
			
			System.out.println("整形的值是："+raf.readInt());
			System.out.println("双精度类型的值是："+raf.readDouble());
			System.out.println("浮点型的值是："+raf.readFloat());
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
