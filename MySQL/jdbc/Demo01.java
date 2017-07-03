package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接数据库
 */
public class Demo01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 使用JDBC
		// 1 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		/*
		 * 2 建立连接
		 * Connection 接口, 来自java.sql 实现类来自MySQL驱动
		 */
		String url = "jdbc:mysql://localhost:3306/test01";
		String user = "root";
		String pwd = "root";
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println(conn.getClass().getName());
		conn.close();
	}
}
