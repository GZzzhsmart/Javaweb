/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int i=0;
  char ch;
  printf("请输入一串字符");
  do{
  	scanf("%c",&ch); 	 
  	if(ch=='\n')
  	break;
  	i++;  	
  }while(1);
  printf("一共%d个字符",i); 
}