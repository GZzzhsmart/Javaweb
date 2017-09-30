/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  //猜数字，定义一个变量num=56，让用户输入一个数与num进行比较，并提示用户是高了还是低了，直到猜中为止。
	/*
	猜数字，定义一个变量num=56，
	让用户输入一个数与num进行比较，
	并提示用户是高了还是低了，直到猜中为止
	*/
	int num=56,n;
	do{
		printf("请输入一个数字");
		scanf("%d",&n);		
		if(n>56){
			printf("该数值大了哟!在猜\n");				
		}else if(n<56){
			printf("该数值小了哟!在猜\n");
		
		}else{
			printf("恭喜你猜对了，领奖去吧！");
			break;
		
		}
		
		
		
	}while(1); 
}