/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
 char a;
 int a1=0,a2=0,a3=0,a4=0;
 printf("请输入一串字符"); 
 while((a=getchar())!='\n'){	
 		
 if(a1>='a'&&a1<='z'||a1>='A'&&a1<='Z'){
 	a1++;
 }else if(a2==""){
 	a2++;
 }else if(a3>=0&&a3<=9){ 
 	a3++;
 }else{
 	a4++;
 }
 }
 printf("字母=%d,空格=%d,数字=%d,其他=%d",a1,a2,a3,a4);
}