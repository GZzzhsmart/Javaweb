/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i;
  int sum=0;
  for(i=1;i<=100;i++){
  		sum=sum+i;
  		if(sum>500){
  			break;	
  		}
  		
  }
  printf("%d,%d",sum,i);
}