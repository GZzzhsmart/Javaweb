/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  
 int i=1900;
 printf("1900~2016年闰年年份有\n");
	while(i<=2016){
		if(i%4==0&&i%100!=0||i%400==0){
			printf("%d\t",i);
		}
		i++;
	}
	
	
		
 }
  