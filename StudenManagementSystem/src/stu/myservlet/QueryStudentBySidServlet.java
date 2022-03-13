package stu.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.mybean.Student;
import stu.service.StudentService;

@SuppressWarnings({ "unused", "serial" })
public class QueryStudentBySidServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			int id = Integer.parseInt(request.getParameter("sid"));
			StudentService service = new StudentService();
			Student student = service.queryStudentBySid(id);
			System.out.println(student);
			//将此人的数据通过前台jsp显示studentInfo
			request.setAttribute("student",student);//将查询到的学生放到request域中
			//如果request域中没有数据，使用重定向跳转response.sendRedirect();
			//如果request域中没有数据（request.setAttribute();），使用请求转发跳转
			request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
			
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
