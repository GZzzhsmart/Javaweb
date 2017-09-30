/* Note:Your choice is C IDE */
#include "stdio.h"
/*
   	函数的递归调用
   		1.函数自己调用自己
   		2.函数一定有一个出口；
	
	递归调用是一种堆栈原理：后进先出
*/
int jiechen(int n);
//计算n的阶乘（递归函数）；
int jiechen(int n)
{
	if(n==0||n==1)
		return 1;
	return jiechen(n-1)*n;
}
void main()
{
	int s;
	int n;
	printf("请输入一个正整数：");
	scanf("%d",&n);
	s=jiechen(n);
	printf("%d的阶乘=%d",n,s);
}