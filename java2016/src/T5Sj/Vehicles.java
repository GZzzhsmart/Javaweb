package T5Sj;
/*创建一个Vehicle类并将它声明为抽象类。
 * 在Vehicle类中声明一个NoOfWheels方法，使它返回一个字符串值。
 * 创建两个类Car和Motorbike从Vehicle类继承，并在这两个类中实现NoOfWheels方法。
 * 在Car类中，应当显示“四轮车”信息；而在Motorbike类中，应当显示“双轮车”信息。
 * 创建另一个带main方法的类，在该类中创建Car和Motorbike的实例，并在控制台中显示消息。          
 * 
 * */
public abstract class Vehicles {
	public abstract String NoofWheels();
}
