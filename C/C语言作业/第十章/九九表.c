/* Note:Your choice is C IDE */
#include "stdio.h"
#define N 9
//九九乘法表
void jiujiuchenfabiao();
//九九除法表
void jiujiuchufabiao();
//九九加法表
void jiujiujiafabiao();
//九九加法表
void jiujiujianfabiao();
void main()
{
	jiujiuchenfabiao();
	printf("\n\n");
	jiujiuchufabiao();
	printf("\n\n");
	jiujiujiafabiao();
	printf("\n\n");
	jiujiujianfabiao();	
}
//九九乘法表
void jiujiuchenfabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i*j;
			printf("%d*%d=%d\t",j,i,i*j);	
		}
		printf("\n");
		
	}	
}
//九九除法表
void jiujiuchufabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i/j;
			printf("%d/%d=%d\t",j,i,i/j);	
		}
		printf("\n");
		
	}	
}
//九九加法表
void jiujiujiafabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i+j;
			printf("%d+%d=%d\t",j,i,i+j);	
		}
		printf("\n");
		
	}		
}
//九九减法表
void jiujiujianfabiao()
{
	int i,j,sum=1;
	for(i=1;i<=N;i++)
	{	sum=1;
		for(j=1;j<=i;j++)
		{
			sum=i-j;
			printf("%d-%d=%d\t",j,i,i-j);	
		}
		printf("\n");
		
	}		
}