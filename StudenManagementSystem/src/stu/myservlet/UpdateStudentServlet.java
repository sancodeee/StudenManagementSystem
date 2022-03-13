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
public class UpdateStudentServlet extends HttpServlet {




	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			//获取待修改人的学号
			int id = Integer.parseInt(request.getParameter("sid"));
			//获取修改后的内容
			
			String name = request.getParameter("sname");
			int age = Integer.parseInt(request.getParameter("sage"));
			String sex = request.getParameter("ssex");
			String home = request.getParameter("shome");
			
			//将修改后的内容封装到一个实体类中
			Student student= new Student(name,age,sex,home);
			
			StudentService service = new StudentService();
			boolean result = service.updateStudentBySid(id, student);

			response.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");//设置响应编码
		      
		    /*if(result){
				
				//out.println();
				
				//response.getWriter().println("修改成功！");
				response.sendRedirect("QueryAllStudentServlet");//修改完毕后，再次跳回全部学生信息页面
				
			}else{
				response.getWriter().println("修改失败！");
			}*/
		    
		    if(!result){  //如果修改失败，给request域中放入一条数据
	        	request.setAttribute("uerror","updateError");
	        }else{//增加成功
	        	request.setAttribute("uerror","noupdateError");
	        }
	                
	        request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);
	        
	        
		    
			
	}

		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
