#include "stdio.h"
#include "graphics.h"
#include "conio.h"

#include "bios.h"

const int KEY_UP = 0x4800; 

void main()
{
    int gdriver = DETECT, gmode;
    registerbgidriver(EGAVGA_driver);
    initgraph(&gdriver, &gmode, "");
    /**
    BLACK, BLUE, RED, WHITE, CYAN, GREEN, BROWN, LIGHTGRAY, YELLOW, DARKGREY, LIGHTBLUE,
    */
    setbkcolor(BLUE); // 设置背景颜色
    setcolor(WHITE); // 设置文本等图形的颜色
    outtextxy(10, 10, "Welcome!");
    
    rectangle(50, 50, 130, 130);// 输出矩形
    
    int key = bioskey(0);
    printf("%x\n", key);
    if(key == KEY_UP) {
    	printf("up");
    }
    
    getch();
    closegraph();//
    
    /**
    bgiobj egavga
    把生成的egavga.obj复制到tlib同级目录中
    tlib lib\graphics.lib+egavga
    */
    
}