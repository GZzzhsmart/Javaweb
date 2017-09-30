/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[10];
	int n=0,i,num;
	printf("原始数据如下：\n");
	printf("请输入10个整数");
	for(i=0;i<10;i++)
	{
		scanf("%d",&a[i]);
		if(i%5==0)
			printf("\n");
		printf("%d\t ",a[i]);
	}
	printf("\n");
	printf("请输入要查找的数据");
	scanf("%d",&num);
	for(i=0;i<10;i++)
	{
		if(num==a[i])
		{
			printf("在数据中的第%d个位置找到了%d",i+1,num);	
			n++;
		}	
		
	}
	if(i==10)
		printf("数组中没有该数据");
	printf("\n");
	printf("数据中%d有%d个",num,n);
	    
}