package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 添加数据
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			String sql = "INSERT INTO test01_02(name, age, address) VALUES('Nero', 17, 'DMC')";
			int n = st.executeUpdate(sql);
			System.out.println("插入了" + n + "行");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
