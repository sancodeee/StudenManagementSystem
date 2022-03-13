<%@page import="stu.mybean.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    
    <title>修改学生信息</title>
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
   			Student student=(Student)request.getAttribute("student");
   		
   		 %>
   		 <!--通过表单展示此人的信息  -->
   		 <form action="UpdateStudentServlet">
   		 	<table align="center" cellpadding="5">
   		 	<thead><h2 align="center" style="color: blue;">修改学生信息</h2></thead>
   		 		<tr>
   		 			<th>学号:</th>
   		 			<td><input type="text" name="sid" value="<%=student.getSid() %>" readonly="readonly"><br/></td>
   		 		</tr>
   		 		<tr>
   		 			<th>姓名:</th>
   		 			<td><input type="text" name="sname" value="<%=student.getSname() %>"><br/></td>
   		 		</tr>
   		 		<tr>
   		 			<th>年龄:</th>
   		 			<td><input type="text" name="sage" value="<%=student.getSage() %>"><br/></td>
   		 		</tr>
   		 		<tr>
   		 			<th>性别:</th>
   		 			<td><input type="text" name="ssex" value="<%=student.getSsex() %>"><br/></td>
   		 		</tr>
   		 		<tr>
   		 			<th>家庭地址:</th>
   		 			<td><input type="text" name="shome" value="<%=student.getHome() %>"><br/></td>
   		 		</tr>
   		 		<tr>
   		 			<th></th>
   		 			<td><input type="submit" value="修改"/>&nbsp;&nbsp;&nbsp;<input type="reset" value="撤回修改">&nbsp;&nbsp;&nbsp;&nbsp;<a href="QueryAllStudentServlet">返回</a></td>
   		 		</tr>
   		 	
   		 	</table>
   		 	
   		 	
   		 	
   		 	
   		 	
   		 	
   		 	
   		 </form>
   		 
  </body>
</html>
