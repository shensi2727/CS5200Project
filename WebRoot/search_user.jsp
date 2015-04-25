<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%> 
<% 
request.setCharacterEncoding("UTF-8"); 
response.setCharacterEncoding("UTF-8"); 
response.setContentType("text/html; charset=utf-8"); 
%> 
<html> 
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Retrieve Customer Information</title>
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
Connection con=null; 
String url="jdbc:mysql://localhost/restaurantdb?user=root&password="; 
//html_db为数据库名 
Class.forName("org.gjt.mm.mysql.Driver").newInstance();//新建实例 
Connection conn= DriverManager.getConnection(url);//建立连接 
Statement stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
String sql="select * from t_user"; 
ResultSet rs=stmt.executeQuery(sql); 

while(rs.next()) {%> 


user_id：<%=rs.getString("user_id")%> </br> 
user_pwd: <%=rs.getString("user_pwd")%></br> 
user_name:<%=rs.getString("user_name")%></br> 
user_sex:<%=rs.getString("user_sex")%></br>
user_mobile:<%=rs.getString("user_mobile")%></br>
user_email:<%=rs.getString("user_email")%></br>
user_certitype:<%=rs.getString("user_certitype")%></br>
user_certinum:<%=rs.getString("user_certinum")%></br>
user_address:<%=rs.getString("user_address")%></br>
user_level:<%=rs.getString("user_level")%></br>
user_point:<%=rs.getString("user_point")%></br>
user_birthday:<%=rs.getString("user_birthday")%></br>
<div style="border-top:1px dashed #cccccc;height: 1px;overflow:hidden"></div>
</br> 
<%}%> 
<%out.print("All user data retrieved! ");%> 
<% 
rs.close(); 
stmt.close(); 
conn.close(); 
%> 
</div>
</div>
<input name="" type="button" onclick="location.href = 'Index.jsp'" value="return" /> 
</div>

</br> 

</body> 
</html> 