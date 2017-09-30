/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //计算10以内的两个数和等于10有哪些情况，输出：加数+被加数=10。
  int i,j,sum=0;
  for(i=1;i<10;i++){
  	for(j=1;j<10;j++){	
  		sum=i+j;
  		if(sum==10){
  		printf("%d+%d=%d\n\n",i,j,sum);
}
  	}
  	
  	
  	
  }
  

  
}