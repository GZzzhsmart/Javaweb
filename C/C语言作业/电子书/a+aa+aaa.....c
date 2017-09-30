/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	/*
	例如：a+aa+aaa+aaaa......=p
	左边为t
	
	*/
	int a,n,i=1;
	int p=0;//p为结果，t为变量加式
	int t=0;
	printf("请输入两个数值");
	scanf("%d,%d",&a,&n);
	while(i<=n){
			t=t+a;//这个等式用来计算数值之和：a+aa+aaa......
			p=p+t;//这个等式用来计算最后结果：
			a=a*10;//这个等式用来进行赋值运算：
			i++;
	}
	printf("%d\n",p);
}