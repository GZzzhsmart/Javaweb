package T11;

public class J_test {
	public static void main(String[] args) {
		try{
			System.out.print("1");
			if(true){
				System.exit(0);
				
			}
		}catch(RuntimeException e){
			System.out.print("2");
			return;
		}finally{
			System.out.print("4");
		}
		System.out.print("End!");
	}
}
