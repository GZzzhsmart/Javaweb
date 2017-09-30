/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{
    int i,j;
    for(i=1;i<=9;i++)
    {
    	for(j=1;j<=i;j++)
    	{
    		printf("%d * %d=%d",i,j,i*j);
    	}
    	printf("\n");
    }
    return 0;
}