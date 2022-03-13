<%@page import="stu.mybean.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    
    <title>学生数据信息</title>
    
     <style>
        th{
            color: 	#8A2BE2;
        }
        td{
            color: #FB7299;
        }
        tr{
            height: 10px; 
        }
        a:link{  
        	color:#blue;
        	text-decoration:none;
        	font-weight:700;
        }
        a:visited{
        	color:orange;
        }
        a:hover{  
        	color:#f10215;
        }
		a:active{ 
			color:#FB7299;	
		}
	
    </style>
    


  </head>
  
  <body>
  	<%
  		String error = (String)request.getAttribute("error");
  		
  		if(error!=null){
  			if(error.equals("addError")){
  				out.print("增加失败！");
  		    }else if(error.equals("noaddError")){
  				out.print("增加成功！");
  		    }
  		}  	
  	 %>
  	 
  	 
  	 <%
  		String uerror = (String)request.getAttribute("uerror");
  		
  		if(uerror!=null){
  			if(uerror.equals("updateError")){
  				out.print("修改失败！");
  		    }else if(uerror.equals("noupdateError")){
  				out.print("修改成功！");
  		    }
  		}  	
  	 %> 
  
  	<table border="1" align="center" width="600" cellpadding="10">
  	 	<caption><h2 style="color: blue; font-size: 25px;" >学生数据信息管理系统</h2></caption>
  	 	<thead>
  		<tr>
  			<th>学号</th>
  			<th>姓名</th>
  			<th>年龄</th>
  			<th>性别</th>
  			<th>家庭地址</th>
  			<th>删除数据</th>
  		</tr>
  		</thead>
  		<%
  			//获取request域中的数据
  			
  			List<Student> students = (List<Student>)request.getAttribute("students");
  			 
  			for(Student student:students){
  		%>
  		
  			<tr>
  				<td><a href="QueryStudentBySidServlet?sid=<%=student.getSid() %>"><%=student.getSid() %></a></td>
  				<td><%=student.getSname() %></td>
  				<td><%=student.getSage() %></td>
  				<td><%=student.getSsex() %></td>
  				<td><%=student.getHome() %></td>
  				<td align="center"><a href="DeleteStudentServlet?sid=<%=student.getSid() %>">删除</a>
  				</td>
  			
  			</tr>
  		 		
  		<%				 			
  			} 			
  		 %>
  		 
  		<tr>
  			<td align="center" colspan="6">
  				<%=request.getAttribute("bar") %>
  			</td>
  		</tr>
  	</table>
  		<a href="QueryAllStudentServlet"><h4 align="center">刷新</h4></a>
		<a href="add.jsp"><h4 align="center">添加学生</h4></a>
		
  </body>
</html>
