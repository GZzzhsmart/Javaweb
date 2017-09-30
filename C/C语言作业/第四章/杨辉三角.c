/* Note:Your choice is C IDE */
#include<stdio.h>

int main()

{int i,j,a[10][10];

for(i=0;i<=9;i++)

   for(j=0;j<=9;j++){

 a[i][0]=1;

 a[i][i]=1;

  }

    for(i=2;i<=9;i++)

       for(j=1;j<=i-1;j++)

           a[i][j]=a[i-1][j-1]+a[i-1][j];

    for(i=0;i<=9;i++){

       for(j=0;j<=i;j++)

          printf("%5d",a[i][j]);

       printf("\n");

    }

getchar() ;

    return 0;

}
