/* Note:Your choice is C IDE */
#include "stdio.h"
void sushu();
void jianyan();
void main()
{
	printf("素数如下：\n");
	sushu();
	printf("\n"); 
	jianyan();   
}
//定义函数
void sushu()
{
	int i,j,n=0,num;
	for(i=2;i<100;i++)
	{
		n=0;
		for(j=2;j<i;j++)
		{
			if(i%j==0)
			{
				n=1;
				break;	
				
			}	
			
		}
		if(n==0)
		{
			printf("%d\t",i);	
			
		}
		
		
	}

}
void jianyan()
{
	int i,j,n=0,num;
	printf("\n");
	printf("以上结果可满意？你可以检测哟！\n");
	printf("请输入一个数");
	scanf("%d",&num);
	for(i=2;i<num;i++)
	{
		if(num%i==0)
		{
			n=1;
			break;	
		}
	}
	if(n==0)
	{
		printf("该数是素数");	
	}
	if(n==1)
	{
		printf("该数不是素数");	
	}
		
	
}