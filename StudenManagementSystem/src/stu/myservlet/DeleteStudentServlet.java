package stu.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import stu.service.StudentService;

@SuppressWarnings({ "unused", "serial" })
public class DeleteStudentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			//删除
		request.setCharacterEncoding("utf-8");
		//接收前端传来的学号
		int id=Integer.parseInt(request.getParameter("sid"));
		
		StudentService service = new StudentService();
		boolean result = service.deleteStudentBySid(id);
		
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");     //设置响应编码
	                                           
	      
		if(result){
			
			//out.println();
			//response.getWriter().println("删除成功！");
			response.sendRedirect("QueryAllStudentServlet");//重新查询所有学生
		}else{
			response.getWriter().println("删除失败！");
		}
		
		//PrintWriter out = response.getWriter();
		
		
		/*if(!result){  //如果删除失败，给request域中放入一条数据
        	request.setAttribute("derror","deleteError");
        }else{
        	request.setAttribute("derror","nodeleteError");
        }
        
        
        
        request.getRequestDispatcher("QueryAllStudentServlet").forward(request, response);*/
		
		
	
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

}
