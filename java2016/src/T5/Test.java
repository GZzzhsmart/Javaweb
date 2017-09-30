package T5;

public class Test {
	public static void main(String[] args){
		AbstractClass abs1 = new SubClass(10,20);
		SubClass sub = new SubClass(30,40);
		abs1.display();
		sub.display();
		Animal tiger = new Tiger();
		Animal cat = new Cat();
		Animal dog = new Dog();
		Dog dog1 = new Dog();
		Test test = new Test();
		test.display(tiger);
		test.display(cat);
		test.display(dog);
		test.display(dog1);
	}
	public void display(Animal animal){
		if(animal instanceof Dog){
			Dog dog = (Dog)animal;
			dog.sport();
		}
		animal.eat();
	}
}
