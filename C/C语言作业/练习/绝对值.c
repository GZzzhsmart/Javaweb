/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a,b;
  printf("请输入一个数");
  scanf("%d,%d",&a,&b);
  if(a>=0){ 	
  			b=a;
  }else{
  			b=0-a;
  } 
  printf("a=%d,该数的绝对值b=%d",a,b);  
}