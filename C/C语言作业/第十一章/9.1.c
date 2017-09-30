/* Note:Your choice is C IDE */
#include "stdio.h"
#define p(a,b) t=a,a=b,b=t;
void main()
{
	int t,a,b;
	printf("请输入两个数");
	scanf("%d,%d",&a,&b);
	printf("a=%d,b=%d\n",a,b);
	p(a,b);
	printf("a=%d,b=%d",a,b);
	
	 	    
}