/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{  int a,b,c,d,e,f,g,h,i,j,k,l;
   float sum;
   printf("*************************◎***************************\n");
   printf("*                                                    *\n"); 
   printf("*         XXX公司2008年年度收入统计系统              *\n"); 
   printf("*                                                    *\n");
   printf("*************************◎***************************\n");
   printf("\t\t请输入第1个月的公司收入:");
   scanf("%d",&a);
   
   fflush(stdin);
   printf("\t\t请输入第2个月的公司收入:");
   scanf("%d",&b);
   
   fflush(stdin);
   printf("\t\t请输入第3个月的公司收入:");
   scanf("%d",&c);
   
   fflush(stdin);
   printf("\t\t请输入第4个月的公司收入:");
   scanf("%d",&d);
   
   fflush(stdin);
   printf("\t\t请输入第5个月的公司收入:");
   scanf("%d",&e);
   
   fflush(stdin);
   printf("\t\t请输入第6个月的公司收入:");
   scanf("%d",&f);
   
   fflush(stdin);
   printf("\t\t请输入第7个月的公司收入:");
   scanf("%d",&g);
   
   fflush(stdin);
   printf("\t\t请输入第8个月的公司收入:");
   scanf("%d",&h);
   
   fflush(stdin);
   printf("\t\t请输入第9个月的公司收入:");
   scanf("%d",&i);
   
   fflush(stdin);
   printf("\t\t请输入第10个月的公司收入:");
   scanf("%d",&j);
   
   fflush(stdin);
   printf("\t\t请输入第11个月的公司收入:");
   scanf("%d",&k);
   
   fflush(stdin);
   printf("\t\t请输入第12个月的公司收入:");
   scanf("%d",&l);
   
   
   
   fflush(stdin);
   sum=a+b+c+d+e+f+g+h+i+j+k+l;
   printf("\t\tXXX公司2008年的总收入为:%f",sum);                        
}