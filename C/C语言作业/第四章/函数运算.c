/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int x,y;
   printf("«Î ‰»Îxµƒ÷µ");
   scanf("%d,%d",&x,&y);
   if(x<1) {  y=x; }  
   else if(x>=1&&x<10) { y=2*x-1; }  
   else if(x>=10) { y=3*x-11; } 
  printf("%d,%d",x,y); 
}