package T16sj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.List;

//客户端线程
public class ClinerThread extends Thread{

	InputStream in;
	List list;
	public ClinerThread(InputStream in,List list) {
		this.in=in;
		this.list=list;
	}
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(in));
			while (true){
				
				String str = br.readLine();
				list.add(str);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
