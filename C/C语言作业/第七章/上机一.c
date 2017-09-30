/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a[10];
  int i;
  printf("请输入要保存的数：\n");
  for(i=0;i<10;i++)
  {
		printf("请输入第%d个数:",i+1);
		scanf("%d",&a[i]); 
				
  }
  printf("你输入的数是：\n");
  for(i=0;i<10;i++){
  	if(i%5==0)
		{
			printf("\n");
		}					
		printf("%d ",a[i]);
		
			
		} 	  	
  printf("\n这些数对吗？\n");
}