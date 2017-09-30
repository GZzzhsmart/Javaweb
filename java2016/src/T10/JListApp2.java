package T10;

import javax.swing.*;
import java.util.Vector;
import java.awt.GridLayout;

public class JListApp2 extends JFrame {

    public JListApp2() {
        this.setTitle("JList AstractListModel演示");
        getContentPane().setLayout(new GridLayout(1, 2));
        //通过数组创建列表
        JList jList1 = new JList(new DataModel());
        //只允许单选
        jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList1.setBorder(BorderFactory.createTitledBorder("你最喜欢那个人物？"));
        //设置list初始化状态下一次能看5个选项
        jList1.setVisibleRowCount(5);
        //将下拉列表分别放到一个滚动面板里面
        this.getContentPane().add(new JScrollPane(jList1));
        this.pack();
        this.show();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JListApp2();
    }
}
class DataModel extends AbstractListModel {
    String[] s1 = {"乔丹", "刘翔", "科比", "姚明", "流川风", "大空翼", "其他"};
    //下标从0开始计算
    public Object getElementAt(int index) {
        Object objValue=(index + 1) + "." + s1[index++];
        System.out.println(objValue);
        return objValue;
    }

    public int getSize() {
        return s1.length;
    }
}
