package T5;
//ц╟ещеепР
public class bubbleSort1 {

	public static void bubbleSort(int[] a) {
		int t=0;
		int loop=1;
		for (int i = 0; i < a.length-1; i++) {
			for(int j=i+1;j<a.length-1;j++){
				if(a[i]>a[j]){
					t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
				System.out.println("╣з"+loop+"лк");
				loop++;
				for(int k=0;k<a.length;k++){
					System.out.println(a[k]+" ");
				}
				System.out.println();
			}
			System.out.println("---------------");
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5,4,3,2,1};
		bubbleSort(a);
	}
}
