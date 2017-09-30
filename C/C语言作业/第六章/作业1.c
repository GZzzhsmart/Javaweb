/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //用户不断输入字符，输入‘A’（区分大小写）时，退出程序。
  char ch;
  printf("请输入字符");
  do{ 			
  			scanf("%c",&ch);
  		if(ch=='a'||ch=='A'){
  			break;
  		}
  
  	}while(ch>2);	 
}