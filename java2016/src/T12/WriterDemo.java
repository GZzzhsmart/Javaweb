package T12;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class WriterDemo {
	public static void main(String[] args) {
		try{
			File file = new File("d:\\File\\write.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			BufferedWriter ab = new BufferedWriter(new FileWriter(file));
			Scanner input = new Scanner(System.in);
			String content=input.next();
			ab.write(content);
			//刷新缓存
			ab.flush();
			ab.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
