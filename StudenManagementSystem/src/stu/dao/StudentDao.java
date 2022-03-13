package stu.dao;
                        //数据访问层

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import stu.mybean.Student;

public class StudentDao {
		
	private final String url="jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8";//注意后面是设置存入数据库的编码格式
	private final String username="root";
	private final String pwd="root";
	
	  //查询此人是否存在
	public boolean isExist(int sid){
		return queryStudentBySid(sid)==null?false:true;//判断此人是否存在
	}
	
	
	
	    //根据学号查人
	public Student queryStudentBySid(int sid) {
		Student student=null;
		
		Connection connection =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "select * from hpu_students where sid =?";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sid);
					
			rs=pstmt.executeQuery();
			
			
			if(rs.next()){
				int id=rs.getInt("sid");
				String name=rs.getString("sname");
				int age=rs.getInt("sage");
				String sex=rs.getString("ssex");
				String home=rs.getString("shome");
				
				student = new Student(id,name,age,sex,home);
			}
			return student;
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	//查询全部学生
	public List<Student> queryAllStudents(int page) { //
		
	
		List<Student> students =  new ArrayList<Student>();
			
		Student student=null;
		
		Connection connection =null;
		PreparedStatement pstmt=null;
	
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "select * from hpu_students order by sid desc limit ?,?";//
			
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, (page-1)*Student.PAGE_SIZE);//
			pstmt.setInt(2,Student.PAGE_SIZE);//
								
			ResultSet rs=pstmt.executeQuery();
			
			
			while(rs.next()){
				student = new Student();
				student.setSid(rs.getInt("sid"));
				student.setSname(rs.getString("sname"));
				student.setSage(rs.getInt("sage"));
				student.setSsex(rs.getString("ssex"));
				student.setHome(rs.getString("shome"));
							
				students.add(student);
			}
			return students;
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				
				
				//if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}
	/**********************************************************************/
	//查询总记录数，用于计算学生信息的总页数
	public int findCount(){
		int count=0;
		
		Connection connection =null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "select count(*) from hpu_students";//
			
			pstmt = connection.prepareStatement(sql);
			

								
			rs=pstmt.executeQuery();
			if(rs.next()){
				count=rs.getInt(1);   //对总记录数赋值
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		finally{
			try {
				
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
		return count;  //返回总记录数
		
	}
	
	
	
	
	
	
	
/**************************************************************************/	
	//添加学生
	public boolean addStudent(Student student){

		Connection connection =null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "insert into hpu_students values(?,?,?,?,?)";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, student.getSid());
			pstmt.setString(2,student.getSname());
			pstmt.setInt(3,student.getSage());
			pstmt.setString(4,student.getSsex());
			pstmt.setString(5,student.getHome());
			
			int count=pstmt.executeUpdate();
			
			if(count>0){
				return true;
			}else{
				return false;
			}					
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				
				
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	
	
	//根据学号删除学生
	public boolean deleteStudentBySid(int sid){
		Connection connection =null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "delete from hpu_students where sid = ? ";
			
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, sid);
			
			int count=pstmt.executeUpdate();
			
			
			if(count>0){
				return true;
			}else{
				return false;
			}					
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				
				
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	//根据学号修改学生信息
	
	public boolean updateStudentBySid(int sid,Student student){
		
		Connection connection =null;
		PreparedStatement pstmt=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection =  DriverManager.getConnection(url,username,pwd);
			
			String sql = "update hpu_students set sname=?,sage=?,ssex=?,shome=? where sid=?";
			
			pstmt = connection.prepareStatement(sql);
			//修改后的内容
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2,student.getSage());
			pstmt.setString(3, student.getSsex());
			pstmt.setString(4, student.getHome());
			//修改的那个人
			pstmt.setInt(5,sid);
			
			int count=pstmt.executeUpdate();
			
			
			if(count>0){
				return true;
			}else{
				return false;
			}					
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		finally{
			try {
								
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
}
