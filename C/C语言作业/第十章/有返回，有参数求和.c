/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数不能是void，只能是int、float、double、等其他数据类型，因为它有返回值，返回值一定是数据类型，不然无法接收
int qiuhe(int a,int b);
void main()
{
	//定义一个有参数，有返回值的函数，该函数可以求用户输入的任意两个数的和。
/*
	定义一个有参数，有返回值的函数注意事项如下：
	1.定义函数时一定是数据类型，
	2.需要有参数
	3.必需要有return语句
	4.输入输出打印结果皆在主函数中，自定义函数只需要写一条return语句即可
	5.若在自定义的函数中加入其它语句，皆会报错，导致程序无法运行	
*/
	int a,b,s=0;
	printf("请输入您要求和的两个整数");
	scanf("%d,%d",&a,&b);
	s=qiuhe(a,b);
	printf("%d+%d=%d",a,b,s); 
}
////定义函数不能是void，只能是int、float、double、等其他数据类型，因为它有返回值，返回值一定是数据类型，不然无法接收
int qiuhe(int a,int b)
{
	return a+b;//必须要有返回语句，才能接收结果
	
}