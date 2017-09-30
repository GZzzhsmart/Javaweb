package T13;

import com.sun.org.apache.xerces.internal.parsers.CachingParserPool.SynchronizedGrammarPool;

/**
 * 死锁问题
 * */

class A {
	synchronized void foo(B b) {
		String name = Thread.currentThread().getName();
		System.out.println(name+"entered A.foo");
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(name+"trying to call B.last()");
		b.last();
	}
	synchronized void last() {
		System.out.println("inside A.last");
	}
}

class B{
	synchronized void bar(A a) {
		String name = Thread.currentThread().getName();
		System.out.println(name + "entered B.bar");
		
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		System.out.println(name + "trying to call A.last()");
		a.last();
	}
	
	synchronized void last() {
		System.out.println("inside A.last");
	}
	
}
public class DeadLock implements Runnable{
	A a = new A();
	B b = new B();
	
	DeadLock(){
		Thread.currentThread().setName("MainThread");
		new Thread(this).start();
		a.foo(b);//get lock on in this thread.
		System.out.println("back in other thread");
	}
	
	public void run(){
		Thread.currentThread().setName("RacingThread");
		b.bar(a);//get lock on in other thread
		System.out.println("back in other thread");
	}
	public static void main(String[] args) {
		new DeadLock();
	}
}
