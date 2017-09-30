/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,f;
   char b;
   printf("请输入一个整数和一个字符（用逗号隔开）");
   scanf("%d,%c",&a,&b);
   printf("交换前：a=%d,b=%c\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("交换后：a=%d,b=%c\n",a,b);    
}