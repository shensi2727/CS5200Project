<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ page import="java.util.List"%>

<%@ page import="com.hnkj.hm.bean.GenericTable"%>
<%@ page import="com.hnkj.hm.dao.IfoodDAO"%>
<%@ page import="com.hnkj.hm.dao.impl.foodDAO"%>
<%@ page import="com.hnkj.hm.vo.foodVO"%>
<%@ page import="com.hnkj.hm.dao.impl.restaurantDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type"
			content="text/html; charset=ISO-8859-1">
		<title></title>
		<link href="css/add.css" rel="stylesheet" type="text/css">
		<script src="js/My97DatePicker/WdatePicker.js" type="text/javascript"
			language="javascript"></script>
		<script lanaguage='jvascript'>
		function back()
		{
           window.location.href = "./Index.jsp";
		}
		</script>
	</head>
	<body>
		<br>
		<%
			String reserveId = GenericTable.getMaxPK("reserve_Id", "T_Reserve",
					"R");
			IfoodDAO reservedao = new foodDAO();
			List<foodVO> rlist = reservedao.findfoodById("1");

			restaurantDAO restaurantdao = new restaurantDAO();
			List<String> hlist = restaurantdao.findrestaurantById("1");
		%>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						Restaurant Reserve
					</h4>
					<%
					   String userId = (String)request.getAttribute("userId");
					   //if(null == userId || "".equals(userId)){
					   //  out.print("<script language=javascript>alert('Please Login First£¡');location.href='Login.jsp';</script>");
					   //}
				    %>
					<form action="Reserve.action" method="post">
						<table style="border: 1px solid #ccc" width="500px" height="300px"
							align="center">
							<tr>
								<td>
									ID
								</td>
								<td>
									<input name="reserveId" value="<%=reserveId%>"
										class="inputControl" readonly/>
									<input name="userId" type="text" value="<%=userId %>" style="display:none">
								</td>
							</tr>
							<tr>
								<td>
									Food ID
								</td>
								<td>
									<select name="foodId" id="foodId">
										<%
											for (int i = 0; i < rlist.size(); i++) {
												foodVO foodVo = rlist.get(i);
										     
										%>
										<option value="<%=foodVo.getfoodId()%>"><%=foodVo.getfoodId()%></option>
										<%
											}
										%>
									</select>

								</td>
							</tr>
							<tr>
								<td>
									Restaurant ID
								</td>
								<td>
									<select name="restaurantId" id="restaurantId">
										<%
										    String restaurantid="";
											for (int i = 0; i < hlist.size(); i++) {
											    restaurantid = hlist.get(i).toString();
										%>
										<option value="<%=restaurantid%>" onClick="query()"><%=restaurantid%></option>
										<%
											}
										%>
									</select>
									<!--  &nbsp;&nbsp;
									<% 
									   //List<String> nlist = restaurantdao.findrestaurantById(restaurantid);
									   
									%>
									<input type="text" value="<%="nlist.get(0)"%>" class="inputControl" readonly/>
								-->
								</td>
							</tr>
							<tr>
								<td>
									Number of Person
								</td>
								<td>
									<input type="text" name="people" id="people" class="inputControl"/>
								</td>
							</tr>
							<tr>
								<td>
									Start Time
								</td>
								<td>
									<input class="Wdate" type="text"  id="startTime" name="startTime" onfocus="new WdatePicker(this)"/>		
								</td>
							</tr>
							<tr>
								<td>
									End Time
								</td>
								<td>
									<input type="text" name="overTime" id="overTime" class="Wdate" onfocus="new WdatePicker(this)"/>
								</td>
							</tr>
							<tr>
								<td>
									<input type="submit" value="Add" class="buttonface"/>
								</td>
								<td>
									<input type="reset" value="Reset" class="buttonface"/>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="button" value="Return" class="buttonface" onClick="back()"/>
								</td>
							</tr>
						</table>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>
