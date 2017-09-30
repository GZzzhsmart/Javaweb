/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //猴子吃桃问题
   int a,sum=1;
   for(a=9;a>0;a--){
   		
   		sum=(sum+1)*2;
   		printf("第%d天摘了%d个桃子\n",a,sum);
   	
   }
   printf("%d",sum);
}