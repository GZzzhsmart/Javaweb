/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[10];
	int i,num,n=0;
	printf("待处理数据如下：\n");
	printf("请输入10个整数");
	
	for(i=0;i<10;i++)//打印输入的数据
	{
		
		scanf("%d",&a[i]);
		
		if(i%5==0)
		{
			printf("\n");	
		}
		printf("%d\t",a[i]);
	}
	printf("\n请输入你要查找的数据");
	scanf("%d",&num);
	for(i=0;i<10;i++)
	{
		
		if(num==a[i])
		{
			n++;//记住个数
			printf("在数组中第%d个位置找到了%d\n",i+1,num);
		}
		
	}
	if(i==10)
			printf("该数据中没有该数");
			printf("\n");
	printf("数据中%d有%d个",num,n);
}