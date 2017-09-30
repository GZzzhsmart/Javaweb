/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a=1,b;
  while(a<=5){
  		b=1;
  	while(b<=5){
  		printf("*");
  		b++;
  	} //终止循环，受a限制	
  	a++;
  	printf("\n");  	  	
  }
    
}