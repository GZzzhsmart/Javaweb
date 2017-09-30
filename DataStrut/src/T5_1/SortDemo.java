package T5_1;
//排序{A,a,b,f,m,k}排序后的结果为{a,A,b,f,k,m}
public class SortDemo {

	private char[] data={'A','a','b','f','m','k'};
	public void sort(){
		for(int i=data.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(data[i]>data[j+1]){
					if(data[j]-data[j+1]!=32){
						char n = data[j];
						data[j]=data[j+1];
						data[j+1]=n;
					}else {
						if(data[j+1]-data[j]==32){
							char n = data[j];
							data[j]=data[j+1];
							data[j+1]=n;
						}
					}
				}
			}
		}
		for(int i=0;i<data.length;i++){
			System.out.println(data[i]+"\t ");
		}
	}
	
	public static void main(String[] args) {
		new SortDemo().sort();
	}
}
