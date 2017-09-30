/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,z,x,big;
   printf("请输入三个整数（用空格隔开）");
   scanf("%d,%d,%d",&a,&z,&x);
   big=a>z?a:z;
   big=big>x?big:x;
   printf("%d,%d,%d中最大的一个是：%d\n",a,z,x,big); 
}