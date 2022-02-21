package ynn.DBdao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ynn.DBdao.ConnectDB;
import ynn.object.*;

public class DBManage {
	String driver="com.mysql.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/test001";
	static String user="root";
	static String password="root";
	
	
	public static boolean validateReg(User user) throws ClassNotFoundException, SQLException {
		Connection conn=ConnectDB.getConnection();
		System.out.print("regesiter\n");
		String sql="select * from users where username=?;";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		ResultSet resultSet=statement.executeQuery();
		if(resultSet.next()){
			System.out.print("֤ validate unsuccessfully!\n");
			ConnectDB.closeAll(conn, statement,resultSet);
			return true;
		}
		else
		{
			ConnectDB.closeAll(conn, statement,resultSet);
			System.out.print("regesiter validate successful……\n");
			return false;
		}
		
		
	}//ͨvalidate user yes or no?yes——can't regesiter
	
	
	public static boolean Insertone(User user) throws ClassNotFoundException, SQLException{
		Connection conn=ConnectDB.getConnection();
		String sql="insert into users(username,password,flag) value (?,?,?);";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, user.getUsername());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getFlag());
		int i = statement.executeUpdate();
		if(i!=0){
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert successfully!\n");
			return true;
		}
		else{
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert unsuccessfully\n");
			return false;
		}
		
	}//insert user——regesiter and userinsert
	
	
	
	public static boolean InsertWord(String sender,String receiver,String content) throws ClassNotFoundException, SQLException{
		Connection conn=ConnectDB.getConnection();
		
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);//获取格式化的时间
		
		String sql="insert into word(time,sender,receiver,content) value (?,?,?,?);";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, time);
		statement.setString(2, sender);
		statement.setString(3, receiver);
		statement.setString(4, content);
		int i = statement.executeUpdate();
		if(i!=0){
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert successfully!\n");
			return true;
		}
		else{
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert unsuccessfully\n");
			return false;
		}
		
	}//插入留言进入表word
	
	
	public static boolean InsertMood(String username,String content) throws ClassNotFoundException, SQLException{
		Connection conn=ConnectDB.getConnection();
		
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);//获取格式化的时间
		
		String sql="insert into mood(time,username,content) value (?,?,?);";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, time);
		statement.setString(2, username);
		statement.setString(3, content);
		int i = statement.executeUpdate();
		if(i!=0){
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert successfully!\n");
			return true;
		}
		else{
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert unsuccessfully\n");
			return false;
		}
		
	}//插入留言进入表word
	
	public static boolean InsertPhoto(String username,String photopath) throws ClassNotFoundException, SQLException{
		Connection conn=ConnectDB.getConnection();
		
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(date);//获取格式化的时间
		
		String sql="insert into photo(time,username,photo) value (?,?,?);";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, time);
		statement.setString(2, username);
		statement.setString(3, photopath);
		int i = statement.executeUpdate();
		if(i!=0){
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert successfully!\n");
			return true;
		}
		else{
			ConnectDB.closeAll(conn, statement);
			System.out.print("insert unsuccessfully\n");
			return false;
		}
		
	}//插入留言进入表word
	
	public static void WordView(String sender) throws ClassNotFoundException, SQLException{
		Connection conn=ConnectDB.getConnection();
		
		String sql="select time,receiver,content from word where sender=?;";
		PreparedStatement statement=conn.prepareStatement(sql);
		statement.setString(1, sender);
		ResultSet resultSet=statement.executeQuery();
		System.out.println("时间\t\t发给了谁\t\t内容<br>");
		while(resultSet.next()){
			System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getString(2)+"\t\t"+resultSet.getString(3)+"<br>");
		}
		ConnectDB.closeAll(conn, statement, resultSet);
	
	}
	
}
