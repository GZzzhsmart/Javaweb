package T6;
import java.awt.Frame;
public class FrameDemo extends Frame{
	public FrameDemo(){
		super("Frame窗口程序演示");
		this.setSize(500,400);
		this.setVisible(true);
		
	}
	public static void main(String[] args){
		new FrameDemo();
	}
}
