package T2;
import java.util.*;

public class test {

	public static void main(String[] args) {
		List plist = new ArrayList();
		plist.add("A");
		plist.add("B");
		for(int i=0;i<plist.size();i++){
			String str = plist.get(i).toString();
			System.out.println(str);
		}
	}
}
