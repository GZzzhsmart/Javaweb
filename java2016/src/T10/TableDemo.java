package T10;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.table.JTableHeader;

public class TableDemo extends JFrame {
	public TableDemo() {
		super("表格例子");
		// 设置该面板为网格布局
		this.getContentPane().setLayout(new GridLayout(1, 0));
		// 使用改写后的tableModel类来创建一个表格
		JTable table = new JTable(new MyTableModel());
		// 设置单元格选种为真
		table.setCellSelectionEnabled(true);

		JTableHeader th = table.getTableHeader();
		th.setReorderingAllowed(false);

		// table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		// 设置表格的默认显示大小
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		// 将该表格放到一个滚动面板中去
		JScrollPane scrollPane = new JScrollPane(table);
		// 将该滚动面板再加入到内容面板中去
		this.add(scrollPane);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	// 内部类实现抽象的TableModel，并改写必要的方法
	public class MyTableModel extends AbstractTableModel {
		private String[] columnNames = { "姓名", "年龄", "成绩", "作弊" };
		private Object[][] data = {
				{ "笨笨", new Integer(12), "85", new Boolean(false) },
				{ "张山", new Integer(13), "70", new Boolean(true) },
				{ "李飞", new Integer(12), "75", new Boolean(false) },
				{ "关羽", new Integer(11), "60", new Boolean(true) },
				{ "大雄", new Integer(14), "50", new Boolean(false) },
				{ "萧萧", new Integer(13), "83", new Boolean(false) } };

		// 得到表格列长度
		public int getColumnCount() {
			return columnNames.length;
		}

		// 得到表格行数
		public int getRowCount() {
			return data.length;
		}

		// 得到表格列名
		public String getColumnName(int col) {
			System.out.println(" 该列的列名为：" + columnNames[col]);
			return columnNames[col];
		}

		// 得到指定单元的值
		public Object getValueAt(int row, int col) {
			System.out.println(" 该单元的值为data[" + row + "][" + col + "] ："
					+ data[row][col]);
			return data[row][col];
		}

		// 返回指定列的数据类型
		public Class getColumnClass(int c) {
			return getValueAt(0, c).getClass();
		}

		// 设置单元格是否可修改
		public boolean isCellEditable(int row, int col) {
			if (col < 2) {
				return false;
			} else {
				return true;
			}
		}

		// 设置单元格的值
		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
		}
	}

	// 让该表格在线程安全模式下运行
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TableDemo();
			}
		});
	}
}
