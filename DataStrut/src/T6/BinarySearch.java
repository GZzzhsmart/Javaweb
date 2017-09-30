package T6;
//折半查找
public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		bs.bSearch(a,30,0,a.length-1);
	}
	
	public boolean bSearch(int[] a,int key,int left,int right){
		int middle;
		//当左边界小于右边界时就算没有找到，就退出循环
		if(left>right){
			return false;
		}else {
			//每次查找要重新设定标志位
			middle=(right+left)/2;
			//如果所查找的数据大于标志位则在数组右半段再次查找
			if(key<a[middle]){
				return bSearch(a, key, left, middle-1);
			}else if(key>a[middle]){
				return bSearch(a, key, middle+1, right);
			}else if(key==a[middle]){
				System.out.println("找到了"+key+"的位置是"+middle);
				return true;
			}
		}
		return false;
	}
	
}
