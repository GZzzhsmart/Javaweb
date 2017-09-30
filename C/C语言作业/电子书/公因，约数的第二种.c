/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int m,n;//m,n为输入的数值
   int a,b,i;//a为最大公约数，b为最小公因数，i为变量
   printf("请输入两个数值");
   scanf("%d,%d",&m,&n);
   if(m<n){
   		a=m;
   		m=n;
   		n=a;   	 	
   	}for(i=1;i<=n;i++){
   	if(m%i==0&&n%i==0)
   		a=i;
   	}
   printf("最小公因数是：%d\n",a);
   b=(m*n)/a;
   printf("最小公倍数是：%d",b); 
}