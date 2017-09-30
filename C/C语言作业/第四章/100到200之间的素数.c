/* Note:Your choice is C IDE */
#include "stdio.h"
#include<math.h>
 int main(void)
 {
      int i,m,count;
      double n;
      count=0;
      for(m=0;m<100;m++){
          n=sqrt(m);
          for(i=2;i<=n;i++)
          if(m%i==0) break;
          if(i>n){
              printf("%5d",m);
              count++;
              if(count%8==0)
              printf("\n");
          }
      }
      printf("\n¸öÊý=%d",count);
      printf("\n");
      
 }   
