#include<stdio.h>
void main ()
{
    int i=1,sum=0; 

    do
    {
       	sum=sum+i;  
	i++;

    }while(i<=100);  //先执行后判断条件

    printf("1~100的和是：%d\n",sum);
}


