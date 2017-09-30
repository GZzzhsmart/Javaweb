/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  int month,day;
	printf("请输入一个月份：");
	scanf("%d",&month);
	switch(month)
	{
	case 1:
	case 3:
	case 5:
	case 7:
	case 8:
	case 10:
	case 12:day=31;	break;
	case 4:
	case 6:
	case 9:
	case 11:day=30;	break;
	case 2:day=29;	break;
	default:day=-1;
	}
	if(day==-1) 
	 {  printf("输入错误，月份必须是1~12之间的数字！\n");
	 }
	else  {  printf("2008年%d月有%d天。\n",month,day);}

}