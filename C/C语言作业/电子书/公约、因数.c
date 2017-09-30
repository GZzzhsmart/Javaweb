/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int x,y;
   int m,i,a=1;//a为公约数，m为最大公倍数
   printf("请输入两个数值");
   scanf("%d,%d",&x,&y);
   m=x;
   if(x<y){
   		x=y;
   		y=m;  	
   }for(i=1;i<=y;i++){
   	if(x%i==0&&y%i==0)
   		a=i; 	
   }
   printf("两数的最大公因数是：%d\n",a);
   		m=(x*y)/a;
   printf("两数的最大公倍数是：%d",m);
   		
}