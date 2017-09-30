/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a;
  a=150;
  printf("150~400能够整除7的数值是\n");
	while(a<=400){
		if(a%7==0)
			printf("%d\t",a);
			
		a++;
		
		}
  
  }