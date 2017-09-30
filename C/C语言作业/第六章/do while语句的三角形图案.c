/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	int i=1,j=1;
  	
    do{//外循环控制行
	   	j=1;//外循环每循环一次，内循环的j都必须重新初始化
    	do{//内循环控制列
    		printf("*\t");
    		j++;
    	}while(j<=i);
    	i++;
    	//换行
    	printf("\n");
    	
    }while(i<=5);  
}