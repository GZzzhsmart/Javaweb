/* Note:Your choice is C IDE */
#include "stdio.h"
void fenshu(); 
void main()
{
	fenshu();	    
}
void fenshu()
{
	long n;
  int e,f,g,h;
  printf("请输入一个4位数的数值");
  scanf("%ld",&n);
  e=n/1000%10;
  f=n/100%10;
  g=n/10%10;
  h=n/1%10;
  printf("%d %d %d %d",e,f,g,h);	
}
