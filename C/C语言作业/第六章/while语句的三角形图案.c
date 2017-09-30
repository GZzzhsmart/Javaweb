/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //编写程序，输出一个矩形（要求用嵌套for循环实现）
   int a=0,b=0;
   
  while(a<=5){
  		b=1;
   		while(b<=a){													 
   			printf("*\t");
   			b++; 			 			
   		}
   		a++;
   		printf("\n");
   }
}