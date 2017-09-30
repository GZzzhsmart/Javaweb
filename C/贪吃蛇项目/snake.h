const int KEY_ONE = 0x231; // 数字键1
const int KEY_TWO = 0x332;
const int KEY_THREE = 0x433;
const int KEY_FOUR = 0x534;
const int KEY_ESC = 0x11b; // Esc

const int KEY_UP = 0x4800; // 向上键
const int KEY_DOWN = 0x5000; // 向下键
const int KEY_LEFT = 0x4b00; // 向左键
const int KEY_RIGHT = 0x4d00; // 向右键

const int DIRECTION_UP = KEY_UP; // 上方向
const int DIRECTION_DOWN = KEY_DOWN; // 下方向
const int DIRECTION_LEFT = KEY_LEFT; // 左方向
const int DIRECTION_RIGHT = KEY_RIGHT; // 右方向

const int RECTANGLE_SIZE = 10; // 每个小方格的宽度和高度都为10，包括围墙，蛇，食物
const int CANVAS_MIN_X = 20; // 整个画布的最小x值
const int CANVAS_MAX_X = 620; // 整个画布的最大x值
const int CANVAS_MIN_Y = 50;  // 整个画布的最小y值
const int CANVAS_MAX_Y = 450; // 整个画布的最大y值

const int CANVAS_VALID_MIN_X = CANVAS_MIN_X + RECTANGLE_SIZE; // 画布有效区域的最小x值  30
const int CANVAS_VALID_MAX_X = CANVAS_MAX_X - RECTANGLE_SIZE; // 画布有效区域的最大x值  610
const int CANVAS_VALID_MIN_Y = CANVAS_MIN_Y + RECTANGLE_SIZE; // 画布有效区域的最小y值  60
const int CANVAS_VALID_MAX_Y = CANVAS_MAX_Y - RECTANGLE_SIZE; // 画布有效区域的最大y值  440

const int SNAKE_NODE = 100; // 蛇最多有多少节

const int TOTAL_ROWS = (CANVAS_MAX_Y - CANVAS_MIN_Y) / RECTANGLE_SIZE; // 总共有多少行
const int TOTAL_COLS = (CANVAS_MAX_X - CANVAS_MIN_X) / RECTANGLE_SIZE; // 总共有多少列
int canvas[TOTAL_ROWS][TOTAL_COLS]; // 存储整个画布格子的二维数组

const int WALL = 1; // 表示画围墙
const int BARRIER_RECT = 2; // 表示画方形障碍物
const int BARRIER_CIRCLE = 3; // 表示画圆形障碍物
const int EMPTY = 0; // 表示空白，不需要画东西

const int TOTAL_MISSION = 2; //总共有多少个关卡
const int WALL_MISSION_ONE = 1; // 用于画第一关的围墙
const int WALL_MISSION_TWO = 3; // 用于画第二关的围墙
const int WALL_MISSION_THREE = 5; // 用于画第三关的围墙

const int TOTAL_BARRIERS = 1000; // 障碍物总数
const int BARRIER_MISSION_ONE = 0; // 用于画第一关的障碍物
const int BARRIER_MISSION_TWO = 1; // 用于画第二关的障碍物
const int BARRIER_MISSION_THREE = 2; // 用于画第三关的障碍物


char lastScore[20] = "Score: "; // 最近一次的分数

const int SPEED_MISSION_ONE = 100; // 第一关的速度
const int SPEED_MISSION_TWO = 50; // 第二关的速度
const int SPEED_MISSION_THREE = 25; // 第三关的速度

int HORIZONTAL_WALL[TOTAL_MISSION * 2][TOTAL_COLS] = {
		// 第一关的上下围墙
		{
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
		},	
		{
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
		},
		// 第二关的上下围墙
		{
			1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
		},	
		{
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1,
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
		}
};

int VERTICAL_WALL[TOTAL_MISSION * 2][TOTAL_ROWS] = {
	//第一关的垂直围墙
	{
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	},
	{
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	},
	// 第二关的垂直围墙
	{
		1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	},
	{
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1,
		1, 1, 1, 1, 1, 1, 1, 1, 1, 1
	}
};

struct barrier {
	int row; //障碍物的行
	int col; //障碍物的列
	int type; //障碍物的类型，包括 BARRIER_RECT， BARRIER_CIRCLE
} barriers[TOTAL_MISSION][TOTAL_BARRIERS] = {
	//第一关的障碍物
	{{5, 6, BARRIER_RECT}, {6, 8, BARRIER_RECT}, {20, 45, BARRIER_RECT}, {10, 20, BARRIER_CIRCLE}},
	//第二关的障碍物
	{{0, 0, 0}}
};