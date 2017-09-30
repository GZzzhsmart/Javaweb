package T2lianxi;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 写程序，对 int arrays[]={10,1,4,2,6,8,3,25}数组排序后输出
 * */
public class Paixu {
    public static void main(String[] args) {
    	int arrays[] = { 10, 1, 4, 2, 6, 8, 3, 25 };
		System.out.println("源数据\t" + Arrays.toString(arrays));
		Arrays.sort(arrays);
		System.out.println("排序后\t" + Arrays.toString(arrays));
    }
 
}
