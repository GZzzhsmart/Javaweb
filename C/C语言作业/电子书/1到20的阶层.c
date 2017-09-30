/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int i=1;
    int jc=1;//阶层数值
    double sn=0;//sn位各项之和
    printf("结果为");
    for(i=1;i<=20;i++){
    	jc*=i;
    	sn+=jc;
    	
    }
    printf("1!+2!+3!+...=%lf",sn);
   
    
    
}