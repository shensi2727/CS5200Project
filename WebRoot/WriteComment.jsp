 
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
<title>Write Comments</title> 
<META http-equiv=Content-Type content="text/html; charset=utf-8"> 

		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
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

<h2>Leave a comment.</h2>
<form action="insert_comment.jsp" method="post"> 
  
 ID    :<input type="text" style="margin:5px;height:15px;" name="id" value="" />
Name   :<input type="text" style="margin:5px;height:15px;" name="name" value="" /></br> 
Title  :<input type="text" style="margin:5px;height:51px;" name="title" " value="" /></br> 
Content:<input type="text" style="margin:5px;height:50px;" name="content" value="" /></br> 
   
    <input type="submit" value="Submit" />   
   <input type="reset" value="Reset" />   

</form> 
</div> 
</div> 
<a href="Index.jsp"> Return Home</a>
</div>

<script type="text/javascript"> 
/*-------------------------鼠标左键拖动---------------------*/ 
/*--------当不需要实现此功能时，可以将这一部分代码删除------------*/ 
var objDiv = document.getElementById("popDiv"); 
var isIE = document.all ? true : false;//判断浏览器类型 
document.onmousedown = function(evnt) {//当鼠标左键按下后执行此函数 
var evnt = evnt ? evnt : event; 
if (evnt.button == (document.all ? 1 : 0)) { 
mouseD = true;//mouseD为鼠标左键状态标志，为true时表示左键被按下 
} 
} 

objDiv.onmousedown = function(evnt) { 
objDrag = this;//objDrag为拖动的对象 
var evnt = evnt ? evnt : event; 
if (evnt.button == (document.all ? 1 : 0)) { 
mx = evnt.clientX; 
my = evnt.clientY; 
objDiv.style.left = objDiv.offsetLeft + "px"; 
objDiv.style.top = objDiv.offsetTop + "px"; 
if (isIE) { 
objDiv.setCapture(); 
//objDiv.filters.alpha.opacity = 50;//当鼠标按下后透明度改变 
} else { 
window.captureEvents(Event.MOUSEMOVE);//捕获鼠标拖动事件 
//objDiv.style.opacity = 0.5;//当鼠标按下后透明度改变 
} 
} 
} 
document.onmouseup = function() { 
mouseD = false;//左键松开 
objDrag = ""; 
if (isIE) { 
objDiv.releaseCapture(); 
//objDiv.filters.alpha.opacity = 100;//当鼠标左键松开后透明度改变 
} else { 
window.releaseEvents(objDiv.MOUSEMOVE);//释放鼠标拖动事件 
//objDiv.style.opacity = 1;//当鼠标左键松开后透明度改变 
} 
} 

document.onmousemove = function(evnt) { 
var evnt = evnt ? evnt : event; 
if (mouseD == true && objDrag) { 
var mrx = evnt.clientX - mx; 
var mry = evnt.clientY - my; 
objDiv.style.left = parseInt(objDiv.style.left) + mrx + "px"; 
objDiv.style.top = parseInt(objDiv.style.top) + mry + "px"; 
mx = evnt.clientX; 
my = evnt.clientY; 
} 
} 
</script> 
</body> 
</html> 
