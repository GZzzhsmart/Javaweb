/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    char ch;
	printf("请输入一个小写字母：");
	scanf("%c",&ch);
	printf("%c的ASCII是：%d，对应的大写字母是：%c\n",ch,ch,ch-32);


}