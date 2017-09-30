/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数
void nianshouru();
void main()
{	

		nianshouru();
}
void nianshouru()
{
	float X,Y,Z,S;
do{	 
		 
		printf("**********************○*************************\n"); 
		printf("*                                               *\n"); 
		printf("*                                               *\n");
		printf("*  　　　　◎中国2016年纳税系统                 *\n");
		printf("*                                               *\n"); 
		printf("*                                               *\n");
		printf("**********************○*************************\n");
		printf("\t请输入你的月薪（以元为单位）");
		scanf("%f",&X);
		fflush(stdin);
		printf("\t请输入当的起征点（以元为单位）");
		scanf("%f",&S);
		printf("\t你的月薪%f\n",X);
		Y=X-S;
		if(Y<=0){
			printf("你工资也太低了吧！还没有交税的资格，好好赚钱\n");
		}else if(Y>0&&Y<=1500){
			Z=45;
		}else if(Y>1500&&Y<=4000){
			Z=45+(Y-1500)*0.1;
		}else if(Y>4000&&Y<=8000){
			Z=445+(Y-4000)*0.2;
		}else if(Y>8000&&Y<=20000){
			Z=1945+(Y-8000)*0.25;
		}else if(Y>20000&&Y<=30000){
			Z=6945+(Y-20000)*0.3;
		}else if(Y>30000&&Y<=80000){
			Z=15945+(Y-30000)*0.4;
		}else {
			Z=51945+(Y-80000)*0.5;
		}
		
		printf("\t你的个人所得税是：%0.2f\n",Z);	 
		printf("\t你扣税后的收入是：%0.2f纳税光荣\n",X-Z);
		printf("\n");
		printf("还要继续操作吗？继续按任意键，退出按1\n");
		getch();
		system("cls");	
		  
}while(1);
		
	
	
}
