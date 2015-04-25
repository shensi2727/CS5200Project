 
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%> 
<%  
   request.setCharacterEncoding("UTF-8");  
   response.setCharacterEncoding("UTF-8");  
   response.setContentType("text/html; charset=UTF-8");  
%> 
<htnl> 
<head> 
<title>Delete User</title> 
</head> 
<body> 
<% 
String id=request.getParameter("id"); //从表单获得  
String name=request.getParameter("name"); //从表单获得 
try  
{  
/** 连接数据库参数 **/ 
String driverName = "com.mysql.jdbc.Driver"; //驱动名称 
String DBUser = "root"; //mysql用户名 
String DBPasswd = "hel610"; //mysql密码 
String DBName = "html_db"; //数据库名 
String connUrl = "jdbc:mysql://localhost/" + DBName + "?user=" + DBUser + "&password=" + DBPasswd; 
String query_sql = "select id,name,sex,age from person_tb"; 
String delete_sql = ""; 
Class.forName(driverName).newInstance(); 
Connection conn = DriverManager.getConnection(connUrl); 
Statement stmt = conn.createStatement(); 
try{  
if(id != null && id != ""){ 
out.println("删除了id=" + id + "的人。</br></br>"); 
delete_sql = "delete from person_tb where id=" + id; 
} 
else if(name != null && name != ""){ 
out.println("删除了name=" + name + "的人。</br></br>"); 
delete_sql = "delete from person_tb where name='" + name + "'"; 
}else{ 
out.println("请至少输入ID、姓名中的一个！</br></br>"); 
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
while(rs.next()) { 
%> 
ID：<%=rs.getString("id")%> 
</br> 姓名：<%=rs.getString("name")%> 
</br> 性别：<%=rs.getString("sex")%> 
</br> 年龄：<%=rs.getString("age")%> 
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
<input name="" type="button" onclick="location.href = 'index_test.jsp'" value="返回" /> 
</body> 
</html> 
