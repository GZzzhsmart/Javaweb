/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数
void jiaohuan();
void main()
{
//写一个函数将3x3的数组列行交换
	jiaohuan();//调用函数    
}
//定义函数
void jiaohuan()
{
	int a[3][3];
	int i,j;
	printf("原始数据如下：\n");
	printf("请输入三行三列的数组");
	for(i=0;i<3;i++)
	{
		
		for(j=0;j<3;j++)
		{
			
			scanf("%d",&a[i][j]);
			printf("%d\t",a[i][j]);
		}
		
		printf("\n");
	}
	printf("换过后的数据：\n");
	for(i=0;i<3;i++)
	{
		
		for(j=0;j<3;j++)
		{
			
			printf("%d\t",a[j][i]);
		}
		
		printf("\n");
	}
}