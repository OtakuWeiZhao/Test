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
�����ʼ��˳��
(1)�����֮��,�����ϵ���(�Ӹ��ൽ����ִ�б�static���ε����;
(2)��static���ִ�����֮��,��ִ��main����;
(3)��������new������Ķ���,�����ϵ���ִ�й�������,������(���߿���˵����һ��).
 * 
 * */