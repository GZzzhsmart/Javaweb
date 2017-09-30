package T10;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
public class JTreeApp2 extends JFrame{
	public JTreeApp2(){
		this.setTitle("JTree演示");
		this.getContentPane().setLayout(new BorderLayout());
		//创建根结点
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("我的公文包");
		//创建一级子目录
		DefaultMutableTreeNode dir1 = new DefaultMutableTreeNode("学校管理资料");
		DefaultMutableTreeNode dir2 = new DefaultMutableTreeNode("备课文件");
		DefaultMutableTreeNode dir3 = new DefaultMutableTreeNode("私人文件");
		//将一级子目录加到根结点中
		root.add(dir1);
		root.add(dir2);
		root.add(dir3);
		//创建dir1的一级子目录
		DefaultMutableTreeNode dir1_f1 = new DefaultMutableTreeNode("会议记录");
		DefaultMutableTreeNode dir1_f2 = new DefaultMutableTreeNode("教学大纲");
		//将dir1的一级子目录加到dir1结点中去
		dir1.add(dir1_f1);
		
		dir1.add(dir1_f2);
		//创建dir2的一级子目录
		DefaultMutableTreeNode dir2_f1 = new DefaultMutableTreeNode("java课件");
		DefaultMutableTreeNode dir2_f2 =  new DefaultMutableTreeNode("java数据结构课件");
		DefaultMutableTreeNode dir2_f3 = new DefaultMutableTreeNode("jsp课件");
		//将dir2的一级子目录加到dir2的结点中去
		dir2.add(dir2_f1);
		dir2.add(dir2_f2);
		dir2.add(dir2_f3);
		//创建dir3的一级子目录
		DefaultMutableTreeNode dir3_f1 = new DefaultMutableTreeNode("我的音乐");
		DefaultMutableTreeNode dir3_f2 = new DefaultMutableTreeNode("我的视频");
		//将dir3的一级子目录加到dir3的结点中去
		dir3.add(dir3_f1);
		dir3.add(dir3_f2);
		//以根结点为主创建树
		JTree jTree1 = new JTree(root);
		getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jTree1);
		this.setSize(200,200);
		this.show();
	}
	public static void main(String[] args) {
		new JTreeApp2();
	}
}
