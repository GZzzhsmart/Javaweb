/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //2、n的阶乘,如：10!=10*9*8*....*2*1 
  int n,i;
  double sum=1;
  printf("请输入一个数字");
  scanf("%d",&n);
  for(i=1;i<=n;i++){
  	sum*=i;
  	if(i!=n){
 	 printf("%d*",i);	 
  }
  if(i==n){
 	 printf("%d",i);	 
  }  	
  }
  
  printf("=%0.2lf",sum);
}