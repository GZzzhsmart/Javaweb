/* Note:Your choice is C IDE */
#include<stdio.h>
#include<math.h>
void main()
{
 int m,i,k;
 printf("请输入一个整数：");
 scanf("%d",&m);
 k=(int)sqrt(m);
	 for(i=2;i<=k;i++)
	 if(m%i==0)
	 break;
	 if(i>k)
	 printf("%d 是素数。\n",m);
	 else
	 printf("%d 不是素数。\n",m);
}