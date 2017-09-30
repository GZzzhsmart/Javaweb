package T5;

import java.util.Arrays;
/**
 * 
1，堆排序也是选择排序的一种，根据堆的特性，每次把最大或最小值（本次以最大值为例）拿出来，按序排列；
2，堆排序是对普通选择排序的一种优化：如果是一个稳定堆，每次在选择最大值时，只用沿着二叉树其中一个分叉去交换即可，
其他分叉符合堆得特性（因是排好的稳定堆），可以看作是稳定的，不用重排交换，省去了绝大多数的比较交换步骤，
数组的数越多，分支越多，该算法的优势就越明显；

3，第一步，将数组初始化为稳定堆，稳定堆的特性：二叉树之父节点总比其左右孩子节点大！初始化稳定堆有很多方法，
可以从堆顶向堆底方向初始化，也可以从堆底向堆顶方向排列初始化，也可以通过小三角递归调等完成初始化，
本例为理解方便，选用从堆底向堆顶方向初始化，即，每次从小三角里找到最大值放在父节点，
从最后一个小三角向前循环，第一遍，找到所有数的最大值，第二遍循环找到次最大值放在第二层节点上，
依次类推，完成稳定堆得初始化；

4，初始化完稳定堆之后，将选出的最大值与最后一个数字交换放在数组的最后固定下来（以后循环不再用到此数字），
此时除了顶部三角不稳定，下面都是稳定的，根据稳定堆得特性（父节点总是大于其左右孩子节点），从顶部往底部寻找
交换，只沿着变动的那个分叉交换下去（只用单线一次循环即可），其他分叉不用动，交换完毕后，次最大数又被移到
顶部，此时的堆仍然是一个稳定堆，再将顶部的最大值交换的数组的后面固定下来，重复这个步骤，依次类推，即可完成；
排序趟数：
1，初始化堆所用趟数：不确定，最大趟数是二叉树的层数，最小一趟

2，初始化堆后所用趟数：length-2次

排序原理：

稳定堆特性，二叉树排序，具体见上述排序思想
 * */
public class HeapSort {
	int a[];
	public HeapSort() {
		a = new int[]{8,19,2,3,100,99,1000,888,-1,0};
	}
	public HeapSort(int a[]) {
		this.a = a;
	}
	//堆排序
	public void heapSort(int[] array){  
        int length=array.length;  
        initHeap(array, length);//初始化稳定堆  
//        System.out.println("初始化堆后：" + Arrays.toString(array));  
        switchData(array,0,length-1);//交换第一个元素和本轮最后一个元素  
        //二叉树排序  
        for (int length2 = length - 1; length2 > 1 ; length2--) {//循环length - 2次  
            int index=0;  
            while(2 * index + 1 < length2){//只要有左孩子节点就可能产生交换，进入循环  
                if (2 * index + 2 < length2) {//左右孩子都有  
                    int max = index; //默认是父节点的下标 
                    if (array[max] < array[2 * index + 1]) {  
                        max = 2 * index + 1;  //返回左孩子的下标
                    }  
                    if (array[max] < array[2 * index + 2]) {  
                        max = 2 * index + 2; //返回右孩子的下标 
                    }  
                    if (max != index) {  
                        switchData(array, index, max);  
                        index = max;  
                    }else {  
                        break;//max==index，表示节点最大，下面的堆都是稳定的，不用继续循环  
                    }  
                      
                }  
                if (2 * index + 1 < length2 && 2 * index + 2 >= length2) {//只有左孩子，没有右孩子  
                    if (array[index] < array[2 * index + 1]) {  
                        switchData(array, index, 2 * index + 1);  
                    }else {  
                        break;//2 * index + 1==index，表示节点最大，下面的堆都是稳定的，不用继续循环  
                    }  
                }  
            }  
//            print();
            switchData(array, 0, length2 - 1);//交换第一个元素和本轮最后一个元素  
//            print();
        }  
    }
	//初始化堆
	public void initHeap(int[] array,int length){  
        int high=length-1; //最大下标 
        boolean isChange=false;  
        //k的初始值就是最大的一个非终端节点
        for(int k=(high-1)/2;k >= 0;k--){  
            //找到最后一个父节点  
            int left=2*k+1;  	//左孩子的下标
            int right=left+1;  //右孩子的下标
            //判断是否有节点  
            if(left<=high){  
                int max=left; //默认值 
                if(right<=high){  
                    if(array[left]<array[right]){  
                        max=right;  //返回左孩子或者右孩子中最大值的下标
                    }  
                }  
                //将最大值跟父节点交换  
                if(array[max] > array[k]){  
                    isChange=true;  
                    switchData(array,max,k);  
                }  
            }  
        }  
        if(isChange){//如果一次就能完成稳定堆的初始化，则不再需要递归调用，以达到优化算法的目的  
            initHeap(array,length);   
//            System.out.println("递归："+Arrays.toString(array));  
        }  
	}
	//交换数组中两个数的方法，因为要多次用到，封装成一个方法；  
    public static void switchData(int[] array,int index1 ,int index2){  
        array[index1] ^= array[index2];  
        array[index2] ^= array[index1];  
        array[index1] ^= array[index2];  
    }  
    public void print(){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		HeapSort sort = new HeapSort();
		System.out.println("排序之前：");
		sort.print();
		System.out.println("========================");
		sort.initHeap(sort.a, sort.a.length);
		sort.heapSort(sort.a);
		sort.print();
	}
}
