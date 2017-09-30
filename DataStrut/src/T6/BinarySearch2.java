package T6;

public class BinarySearch2 {

	//当找到关键字时输出其位置并返回true，否则返回false
	public boolean bSearch(int[] a,int key,int left,int right){
		int middle;
		//在查找之前先判断一下左右边界
		if(left>right){
			return false;
		}else {
			middle = (right+left)/2;
			//如果要查找数据小于标志位则将右边界减1进行递归
			if(key<a[middle]){
				return bSearch(a, key, left, middle-1);
			}else if(key>a[middle]){
				return bSearch(a, key, middle+1, right);
			}else if(key==a[middle]){
				System.out.println("找到了"+middle);
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinarySearch2 bs = new BinarySearch2();
		int[] a = {1,3,5,6,7,8,9,12,15,16,18,21,23,25,26,27,30};
		bs.bSearch(a,27,0,a.length-1);
	}
}
