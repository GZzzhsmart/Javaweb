/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
   int z,x,c,v,b,n,m,f;
   printf("请输入整数（用逗号隔开）");
   scanf("%d,%d,%d,%d,%d,%d,%d,%d",&z,&x,&c,&v,&b,&n,&m);
   printf("交换前：z=%d\n,x=%d\n,c=%d\n,v=%d\n,b=%d\n,n=%d\n,m=%d\n",z,x,c,v,b,n,m); 
   f=z;
   z=x;
   x=c;
   c=v;   
   v=b;
   b=n;
   n=m;   
   m=f;
   
   printf("交换后：z=%d\n,x=%d\n,c=%d\n,v=%d\n,b=%d\n,n=%d\n,m=%d\n",z,x,c,v,b,n,m);     
}