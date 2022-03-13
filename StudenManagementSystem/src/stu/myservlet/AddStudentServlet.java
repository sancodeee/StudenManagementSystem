package stu.myservlet;
                                 //后台
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.net.httpserver.HttpServer;

import stu.mybean.Student;
import stu.service.StudentService;

@SuppressWarnings({ "serial", "unused" })
public class AddStudentServlet extends HttpServer {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				   request.setCharacterEncoding("utf-8");

			       int id = Integer.parseInt(request.getParameter("sid"));
			       String name = request.getParameter("sname");
			       int age = Integer.parseInt(request.getParameter("sage"));
			       String sex = request.getParameter("ssex");
			     
			       String home = request.getParameter("shome");
			       
			       Student student = new Student(id,name,age,sex,home);       //把从前端页面获取的信息封装到student类里
			       
			       StudentService studentService = new StudentService();
			       boolean result=studentService.addStudent(student);
			       /*
			        * out :PrintWriter out= response.getWriter();
			        * session: request.getSession();
			        * application: request.getServiceContext();
			        * 
			        * */
				   response.setCharacterEncoding("utf-8");
			       response.setContentType("text/html;charset=utf-8");//设置响应编码
			       
			       
			      // PrintWriter out = response.getWriter();
			     /*  if(result){
			    	   
			    	   out.println("增加成功！");
			    	   response.sendRedirect("QueryAllStudentServlet");
			       }else{
			    	  
					out.println("增加失败！");
			       }
			       
			     */
			        if(!result){  //如果增加失败，给request域中放入一条数据
			        	request.setAttribute("error","addError");
			        }else{//增加成功
			        	request.setAttribute("error","noaddError");
			        }
			        
			        
			        
			        request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);       
			       
	}
	
	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}

}
