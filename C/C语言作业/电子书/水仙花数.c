/* Note:Your choice is C IDE */
#include "stdio.h"
void main()
{	int a,b,c,p=100;
	for(p=100;p<1000;p++){
		a=p/100%100;
		b=p/10%10;
		c=p/1%10;
		
 		if(p==a*a*a+b*b*b+c*c*c){
 			printf("%d\t",p);	
 		}
 	
 }	
}