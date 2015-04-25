 
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%> 
<%  
   request.setCharacterEncoding("UTF-8");  
   response.setCharacterEncoding("UTF-8");  
   response.setContentType("text/html; charset=UTF-8");  
%> 
<htnl> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Delete Customer </title>
		<link href="css/add.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		.text {
			width: 100px;
		}
		</style>
		<script language="javascript" type="text/javascript">
        function selectByCondition(){
             
	         var address= document.getElementById("address").value;
	         var price= document.getElementById("priceRange").value;
	        
             location.href="Viewrestaurant.action?address="+address+"&priceRange="+price;
         
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
			<h3>All customer information</h3>	
<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>	

<% 
String id=request.getParameter("id"); //从表单获得  
String name=request.getParameter("name"); //从表单获得 
try  
{  
/** 连接数据库参数 **/ 
String driverName = "com.mysql.jdbc.Driver"; //驱动名称 
String DBUser = "root"; //mysql用户名 
String DBPasswd = ""; //mysql密码 
String DBName = "restaurantdb"; //数据库名 
String connUrl = "jdbc:mysql://localhost/" + DBName + "?user=" + DBUser + "&password=" + DBPasswd; 
String query_sql = "select user_id,user_name,user_mobile,user_address from t_user"; 
String delete_sql = ""; 
Class.forName(driverName).newInstance(); 
Connection conn = DriverManager.getConnection(connUrl); 
Statement stmt = conn.createStatement(); 
try{  
if(id != null && id != ""){ 
out.println("Delete user id=" + id + ".</br></br>"); 
delete_sql = "delete from t_user where user_id='" + id +"'";; 
} 
else if(name != null && name != ""){ 
out.println("Delete user name=" + name + ".</br></br>"); 
delete_sql = "delete from t_user where user_name='" + name + "'"; 
}else{ 
out.println("You must enter user name or user id！</br></br>"); 
} 
}catch(Exception e){ 
e.printStackTrace(); 
}    
try {  
stmt.execute(delete_sql);  
}catch(Exception e){ 
e.printStackTrace(); 
} 
try {  
ResultSet rs = stmt.executeQuery(query_sql); 

out.print("<h4>Remain Customer's ID and Name List</h4>");   
while(rs.next()) { 
%> 


ID：<%=rs.getString("user_id")%> 
</br> User Name: <%=rs.getString("user_name")%> 
<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>	

</br> 
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
<input name="" type="button" onclick="location.href = 'Admin.jsp'" value="返回" /> 
</div>
</div>
</div>
</body> 
</html> 
