package testDate;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Test;

public class TestCase {
//	@Test
//	public void testGetDate(){
//		Date myDate = new Date();
//		myDate.getTime();
//		System.out.println(myDate);
//		long time = myDate.getTime();
//		System.out.println(time);
//	}
	/**modify*/
	Date myDate = new Date(1484374829);
	@Test
	public void timeStamp(){
		myDate.getTime();
		System.out.println(myDate);
		Timestamp ts = new Timestamp(1484374829);
		System.out.println(ts);
		ts.setNanos(82900);
		int myTimeStamp = ts.getNanos();
		System.out.println(myTimeStamp);
		String myTimeStamp2 = String.valueOf(myTimeStamp);
		System.out.println(myTimeStamp2);
	}
}
