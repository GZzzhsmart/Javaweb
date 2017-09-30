/* Note:Your choice is C IDE */
#include "stdio.h"
#include "string.h"
void main()
{
    char c1[20]={'H','e','l','l','o',','};
    char c2[]="World!";
    
    //连接函数strcat(参数1，参数2）；把参数2的内容连接到参数1的原内容的后面
    //注意事项：参数1是一个字符数组，那么连接时要确保参数1的长度必须大于2个字符串字符总数的长度
    strcat(c1,c2);
    puts(c1);
}