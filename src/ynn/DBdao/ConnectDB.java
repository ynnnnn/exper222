package ynn.DBdao;

import java.sql.*;


public class ConnectDB {
	//static String driver="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/test001";
	static String user="root";
	static String password="root";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// 1.
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("驱动连接成功！\n");
		// 2. 
		Connection conn=DriverManager.getConnection(url,user,password);
		System.out.println("数据库连接成功!\n");
		return conn;
		
		
	}
	
	public static void closeAll(Connection connection, PreparedStatement statement) {
		try {
			if(statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(connection, statement);
		}
	}
}
