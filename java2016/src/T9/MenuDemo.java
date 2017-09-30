package T9;

import java.awt.Color;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.Popup;
public class MenuDemo extends JFrame implements ActionListener,MouseListener{
	
	//菜单条JMenuBar,子菜单JMenu,菜单项JMenuItem
	JMenuBar menuBar;
	JMenu mnuFile,mnuEdit;
	JMenuItem itemNew,itemOpen,itemSave,itemExit;
	JMenuItem itemCut,itemCopy,itemPaste;
	//弹出菜单
	JPopupMenu popup;
	JMenuItem itemColor,itemFont;
	
	public MenuDemo() {
		//创建菜单项
		itemNew = new JMenuItem("新增");
		itemOpen = new JMenuItem("打开");
		itemSave = new JMenuItem("保存");
		itemExit = new JMenuItem("退出");
		itemNew.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemExit.addActionListener(this);
		Icon icon = new ImageIcon("images/white.gif");
		itemCut = new JMenuItem("剪切",icon);
		itemCopy = new JMenuItem("拷贝");
		itemPaste = new JMenuItem("粘贴");
		itemPaste.setEnabled(false);
		mnuEdit = new JMenu("编辑(E)");
		mnuEdit.setMnemonic('E');
		mnuEdit.add(itemCut);
		mnuEdit.add(itemCopy);
		mnuEdit.add(itemPaste);
		
		//创建子菜单
		mnuFile = new JMenu("文件(F)");
		mnuFile.setMnemonic('F');
		//把菜单项加到子菜单;
		mnuFile.add(itemNew);
		mnuFile.add(itemOpen);
		mnuFile.add(itemSave);
		//分隔条
		mnuFile.addSeparator();
		mnuFile.add(itemExit);
		//创建菜单条
		menuBar = new JMenuBar();
		//添加子菜单
		menuBar.add(mnuFile);
		menuBar.add(mnuEdit);
		
		//把菜单条放到窗口
		setJMenuBar(menuBar);
		
		
		//弹出菜单
		popup = new JPopupMenu();
		itemColor = new JMenuItem("选择颜色");
		itemFont = new JMenuItem("选择字体");
		popup.add(itemColor);
		popup.add(itemFont);
		itemColor.addActionListener(this);
		itemFont.addActionListener(this);
		addMouseListener(this);
		
		setSize(500, 500);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new MenuDemo();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== itemNew){
			//确认框
//			JOptionPane.showMessageDialog(this,"显示的内容", "确认框",JOptionPane.QUESTION_MESSAGE);
			//选择对话框
			/*OK_CANCEL_OPTION,2个按钮，确定，取消
			 * YES_NO_CANCEL_OPTION,3个按钮，是，否，取消
			 * 
			 * */
			if(JOptionPane.showConfirmDialog(this, "删除确定","选择对话框",JOptionPane.YES_NO_CANCEL_OPTION)==JOptionPane.OK_OPTION){
				JOptionPane.showMessageDialog(this,"您点击的是确定按钮");
			}else{
				JOptionPane.showMessageDialog(this,"您点击的是取消按钮");
			}
			//输入对话框
			String str = JOptionPane.showInputDialog("请输入内容");
			JOptionPane.showMessageDialog(this,"你输入的内容是："+str);
		}else if(e.getSource()== itemOpen){
			//文件对话框
			System.out.println("open");
			JFileChooser dlgopen = new JFileChooser();
			dlgopen.showSaveDialog(this);
		}else if(e.getSource()== itemSave){
			
		}else if(e.getSource()== itemExit){
			System.exit(0);
		}else if(e.getSource()==itemColor){
			System.out.println("颜色对话框");
			//颜色对话框
			JColorChooser dlgcolor = new JColorChooser();
//			dlgcolor.show();
			Color color= dlgcolor.showDialog(this, "颜色对话框", Color.RED);
			System.out.println(color);
			setBackground(color);
		}else if(e.getSource()==itemFont){
			
		}
		
	}
	//单击事件
	public void mouseClicked(MouseEvent e) {
		//右键
		if(e.getButton()==3){
			popup.show(this, e.getX(), e.getY());
		}
	}
	public void mouseEntered(MouseEvent e) {
		
		
	}
	public void mouseExited(MouseEvent e) {
		
		
	}
	public void mousePressed(MouseEvent e) {
		
		
	}
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
}
