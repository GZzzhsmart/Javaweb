/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	int a,b,c,max;
	printf("请输入三个数");
	scanf("%d,%d,%d,%d",&a,&b,&c,&max);
   if(a>b) 	{ max=a; }
	else	{ max=b;}
	if(c>max) { max=c; }
	printf("a=%d,b=%d,c=%d,最大值max:%d",a,b,c,max);
 
}