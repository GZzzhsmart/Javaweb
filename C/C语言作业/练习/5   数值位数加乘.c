/* Note:Your choice is C IDE */
#include "stdio.h"
#include "math.h"
void main()
{
   int a,b,n,i=0,sum=0,j;
   printf("请输入数值和位数");//a为数值，b为位数
   scanf("%d,%d",&a,&b);
   for(i=1;i<=b;i++){
   			j=0;
   		for(n=0;n<i;n++){
   			j+=a*pow(10,n);   			
   		}
   		sum+=j;
   		if(i!=b){
   			
   		printf("%d+",j);	
   		
   		}if(i==b){
   			
   		printf("%d",j);	
   			
   		}
   } 
   printf("=%d",sum);
}