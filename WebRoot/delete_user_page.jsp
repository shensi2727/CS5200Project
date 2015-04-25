 
<%@ page language="java" pageEncoding="utf-8"%> 
<%@ page contentType="text/html;charset=utf-8"%>  
<%  
   request.setCharacterEncoding("UTF-8");  
   response.setCharacterEncoding("UTF-8");  
   response.setContentType("text/html;charset=utf-8");  
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<title>Delete Customer</title> 
<META http-equiv=Content-Type content="text/html; charset=utf-8"> 

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

<!-- 表单div --> 

<div id="popForm"><!-- 表单div --> 
<form action="delete_user.jsp" method="post"> 
  
 User ID :<input type="text" name="id" value="" /> </br>  
 User Name:<input type="text" name="name" value="" /> </br> 
   
    <input type="submit" value="Submit" />   
   <input type="reset" value="Reset" />   
  
</form> 
</div> 
</div> 
  
<input name="" type="button" onclick="location.href = 'Index.jsp'" value="Return" />   
</div>
</div>


</body> 
</html> 
