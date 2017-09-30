/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
   n=1;
   sum=0;
   printf("*************************◎***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX公司2008年年度收入统计系统              *\n"); 
   printf("*                                                    *\n");
   printf("*************************◎***************************\n");
   do{
   		printf("\t\t请输入第%d个月的月收入",n);
   		scanf("%d",&a);
   		n++;
   		sum+=a;
   	
   	
   }while(n<=12);
   printf("\t\tXXX公司2008年年度总收入为：%0.3f",sum);
}