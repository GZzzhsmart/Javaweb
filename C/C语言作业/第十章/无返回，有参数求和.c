/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数只能是void，不能是int、float、double、等其他数据类型，因为它没有返回值
void qiuhe(int a,int b);  
void main()
{
	//定义一个有参数，无返回值的函数，该函数可以求用户输入的任意两个数的和。
/*
	定义一个有参数，无返回值的函数注意事项如下：
	1.定义函数时不能是数据类型，
	2.需要有参数
	3.不需要有return语句
	4.输入输出打印结果皆在主函数中，自定义函数只需要定义主函数中所用的变量，和一条打印结果的语句即可
	5.打印语句必须要在自定义的函数中否则会计算不出结果	
*/
	int a,b,s=0;
	printf("请输入您要求和的两个整数");
	scanf("%d,%d",&a,&b);
	qiuhe(a,b);	
	
	    
}
//定义函数只能是void，不能是int、float、double、等其他数据类型，因为它没有返回值
void qiuhe(int a,int b)
{
	int s=a+b;
	printf("%d+%d=%d",a,b,s);//打印过程和结果，若将它放入主函数，结果只会是0	
}