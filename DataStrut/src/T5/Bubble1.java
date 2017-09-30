package T5;

public class Bubble1 {

	public static void main(String[] args) {
		Bubble1 bs = new Bubble1();
		String[] s = new String[]{"e","d","c","b","a"};
		bs.bubble1(s);
	}
	public void bubble1(String[] a){
		String t = null;
		int loop = 1;
		for (int i = 0; i < a.length-1; i++) {
			for (int j = i+1; j < a.length-1; j++) {
				if(a[i].compareTo(a[j])>0){
					t = a[i];
					a[i]=a[j];
					a[j]=t;
				}
				System.out.println("╣з"+loop+"лк");
				loop++;
				for (int k = 0; k < a.length; k++) {
					System.out.println(a[k]+" ");
				}
				System.out.println("");
			}
			System.out.println("----------------------");
		}
	}
}
