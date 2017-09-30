package T6Sj;
import java.awt.*;
public class FrameApp extends Frame{
	Button button1 = new Button("按钮1");
	Button button2 = new Button("按钮2");
	Panel panel = new Panel();
	public FrameApp(){
		super();
		this.setSize(180,160);
		this.setBackground(Color.BLUE);
		panel.add(button1);
		panel.add(button2);
		this.add(panel);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new FrameApp();
	}
}
