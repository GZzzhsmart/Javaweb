/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //5. 用for循环计算sum=1+2+3+4+....,直到sum>500时退出
  int a,i,sum=0;
  for(i=1;i<=100;i++){
  	sum+=i;
  	printf("%d+",i);
  	
  	if(sum>500){  		
  		 printf(">%d",sum);
  		 break;
  	}
  }
 
}