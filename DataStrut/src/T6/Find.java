package T6;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

public class Find {

	Vector v = new Vector();
	
	public void find(){
		String msg = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("dangan.p")));
			while((msg=br.readLine())!=null){
				if(!msg.equals("")){
					String[] str = msg.split("@_@");
					v.add(str);
				}
			}
			this.sort();
			this.bSearch(5);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//√∞≈›≈≈–Ú
	public void sort(){
		Object temp = null;
		for(int i=0;i<v.size()-1;i++){
			for(int j=i+1;j<v.size()-1;j++){
				String[] str1 = (String[])v.get(i);
				String[] str2=(String[])v.get(j);
				int n1 = Integer.parseInt(str1[0]);
				int n2 = Integer.parseInt(str2[0]);
				if(n1>n2){
					temp = v.get(i);
					v.set(i, v.get(j));
					v.set(j, temp);
				}
			}
		}
	}
	//’€∞Î≤È’“
	public boolean bSearch(int key){
		int left = 0;
		int right = v.size()-1;
		int middle;
		while(left<=right){
			middle = (left+right)/2;
			String[] str1 = (String[])v.get(middle);
			int num = Integer.parseInt(str1[0]);
			if(key>num){
				left = middle+1;
			}else if(key<num){
				right = middle-1;
			}else if(key==num){
				System.out.println("–’√˚£∫"+str1[1]+"  µÁª∞£∫"+str1[2]);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Find find = new Find();
		find.find();
		find.bSearch(1);
		find.bSearch(2);
		find.bSearch(3);
		find.bSearch(4);
	}
}
