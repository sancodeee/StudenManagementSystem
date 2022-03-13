package stu.service;
import java.util.List;

import stu.mybean.Student;
import stu.dao.StudentDao;

//业务逻辑层：逻辑性的增删改查

public class StudentService {
	StudentDao studentDao = new StudentDao();
	
		//增加学生service
	
	public boolean addStudent(Student student){
		
		if(!studentDao.isExist(student.getSid())){
			
			return studentDao.addStudent(student);
		}else{
			System.out.println("此人已存在！");
			return false;
		}
	}
		
		//删除
	public boolean deleteStudentBySid(int sid){
		if(studentDao.isExist(sid)){
			return studentDao.deleteStudentBySid(sid);
		}else{
			return false;
		}
		
	}
	
	//修改
	public boolean updateStudentBySid(int sid,Student student){
		if(studentDao.isExist(sid)){
			return studentDao.updateStudentBySid(sid, student);
		}
		return false;
	}
	
		//根据学号查一个人
	public Student queryStudentBySid(int sid){
		return studentDao.queryStudentBySid(sid);
	}
	
	//查询全部学生
	public List<Student> queryAllStudents(int page){
		return studentDao.queryAllStudents(page);//
	}
	
	//查询总记录数
	public int findCount(){
		return studentDao.findCount();
	}
		
}
