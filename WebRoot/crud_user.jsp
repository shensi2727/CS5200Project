 
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
<title>人员操作</title> 
<META http-equiv=Content-Type content="text/html; charset=utf-8"> 
<style> 
#popDivAdd,#popDivDelete { 
position: absolute; 
visibility: hidden; 
overflow: hidden; 
border: 2px solid #AEBBCA; 
background-color: #EEF1F8; 
cursor: move; 
padding: 1px; 
} 

#popTitle { 
background: #9DACBF; 
height: 20px; 
line-height: 20px; 
padding: 1px; 
} 

#popForm { 
padding: 2px; 
} 

.title_left { 
font-weight: bold; 
padding-left: 5px; 
float: left; 
} 

.title_right { 
float: right; 
} 

#popTitle .title_right a { 
color: #000; 
text-decoration: none; 
} 

#popTitle .title_right a:hover { 
text-decoration: underline; 
color: #FF0000; 
} 
</style> 
<script> 
function showPopup(type) {//弹出层 
//var objDiv = null;//objDiv是目标div 
if(type == 'add'){ 
objDiv = document.getElementById("popDivAdd"); 
} 
else 
if(type = 'delete'){ 
objDiv = document.getElementById("popDivDelete"); 
} 
objDiv.style.top = "50px";//设置弹出层距离上边界的距离 
objDiv.style.left = "200px";//设置弹出层距离左边界的距离 
objDiv.style.width = "300px";//设置弹出层的宽度 
objDiv.style.height = "220px";//设置弹出层的高度 
//objDiv.style.display = "block"; 
objDiv.style.visibility = "visible"; 
} 
function hidePopup(type) {//关闭层 
//var objDiv = null;//objDiv是目标div 
if(type == 'add'){ 
objDiv = document.getElementById("popDivAdd"); 
} 
else  
if(type = 'delete'){ 
objDiv = document.getElementById("popDivDelete"); 
} 
objDiv.style.visibility = "hidden"; 
} 
</script> 
</head> 

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Customer Information Administrator</title>
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
				<h2>Customer Information Administrator</h2>

<!-- 表单div --> 
<form action="insert_test.jsp" method="post"> 
  
 user_ID :<input type="text" name="id" value="0" /></br>  
user_name:<input type="text" name="name" value="" /></br> 
user_sex:<input type="text" name="sex" value="" /></br> 
user_age:<input type="text" name="age" value="" /></br> 
   
    <input type="submit" value="Submit" />   
   <input type="reset" value="Reset" />   
   <input type="reset" value="Cancel" onclick="hidePopup('add')" /> 
</form> 


<div id=""><!-- 删除人员的div --> 
<div id=""><!-- 标题div --> 
<span class="title_left">Delete</span> <span class="title_right"> 
<a href="#" onclick="hidePopup('delete');">Close</a> </span> 
</div> 
<div id="popForm"><!-- 表单div --> 
<form action="delete_test.jsp" method="post"> 
  
 ID :<input type="text" name="id" value="" /> </br>  
姓名:<input type="text" name="name" value="" /> </br> 
   
    <input type="submit" value="提交" />   
   <input type="reset" value="重置" />   
   <input type="reset" value="取消" onclick="hidePopup('delete')" /> 
</form> 
</div> 
</div> 
  
<input name="" type="button" onclick="location.href = 'query_test.jsp'" value="查询" />   
<input name="" type="button" onclick="showPopup('add')" value="添加" />   
<input name="" type="button" onclick="showPopup('delete')" value="删除" /> 
  
</div>
</div>
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
