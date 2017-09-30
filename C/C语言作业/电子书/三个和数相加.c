/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 float k=1;
 float a1=0,a2=0,a3=0,s=0;
 printf("½á¹ûÎª"); 
 for(k=1;k<=10;k++){
 	a1=a1+1/k;	
 }
  for(k=1;k<=100;k++){
 	a2=a2+k;	
  }
   for(k=1;k<=50;k++){
 	a3=a3+k*k;	
 }
 s=a1+a2+a3;
 printf("a1=%f,a2=%f,a3=%f,s=%0.2f",a1,a2,a3,s);
}