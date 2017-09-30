/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
//定义全局变量
char name[20]; //姓名
char password[20];//登录密码
int cardno; //卡号
double money; //帐上余额
//声明所有函数
//开户
void kaihu();
//存款
void cunkuan();
//取款
void qukuan();
void main()
{
	int num;
	do{
		printf("\t\t\t*******************************************************\n");
		printf("\t\t\t*                                                     *\n");
		printf("\t\t\t*                 欢迎进入中国银行系统                *\n");
		printf("\t\t\t*                                                     *\n");
		printf("\t\t\t*******************************************************\n");
		printf("\t\t\t\t请选择您要办理的业务：\n");
		printf("\t\t\t\t\t1.开户：\n");
		printf("\t\t\t\t\t2.存款：\n");
		printf("\t\t\t\t\t3.取款：\n");
		printf("\t\t\t\t\t4.查询余额：\n");
		printf("\t\t\t\t\t5.转账：\n");
		printf("\t\t\t\t\t6.退出：\n");
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
				break;
			case 5://转账	
				break;
			case 6:
				break;
		}
		printf("按任意键继续......\n");
		getch();//暂停
		system("cls");
	}while(num!=6);
    
}
//定义函数
//开户
void kaihu()
{
	printf("请输入您的姓名：");
	scanf("%s",name);//字符数组赋值
	printf("请输入卡号：");
	scanf("%d",&cardno);
	printf("请输入密码：");
	scanf("%s",password);
	printf("请输入开户金额：");
	scanf("%lf",&money);
	printf("恭喜你开户成功！请妥善保管您的个人信息，详细信息如下：\n");
	printf("您的姓名是：%s,您的卡号是：%d,您的密码是：%s,您的账上余额是:%0.2lf\n",name,cardno,password,money);	
}
//存款
void cunkuan()
{
	int m_cardno;
	char m_password[20];
	double m_money;
	printf("请输入卡号和密码");
	scanf("%d,%s",&m_cardno,m_password);
	if(m_cardno==cardno && !strcmp(m_password,password))
	{
		printf("请输入你要存款的金额：");
		scanf("%lf",&m_money);
		printf("存款之前您的账上余额是：%0.2lf\n",money);
		money += m_money;
		printf("存款%0.2lf元，您的账上余额是：%0.2lf\n",m_money,money);
		
	}else{
		printf("您输入的卡号或密码错误\n");
	}
}
void qukuan()
{
	int p_cardno;
	char p_password[20];
	double p_money;
	printf("请输入卡号和密码");
	scanf("%d,%s",&p_cardno,p_password);
	if(p_cardno==cardno && !strcmp(p_password,password))
	{
		printf("请输入你要取款的金额：");
		scanf("%lf",&p_money);
		printf("存款之前您的账上余额是：%0.2lf\n",money);
		money -= p_money;
		printf("取款%0.2lf元，您的账上余额是：%0.2lf\n",p_money,money);
		printf("请收好你的金额\n");
		
	}else{
		printf("您输入的卡号或密码错误\n");
	}	
}