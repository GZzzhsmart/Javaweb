package T10sj;
//运用JTree对象编写通讯录，并实现添加，删除节点的功能
import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI.SelectionModelPropertyChangeHandler;
import javax.swing.tree.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.EventListener;
import javax.swing.event.TreeModelListener;

import com.sun.org.apache.xerces.internal.dom.ParentNode;
public class JTreeEventApp extends JFrame implements ActionListener{
	private static final Component SelectionNode = null;
	JTree tree = null;
	DefaultTreeModel treeModel = null;
	public JTreeEventApp(){
		super("JTree事件示例");
		this.addItem();
		this.pack();
		this.setVisible(true);
	}
	private void addItem() {
		Container cn = this.getContentPane();
		cn.setLayout(new BorderLayout());
		//通过DefaultMutableTreeNode创建初始化的联系人
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("同学通讯录");
		DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("大学同学");
		DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("研究生同学");
		DefaultMutableTreeNode  t1_1 = new DefaultMutableTreeNode("小杨");
		DefaultMutableTreeNode t1_2 = new DefaultMutableTreeNode("小刚");
		DefaultMutableTreeNode t1_3 = new DefaultMutableTreeNode("小张");
		//将上面创建的结点按照父子关系进行设置，切记结点不能掉链
		root.add(t1);
		root.add(t2);
		t1.add(t1_1);
		t1.add(t1_2);
		t1.add(t1_3);
		//根据根结点创建一个数
		tree = new JTree(root);
		//得到treeMode1以便对结点动态进行添加删除
        DefaultTreeModel treeModel1 = (DefaultTreeModel) tree.getModel();
        JPanel panel = new JPanel();
        JButton button1 = new JButton("添加");
        JButton button2 = new JButton("删除");
        //给添加删除按钮添加时间监听
        button1.addActionListener(this);
        button2.addActionListener(this);
        panel.add(button1);
        panel.add(button2);
        cn.add(new JScrollPane(tree),BorderLayout.CENTER);
        cn.add(panel,BorderLayout.NORTH);
	}
	//添加按钮事件
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("添加")){
			//通过弹出对话框得到要添加的联系人的姓名
			String str = JOptionPane.showInputDialog(this,"输入结点名称:");
			if(str!=null){
				DefaultMutableTreeNode parenTreeNode=null;
				//根据联系人姓名来创建名称
				DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(str);
				//设置允许该结点拥有孩子结点，以便使其添加孩子结点
				newNode.setAllowsChildren(true);
				//得到选种父结点的路径
				TreePath parentPath =tree.getSelectionPath();
				//得到选种父结点中的路径最后一个孩子的结点，该结点就是我们选的父亲结点
				DefaultMutableTreeNode ParentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
				//该treeModel添加一个新结点，并且指定该结点中的父亲结点
				treeModel.insertNodeInto(newNode, ParentNode, ParentNode.getChildCount());
				tree.scrollPathToVisible(new TreePath(newNode.getPath()));
			}
		}
		if(e.getActionCommand().equals("删除")){
			TreePath treePath = tree.getSelectionPath();
			if(treePath!=null){
				//得到选种的要删除的结点
				DefaultMutableTreeNode selecTreeNode=(DefaultMutableTreeNode) treePath.getLastPathComponent();
				TreeNode parent = (TreeNode) SelectionNode.getParent();
				if(parent!=null){
					//删除指定的结点
					treeModel.removeNodeFromParent((MutableTreeNode) SelectionNode);
					//重新架加载结点
					treeModel.reload();
				}
			}
		}
	}
	public static void main(String[] args) {
		new JTreeEventApp();
	}
}
