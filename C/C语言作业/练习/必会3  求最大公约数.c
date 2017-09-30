/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 
	/* 
	  输入两个数a、b，求最大公约数,(最大公约数：能被a、b整除的最大整数) 
	*/
	int a,b,n,i,p=0,t;
	printf("请输入两个数字");
	scanf("%d,%d",&a,&b);
	if(a<b){
		t=b;
		b=a;
		a=t;	
		
	}
	for(i=1;i<a;i++){
		if(a%i==0 && b%i==0){
			p=i;
			
		}			
	}
	printf("%d",p);	
}