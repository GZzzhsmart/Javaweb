/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数
#define N 10
char zifu();
void main()
{
//写一个函数达成字符的倒序存放  
	zifu();  
}
//定义函数
char zifu()
{
	char c[N],t;
	int i;
	printf("请输入一串字符");
	for(i=0;i<N;i++)
	{
		scanf("%c",&c[i]);
		printf("%c\t",c[i]);;
	}
	for(i=0;i<N/2;i++)
	{
		t=c[i];
		c[i]=c[(N-1)-i];
		c[(N-1)-i]=t;	
	}
	printf("\n");
	printf("交换后的字符如下：\n"); 
	for(i=0;i<N;i++)
	{
		
		printf("%c\t",c[i]);;
	}
}