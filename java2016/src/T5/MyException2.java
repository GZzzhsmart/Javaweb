package T5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MyException2 {

	public void readFile(String filename) throws FileNotFoundException{
		
		
		FileInputStream fis = new FileInputStream(filename);
		
	}
	
	public void readTxtFile(){
		String name="c:\\text.txt";
		try {
			readFile(name);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("文件名不存在");
		}
	}
	
	
	public void readFile2(String filename){
		
		
		try {
			FileInputStream fis = new FileInputStream(filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void readTxtFile2(){
		String name="c:\\text.txt";
		readFile2(name);
	}

}
