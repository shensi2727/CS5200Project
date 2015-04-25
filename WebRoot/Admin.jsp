<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
		<title></title>
		<link href="css/main.css" rel="stylesheet" type="text/css">
		<style type="text/css">
.c1 {
	color: black;
	font-style: Times;
	font-size: 16px;
	font-weight: 500;
}

a:hover {
	background-color: #FFC9AF;
}

a {
	text-decoration: none;
	color: #51AEF5;
}
</style>
	</head>
	<body>
	    <%
	       String userid = (String)session.getAttribute("uid");
	       System.out.println("user: "+userid); 
	    %>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						System Admin
					</h4>
					<table style="border: 1px solid #35719E" width="600px"
						align="center">
						<tr class="c1">
							<td>
								Restaurant 
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<a href="AddRestaurantInfo.jsp">Add Restaurant</a>
							</td>
							<td>
								<a href="Viewrestaurant.action?type_id=<%="1"%>">Search Restaurant</a>
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="2"%>">Delete Restaurant</a>
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="3"%>">Modify Restaurant</a>
							</td>
						</tr>
						<tr>
							<td>
								Admin Restaurant Foods
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<a href="AddFoodInfo.jsp">Add Food</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="1" %>">Search Food</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="2" %>">Delete Food</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="3" %>">Modify Food</a>
							</td>
						</tr>
						<tr>
							<td>
								Book Management
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<a href="reserve.action?ydcx=<%="1"%>">Search Booking</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="2" %>">Delete Booking</a>
							</td>
							<td colspan="2">
								&nbsp;
							</td>
						</tr>
						 <tr>
							<td>
								Customer
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td>
								<a href="search_user.jsp">Retrieve All Customer</a>
							</td>
							<td>
								<a href="query_user_page.jsp">Search Customer</a>
							</td>
							<td>
								<a href="delete_user_page.jsp">Delete Customer</a>
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
						
						<tr>
							<td>
								<a href="Index.jsp">Home</a>
								<a href="Logout.jsp">Logout</a>
							</td>
							<td colspan="3">
								&nbsp;
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>