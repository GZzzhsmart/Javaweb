package T7;
import java.awt.*;
public class Example {
	public static void main(String[] args){
		Frame fr = new Frame("媒体新闻");
		fr.setLayout(new FlowLayout());
		Button button1 = new Button("确定");
		Button button2 = new Button("取消");
		fr.add(button1);
		fr.add(button2);
		fr.setSize(200,300);
		fr.setBackground(Color.cyan);
		fr.setVisible(true);
		fr.validate();
	}
}
