package T2;

import java.util.*;

public class StackTest {
    public static void main(String args[]) {
    	MyStacks mystack = new MyStacks(10); //构造一个MyStack对象,将大小设为10
        mystack.push("羽绒服");
        mystack.push("羊毛衫");
        mystack.push("牛仔裤");
        mystack.push("毛裤");
        mystack.push("袜子");
        System.out.println("-------------------------------");
        System.out.println("天亮了，要穿衣服了		^Q^");
        while (!mystack.empty()) {
            System.out.println("   把 " + mystack.pop() + " 取出来穿上");
        }
    }
}


class MyStacks {
    private Object[] data;
    private int top = -1; //堆栈指向标
    private int size;
    public MyStacks() {
        data = new Object[100];
        this.size = 100;
    }

    public MyStacks(int size) {
        data = new Object[size];
        this.size = size;
        System.out.println("要睡觉了,该脱衣服了		^Q^");
    }

    //出栈
    public Object pop() {
        Object obj = null; //声明一个Object变量用来存储取出的数据，初始化为null
        if (top > -1) { //判断堆栈是否为空，即指向标的位置
            obj = this.data[top]; //将数据取出
            top--; //将指向标向下移动一位
        }
        return obj; //将取出的数据返回
    }

    //入栈
    public void push(Object obj) {
        //如果堆栈不满的话可以入栈
        if (top < size - 1) {
            top++; //将指向标向上移动一位
            this.data[top] = obj; //将数据放入栈区
            System.out.println("   将 " + obj + " 放入衣柜");
        } else { //如果堆栈已满则数据不能入栈
            System.out.println("----堆栈已满----");
        }
    }

    //判断堆栈是否为空
    public boolean empty() {
        boolean isEmpty = true;
        if (top > -1) {
            isEmpty = false;
        }
        return isEmpty;
    }
}
