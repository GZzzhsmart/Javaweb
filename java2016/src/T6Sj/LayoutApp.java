package T6Sj;
import java.awt.*;
public class LayoutApp extends Frame{
	Panel p1 = new Panel();
	Panel p2 = new Panel();
	Panel p3 = new Panel();
	
	Label label1 = new Label("变量名(N)");
	Label label2 = new Label("变量名(V)");
	Label label3 = new Label("            ");
	TextField text1 = new TextField("TEMP",18);
	TextField text2 = new TextField("%USERPROFILE%\\Local Settings\\Temp",18);
	
	Button submit = new Button("确定");
	Button cancel = new Button("取消");
	public LayoutApp(){
		super();
		this.setLayout(new GridLayout(3,2));
		p1.add(label1);
		p1.add(text1);
		p2.add(label2);
		p2.add(text2);

		p3.add(label3);
		p3.add(submit);
		p3.add(cancel);
		
		this.add(p1);
		this.add(p2);
		this.add(p3);
		this.setSize(240,130);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new LayoutApp();
	}
}
