<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>

<%@ page import="com.hnkj.hm.dao.impl.restaurantDAO"%>
<%@ page import="com.hnkj.hm.vo.restaurantVO"%>
<%@ page import="com.hnkj.hm.bean.PageBean"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>Home</title>
		<link href="css/index.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
a {
	text-decoration: none;
	color: #006699;
}

a:hover,a:active {
	color: #BC2A4D;
	text-decoration: underline;
}
</style>
	</head>
	<body>
	<%
	   String userId = (String)session.getAttribute("user");

    %>
		<div id="brand">
		</div>
		<DIV id="page">
			<div id="content" class="clearfix">
				<div id="header">
					<div id="channel_nav">
						<ul>

							<li>
								<a href="Index.jsp">Home</a>
							</li>
							<li>
								<a href="ShowrestaurantInfo.action?star=<%="1"%>">Take-Out</a>
							</li>
							<li>
								<a href="ShowrestaurantInfo.action?star=<%="2"%>">Lobby</a>
							</li>
							<li>
								<a href="ShowrestaurantInfo.action?star=<%="3"%>">Box</a>
							</li>
							<li>
								<a href="Reservefood.jsp">Booking</a>
							</li>
							<li>
								<a href="food_info.action?kfcx=<%="1"%>">Food Information</a>
							</li>
							<li>
								<a href="AdminLogin.jsp">System Admin</a>
							</li>
							<%
							  if(null == userId || userId.equals(""))
							  {
							   %>
							    <li>
								<a href="Login.jsp" target="_blank">Login</a>
							    </li>
							   <%   
							  }else
							  {
							  %>
							  
							  <%
							   } 
							  %>
							<li>
								<a href="UserRegister.jsp" target="_blank">Register</a>
							</li>
							<li class="last">
								<a href="Login.jsp">Login</a>
							</li>
							<li>
								<a href="WriteComment.jsp">Leave a Comment</a>
							</li>
							<li>
								<a href="ViewComment.jsp">View Comments</a>
							</li>
						</ul>
					</div>
				</div>
				<div id="main">
					<div id="blog1"
						style="background-image: url(image/login_bg.jpg); height: 700;">
						<!-- left -->
						<div class="bodyleft">
							<div class="i_menu">
								<div class="i_menudiv" style="background-position: 0 -155px;">
									<a href="#"></a>
									<h4><% 
									out.print("Welcome:\n");
									if(userId != null)
									{
										out.print(userId);
										out.print("<a href='Logout.jsp'>Logout</a>");
									}
									%></h4>
								</div>
								<div class="i_menu_ul">
									<ul>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
									</ul>
								</div>
								<div class="i_menudiv" style="background-position: 0 -155px;">
									<a href="#"></a>
								</div>
								<div class="i_menu_ul">
									<ul>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
									</ul>
								</div>
								<div class="i_menudiv" style="background-position: 0 -155px;">
									<a href="#"></a>
								</div>
								<div class="i_menu_ul">
									<ul>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
									</ul>
								</div>
								<div class="i_menudiv" style="background-position: 0 -155px;">
									<a href="#"></a>
								</div>
								<div class="i_menu_ul">
									<ul>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
										<li>
											<a href="#"></a>
										</li>
									</ul>
								</div>
							</div>
							<br />
							<div class="box2" style="">
								
							</div>
						</div>
					</div>
					<div id="blog2">
						<div class="key">
							<form action="selectInfo.action" method="post">
								<table>
									<tr>
										<td>
											Location &nbsp;&nbsp;
											<input type="text" name="address" id="address"
												class="inputControl">
										</td>
										<td>
											&nbsp;&nbsp;Price&nbsp;&nbsp;
											<select name="priceRange" id="priceRange">
												<option value="100,400">
													100-400 $
												</option>
												<option value="400,800">
													400-800 $
												</option>
												<option value="800,6000">
													800 $ above
												</option>
											</select>
										</td>
										<td>
											&nbsp;&nbsp;
											<input type="submit" name="Submit" value="Search"
												class="buttonface" />
										</td>
									</tr>
								</table>
							</form>
						</div>
						<div id="blog4">
							<table height="195px" width="495px">
								<%
									ArrayList<restaurantVO> list = (ArrayList) request.getAttribute("list");
									if (list != null && list.size() > 0) {
										for (int i = 0; i < list.size(); i++) {
											restaurantVO restaurantvo = list.get(i);
										%>
								<tr>
									<td>
										<img src="upload/<%=restaurantvo.getImageFileName() %>" width="60"
											height="50" style="border: 1px solid #ccc" />
									</td>
									<td>
										<%=restaurantvo.getrestaurantName() %>
									</td>
									<td>
										￥
										<font color="#FF5500"><%=restaurantvo.getPrice()%></font>
									</td>
									<td>
										<%=restaurantvo.getAddress() %>
									</td>
								</tr>
								<%
									     }
									}
                                    else{
                                       restaurantDAO restaurantdao = new restaurantDAO();
                                       List<restaurantVO> lists = restaurantdao.findAllrestaurant("", "100,6000");
                                       for (int i = 0; i < lists.size(); i++) {
											restaurantVO restaurantvo = lists.get(i);
										%>
								<tr>
									<td>
										<img src="upload/<%=restaurantvo.getImageFileName() %>" width="60"
											height="50" style="border: 1px solid #ccc" />
									</td>
									<td>
										<%=restaurantvo.getrestaurantName() %>
									</td>
									<td>
										$
										<font color="#FF5500"><%=restaurantvo.getPrice()%></font>
									</td>
									<td>
										<%=restaurantvo.getAddress() %>
									</td>
								</tr>
								<%  
                                      }
                                  }
								%>
							</table>
						</div>
						<div id="blog3">

						</div>
						<br />
						<!--<div id="blog5"></div>-->
					</div>
				</div>
			</div>
			
		</div>
	</body>
</html>
