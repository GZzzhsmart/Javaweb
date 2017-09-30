/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//对角线的和
	int  a[3][3]={
			{1,2,3},
			{4,7,9},
			{8,0,9}
		};
	int i,j,sum=0;
	//用来输出你规定好的数组
	printf("数据如下：\n");
	for(i=0;i<3;i++)
	{	
		printf("\n");
		for(j=0;j<3;j++)
		{
			printf("%d\t",a[i][j]);	
		}
	} 
	//求对角线上数字之和
	/*
		 (i,j)
		1(0,0)  	2(0,1)  	3(0,2)
		
		4(1,0)  	7(1,1)  	9(1,2)
		
		8(2,0)  	0(2,1)  	9(2,2)
	*/
	for(i=0;i<3;i++)//控制行
	{
		for(j=0;j<3;j++)//控制列
		{
			if(i==j||i+j==2)
				sum+=a[i][j];	
			
		}		
		
	}
	printf("\n");
	printf("数组中的对角线和为%d",sum);
	
}