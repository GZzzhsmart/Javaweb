/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int ge,shi,qian,wan;
   int X;
   printf("请输入一个五位数的数值");
   scanf("%d",&X);
   wan=X/10000%10;
   qian=X/1000%10;
   shi=X/10%10;
   ge=X/1%10;
   if(ge==wan&&shi==qian){printf("该数是回文数");}
    else{printf("该数不是回文数");}
    if(ge==shi==qian==wan){printf("该数是回文数");}
    
    
}