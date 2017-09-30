/* Note:Your choice is C IDE */
#include "stdio.h"
int jiechen(int n);//声明函数
void main()
{
	int n,s;
	printf("请输入一个整数");
	scanf("%d",&n);
	s=jiechen(n);
	printf("%d的阶层=%d",n,s);	    
}
int jiechen(int n)//定义函数
{
	if(n==0||n==1)
		return 1;
	return jiechen(n-1)*n;//jiechen用来自己调用自己 		
	
}