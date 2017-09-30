#include "stdio.h"

void main()
{
	int a,b;
	char ch;
	do
	{
		printf("请输入您要计算的两个数：");
		scanf("%d,%d",&a,&b);

		printf("%d+%d=%d\n",a,b,a+b);

		printf("还要继续吗？（按“n”退出，其他键继续）\n");

		fflush(stdin);//清除键盘缓存（如果不加或出现什么情况？）

		scanf("%c",&ch); //接收用户的选择
	}while(ch!='n'); //按"n"退出
}
