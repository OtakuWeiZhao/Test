package zhao;

public class HelloB extends HelloA {
	public HelloB() {
		System.out.println("HelloB");
	}

	{
		System.out.println("I'm B class");
	}
	static {
		System.out.println("static B");
	}
	public static void main(String[] args) {
		System.out.println("main start");
		new HelloB();
		System.out.println("main end");
	}
}
/**
static A
static B
main start
I'am A class
HelloA
I'm B class
HelloB
main end
对象初始化顺序：
(1)类加载之后,按从上到下(从父类到子类执行被static修饰的语句;
(2)当static语句执行完毕之后,再执行main方法;
(3)如果有语句new了自身的对象,将从上到下执行构造代码块,构造器(两者可以说绑定在一起).
 * 
 * */