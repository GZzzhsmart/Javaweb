/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int i=1,j=1;
    for(i=1;i<=9;i++)
       for(j=1;j<=i;j++)
       {
       	   printf("%d*%d=%d",j,i,j*i);
       	   if(i!=j)printf("\t");
       	   if(i==j)printf("\n");
       }
    
    	
}