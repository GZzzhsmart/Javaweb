/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   /*
   		1、编写程序，输出1~100中非6的倍数的数字（要求用while循环实现，每行输出8个）
		2、编写程序，统计用户输入的字符数，按回车键结束。
		3、编写程序，输出一个矩形（要求用嵌套for循环实现）


   */
   int i,n;
   for(i=1;i<=100;i++){
   		if(i%6==0)
   			continue;
    printf("%d\t",i);
    	n++;
    	if(n%8==0)
    	printf("\n");	
   }
   	
}