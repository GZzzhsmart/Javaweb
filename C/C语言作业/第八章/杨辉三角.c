/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	//杨辉三角
	int a[10]={1,1};
	int i,j;
	printf("1\n");//固定两行为1
	printf("1\t1\n");
	for(i=2;i<10;i++)
	{
		for(j=i-1;j>0;j--)//从后往前覆盖
		{
			a[j]=a[j]+a[j-1];	
		}
		a[i]=1;//最后一个为1，打印最后的1
		for(j=0;j<=i;j++)
    	{
    		printf("%d\t",a[j]);
    	}
    	printf("\n");
	}
	    
}