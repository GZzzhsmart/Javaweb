/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
  /* 
	  循环输入5个学生的成绩，并计算出最高分、最低分、平均分
	*/
	int a,i;
	float max,min,sum=0;
	max=0;
	min=100;
	for(i=1;i<=5;i++){
		printf("请输入第%d个学生的分数",i);
		scanf("%d",&a);		
		if(max<a){
			max=a;
			
		}
		if(min>a){
			min=a;			
		}
		sum+=a;		
	}
	printf("最大值为：%f,最小值为：%f,平均分为：%f",max,min,sum/5);
}