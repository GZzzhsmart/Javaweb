/* Note:Your choice is C IDE */
#include "stdio.h"
#include "bios.h"
void main()
{
    int a = bioskey(0);
    printf("%x", a);
}