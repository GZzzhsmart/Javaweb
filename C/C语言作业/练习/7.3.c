/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
	int a[3][3],i,j,sum=0;
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			scanf("%d",&a[i][j]);
			if(i+j==2||i==j)
			{
				sum+=a[i][j];
				
			}
			
			
		}
		
	}
	printf("%d",sum);
	    
}