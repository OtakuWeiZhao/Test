package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSql {
	public static void main(String[] args) {
		String sql = "SELECT name, age FROM test01_01";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			/*
			 * 执行DQL语句使用 st.executeQuery(sql)
			 * 方法返回ResultSet对象
			 */
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()){
				//移动结果集的每一行
				//getXXX(列名) 用于获取当前行的数据
				String name = rs.getString("name");
//				String name = rs.getString(1);
				int age = rs.getInt("age");
//				int age = rs.getInt(2);
				System.out.println("查询到名字为:" + name + " ,年龄为:" + age);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
