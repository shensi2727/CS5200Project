<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link type="text/css" rel="stylesheet" href="css/admin.css" />
		<style type="text/css">
input.text {
	height: 15px;
	font-family: Arial;
	width: 130px;
}
</style>
	</head>
	<body>
		<div id="page">
			<div id="header" class="clearfix">
			</div>
			<div id="content" class="clearfix">
				<div id="main">
					<div
						style="background-image: url(image/loginback.jpg); height: 400px;">
						<div id="links">
							<a href="./Index.jsp">&nbsp;Home&nbsp;&nbsp;</a>&gt;Admin Login
						</div>
						<FORM action="AdminLogin.action" id="login_form" method="post"
							style="border-right: 1px solid #ccc; width: 500px; float: left; margin: 30px 0 30px 50px; height: 250px;">
							<div
								style="border: 1px solid #ccc; width: 400px; padding: 10px; background: white;">
								<SPAN style="color: #4274A1;">Please Enter administrator username and password</SPAN>
								<BR>
								<TABLE width="100%;" cellpadding="5">
									<TBODY>
										<TR>
											<TD width="110px">
												<SPAN style="color: red">*</SPAN> Administrator Name
											</TD>
											<TD>
												<INPUT type="text" class="text" name="userName">
											</TD>
										</TR>
										<TR>
											<TD>
												<SPAN style="color: red">*</SPAN> Password
											</TD>
											<TD>
												<INPUT type="password" class="text" name="password">
											</TD>
										</TR>
										<TR>
											<TD>
											</TD>
											<TD>
												<input type="submit" name="Submit" value="Login" />
											</TD>
										</TR>
										<TR>
											<TD colspan="2" align="center">
											</TD>
										</TR>
									</TBODY>
								</TABLE>
							</div>
						</FORM>
						<%
							//request.setAttribute("user","user");
							request.getSession().setAttribute("user", "admin");
						%>
						<div
							style="float: left; width: 250px; height: 200px; margin-top: 35px; margin-left: 30px; line-height: 2.2; color: black;">
							<P> 
								Admin 
								<SPAN class="highlight">you can :</SPAN>
							</P>
							<OL>
								<LI>
									For customer management
								</LI>
								<LI>
									For restaurant and food management
								</LI>
							</OL>
							<P></P>
							
						</div>
					</div>
				</div>
			</div>
			<div id="footer">
				<div id="site_nav">
					

				</div>
				<div id="copyright">
					
				</div>
			</div>
		</div>
	</body>
</html>