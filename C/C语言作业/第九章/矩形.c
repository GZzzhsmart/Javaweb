/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[5][5];
	int n,t,i,j;
	printf("请输入行数,和列数");
	scanf("%d,%d",&n,&t);
	for(i=0;i<n;i++)//控制行数
	{
		
		for(j=0;j<t;j++)//控制列数
		{
			printf("*\t");//打印图案		
		}
		
		printf("\n\n");
	}    
}