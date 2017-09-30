/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i=0,n=0;
  while(i<=100){
  	i++;
  	if(i%6==0){
  		continue;
  	}printf("%d\t",i);
  	n++;	
  	if(n%8==0)
  		printf("\n");
  }  
}