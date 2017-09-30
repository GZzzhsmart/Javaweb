package T12lianxi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class DataOutputStreamDemo {
	public static void main(String[] args) {
		try{
			File file = new File("d:\\File\\test.dbf");
			if(!file.exists()){
				file.createNewFile();
			}
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
			int a=10;
			short sh=20;
			float f= 111.115f;
			double d=8.888;
			String str = "文本内容";
			dos.writeInt(a);
			dos.writeShort(sh);
			dos.writeFloat(f);
			dos.writeDouble(d);
			dos.writeUTF(str);
			dos.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
