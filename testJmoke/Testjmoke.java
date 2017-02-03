package testJmoke;

import static org.junit.Assert.assertEquals;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Test;

/**
 * @author OtakuWeiZhao
 *
 */
public class Testjmoke {
	@Test
	/**
	 * 测试接口mock
	 */
	public void t1(){
		Mockery context = new JUnit4Mockery();
		final TestInterface testInterface = context.mock(TestInterface.class);
		context.checking(new Expectations(){
			{
				oneOf(testInterface).t1();
				will(returnValue("owz"));
			}
		});
		assertEquals("owz",testInterface.t1());
	}
	@Test
	/**
	 * 测试类mock
	 * */
	public void t12(){
		Mockery context = new JUnit4Mockery(){{
			setImposteriser(ClassImposteriser.INSTANCE);
		}};
		final TestClass testClass = context.mock(TestClass.class);
		context.checking(new Expectations(){
			{
				oneOf(testClass).get();
				will(returnValue("owz"));
			}
		});
		assertEquals("owz",testClass.get());
	}
}
