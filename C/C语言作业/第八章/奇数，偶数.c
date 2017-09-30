/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[5],i,n=0,p=0;
	printf("请输入5个数");
	for(i=0;i<5;i++)
	{
		scanf("%d",&a[i]);
	}
	
	for(i=0;i<5;i++)
	{
		if(i%2==0)	
			printf("\n");
		printf("%d\t",a[i]); 
		if(a[i]%2==0)
		{
			n++;	
		}else
		{
			p++;	
		}
		
	}
	printf("\n该数值中偶数有%d个，奇数有%d个",n,p);
	   
}