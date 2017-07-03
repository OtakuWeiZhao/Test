package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class TestCase {
	@Test
	public void testInsert() {
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
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testUpdate() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			String sql = "UPDATE test01_02 SET name = 'VERGEL' WHERE name = 'jack'";
			int n = st.executeUpdate(sql);
			System.out.println(n + "行已更新");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testSelect() {
		String sql = "SELECT name, age, address FROM test01_02";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			/*
			 * 执行DQL语句使用 st.executeQuery(sql) 方法返回ResultSet对象
			 */
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				// 移动结果集的每一行
				// getXXX(列名) 用于获取当前行的数据
				String name = rs.getString("name");
				// String name = rs.getString(1);
				int age = rs.getInt("age");
				// int age = rs.getInt(2);
				String address = rs.getString("address");
				System.out.println("查询到名字为:" + name + " ,年龄为:" + age + ",住址为:" + address);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void testSave() {
		Person p = new Person("Kyouko", 25, "SandGlass");
		save(p);
		System.out.println("保存完成");
	}

	public void save(Person person) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			String sql = "INSERT INTO test01_02(name, age, address) VALUES('" + person.getName() + "',"
					+ person.getAge() + ",'" + person.getAddress() + "')";
			int n = st.executeUpdate(sql);
			System.out.println("插入了" + n + "行");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询到名字为:Kyouko, 年龄:25, 住址:SandGlass
	 */
	@Test
	public void testFindByName() {
		Person p = findByName("Kyouko");
		System.out.println(p);
	}

	public Person findByName(String name) {
		String sql = "SELECT name, age, address FROM test01_02 WHERE name = '" + name + "'";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/test01";
			String user = "root";
			String pwd = "root";
			conn = DriverManager.getConnection(url, user, pwd);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			Person person = new Person();
			while (rs.next()) {
				int age = rs.getInt("age");
				String address = rs.getString("address");
				person.setName(name);
				person.setAge(age);
				person.setAddress(address);
			}
			return person;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
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
		return null;
	}
}
