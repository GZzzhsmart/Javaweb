#include "stdio.h"
#include "stdlib.h"
#include "graphics.h"
#include "conio.h"
#include "bios.h"
#include "time.h"
#include "dos.h"
#include "string.h"
#include "snake.h"

struct snake {
	int x[SNAKE_NODE]; // 蛇每一节的左上角x坐标
	int y[SNAKE_NODE]; // 蛇每一节的左上角y坐标
	int node; // 蛇当前有多少节，初始化为2
	int direction; // 蛇移动的方向，初始化为DIRECTION_RIGHT
	int life; // 蛇的生命值
	int foodCount; // 蛇吃了多少食物，初始为0
	int score; // 得分，初始为0
	int level; //等级，初始为0
} snake;

struct food {
	int x; // 食物的左上角的x坐标
	int y; // 食物的左上角的y坐标
} food;

void init();
void close();

void startCanvas();
void playCanvas(int mission);
void play(int wallMission, int barreriMission, int speed, char title[], int snakeX, int snakeY);

void initFood();
void drawFood();
void initSnake(int x, int y);
void drawSnake();
void snakeMove(int key);
int needToMove(int key);
int isDirectionKey(int key);

void initCanvas();
void initHorizontalWall(int mission);
void initVerticalWall(int mission);
void initBarriers(int mission);
void drawWallAndBarrier();

int collision();
void bitFood();
int bitSelf();

void printScore();
void gameOver();

int round(int o);
int getX(int col);
int getY(int row);
int getRow(int y);
int getCol(int x);

int main()
{
    init();
    startCanvas();
    close();
    return 0;
}

/**
	初始化图形驱动
*/
void init() {
	int gdriver = DETECT, gmode;
	registerbgidriver(EGAVGA_driver);
    initgraph(&gdriver, &gmode, "");
}

/**
	关闭图形驱动
*/
void close() {
	getch();
	closegraph();
}

/**
	游戏开始界面，提供相应的选项，如模式选择，关卡选择，及退出
*/
void startCanvas() {
	int key;
	cleardevice();
	setbkcolor(BLUE);
	setcolor(WHITE);
	settextstyle(0, 0, 3);
	outtextxy(20, 20, "Welcome to My Snake Game!");
	settextstyle(0, 0, 2);
	outtextxy(200, 80, "1. Mission One");	
	outtextxy(200, 100, "2. Mission Two");
	outtextxy(200, 120, "3. Mission Three");
	outtextxy(200, 140, "4. Quit");
	key = bioskey(0);
	switch(key) {
		case KEY_ONE:playCanvas(KEY_ONE); break;
		case KEY_TWO:playCanvas(KEY_TWO); break;
		case KEY_THREE:playCanvas(KEY_THREE); break;
		case KEY_FOUR:cleardevice(); exit(0); break;
	}
}

/**
	进入指定模式或关卡的游戏界面
*/
void playCanvas(int mission) {
	cleardevice();
	if(mission == KEY_ONE) {
		play(WALL_MISSION_ONE, BARRIER_MISSION_ONE, SPEED_MISSION_ONE, "Mission: 1", 30, 60);
	} else if(mission == KEY_TWO) {
		play(WALL_MISSION_TWO, BARRIER_MISSION_TWO, SPEED_MISSION_TWO, "Mission: 2", 30, 60);
	} else if(mission == KEY_THREE) {
		play(WALL_MISSION_THREE, BARRIER_MISSION_THREE, SPEED_MISSION_THREE, "Mission: 3", 30, 60);
	}
}

void play(int wallMission, int barrierMission, int speed, char title[], int snakeX, int snakeY) {
	int key = KEY_RIGHT;
	int isRunning = 1;
	outtextxy(20, 20, title);
	initCanvas(); // 初始化画布
	initHorizontalWall(wallMission); // 初始化横向围墙
	initVerticalWall(wallMission); // 初始化纵向围墙
	initBarriers(barrierMission); // 初始化所有障碍物
	initFood(); // 出现随机食物
	initSnake(snakeX, snakeY); //出现一条随机的蛇
	printScore();
	// 开始判断用户的键盘输入
	while(snake.life) {
		while(!kbhit()) { // 循环判断用户是否按键
			snakeMove(key); //让蛇移动
			drawFood(); // 重新绘制食物
			drawWallAndBarrier(); //绘制围墙和障碍物
			if(collision()) { //进行碰撞检测 ，如果有碰撞，则游戏结束
				if(--snake.life == 0) {
					isRunning = 0;
					break;
				}
			}
			bitFood(); //检测吃食物
			delay(speed); // 延迟5指定毫秒数
		}
		if(!isRunning) {
			break;
		}
		//接收用户的键盘输入，如果按的方向键，则让蛇在该方向上移动，如果按的esc键，则退出到选择界面
		key = bioskey(0);
		if(isDirectionKey(key)) {
			if(needToMove(key)) {// 判断蛇是否需要更换方向 
				snakeMove(key);
			}
		} else if(key == KEY_ESC) {
			startCanvas();
		}
	}
	gameOver();
}

void initCanvas() {
	int i,j ;
	for(i = 0; i < TOTAL_ROWS;i++) {
		for(j = 0; j < TOTAL_COLS; j++) {
			canvas[i][j] = EMPTY;
		}
	}
}

/**
	根据围墙数组和关卡初始化该关的横向围墙
*/
void initHorizontalWall(int mission) {
	int i;
	for(i = 0; i < TOTAL_COLS; i++) {
		canvas[0][i] = HORIZONTAL_WALL[mission - 1][i];
		canvas[TOTAL_ROWS - 1][i] = HORIZONTAL_WALL[mission][i];
	}
}

/**
	根据围墙数组和关卡初始化该关的纵向围墙
*/
void initVerticalWall(int mission) {
	int i;
	for(i = 0; i < TOTAL_ROWS; i++) {
		canvas[i][0] = VERTICAL_WALL[mission - 1][i];
		canvas[i][TOTAL_COLS - 1] = VERTICAL_WALL[mission][i];
	}
}

void initBarriers(int mission) {
	int i;
	int type;
	for(i = 0; i < TOTAL_BARRIERS; i++) {
		type = barriers[mission][i].type;
		if(type == EMPTY) { // 去除掉barriers后面的那些未被赋值的障碍物
			break;
		}
		canvas[barriers[mission][i].row][barriers[mission][i].col] = barriers[mission][i].type;
	}
}

/**
	根据初始化的围墙数据绘制围墙
*/
void drawWallAndBarrier() {
	int i,j;
	for(i = 0; i < TOTAL_ROWS; i++) {
		for(j = 0; j < TOTAL_COLS; j++) {
			if(canvas[i][j] == WALL) {
				rectangle(getX(j), getY(i), getX(j) + RECTANGLE_SIZE, getY(i) + RECTANGLE_SIZE);
			} else if(canvas[i][j] == BARRIER_RECT) {
				rectangle(getX(j), getY(i), getX(j) + RECTANGLE_SIZE, getY(i) + RECTANGLE_SIZE);
			} else if(canvas[i][j] == BARRIER_CIRCLE) {
				circle(getX(j) + RECTANGLE_SIZE / 2, getY(i) + RECTANGLE_SIZE / 2, RECTANGLE_SIZE / 2);
			}
		}
	}
}

/**
	在有效区域内随机产生食物，保留坐标，并且确保食物与方格重合
*/
void initFood(){
	int row, col;
	food.x = rand() % (CANVAS_VALID_MAX_X - CANVAS_VALID_MIN_X - 2 * RECTANGLE_SIZE) + CANVAS_VALID_MIN_X;
	food.y = rand() % (CANVAS_VALID_MAX_Y - CANVAS_VALID_MIN_Y - 2 * RECTANGLE_SIZE) + CANVAS_VALID_MIN_Y;
	food.x = round(food.x);
	food.y = round(food.y);
	row = getRow(food.y); 
	col = getCol(food.x);
	// 判断食物是否出现在障碍物上，如果在障碍物上，重新获取食物
	while(canvas[row][col] == BARRIER_RECT || canvas[row][col] == BARRIER_CIRCLE) {
		if(food.x == CANVAS_VALID_MAX_X - RECTANGLE_SIZE) {
			food.x = CANVAS_VALID_MIN_X;
		}
		if(food.y == CANVAS_VALID_MAX_Y - RECTANGLE_SIZE) {
			food.y = CANVAS_VALID_MIN_Y;
		}
		food.x += RECTANGLE_SIZE;
		food.y += RECTANGLE_SIZE;
		row = getRow(food.y); 
		col = getCol(food.x);
	}
}

/**
	根据随机产生的食物坐标绘制食物
*/
void drawFood() {
	setfillstyle(1, GREEN);
	bar(food.x, food.y, food.x + RECTANGLE_SIZE, food.y + RECTANGLE_SIZE);
}

/**
	在有效区域内随机产生一条蛇并保留坐标，并且确保蛇头与某个方格重合，方向初始化为向右，蛇身2节
*/
void initSnake(int x, int y) {
	snake.node = 2;
	snake.life = 1;
	snake.foodCount = 0;
	snake.score = 0;
	snake.level = 1;
	snake.direction = DIRECTION_RIGHT;
	snake.x[0] = x;
	snake.y[0] = y;
}

/**
	根据随机产生的蛇的坐标绘制蛇
*/
void drawSnake() {
	int i;
	for(i = 0; i < snake.node; i++) {
		rectangle(snake.x[i], snake.y[i], snake.x[i] + RECTANGLE_SIZE, snake.y[i] + RECTANGLE_SIZE);
	}
}

/**
	根据指定的方向让蛇在该方向上移动。
	1、需要擦除蛇身的最后一节，先保留住最后一节的x和y坐标，最后使用与背景色相同的颜色重新画最后一节
	2、让蛇移动起来，相当于把蛇前面的坐标赋值给蛇后面节点，最后整条蛇重新绘制出来
*/
void snakeMove(int key) {
	int i;
	int x = snake.x[snake.node - 1];
	int y = snake.y[snake.node - 1];
	for(i = snake.node - 1; i > 0; i--) {
		snake.x[i] = snake.x[i - 1];
		snake.y[i] = snake.y[i - 1];
	}
	if(key == KEY_UP && (snake.direction == DIRECTION_LEFT || snake.direction == DIRECTION_RIGHT)) {
		snake.direction = DIRECTION_UP;
	} else if (key == KEY_DOWN &&(snake.direction == DIRECTION_LEFT || snake.direction == DIRECTION_RIGHT)) {
		snake.direction = DIRECTION_DOWN;
	} else if(key == KEY_LEFT && (snake.direction == DIRECTION_DOWN || snake.direction == DIRECTION_UP)) {
		snake.direction = DIRECTION_LEFT;
	} else if(key == KEY_RIGHT && (snake.direction == DIRECTION_UP || snake.direction == DIRECTION_DOWN)) {
		snake.direction = DIRECTION_RIGHT;
	}
	if(snake.direction == DIRECTION_UP) {
		snake.y[0] -= RECTANGLE_SIZE;
	} else if(snake.direction == DIRECTION_DOWN) {
		snake.y[0] += RECTANGLE_SIZE;
	} else if(snake.direction == DIRECTION_LEFT) {
		snake.x[0] -= RECTANGLE_SIZE;
	} else if(snake.direction == DIRECTION_RIGHT) {
		snake.x[0] += RECTANGLE_SIZE;
	}
	setcolor(BLUE);
	rectangle(x, y, x + RECTANGLE_SIZE, y + RECTANGLE_SIZE); // 擦除蛇身最后一节
	setcolor(WHITE);
	drawSnake(); // 重新画蛇
}

/**
	判断用户按键后，是否需要把蛇换个方向
*/
int needToMove(int key) {
	if(snake.direction == key ||
		 (snake.direction == DIRECTION_UP && key == DIRECTION_DOWN) ||
		 (snake.direction == DIRECTION_DOWN && key == DIRECTION_UP) ||
		 (snake.direction == DIRECTION_LEFT && key == DIRECTION_RIGHT) ||
		 (snake.direction == DIRECTION_RIGHT && key == DIRECTION_LEFT)) {
		return 0;
	}
	return 1;
}

/**
	判断用户是否按的方向键
*/
int isDirectionKey(int key) {
	return (key == KEY_UP || key == KEY_DOWN || key == KEY_LEFT || key == KEY_RIGHT) ? 1 : 0;
}

/**
	判断是否碰撞围墙，障碍物，蛇身，如果碰撞，则返回1
*/
int collision() {
	int snakeRow = getRow(snake.y[0]);
	int snakeCol = getCol(snake.x[0]);
	int snakeRow1 = getRow(snake.y[1]);
	int snakeCol1 = getCol(snake.x[1]);
	if((canvas[snakeRow][snakeCol] == WALL || canvas[snakeRow1][snakeCol1] == WALL) ||
		(canvas[snakeRow][snakeCol] == BARRIER_RECT || canvas[snakeRow1][snakeCol1] == BARRIER_RECT) ||
		(canvas[snakeRow][snakeCol] == BARRIER_CIRCLE || canvas[snakeRow1][snakeCol1] == BARRIER_CIRCLE) || bitSelf()) {
		return 1;
	}
	return 0;
}

/**
	吃到食物，蛇身变长，分数增加，重新出现食物
*/
void bitFood() {
	int foodRow = getRow(food.y);
	int foodCol = getCol(food.x);
	int snakeRow = getRow(snake.y[0]);
	int snakeCol = getCol(snake.x[0]);
	int snakeRow1 = getRow(snake.y[1]);
	int snakeCol1 = getCol(snake.x[1]);
	if(foodRow == snakeRow && foodCol == snakeCol || foodRow == snakeRow1 && foodCol == snakeCol1) {
		snake.score += 10;
		setfillstyle(1, BLUE);
		bar(food.x, food.y, food.x + RECTANGLE_SIZE, food.y + RECTANGLE_SIZE);
		initFood();
		snake.x[snake.node] = snake.x[snake.node - 1];
		snake.y[snake.node] = snake.y[snake.node - 1];
		snake.node += 1;
		printScore();
	}
}

/**
	判断是否碰撞蛇本身
*/
int bitSelf() {
	int i;
	if(snake.node < 5) {
		return 0;
	}
	for(i = 5; i < snake.node; i++) {
		if(snake.x[0] == snake.x[i] && snake.y[0] == snake.y[i]) {
			return 1;
		}
	}
	return 0;
}

/**
	在游戏界面打印分数
*/
void printScore() {
	char score[20];
	setcolor(BLUE);
	outtextxy(400, 20, lastScore);
	sprintf(score,"Score: %d", snake.score);
	strcpy(lastScore, score);
	setcolor(WHITE);
	outtextxy(400, 20, score);
}

/**
	显示游戏结束画面
*/
void gameOver() {
	cleardevice();
	settextstyle(0, 0, 4);
	outtextxy(100, 30, "Game Over!");
}

/**
	对整数o进行四舍五入取整操作
*/
int round(int o) {
	return (int) ((o + 5) / 10.0f) * 10;
}

/**
	通过列索引获取该格子的x坐标
*/
int getX(int col) {
	return col * RECTANGLE_SIZE + CANVAS_MIN_X;
}

/**
	通过行索引获取该格子的y坐标
*/
int getY(int row) {
	return row * RECTANGLE_SIZE + CANVAS_MIN_Y;
}

/**
	通过y坐标获取该格子的行索引
*/
int getRow(int y) {
	return (y - CANVAS_MIN_Y) / 10;
}

/**
	通过x坐标获取该格子的列索引
*/
int getCol(int x) {
	return (x - CANVAS_MIN_X) / 10;
}