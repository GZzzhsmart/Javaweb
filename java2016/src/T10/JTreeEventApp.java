package T10;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

import java.awt.*;
import java.io.*;
public class JTreeEventApp extends JFrame implements TreeSelectionListener{
	JEditorPane editorPane;
	public JTreeEventApp(){
		super("简单的记事本程序框架");
		 Container contentPane = this.getContentPane();
	        DefaultMutableTreeNode root = new DefaultMutableTreeNode("2007年3月");
	        DefaultMutableTreeNode node = new DefaultMutableTreeNode("2007-03-09.txt");
	        root.add(node);
	        node = new DefaultMutableTreeNode("2007-03-10.txt");
	        root.add(node);
	        node = new DefaultMutableTreeNode("2007-03-11.txt");
	        root.add(node);
	        node = new DefaultMutableTreeNode("2007-03-12.txt");
	        root.add(node);
	        JTree tree = new JTree(root);
	        //设置只能在树中单选
	        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.
	                                                  SINGLE_TREE_SELECTION);
	        //增加选项监听
	        tree.addTreeSelectionListener(this);
	        //将树放到滚动面板中去
	        JScrollPane scrollPanel = new JScrollPane(tree);
	        //富文本框
	        editorPane = new JEditorPane();
	        //将编辑面板放到滚动面板中去
	        JScrollPane scrollPane2 = new JScrollPane(editorPane);
	        //实例化一个以左右分割的面板，分别放两个滚动面板
	        //分割面板JSplitPane
	        
	        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,
	                                              scrollPanel, scrollPane2);
	        contentPane.add(splitPane);
	        this.pack();
	        this.setVisible(true);
	        this.show();
	    }

	    //实现对应的监听方法
	    public void valueChanged(TreeSelectionEvent e) {
	        JTree tree = (JTree) e.getSource();
	        //获取选中的选项
	        DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) tree.
	                                               getLastSelectedPathComponent();
	        //获取选项中的内容
	        String nodeName = selectionNode.toString();
	        //判断选中的节点是不是叶节点isLeaf()
	        //获取系统属性,应用程序的当前路径:System.getProperty("user.dir")
	        //获取分隔符System.getProperty("file.separator")
	        if (selectionNode.isLeaf()) {
	            String filepath = "file:" + System.getProperty("user.dir") +
	                              System.getProperty("file.separator") + nodeName;
	            System.out.println("filepath-->" + filepath);
	            try {
	            	//清空文本面板的值
	            	editorPane.setText("");
	            	//想文本面板中打开该文件，并显示内容到文本面板中
	                editorPane.setPage(filepath);
	                
	            } catch (IOException ie) {
	                System.out.println("找不到此文件！");
	            }
	        }
	    }

	    public static void main(String[] args) {
	        new JTreeEventApp();
	    }
	
}
