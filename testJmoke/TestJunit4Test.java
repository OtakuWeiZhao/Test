package testJmoke;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author OTakuWeiZhao
 *
 */
//测试类继承了TestCase
public class TestJunit4Test extends TestCase {
	// Junit4Mockery继承Mockery
	//创建了Mockery对象context
	private Mockery context = new JUnit4Mockery();
	private IMathfun math = null;

	private TestJunit4test test = null;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		// mock IMathfun类, mock接口实例
		math = context.mock(IMathfun.class);
		test = new TestJunit4(math);
		context.checking(new Expectations() {
			{
				//对应的方法
				//给定数值-10, 直接返回10
				exactly(1).of(math).abs(-10);
				will(returnValue(10));
			}
		});
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void test() {
		assertEquals(100, test.cal(-10));
	}
}
