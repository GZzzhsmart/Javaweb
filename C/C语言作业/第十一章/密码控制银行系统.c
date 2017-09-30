/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
#define N 50
//结构体
//银行代码，户名，密码，金额
struct bank
{
	int num;
	char name[20];
	char password[20];
	double money;  	
}people[N];
int i=0;
//声明函数
//登入函数
void denglujiemian();
//开户
void kaihu();
//登入
int dengru();//有返回结果
//存款
void cunkuan();
//取款
void qukuan();
//查询
void chaxun();
//转账
void zhuanzhang();
//退出
void tuichu();
//主函数
void main()
{
	int num;
	denglujiemian();
	do{
		printf("\t\t*******************************************************\n");
		printf("\t\t*                                                     *\n");
		printf("\t\t*                 欢迎进入中国银行系统                *\n");
		printf("\t\t*                                                     *\n");
		printf("\t\t*******************************************************\n");
		printf("\t\t\t请选择您要办理的业务：\n");
		printf("\t\t\t\t1.开户：\n");
		printf("\t\t\t\t2.存款：\n");
		printf("\t\t\t\t3.取款：\n");
		printf("\t\t\t\t4.查询余额：\n");
		printf("\t\t\t\t5.转账：\n");
		printf("\t\t\t\t6.退出：\n");
		scanf("%d",&num);
		switch(num)
		{
			case 1://开户
				kaihu();
				break;
			case 2://存款
				cunkuan();
				break;
			case 3: //取款
				qukuan();
				break;
			case 4://查询
				chaxun();
				break;
			case 5://转账
				zhuanzhang();	
				break;
			case 6:
				break;
		}
		printf("按任意键继续......\n");
		getch();
		system("cls");
	}while(num!=6);

}
//定义
//登入界面
void denglujiemian()
{
	char user[20]={"chenfeilong"};//设置用户字符串
	char password[20]={"cfl1997"}; //设置密码字符串 
	char ustr[20],pwstr[20]; 
	int i=0;
	while(i<3) 
	{
		printf("\t\t\t输入银行工作人员的用户名：\n");
		gets(ustr);
		printf("\t\t\t输入银行工作人员的用户名的密码：\n");
		gets(pwstr);
		if(strcmp(user,ustr))
		{
			printf("\t\t\t您输入的银行用户名称有误！\n");	
		}else{
		
			if(strcmp(password,pwstr))
			{
				printf("\t\t\t密码字符输入有误,请重新输入！\n");	
				
			}else{
				printf("\t\t\t欢迎进入银行系统！\n");
				break;
			
			}
		
		}
		i++;
		
	}
	if(i==3)
	{
		printf("输入密码错误三次！此号存在风险，即将进行冻结，请寻找总裁进行更改密码\n");	
	}
	return 0;
		
}


//开户
void kaihu()
{
		printf("开户业务开始了\n");
		printf("请输入你的银行户名:");
		scanf("%s",&people[i].name);
		printf("请输入你的银行卡号:");
		scanf("%d",&people[i].num);
		printf("请输入你银行户名的密码:");
		scanf("%s",&people[i].password);
		printf("请输入你需要往银行储存的金额");
		scanf("%lf",&people[i].money);
		printf("你的银行卡号是:%d\n你的银行账户名是:%s\n你的银行金额是:%lf\n\n",people[i].num,people[i].name,people[i].money);
		i++;
		printf("开户完成，请妥善保管信息资料哦！\n");
}
//登入
int dengru()//返回结果
{
	int n;//查找户名所用的参数
	int f_num;//登入需要输入的名称，需要跟原来的进行比较，重新定义	
	char f_password[20];//登入需要输入的密码，需要跟原来的进行比较，重新定义	
	int fanhuizhi=-1;//返回的参数
	printf("请输入卡号和密码");
	scanf("%d,%s",&f_num,&f_password);
	for(n=0;n<i;n++)
	{
		if(f_num==people[n].num && strcmp(people[n].password,f_password)==0)
		{
			fanhuizhi=n;
			break;	
		}
		
	}
	return fanhuizhi;

}
//存款
void cunkuan()
{
	double amoney;
	int hedui;

	hedui=dengru();
	if(hedui>=0)
	{
		printf("请输入你要存款的金额");
		scanf("%lf",&amoney);
		people[hedui].money+=amoney;
		printf("您存了%lf元,共有%lf元",amoney,people[hedui].money);
	}
	else
	{
		printf("您输入的卡号或密码有误！请核对后再输入");
	}	
}
//取款
void qukuan()
{
	double amoney;
	int hedui;

	hedui=dengru();
	if(hedui>=0)
	{
		printf("请输入你要取款的金额");
		scanf("%lf",&amoney);
		if(people[hedui].money-amoney>=0)
		{
			people[hedui].money-=amoney;
			printf("您存了%lf元,共有%lf元",amoney,people[hedui].money);
		}else{
			printf("您的余额不足！");
		}
	}
	else
	{
		printf("您输入的卡号或密码有误！请核对后再输入");
	}			
}
//查询
void chaxun()
{
	int hedui;
	hedui=dengru();
	if(hedui>=0)
	{
		printf("您账上共有%lf元",people[hedui].money);	
	}
	else
	{
		printf("您输入的卡号或密码有误！请核对后再输入");
	}
			
}

//转账
void zhuanzhang()
{
	double amoney;
	int hedui;
	int duifangzhanghao;
	int t,p=-1;
	hedui=dengru();
	if(hedui>=0)
	{
		printf("请输入对方卡号：");
		scanf("%d",&duifangzhanghao);
		for(t=0;t<i;t++)
		{
			if(duifangzhanghao==people[t].num)
			{
				p=t; //表示对方的账号信息对应的下标
				printf("请输入转出金额：");
				scanf("%lf",&amoney);
				if(people[hedui].money-amoney>=0)
				{
					people[hedui].money-=amoney;//自己账户的钱
					people[p].money+=amoney;//对方账户的钱
					printf("恭喜你转账成功，转出%0.2lf元，您账上剩余%0.2lf元",amoney,people[hedui].money);	
				}
				else
				{
					printf("转账失败！您的余额不足！");
				}
				break;
							
			}
			
		}
		if(p==-1)
		{
			printf("转账失败：对方卡号不存在\n");
		}
		
	}else{
		printf("您输入的卡号或密码错误\n");
	}	
}
