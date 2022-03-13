package stu.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.mybean.Student;
import stu.service.StudentService;

@SuppressWarnings({ "unused", "serial" })
public class QueryAllStudentServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int currPage = 1;//当前页码
	
		StudentService service = new StudentService();
		
		List<Student> students = service.queryAllStudents(currPage);//查询所有学生信息
		
		System.out.println(students);
		
		request.setAttribute("students",students);
		//因为request域中有数据，因此需要通过请求转发的方式跳转（重定向会丢失request域）
		//pageContext<request<session<application
		int pages;//总页数
		int count = service.findCount(); //查询总记录数
		if(count % Student.PAGE_SIZE==0){ //计算总页数
			pages = count / Student.PAGE_SIZE;//对总页数赋值
		}else{
			pages = count / Student.PAGE_SIZE+1;//对总页数赋值
		}
		
		StringBuffer sb = new StringBuffer();  //实例化StringBuffer
		for(int i=1;i<=pages;i++){
			if(i==currPage){
				sb.append("["+i+"]");
			}else{
				sb.append("<a href='QueryAllStudentServlet?page="+i+"'>"+i+"</a>");//构建分页条
			}
			sb.append("  ");
		}
		request.setAttribute("bar", sb.toString());//将分页条的字符串放到request域中；
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
