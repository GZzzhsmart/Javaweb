package T6;
//线性查找
public class LinearSearch {

	public boolean ISearch(int[] a,int key){
		
		for (int i = 0; i < a.length; i++) {
			if(key==a[i]){
				System.out.println(key+"的位置"+i);
				return true;//返回true
			}
		}
		//如果没有找到就返回false
		return false;
	}
	
	public static void main(String[] args) {
		LinearSearch ls = new LinearSearch();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		ls.ISearch(a,27);
	}
}
