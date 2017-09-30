/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a;
  
  do{	
  			printf("请输入一个整数");
  			scanf("%d",&a);
  		if(getchar()=='n')
  			break;
  		if(a%5==0&&a%7==0)
  			printf("该数符合题意\n");  			
  		
  		
  		else{
  			printf("该数不合题意\n");
  		}	 		
  }while(getchar()!='n');
   
}