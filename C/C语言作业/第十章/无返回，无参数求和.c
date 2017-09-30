/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数只能是void不能是int、float、double、等其他数据类型
void qiuhe();
void main()
{
//定义一个无参数无返回值的函数，该函数可以求用户输入的任意两个数的和。
/*
	定义一个无参数无返回值的函数注意事项如下：
	1.定义函数时不能是数据类型，
	2.不需要有参数
	3.不需要return语句
	4.输入输出打印结果皆在自定义的函数中，主函数只需要直接调用该函数即可
	5.主函数中不能有别的语句，否则会报错，导致程序无法运行	
*/
	qiuhe();    
}
//定义函数，定义的只能是void不能是int、float、double、等其他数据类型
void qiuhe()//
{
	int a,b,s=0;
		printf("请输入您要求和的两个整数");
		scanf("%d,%d",&a,&b);
		s=a+b;//进行求和运算
		printf("%d+%d=%d",a,b,s);//输出过程和结果
}