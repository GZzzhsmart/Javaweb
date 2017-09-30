/* Note:Your choice is C IDE */
#include "stdio.h"
//声明所有函数
double jia(double a,double b);
double jian(double a,double b);
double chen(double a,double b);
int chu(int a,int b);
void main()
{	
	double a,b,p=0;
	printf("请输入两个整数"); 
	scanf("%lf,%lf",&a,&b);
	printf("两个数的和的值如下：\n"); 
	p=jia(a,b);
	printf("%0.2lf+%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("两个数的差的值如下：\n"); 
	p=jian(a,b);
	printf("%0.2lf-%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("两个数的乘的值如下：\n"); 
	p=chen(a,b);
	printf("%0.2lf*%0.2lf=%0.2lf",a,b,p);
	printf("\n");
	
	printf("两个数的除的值如下：\n");
	p=chu(a,b); 
	printf("%0.2lf/%0.2lf=%0.2lf",a,b,p);
	printf("\n");
}
double jia(double a,double b)
{
	 	
	return a+b;	
	
}
double jian(double a,double b)
{

	return a-b;
		
}
double chen(double a,double b)
{
	
	return a*b;	
	
}
int chu(int a,int b)
{
	
	return a/b;	
	
}