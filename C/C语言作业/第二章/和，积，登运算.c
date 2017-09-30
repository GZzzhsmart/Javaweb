/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   float a,b;
   printf("请输入两个数字（并用逗号隔开）");
   scanf("%f,%f",&a,&b);
  
   printf("和:%0.2f+%0.2f=%0.2f\n",a,b,a+b); 
   printf("差:%0.2f-%0.2f=%0.2f\n",a,b,a-b); 
   printf("商:%0.2f/%0.2f=%0.2f\n",a,b,a/b); 
   printf("积:%0.2f+%0.2f=%0.2f\n",a,b,a*b); 

}