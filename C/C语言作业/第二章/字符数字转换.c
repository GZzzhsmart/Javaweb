/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int a;
  char b;
  float c;
  double d;//将数字转换成字符
  printf("请输入一个数字");
  scanf("%d",&a);
  printf("a=%d,a=%c\n",a,a);
  
   
  fflush(stdin); //将字符转换成数字 
  printf("请输入一个字符");
  scanf("%c",&b);
  printf("b=%d,b=%c\n",b,b); 
  a=b;
  printf("a=%d,a=%c",a,a);
}