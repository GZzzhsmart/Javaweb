/* Note:Your choice is C IDE */
#include "stdio.h"
int jia(int a,int b);//加
int jian(int a,int b);//减
int cheng(int a,int b);//乘
int chu(int a,int b);//除

void main()
{
    int a,b,c,c1,c2,c3;//c...c3分别代表加、减、乘、除。
    printf("请输入第一个整数：");
    scanf("%d",&a);
    printf("请输入第二个整数：");
    scanf("%d",&b);
    c=jia(a,b);
    c1=jian(a,b);
    c2=cheng(a,b);
    c3=chu(a,b);
    printf("这两个整数加减乘除后的结果分别为%d\t%d\t%d\t%d%",c,c1,c2,c3);
}
int jia(int a,int b)
{	//int a,b;
	return a+b;
}
int jian(int a,int b)
{
	return a-b;
}
int cheng(int a,int b)
{
	return a*b;
}
int chu(int a,int b)
{
	return a/b;
}