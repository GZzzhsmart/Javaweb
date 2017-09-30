/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,b;
   printf("请输入两个数值（中间用逗号隔开）");
   scanf("%d,%d",&a,&b);
   printf("a=%d,b=%d\n",a,b);
   printf("a=%d,b=%d",b,a); 
}