/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
   n=0;
   sum=0;
   printf("*************************◎***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX公司2008年年度收入统计系统              *\n"); 
   printf("*                                                    *\n");
   printf("*************************◎***************************\n");
   for(n=1;n<=12;n++){
   		printf("\t\t请输入第%d个月的月收入",n);
   		scanf("%d",&a);
   		sum+=a;
   	
   }
   printf("\t\tXXX公司2008年年度收入为：%0.3f",sum);
}