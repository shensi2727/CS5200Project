<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>

<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>

<%@ page import="com.hnkj.hm.vo.restaurantVO"%>
<%@ page import="com.hnkj.hm.bean.PageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
		<link href="css/add.css" style="text/css" rel="stylesheet">
		<script src="js/list.js" type="text/javascript" language="javascript"></script>
        <script type="text/javascript" language="javascript">
	     function deleterestaurant(restaurantId,image)
	     {
	        var type_id = 2;
	        if(confirm("Do you really want to delete？"))
	        {
	          window.location.href= "delrestaurant.action?type_id="+type_id+"&id="+restaurantId+"&img="+image;
	        }
	     }
	    </script>
	</head>
	<body>
	<body>
		<%
			ArrayList<restaurantVO> list = (ArrayList) session.getAttribute("list");
			PageBean pb = (PageBean) session.getAttribute("pagebean");
			int totalPage = pb.getTotalPage();
			int currentPage = pb.getCurrentPage();
			int nextPage = pb.getNextPage();
			int prevPage = pb.getPrevPage();
		%>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						Delete Restaurant
					</h4>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								Restaurant ID
							</td>
							<td>
								Restaurant NAME
							</td>
							<td>
								TYPE
							</td>
							<td>
								LOCATION
							</td>
							<td>
								PRINCE
							</td>
							<td>
								OPERATION
							</td>
						</tr>
						<%
							ListIterator<restaurantVO> it = list.listIterator();
							while (it.hasNext()) {
								restaurantVO restaurantvo = it.next();
								String id = restaurantvo.getrestaurantId();
								String name = restaurantvo.getrestaurantName();
								String stars = restaurantvo.getStar();
								String address = restaurantvo.getAddress();
								float price = restaurantvo.getPrice();
								String image = restaurantvo.getImageFileName();
								
								if (stars.equals("1")) {
									stars = "Michelin-One-Star";
								} else if (stars.equals("2")) {
									stars = "Michelin-Two-Star";
								} else if (stars.equals("3")) {
									stars = "Michelin-Three-Star";
								} else if (stars.equals("4")) {
									stars = "Michelin-Four-Star";
								} else if (stars.equals("5")) {
									stars = "Michelin-Five-Star";
								}
						%>
						<tr onClick="mouseClickTr(this)" onMouseOver="mouseOverTr(this,'over')" onMouseOut="mouseOverTr(this,'out')">
							<td>
								<%=id%>
							</td>
							<td>
								<%=name%>
							</td>
							<td>
								<%=stars%>
							</td>
							<td>
								<%=address%>
							</td>
							<td>
								<%=price%>
							</td>
							<td>
							<!--
							<a href="delproduct.action?type_id=<%="2" %>&id=<%="" %>&img=<%="" %>">Delete</a>
							-->
							<input type="button" onClick="deleterestaurant('<%=id%>','<%=image%>')" value="Delete" class="buttonface">
							</td>
						</tr>
						<%
							}
						%>
						
					</table>
					<table align="center" width="750px"
						style="border: 1px solid #ccc">
						<tr>
							<td>
								Current Page[<%=currentPage%>/Total<%=totalPage%>Page]
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="2"%>&pageNo=<%=1%>">First</a>
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="2"%>&pageNo=<%=prevPage%>">Previous</a>
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="2"%>&pageNo=<%=nextPage%>">Next</a>
							</td>
							<td>
								<a href="findrestaurant.action?type_id=<%="2"%>&pageNo=<%=totalPage%>">Last</a>
							</td>
							<td>
								<a href="Admin.jsp">Return&nbsp;</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>