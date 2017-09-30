/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//排序
	int a[10];	
	int i,j,t,k;
	printf("排序前的数据\n");
	printf("请输入10个数字");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
		if(i%5==0)
			printf("\n");-
		printf("%d\t",a[i]);	
		
	}
	//开始排序
	for(i=0;i<10;i++)
	{
		printf("\n");
		printf("i=%d,第%d轮：\n",i,i+1);
		for(j=i+1;j<=9;j++)//重点为i+1后一个数跟前一个数进行交换
		{
			if(a[i]>a[j])
				{	
					t=a[i];
					a[i]=a[j];
					a[j]=t;
				}
			for(k=0;k<10;k++)
			printf("%d\t",a[k]);
			printf("\n");
		}	
		
	}
	//排序完的数
	printf("\n");
	printf("排序完的数\n");
	for(i=0;i<10;i++)
	{	
		if(i%5==0)
			printf("\n");
		printf("%d\t",a[i]);
		
		
	}
	
	
    
}