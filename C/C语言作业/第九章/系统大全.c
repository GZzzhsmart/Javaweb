/* Note:Your choice is C IDE */
#include "stdio.h"
//声明函数
void niandushouru();
void gerenshui();
void kalaok();
void yinhangyewu();
void main()
{
	int i;
	
	do
	{
	printf("\t\t**********************⊙*************************\n");
	printf("\t\t*                                               *\n");
	printf("\t\t*              ◎   系统软件大全                *\n");
	printf("\t\t*                                               *\n");
	printf("\t\t**********************⊙*************************\n");
	printf("\n\n");
	printf("\t\t\t请选择您想进入的系统:\n");
	printf("\t\t\t\t1.年度收入统计系统\n");
	printf("\t\t\t\t2.个人所得税计算系统\n");
	printf("\t\t\t\t3.卡拉OK大赛评分系统\n");
	printf("\t\t\t\t4.银行业务系统\n");
	printf("\t\t\t\t5.退出系统\n");
	printf("\t\t\t\t请选择:");

	
	scanf("%d",&i);
	if(i==5)
		break;

	switch(i)
	{
	case 1:
		getch();
		system("cls");  //清屏
		niandushouru();
		printf("\n");
		printf("\t\t\t按回车键返回主菜单:\n");
		fflush(stdin);//清除键盘缓存
		break;
	case 2:
		getch();
		system("cls");
		gerenshui();
		printf("\n");
		printf("\t\t\t按回车键返回主菜单:\n");
		fflush(stdin);
		break;
	case 3:
		getch();
		system("cls");
		kalaok();
		printf("\n");
		printf("\t\t\t按回车键返回主菜单:\n");
		fflush(stdin);
		break;
	case 4:
		getch();
		system("cls");
		yinhangyewu();
		printf("\n");
		printf("\t\t\t按回车键返回主菜单:\n");
		fflush(stdin);
		break;
	default:
		printf("\t\t\t输入错误，请在1~5中选择！\n");
		break;
	}
	}while(1);    
}
//定义函数
//年度收入
void niandushouru()
{
	int a[12],i,p,t,n=0;
	float sum=0,max=0,min=0;
do{
	printf("\t\t*************************◎***************************\n");
	printf("\t\t*                                                    *\n"); 
	printf("\t\t*         XXX公司2008年年度收入统计系统              *\n"); 
	printf("\t\t*                                                    *\n");
	printf("\t\t*************************◎***************************\n"); 
	for(i=0;i<12;i++)
	{
		printf("\t\t请输入第%d个月的月收入",i+1);
		scanf("%d",&a[i]);	
	}
	max=min=a[0];
	sum=0;
	for(i=0;i<12;i++)
	{
		if(max<a[i])
		{
			max=a[i];
			p=i;	
		}
		if(min>a[i])
		{
			min=a[i];
			t=i;
		}
		sum+=a[i];
		if(i%6==0)
			printf("\n");
		printf("%d\t",a[i]);
	
	}
	printf("\t\t\n第%d个月的月总收入最高为%0.2f\n",p+1,max);
	printf("\t\t第%d个月的月总收入最底为%0.2f\n",t+1,min);
	printf("\t\t公司平均收入为%0.2f\n",sum/12);
	printf("\t\t总收入%0.2f",sum);
	getch();
	system("cls");  
}while(1);   
		
}
//个人税
void gerenshui()
{
	float X,Y,Z,S;
  printf("\t\t**********************○*************************\n"); 
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t*  　　　　◎中国2016年纳税系统                 *\n");
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t**********************○*************************\n");
 
   printf("\t\t\t请输入你的月薪（以元为单位）");
   scanf("%f",&X);
   fflush(stdin);
   printf("\t\t\t请输入当的起征点（以元为单位）");
   scanf("%f",&S);
   printf("\t\t\t你的月薪%f\n",X);
   Y=X-S;
  	if(Y<=0){
  		printf("\t\t\t你的工资太低！好好赚钱，争取纳税\n");
  	}else if(Y>0&&Y<=1500){
		Z=1500*0.03;
	}else if(Y>1500&&Y<=4000){
		Z=1500*0.03+(Y-1500)*0.1;
	}else if(Y>4000&&Y<=8000){
		Z=1500*0.03+4000*0.1+(Y-4000)*0.2;
	}else if(Y>8000&&Y<=20000){
		Z=1500*0.03+3000*0.1+8000*0.2+(Y-8000)*0.25;
	}else if(Y>20000&&Y<=30000){
		Z=1500*0.03+3000*0.1+8000*0.2+20000*0.25+(Y-20000)*0.3;
	}else if(Y>30000&&Y<=80000){
		Z=1500*0.03+3000*0.1+8000*0.25+20000*0.25+30000*0.3+(Y-30000)*0.4;
	}else {
		Z=1500*0.03+3000*0.1+8000*0.25+20000*0.25+30000*0.3+80000*0.4+(Y-80000)*0.5;
	}

	printf("\t\t\t你的个人所得税是：%f\n",Z);	 
	printf("\t\t\t你扣税后的收入是：%f纳税光荣",X-Z);
	getch();
	system("cls");	  	
	
}
//卡拉ok
void kalaok()
{
	 float a[10],max=0,min=10,sum=0;
    int i;
    printf("\t\t                  卡拉OK大赛评分系统              \n");
    printf("\t\t**************************************************\n");
    printf("\t\t*                                                *\n");
    printf("\t\t        第一届中华杯校园歌手卡拉OK大赛开始了      \n");
    printf("\t\t*                                                *\n");
    printf("\t\t**************************************************\n");
    for(i=0;i<10;i++)
    {
    	printf("\t\t\t请输入第%d位评委的分数:",i+1);
    	scanf("%f",&a[i]);	
    }
    max=min=a[0];
    for(i=0;i<10;i++)
    {
    	if(max<a[i])
    		max=a[i];
    	if(min>a[i])
    		min=a[i];
		sum += a[i];
    	if(i%5==0)
    		printf("\n");    		
    	printf("%0.2f\t",a[i]);
    }
    
    printf("\t\t\t\n去掉一个最高分：%0.2f\n",max);
    printf("\t\t\t去掉一个最低分:%0.2f\n",min);
    printf("\t\t\t选手的最后得分是:%0.2f",(sum-max-min)/8);	
	getch();
	system("cls");
}
//银行业务
void yinhangyewu()
{
	int a,i;
	do{
  printf("\t\t**********************○*************************\n"); 
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t*  　　　　◎欢迎进入中国银行                   *\n");
  printf("\t\t*                                               *\n"); 
  printf("\t\t*                                               *\n");
  printf("\t\t**********************○*************************\n");
  
  
    
  printf("           请选择您要办理的手续：\n"); 
  printf("                   1.开户\n");  
  printf("                   2.存款\n");  
  printf("                   3.取款\n");
  printf("                   4.查询余额\n"); 
  printf("                   5.转账\n");  
  printf("                   6.退出\n");  
  printf("\t请输入你要办理的业务");
  scanf("%d",&a);
 
  switch(a){	
  				case 1:
  					printf("你选择了开户业务");
  					break;
				case 2:
  					printf("你选择了存款业务");
  					break;
				case 3:
  					printf("你选择了取款业务");
  					break;
				case 4:
  					printf("你选择了查询余额业务");
  					break;
				case 5:
  					printf("你选择了转账业务");
  					break;
				case 6:
  					printf("你选择了退出业务");
  					break;
				default :
  					printf("你输入的有误，请输入1-6之间的数字");
  					
  			}
	} while(i!=6);
	getch();
	system("cls");
  	
}