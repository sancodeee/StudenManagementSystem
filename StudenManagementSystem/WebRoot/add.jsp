<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>学生数据</title>
    
     <style>
        th{
            color: 	#8A2BE2;
        }
        td{
            color: #FB7299;
        }
        tr{
            height: 30px; 
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
        <form action="AddStudentServlet" method="post"> 
        <table align="center">
        <thead><h2 align="center" style="color:blue;">学生信息录入系统</h2></thead>
            <tr>
                <th>id:</th>
                <td><input type="text" name="sid"></td>
            </tr>
            <tr>
                <th>姓名:</th>
                <td><input type="text" name="sname"></td>
            </tr>
            <tr>
                <th>年龄:</th>
                <td><input type="text" name="sage"></td>
            </tr>
            <tr>
                <th>性别:</th>
                <td><input type="text" name="ssex"></td>
                <td></td>
            </tr>
            <tr>
                <th>家庭地址:</th>
                <td><input type="text" name="shome"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="添 加">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="QueryAllStudentServlet">返回</a></td>
            </tr>
        </table>
    </form>
  </body>
</html>
