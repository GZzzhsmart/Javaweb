/* Note:Your choice is C IDE */
#include "stdio.h"

void main()
{
	float a,b,h,area;
	printf("请依次输入梯形的上底、下底及高：（用逗号分隔）");
	scanf("%f,%f,%f",&a,&b,&h);
	area=(a+b)*h/2;
	printf("上底：%0.2f\t下底：%0.2f\t高：%0.2f\t面积：%0.2f\n",a,b,h,area);
	

}