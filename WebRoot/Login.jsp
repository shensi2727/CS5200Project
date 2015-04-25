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
			   alert('\please enter username £¡');
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
			   alert('\please enter password £¡');
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
		<div id="page">
			<div id="header" class="clearfix">
			</div>
			<div id="content" class="clearfix">
				<div id="main">
					<div
						style="background-image: url(./image/background.jpg); height: 400px;">
						<div id="links">
							<a href="./Index.jsp">&nbsp;Home&nbsp;&nbsp;</a>&gt; Login&nbsp;
						</div>
						<form action="Login.action" method="post" name="frm"
							onsubmit="frm_login()"
							style="border-right: 1px solid #ccc; width: 550px; float: left; margin: 30px 0 30px 50px;">
							
							<div
								style="border: 1px solid #ccc; background-color: white; width: 500px; padding: 10px; height: 180px;">
								<span style="color: #4274A1;">Please Enter username and password</span>
								<br />
								<table width="100%" cellpadding="5">
									<tbody>
										<tr>
											<td width="110px" height="35">
												<SPAN style="color: red">*</SPAN> Username
											</td>
											<td>
												<INPUT class="text required" id="userId" name="userId"
													type="text">
											</td>
										</tr>
										<tr>
											<td height="38">
												<SPAN style="color: red">*</SPAN> Password
											</td>
											<td>
												<INPUT class="required text" id="password" name="password"
													type="password">
											</td>
										</tr>
										<tr>
											<td colspan="2"></td>
										</tr>
										<tr>
											<td colspan="1" align="center">
												&nbsp;
											</td>
											<td>
												<label>
													<input type="submit" name="Submit" value="Login&nbsp;" />
												</label>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</form>
						<div
							style="float: left; width: 250px; height: 200px; margin-top: 45px; margin-left: 30px; line-height: 2.2; color: black;">
							<P>
								Welcome to register .
								<SPAN class="highlight">you can:</SPAN>
							</P>
							<OL style="line-height: 2.5">
								<LI>
									Search the latest information
								</LI>
								<LI>
									Booking the restaurant
								</LI>
								<LI>
									Feedback
								</LI>
								<LI>
									<a href="UserRegister.jsp">register</a>
								</LI>
							</OL>
						</div>
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
