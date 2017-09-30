/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,b,f;
   printf("请输入两个整数（用逗号隔开）");
   scanf("%d,%d",&a,&b);
   printf("交换前：a=%d,b=%d\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("交换后：a=%d,b=%d\n",a,b); 
}