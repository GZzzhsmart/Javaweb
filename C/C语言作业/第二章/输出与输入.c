/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   float a,b,c,s;
   printf("请输入数字(用逗号隔开)");
   scanf("%f,%f,%f,%f",&a,&b,&c,&s);
   s=(a+b)*c/2;
   printf("a=%f,b=%f,c=%f,s=%0.2f\n",a,b,c,s);
   
}