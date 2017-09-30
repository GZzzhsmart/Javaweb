/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,n;
   float sum;
  
   printf("*************************◎***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX公司2008年年度收入统计系统              *\n"); 
   printf("*                                                    *\n");
   printf("*************************◎***************************\n");
   n=1;
   sum=0;
   while(n<=12){
   		printf("\t\t请输入第%d个月的收入",n);
   		scanf("%d",&a);
   		n++;
   		sum+=a;
   }
   printf("\t\tXXX公司2008年年度收入为：%0.3f\n",sum);
   
}