/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   char a,f;
   char b;
   printf("请输入一个整数和一个字符（用逗号隔开）");
   scanf("%c,%c",&a,&b);
   printf("交换前：a=%c,b=%c\n",a,b); 
   f=a;
   a=b;
   b=f;
   
   printf("交换后：a=%c,b=%c\n",a,b);   
}