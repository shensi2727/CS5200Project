 
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<% 
request.setCharacterEncoding("UTF-8"); 
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%> 
<html> 
<body> 
<% 
Connection con=null; 
String url="jdbc:mysql://localhost/html_db?user=root&password=123456"; 
//html_db为数据库名 
Class.forName("org.gjt.mm.mysql.Driver").newInstance();//新建实例 
Connection conn= DriverManager.getConnection(url);//建立连接 
Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
String sql="select * from person_tb"; 
ResultSet rs=stmt.executeQuery(sql); 
while(rs.next()) {%> 
ID：<%=rs.getString("id")%> </br> 
姓名：<%=rs.getString("name")%></br> 
性别：<%=rs.getString("sex")%></br> 
年龄：<%=rs.getString("age")%></br></br> 
<%}%> 
<%out.print("恭喜你!数据库操作成功！ ");%> 
<% 
rs.close(); 
stmt.close(); 
conn.close(); 
%> 
</br> 
<input name="" type="button" onclick="location.href = 'index_test.jsp'" value="返回" /> 
</body> 
</html> 
