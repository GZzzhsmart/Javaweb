/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int hang,zhongjian,kongge,xinhao,i,j;
  printf("请输入一个行数");
  scanf("%d",&hang);
  zhongjian=hang/2+1;
  for(i=1;i<=zhongjian;i++)
  {
  		xinhao=i*2-1;
  		kongge=(hang-xinhao)/2;
  		for(j=0;j<kongge;j++)
  		{
  				printf(" ");
  		}
  		for(j=1;j<=xinhao;j++)
  		{
  				printf("*");
  				
  		}
  		printf("\n");
  	}
  	for(i=zhongjian-1;i>0;i--){
  		xinhao=i*2-1;
  		kongge=(hang-xinhao)/2;
  		for(j=0;j<kongge;j++){
  				printf(" ");
  		}for(j=1;j<=xinhao;j++){
  				printf("*");
  				
  		}
  		printf("\n");
  		}
  	
  }
  
