package T8sj;
import java.awt.*;
public class Books extends Frame{
	public Books(){
		super("加载图片");
		this.setSize(200,200);
		this.show();
	}
	public void paint(Graphics g){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = toolkit.getImage("images/books.gif");
		g.drawImage(image,0,20,this);
		
	}
	public static void main(String[] args) {
		new Books();
	}
}
