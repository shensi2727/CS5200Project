<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.util.List"%>

<%@ page import="com.hnkj.hm.bean.GenericTable"%>
<%@ page import="com.hnkj.hm.dao.impl.restaurantDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title></title>
		<link href="css/add.css" rel="stylesheet" type="text/css">
		<script type="text/javascript"> 
		
		function back()
		{
           window.location.href = "./Admin.jsp";
		}
		</script>
	</head>
	<body>
		<br>
		<%
			String foodId = GenericTable.getMaxPK("food_Id", "T_food", "N");
			
			restaurantDAO restaurantdao = new restaurantDAO();
			List<String> list = restaurantdao.findrestaurantById("1");
		%>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						Add Food 
					</h4>
					<s:form action="AddfoodInfo" method="post" theme="simple">
						<table style="border: 1px solid #ccc" width="500px" height="300px"
							align="center">
							<tr>
								<td>
									ID
								</td>
								<td>
									<input name="foodId" value="<%=foodId%>" readonly class="inputControl" />
								</td>
							</tr>
							<tr>
								<td>
									Restaurant ID
								</td>
								<td>
									<select name="restaurantId" id="restaurantId">
										<%
											for (int i = 0; i < list.size(); i++) {
													String restaurantid = list.get(i).toString();
										%>
										<option value="<%=restaurantid%>"><%=restaurantid%></option>
										<%
											}
										%>
									</select>

								</td>
							</tr>
							<tr>
								<td>
									Type
								</td>
								<td>
									
									<select name="foodName" id="foodName">
                                        <option value="Take-Out">Take-Out</option>
										<option value="Lobby">Lobby</option>
										<option value="Box">Box</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									Status
								</td>
								<td>
									<s:textfield name="status" value="Available" cssClass="inputControl"
										readonly="true"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									Price
								</td>
								<td>
									<s:textfield name="price" cssClass="inputControl"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									Discount
								</td>
								<td>
									<s:textfield name="discountPrice" cssClass="inputControl"></s:textfield>
								</td>
							</tr>
							<tr>
								<td>
									<s:submit value="Add" cssClass="buttonface"></s:submit>
								</td>
								<td>
									<s:reset value="Cancel" cssClass="buttonface"></s:reset>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="Return" class="buttonface" onClick="back()"/>
								</td>
							</tr>
						</table>
					</s:form>
				</div>
			</div>
		</div>
	</body>
</html>
