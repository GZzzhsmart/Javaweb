package T5Sj;
/*.抽象类、继承、接口综合 设计一个系统： xxx纯净水生产线 
目前流程是：从某个地方把水取出来，然后经过缓冲，过滤，加热和放糖的步骤 
abstract 水{ 
 public void 水(); } 
interface 过滤{} interface 缓冲{} interface 加热{} interface 放糖{}  
class 纯净水1 extends 水 imps 过滤,缓冲{} class 纯净水2 extends 水 imps 缓冲{}
 class 纯净水2 extends 水 imps 过滤{} 
。。。。 

 * 
 * */
public abstract class Water {
	public abstract void Water();
	public interface Filter{
		public abstract void Filter();
	}
	public interface Buffer{
		public abstract void Buffer();
	}
	public interface Heat{
		public abstract void Heat();
	}
	public interface Suger{
		public abstract void Suger();
	}
}

