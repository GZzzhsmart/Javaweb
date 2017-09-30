import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

@SuppressWarnings("serial")
public class ClockApp extends Applet{
	private String lastTime="";
	public void init(){
		setBackground(Color.black);
	}	
	public void paint(Graphics g){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar today=Calendar.getInstance();
		String time=format.format(today.getTime());
		g.setColor(Color.red);
		g.drawString(lastTime,20,20);
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			
		}
		lastTime=time;
		repaint();
	}	
	public void start(){}	
	public void stop(){}
}