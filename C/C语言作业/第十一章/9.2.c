/* Note:Your choice is C IDE */
#include "stdio.h"
#define qiuyu(a,b) p=a%b;
void main()
{
	//输入两个数，求余数
	int a,b,p;
	printf("请输入两个数");
	scanf("%d,%d",&a,&b);
	qiuyu(a,b);
	printf("%d与%d的余数为%d",a,b,p);
}