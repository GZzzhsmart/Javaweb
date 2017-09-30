/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int grade;
    printf("请输入你的分数");
    scanf("%d",&grade);
    if(grade<60){printf("你的成绩是E，可不要玩游戏了，努力哦！");}
    else if(grade>=60&&grade<70){printf("你的成绩是D，努力哦！");}
    else if(grade>=70&&grade<80){printf("你的成绩是c，努力靠近B！");}
    else if(grade>=80&&grade<90){printf("你的成绩是B，努力靠近A！");}
    else {printf("你获得一个A，继续保持");}
	
  
}