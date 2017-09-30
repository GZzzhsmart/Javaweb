/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //n的阶乘,如：10!=10*9*8*....*2*1 
   int sum=1,i,n,j=1;
   printf("请输入所要计算的阶层数值");
   scanf("%d",&n);
   for(i=1;i<=n;i++){
   		sum*=i;
   		
   	
   }
   printf("%d",sum);
}