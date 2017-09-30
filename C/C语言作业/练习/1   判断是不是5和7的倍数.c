/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //1.输入一个数，判断它是否为5和7的倍数，用户可以循环输入数字进行判断，直到输入'n'结束程序
  int a,b;
  do{
	  	printf("请输入一个整数");
	  	scanf("%d",&a);
	  if('n'==(getchar()))
	  	break;
	  if(a%5==0 && a%7==0)
	  	printf("该数符合题意\n");
	  
	  else{
	  	printf("该数不符合题意\n");
	  }
  }while(1);
  	
  
}