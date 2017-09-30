/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[][4]={
		
			{1,2,3,4},
			{5,7,9,10},
			{7,9,12,15},
			{15,34,47,904}
	
		};
	int i,j,t=0,max,min,t2=0;
	printf("待求数据如下：\n");
	
	for(i=0;i<4;i++)
	{
		for(j=0;j<4;j++)
		
			printf("%d\t",a[i][j]);
			printf("\n");	
	
	} 
	for(i=0;i<4;i++)//求行的最大值
	{
		t=0;
		max=a[i][0];
		
		for(j=0;j<4;j++)
		{
			if(max<a[i][j])
			{
				max=a[i][j];
				t=j;	
			}	
		}	
		t2=0;
		min=a[i][0];
		for(j=0;j<4;j++)//求列的最小值
		{
				
			if(min>a[i][j])
			{
				min=a[i][j];
				t2=j;	
				
			}	
			
		}
		if(i==t2)
		{
    		printf("第%d行的第%d列的%d是鞍点",t2+1,t+1,a[t2][t]);	
    	}	
	
		
	}
}