/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{     int a,i;
	do{
  printf("**********************○*************************\n"); 
  printf("*                                               *\n"); 
  printf("*                                               *\n");
  printf("*  　　　　◎欢迎进入中国银行                   *\n");
  printf("*                                               *\n"); 
  printf("*                                               *\n");
  printf("**********************○*************************\n");
  
  
    
  printf("           请选择您要办理的手续：\n"); 
  printf("                   1.开户\n");  
  printf("                   2.存款\n");  
  printf("                   3.取款\n");
  printf("                   4.查询余额\n"); 
  printf("                   5.转账\n");  
  printf("                   6.退出\n");  
  printf("\t请输入你要办理的业务");
  scanf("%d",&a);
 
  switch(a){	
  				case 1:
  					printf("你选择了开户业务");
  					break;
				case 2:
  					printf("你选择了存款业务");
  					break;
				case 3:
  					printf("你选择了取款业务");
  					break;
				case 4:
  					printf("你选择了查询余额业务");
  					break;
				case 5:
  					printf("你选择了转账业务");
  					break;
				case 6:
  					printf("你选择了退出业务");
  					break;
				default :
  					printf("你输入的有误，请输入1-6之间的数字");
  					
  			}
  			} while(i!=6);
  
  
     
}