package T13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.*;

public class Fight {
    public static void main(String args[]) {
        FightFrame f = new FightFrame();
        f.show(); //运行窗体
    }
}


class FightFrame extends JFrame implements Runnable, KeyListener {
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    int djx = new Random().nextInt(300), djy = 10; //敌机的X坐标,Y坐标
    int mex = 90, mey = 440; // 我方飞机的X坐标,Y坐标
    int bx = mex + 22, by = mey; //子弹的X坐标,Y坐标

    Image imgdj = toolkit.getImage("image/dj.gif"); //得到敌机图片对象
    Image imgme = toolkit.getImage("image/main.gif"); //得到我方飞机的图片对象
    boolean gameover = false, djover = false; //是否结束游戏和是否敌机死亡
    boolean fire = false; //是否开火

    public FightFrame() {
        super("雷电游戏");
        this.setBackground(Color.BLACK); //背景颜色
        this.setSize(300, 500); //大小
        this.addKeyListener(this); //键盘监听
        new Thread(this).start(); //启动线程,run()方法单独出来运行
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
    	g.fillRect(0, 0, 300, 500);
    	g.setColor(Color.BLACK);
        if (gameover) { //是否结束游戏,如果为true表示结束,调飞机爆炸的图片
            g.drawImage(toolkit.getImage("image/dj_over.gif"), djx, djy, this);
            g.drawImage(toolkit.getImage("image/me_over.gif"), mex, 450, this);
        } else if (djover) { //是否敌机死亡,如果为true表示敌机死亡,调敌机死亡的图片
            g.drawImage(toolkit.getImage("image/dj_over.gif"), djx, djy, this);
            g.drawImage(imgme, mex, mey, this);
        } else { //否则运行程序,游戏继续进行
            g.drawImage(imgdj, djx, djy, this);
            g.drawImage(imgme, mex, mey, this);
        }
        Font f = new Font("", Font.BOLD, 15); //设置子弹的字体
        g.setFont(f);
        g.setColor(Color.white); //子弹颜色
        if (fire) {
            g.drawString("!", bx, by); //子弹坐标
        }

    }

    /*
     *run()方法是这个小程序的核心部分,线程的启动可以让run()方法
     *里的死循环单独运行,它在不断移动和监控飞机的状态,在条件满足
     *的情况下会改变boolean变量的状态,之后执行this.repaint()方法
     *达到飞机变化的效果
     */
    public void run() {
        while (true) {
            djy += 10;
            if ((djy > 400) && (djy < 480) && (mex < 140) && mex > 40) {
                gameover = true; //游戏结束
            }
            if (djy > 500) {
                djy = 0;
                djx = new Random().nextInt(300); //敌机出现的Y坐标为随机
            }
            by -= 20;

            if (by < (djy + 35) && (bx > djx && bx < (djx + 35))) {
                djover = true; //敌机死亡
            } else if (by < djy) {
                fire = false; //子弹结束的位置不超过敌机的位置
            }
            this.repaint();
            try {
                Thread.sleep(200); //等待200毫移
            } catch (Exception e) {}
            if (gameover || djover) {
                break; //如果游戏结束了,就跳出循环
            }
        }
    }

    /*
     *键盘按下会触发此方法
     */
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 39) { //39表示右键
            mex += 5;
            if (mex > 250) {
                mex = 250;
            }
        } else if (code == 37) { //37表示左键
            mex -= 5;
            if (mex < 10) {
                mex = 10;
            }
        } else if ((code == 38) && (!fire)) { //38表示上键
            bx = mex + 22;
            by = mey;
            fire = true;
        }
    }

    public void keyReleased(KeyEvent parm1) {
        //System.out.println("release");
    }

    public void keyTyped(KeyEvent parm1) {
        //System.out.println("type");
    }
}
