/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i=0,n=0;
  do{
  		i++;  	
  	if(i%6==0){
  		continue;
  			
  	}
  		printf("%d\t",i);
  		n++;	
  	if(n%8==0)
  		printf("\n");
  		
  		
  		
  	  	
  }while(i<=100);
 
}