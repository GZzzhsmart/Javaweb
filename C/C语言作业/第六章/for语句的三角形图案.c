/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //编写程序，输出一个矩形（要求用嵌套for循环实现）
   int a,b;
   for(a=1;a<=10;a++){
   		for(b=1;b<=a;b++){
   			printf("*\t");
   			
   		}
   		printf("\n");
   }
}