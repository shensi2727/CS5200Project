 
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<% 
request.setCharacterEncoding("UTF-8"); 
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%> 
<htnl> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Insert Comment Result</title>
		<link href="css/add.css" rel="stylesheet" type="text/css" />
	
		<script language="javascript" type="text/javascript">
        function selectByCondition(){
        
             var id= document.getElementById("restaurantId").value;
             var name= document.getElementById("restaurantName").value;
	         var address= document.getElementById("address").value;
	         var price= document.getElementById("priceRange").value;
	        
             location.href="Viewrestaurant.action?restaurantId="+id+"&restaurantName"+name+"&address="+address+"&priceRange="+price;
         
        }
		
		function back()
		{
           window.location.href = "./Admin.jsp";
		}
        </script>
	</head>
<body> 

		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">

<h2>View all Comment!</h2>
<% 
String id=request.getParameter("id"); //从表单获得 
String name=request.getParameter("name"); //从表单获得 
String title=request.getParameter("title"); //从表单获得 
String content=request.getParameter("content"); //从表单获得 

try 
{ 
/** 连接数据库参数 **/ 
String driverName = "com.mysql.jdbc.Driver"; //驱动名称 
String DBUser = "root"; //mysql用户名 
String DBPasswd = ""; //mysql密码 
String DBName = "restaurantdb"; //数据库名 

String connUrl = "jdbc:mysql://localhost/" + DBName + "?user=" + DBUser + "&password=" + DBPasswd; 
Class.forName(driverName).newInstance(); 
Connection conn = DriverManager.getConnection(connUrl); 
Statement stmt = conn.createStatement(); 
stmt.executeQuery("SET NAMES UTF8"); 
String insert_sql = "insert into t_comment values('" + id + "','" + name + "','" + title + "','" + content + "')"; 
String query_sql = "select * from t_comment"; 

try { 
stmt.execute(query_sql); 
}catch(Exception e) { 
e.printStackTrace(); 
} 
try { 
ResultSet rs = stmt.executeQuery(query_sql); 
while(rs.next()) { 
%> 
ID     ：<%=rs.getString("id")%> </br> 
name   :<%=rs.getString("name")%> </br> 
title  :<%=rs.getString("title")%> </br> 
content: <%=rs.getString("content")%> </br> 
<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
</br> 
<% 
} 
}catch(Exception e) { 
e.printStackTrace(); 
} 
//rs.close(); 
stmt.close(); 
conn.close(); 
}catch (Exception e) { 
e.printStackTrace(); 
} 
%> 
</br> 
<input name="" type="button" onclick="location.href = 'Index.jsp'" value="Return Home" />
</div>
</div>
</div>  
</body> 
</html> 
