<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>Login</title>
		<link href="css/login.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
        //check[a-z][A-Z]and[0-9]
        function fucCheckSpace(str)
        {       
            var strSource ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            var ch; var i;var temp;
            for(i=0;i<=(str.length-1);i++)
            {
                ch = str.charAt(i);
                temp = strSource.indexOf(ch);
                if(temp==-1) 
                {
                   return 0;
                }
            }
            if(strSource.indexOf(ch)==-1)
            {
                 return 0;
            } 
            else
            {
                  return 1;
            } 
         }
		 //
        function frm_login()
		{
		    if(document.frm.userId.value == "")
			{
			   alert('\please enter username ！');
			   document.frm.username.focus();
			   return false;
			}
			else if(fucCheckSpace(document.frm.userId.value)==0)
			{
			   document.frm.userId.value = "";
			   document.frm.userId.focus();
			   return false;
			}
			if(document.frm.password.value == "")
			{
			   alert('\please enter password ！');
			   document.frm.password.focus();
			   return false;
			}
			else if(fucCheckSpace(document.frm.password.value)==0)
			{
			   document.frm.password.value = "";
			   document.frm.password.focus();
			   return false;
			}
		}
</script>
	</head>
	<body>


<%
if(session.getAttribute("user")!=null)//判断用户名是不是为空
{
session.setAttribute("user","");

session.removeAttribute("user");//注销
}

out.println("<script>alert('You had logout');this.location.href='Index.jsp';</script>");//回到首页
%>  
		<div id="page">
			<div id="header" class="clearfix">
			</div>
			<div id="content" class="clearfix">
				<div id="main">
					Logout Success
					<a href="Index.jsp">Return To Home</a>
					</div>
				</div>
			</div>
			<div id="footer">
				<div id="site_nav">
					<ul>

				</div>
				<div id="copyright">
				
				</div>
			</div>
		</div>
	</body>
</html>
