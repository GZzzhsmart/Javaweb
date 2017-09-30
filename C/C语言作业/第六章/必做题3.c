/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int a,b,i,t,p;
   printf("请输入两个整数");
   scanf("%d,%d",&a,&b);
   if(a<b){
   		t=a;
   		a=b;
   		b=t;   		   	
   }for(i=1;i<=a;i++){
   		if(a%i==0 && b%i==0){
   			p=i;  			
   		}
   }
   printf("%d",p); 
}