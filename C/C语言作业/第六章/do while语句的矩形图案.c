/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a=1,b;
  	do{
  		b=1;
		do{
			printf("*");
			b++;
		}while(b<=5); //终止循环，受a限制	
		a++;
		printf("\n");  	  	
	}while(a<=5);
}