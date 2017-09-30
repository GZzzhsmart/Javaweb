/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
	{
	char a[5]={'*','*','*','*','*',};
	int i,j,k;
	char space=' ';
	for(i=0;i<5;i++)
	{
		printf("\n\n\n");
		printf(" ");		
	
		for(j=1;j<=i;j++)
		{
			printf("%c\t",space);
		}
		for(k=0;k<5;k++)
		{
			
			printf("%d\t",a[k]);	
			
			
		}
		
	}
}