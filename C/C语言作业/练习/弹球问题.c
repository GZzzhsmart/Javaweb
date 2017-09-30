/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a;
   float h=100,sum=100;
   for(a=1;a<=9;a++){
   		sum+=h;
   		h=h/2;
   	
   }
   printf("一共走过了%0.2f(米)\n",sum);
   printf("最后走了%0.3f(米)",h);
}