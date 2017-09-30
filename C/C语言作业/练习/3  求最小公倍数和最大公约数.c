/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  /*
  	3、输入两个数a、b，求最大公约数.(最大公约数：能被a、b整除的最大整数)
	 
	  输入两个数a、b，求最大公约数,(最大公约数：能被a、b整除的最大整数) 
	*/ 
 
  	int a,b,i,t,p;
  	printf("输入两个数字");
  	scanf("%d,%d",&a,&b);
  	if(a<b){
  		t=a;
  		a=b;
  		b=t;		
  	}
  	for(i=1;i<=a;i++){
  		if(a%i==0 && b%i==0)
  			p=i;		
  	}
  	printf("%d",p);
  	
}

