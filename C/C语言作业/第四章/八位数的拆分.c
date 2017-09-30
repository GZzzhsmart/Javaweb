/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  long n;
  int a,b,c,d,e,f,g,h;
  printf("请输入一个8位数的数值");
  scanf("%ld",&n);
  a=n/10000000; 
  b=n/1000000%10; 
  c=n/100000%10;
  d=n/10000%10;
  e=n/1000%10;
  f=n/100%10;
  g=n/10%10;
  h=n/1%10;
  printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d",a,b,c,d,e,f,g,h);
  
}