package T5;

public class bubble {

	public static void main(String[] args) {
		bubble b = new bubble();
		for(int i=0;i<args.length;i++){
			System.out.println(arr[i]+" ");
		}
		System.out.println();
		b.bubble();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]+"");
		}
		System.exit(0);
	}
	public void bubble(){
		for (int i = arr.length-1; i >1; i--) {
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					swap(j,j+1);
				}
			}
		}
	}
	public void swap(int one,int two){
		long temp = arr[one];
		arr[one]=arr[two];
		arr[two]=temp;
	}
	static long arr[] = new long[20];
	
	static{
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (long)(Math.random()*100);
		}
	}
	
}
