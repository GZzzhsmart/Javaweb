/* Note:Your choice is C IDE */
#include "stdio.h"
double sum=0;//定义全局变量，主函数中不能有变量，否则将会覆盖
//声明函数
void qiuhe(int n);
void main()
{
	//题目要求定义一个无返回，有参数的函数,函数名不能与参数同名
	int n;
	printf("请输入一个你所要求和的最大值");
	scanf("%d",&n);
	qiuhe(n);
	printf("1~%d的和=%lf",n,sum);

}
void qiuhe(int n)
{
	int i;
	for(i=1;i<=n;i++)
	{
		sum+=i;	
	}
}
