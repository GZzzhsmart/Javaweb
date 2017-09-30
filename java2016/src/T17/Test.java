package T17;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) {
		try{
			Properties prop = new Properties();
			prop.load(new FileReader("./config.properties"));
			
			String test = prop.getProperty("TestA");
			String chat = prop.getProperty("UDPChat");
			Class.forName(test).newInstance();
			Class.forName(chat).newInstance();
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
