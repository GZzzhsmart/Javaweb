/* Note:Your choice is C IDE */
#include "stdio.h"
int qiuhe(int n);//声明函数
void main()
{
	//递归求和方法
	int n,s;
	printf("请输入一个整数");
	scanf("%d",&n);
	s=qiuhe(n);
	printf("1到%d的和=%d",n,s);	    
}
int qiuhe(int n)//定义函数
{
	if(n==0||n==1)
		return 1;
	return qiuhe(n-1)+n;//jiechen用来自己调用自己 		
	
}