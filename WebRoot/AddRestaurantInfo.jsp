<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.hnkj.hm.bean.GenericTable"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title></title>
		<link href="css/add.css" rel="stylesheet" type="text/css">
		<script>
		function back()
		{
           window.location.href = "./Admin.jsp";
		}
		</script>
	</head>
	<body>
		<%
			String restaurantId = GenericTable.getMaxPK("restaurant_Id", "T_restaurant", "A");
		%>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						Add Restaurant | important: Please add every field below!
					</h4>
					<s:form action="AddrestaurantInfo" method="post"
						enctype="multipart/form-data" theme="simple">
						<table style="border: 1px solid #ccc" align="center" width="500px"
							height="450px">
							<tr>
								<td>
									ID
								</td>
								<td>
									<input type="text" name="restaurantId" value="<%=restaurantId%>" readonly />
								</td>
							</tr>
							<tr>
								<td>
									Name
								</td>
								<td>
									<s:textfield name="restaurantName" id="restaurantName"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									Max Seat Provide
								</td>
								<td>
									<s:textfield name="quantity" id="quantity"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									Level
								</td>
								<td>
									<select name="star" id="star">
										<option value="1">
											Michelin-One-Star 
										</option>
										<option value="2">
											Michelin-Two-Star 
										</option>
										<option value="3">
											Michelin-Three-Star 
										</option>
										<option value="4">
											Michelin-Four-Star 
										</option>
										<option value="5">
											Michelin-Five-Star 
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									Price Average
								</td>
								<td>
									<s:textfield name="price" id="price"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									Image
								</td>
								<td>
									<s:file name="image">Important:You Must Upload Image</s:file>
								</td>
							</tr>
							<tr>
								<td>
									Location
								</td>
								<td>
									<select name="address" id="address">
										<option value="0">
											-- Select --
										</option>
										<option value="NEWYORK">
											NEWYORK
										</option>
										<option value="TOKYO">
											TOKYO
										</option>
										<option value="PARIS">
											PARIS
										</option>
										<option value="MALILAND">
											MALILAND
										</option>
										<option value="HAWAII">
											HAWAIII
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									Description
								</td>
								<td>
									<s:textarea name="description" cols="20" rows="3"></s:textarea>
								</td>
							</tr>
							<tr>
								<td>
									<s:submit value="Add" cssClass="buttonface"></s:submit>
								</td>
								<td>
									<s:reset value="Reset" cssClass="buttonface"></s:reset>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="return" class="buttonface" onClick="back()"/>
								</td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
		</div>
	</body>
</html>