/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数
void zdgys();
void zdgbs();
void main()
{	
	//运用函数来求最大公约数最小公倍数	
	zdgys();
	zdgbs(); 
	

}
//定义函数
void zdgys()
{
	int a,b,t,p,i;
	printf("请输入两个数");
	scanf("%d,%d",&a,&b); 
	if(a<b)//确保a>b
	{
		
		t=b;
		b=a;
		a=t;	
		
	}
	for(i=1;i<a;i++)
	{
		if(a%i==0 && b%i==0)
		{
			p=i;	
			
		}	
		
	}
	printf("%d和%d的最大公因数是%d\n",a,b,p);
	
}
void zdgbs()
{
	int a,b,t,p,i;
	zdgys();
	printf("%d和%d的最小公倍数是%d\n",a,b,a*b/p);
	
}