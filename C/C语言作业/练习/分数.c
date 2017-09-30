/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   //·ÖÊýÔËËã
   //2/1+3/2+5/3+7/5....
   int i;
   double a,b,a1,a2,b1,b2,sum=0;
   a=2;
   b=1;
   a1=3;
   b1=2;
   sum=a/b+a1/b1;
   for(i=2;i<20;i++){
   		a=a+a1;
   		b=b+b1;
   		sum+=a/b;
   		printf("%0.0lf/%0.0lf+",a,b);
   		a2=a;
   		a=a1;
   		a1=a2;
   		b2=b;
   		b=b1;
   		b1=b2;
   		   	
   } 
   printf("=%lf",sum);
}