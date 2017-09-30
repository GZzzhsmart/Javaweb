package T15;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class UserListUI extends JFrame implements ActionListener{

	JLabel lblTitle,lblUserName,lblqqCode;
	JTextField txtUserName,txtqqCode;
	JComboBox cbSex;
	JButton btnFind;
	JTable dataTable;
	Vector<String> columnsName;
	Vector rowsData;
	public UserListUI(){
		super("用户资料查找");;
		lblTitle = new JLabel("请输入查询条件：",JLabel.RIGHT);
		lblUserName = new JLabel("用户名称：",JLabel.RIGHT);
		lblqqCode = new JLabel("用户QQ",JLabel.RIGHT);
		txtUserName = new JTextField(10);
		cbSex = new JComboBox(new String []{"男","女"});
		txtqqCode = new JTextField(10);
		btnFind = new JButton("查找(F)");
		btnFind.setMnemonic('F');
		btnFind.addActionListener(this);
		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(lblTitle);
		topPanel.add(cbSex);
		topPanel.add(lblUserName);
		topPanel.add(txtUserName);
		topPanel.add(lblqqCode);
		topPanel.add(txtqqCode);
		topPanel.add(btnFind);
		add(topPanel,BorderLayout.NORTH);
		
		//设置表头
		addHead();
		//获取数据
		rowsData =  new UserDaoImpl().find("", "", "");
		MyTableModel model = new MyTableModel(columnsName,rowsData);
		dataTable = new JTable(model);
		//设置行高
		dataTable.setRowHeight(30);
		add(new JScrollPane(dataTable));
		setSize(650,500);
		setVisible(true);
		setLocationRelativeTo(null);
		//关闭窗口，但程序还能运行
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new UserListUI();
	}
	private void addHead() {
		columnsName = new Vector<String>();
		columnsName.addElement("用户编号");
		columnsName.addElement("用户名称");
		columnsName.addElement("登录密码");
		columnsName.addElement("性别");
		columnsName.addElement("年龄");
		columnsName.addElement("身份证号");
		columnsName.addElement("QQ号码");
		columnsName.addElement("邮箱地址");
		columnsName.addElement("备注");
		
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnFind){
			String sex = cbSex.getSelectedItem().toString();
			String userName = txtUserName.getText().trim();
			String qqCode = txtqqCode.getText().trim();
			//查找符合条件的用户资料
			rowsData =  new UserDaoImpl().find(userName,sex,qqCode);
			//更新表格的数据
			MyTableModel model = new MyTableModel(columnsName,rowsData);
			dataTable.setModel(model);
		}
		
	}
	//内部类实现抽象的TableModel，并改写必要的方法
	class MyTableModel extends AbstractTableModel{
		//表头的标题
		private Vector<String> columnNames;
		//表格中显示的记录
		private Vector data;
		
		
		public MyTableModel(Vector<String> columnNames,Vector data) {
			this.columnNames = columnNames;
			this.data = data;
		}
		//得到表格列长度
		 public int getColumnCount() {
	            return columnNames.size();
	        }
	       //得到表格行数
	        public int getRowCount() {
	            return data.size();
	        }
	       //得到表格列名
	        public String getColumnName(int col) {
	            System.out.println(" 该列的列名为："+columnNames.get(col));
	            return columnNames.get(col);
	        }
	       //得到指定单元的值
	        public Object getValueAt(int row, int col) {
	        	//获取row这一行的数据
	        	Vector v = (Vector)data.get(row);
	        	Object obj = v.get(col);
	            System.out.println(" 该单元的值为data["+row+"]["+col+"] ："+obj);
	            return obj;
	        }
	        //返回指定列的数据类型，不需要调用
	        public Class getColumnClass(int c) {
	            return getValueAt(0, c).getClass();
	        }
	       //设置单元格是否可修改,系统自动执行
	        public boolean isCellEditable(int row, int col) {
	            if (col < 2) {
	                return false; //不能修改
	            } else {
	                return true; //可以修改
	            }
	        }
	        //设置单元格的值,不需要调用，系统自动赋值
	        public void setValueAt(Object value, int row, int col) {

	            //更新界面
	            fireTableCellUpdated(row, col);
	        }
	    }




	}
