/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	char a[5]={'*','*','*','*','*'} ;
	char space=' ';
	int i,j,k;
	for(i=0;i<5;i++)
	{
		printf("\n");
		printf(" ");
		for(j=1;j<=i;j++)//¿Õ¸ñ
		{
			printf("%c",space);	
		}	
		for(k=0;k<5;k++)//*
		{
			printf("%c",a[k]);	
		}	
	}   
}