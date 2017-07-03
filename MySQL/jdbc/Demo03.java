package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 删除数据
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			String sql = "DELETE FROM test01_02 WHERE name = 'Nero'";
			int n = st.executeUpdate(sql);
			System.out.println("删除了" + n + "行");
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
