package stu.mybean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {  //数据库连接类
	public static Connection getConnection(){
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String pwd="root";
		
		
		Connection conn=null;
		try{
			conn=DriverManager.getConnection(url, username, pwd);//与数据库建立连接
			System.out.println("link ok!");
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return conn;
	}
}
	
