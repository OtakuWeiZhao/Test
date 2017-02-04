package testJmoke;

/**
 * @author OTakuWeiZhao
 *
 */
public class TestJunit4 {
	private IMathfun util;
	public TestJunit4(IMathfun util){
		this.util = util;
	}
	//该方法需要调用IMathfun接口中的abs方法
	//通过Mock IMathfun实例及方法来切断对其依赖性
	public int cal(int num){
		return 10 * util.ass(num);
	}
}
