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
		<link href="css/view.css" rel="stylesheet" type="text/css" />
		<script src="js/list.js" type="text/javascript" language="javascript"></script>
	</head>
	<body>
		<%
			ArrayList<restaurantVO> list = (ArrayList) request.getAttribute("list");
			PageBean pb = (PageBean) request.getAttribute("pagebean");
			String star = (String) request.getAttribute("star");
			int totalPage = pb.getTotalPage();
			int currentPage = pb.getCurrentPage();
			int nextPage = pb.getNextPage();
			int prevPage = pb.getPrevPage();
			System.out.println("list is: "+list.size());
		%>
		<div id="brand"></div>
		<div id="page">

			<h4>
				Restaurant Information
			</h4>

			<div id="content">
				<div id="main">
					<table style="border: 1px solid #ccc" width="780px" align="center">
						<tr>
							<td>
								Image
							</td>
							<td>
								Restaurant Name
							</td>
							<td>
								Type
							</td>
							<td>
								Price 
							</td>
							<td>
								Location
							</td>
							<td>
								Description
							</td>
						</tr>
						<%
							
							ListIterator<restaurantVO> it = list.listIterator();
							while (it.hasNext()) {
								restaurantVO restaurantvo = it.next();
								String image = restaurantvo.getImageFileName();
								String name = restaurantvo.getrestaurantName();
								String stars = restaurantvo.getStar();
								String address = restaurantvo.getAddress();
								String description = restaurantvo.getDescription();
                                float price = restaurantvo.getPrice();
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

						<tr>
							<td>
								<img src="upload/<%=image%>" width="60" height="50"
									style="border: 1px solid #ccc" />
							</td>
							<td>
								<%=name%>
							</td>
							<td>
								<%=stars%>
							</td>
							<td>
								$<font color="#FF5500"><%=price%></font>
							</td>
							<td><%=address%></td>
							<td><%=description%></td>
						</tr>
						<%
							}
						%>
					</table>
					<table align="center" width="780px" style="border: 1px solid #ccc">
						<tr>
							<td>
								Current[<%=currentPage%>/Totally<%=totalPage%>Page]
							</td>
							<td>
								<a href="ShowrestaurantInfo.action?star=<%=star%>&pageNo=<%=1%>">First</a>
							</td>
							<td>
								<a
									href="ShowrestaurantInfo.action?star=<%=star%>&pageNo=<%=prevPage%>">Previous</a>
							</td>
							<td>
								<a
									href="ShowrestaurantInfo.action?star=<%=star%>&pageNo=<%=nextPage%>">Next</a>
							</td>
							<td>
								<a
									href="ShowrestaurantInfo.action?star=<%=star%>&pageNo=<%=totalPage%>">Last</a>
							</td>
							<td>
								<a href="Index.jsp">Return&nbsp;</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>