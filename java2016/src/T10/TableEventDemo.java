package T10;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import T10.TableDemo.MyTableModel;

import java.awt.*;
public class TableEventDemo extends JFrame implements TableModelListener{
	JTable table = null;
	 MyTableModel myModel = null;
	 JLabel label = null; //用于显示修改的字段位置
	 public TableEventDemo(){
		 super();
	        myModel = new MyTableModel();
	        myModel.addTableModelListener(this);
	        table = new JTable(myModel);
	        //实例化一个列表框
	        JComboBox c = new JComboBox();
	        c.addItem("襄城");
	        c.addItem("樊城");
	        //设置表格第二列的值通过列表框选值
	        table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(
	                c));
	        //设置表格的默认显示大小
	        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
	        //将该表格放到一个滚动面板中去
	        JScrollPane scrollPane = new JScrollPane(table);
	        label = new JLabel("修改字段位置：");
	        //将该滚动面板再加入到内容面板中去
	        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
	        this.getContentPane().add(label, BorderLayout.SOUTH);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.pack();
	        this.setVisible(true);

	 }
	
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        label.setText("修改字段位置：" + (row + 1) + " 行 " + (column + 1) + " 列");
        int yuwen = ((Integer)(myModel.getValueAt(row,2))).intValue();
        int shuxue = ((Integer)(myModel.getValueAt(row,3))).intValue();
        if(yuwen>=60 && shuxue>=60){
           myModel.mySetValueAt(new Boolean(true),row,4);
        }else{
           myModel.mySetValueAt(new Boolean(false),row,4);
        }
        table.repaint();
    }

    //内部类实现抽象的TableModel，并改写必要的方法
    class MyTableModel extends AbstractTableModel {
        private String[] columnNames = {"姓名", "居住地", "语文", "数学", "及格"};
        private Object[][] data = {
          {"笨笨", "襄城", new Integer(72),  new Integer(62), new Boolean(true)},
          {"张山", "襄城", new Integer(63), new Integer(82),  new Boolean(true)},
          {"李飞", "襄城", new Integer(62), new Integer(72), new Boolean(true)},
          {"关羽", "襄城", new Integer(61), new Integer(52), new Boolean(false)},
          {"大雄", "襄城", new Integer(74), new Integer(72), new Boolean(true)},
          {"萧萧", "襄城", new Integer(43), new Integer(82), new Boolean(false)}
        };
        //得到表格列长度
        public int getColumnCount() {
            return columnNames.length;
        }

        //得到表格行数
        public int getRowCount() {
            return data.length;
        }

        //得到表格列名
        public String getColumnName(int col) {
            System.out.println(" 该列的列名为：" + columnNames[col]);
            return columnNames[col];
        }

        //得到指定单元的值
        public Object getValueAt(int row, int col) {
            System.out.println(" 该单元的值为data[" + row + "][" + col + "] ：" +
                               data[row][col]);
            return data[row][col];
        }

        //返回指定列的数据类型
        public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        //设置单元格是否可修改
        public boolean isCellEditable(int row, int col) {
            if(col>0){
                return true;
            }
            return false;
        }

        //设置单元格的值
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
        public void mySetValueAt(Object value, int row, int col) {
            data[row][col] = value;
        }
    }


    //让该表格在线程安全模式下运行
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TableEventDemo();
            }
        });
    }
}
