/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    //编写程序，让用户输入20个整数，统计这20个数中有多少个奇数、多少个偶数并输出。
    int a[20];
    int i,n=0,c=0;
    printf("请输入20个整数\n");
    for(i=0;i<20;i++)
    {	
    	scanf("%d",&a[i]);
    	 	     	
    }	
	for(i=0;i<20;i++)
	{	
		
		if(i%5==0)
	    {
	    	printf("\n");
	    }
	    printf("%d ",a[i]);
	    if(a[i]%2==0)
	    {
	    	n++;	
	    }else
	    {
	    	c++;
	    }
	   
	} 
	 printf("\n数据中偶数一共有%d个,奇数有%d个\n",n,c); 
}