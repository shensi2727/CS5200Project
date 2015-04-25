<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>

<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>

<%@ page import="com.hnkj.hm.vo.ReserveVO"%>
<%@ page import="com.hnkj.hm.bean.PageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
		<link href="css/add.css" style="text/css" rel="stylesheet">
		<script src="js/list.js" type="text/javascript" language="javascript"></script>
	</head>
	<body>
	<body>
		<%
			ArrayList<ReserveVO> list = (ArrayList) session
					.getAttribute("list");
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
						Reserve Information
					</h4>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								ID
							</td>
							<td>
								Food ID
							</td>
							<td>
								Name of Customer
							</td>
							<td>
								Price Approximate
							</td>
							<td>
								Totally
							</td>
							<td>
								Status
							</td>
							<td>
								Start Time
							</td>
							<td>
								End Time
							</td>
						</tr>
						<%
							ListIterator<ReserveVO> it = list.listIterator();
							while (it.hasNext()) {
								ReserveVO reserveVo = it.next();
						%>
						<tr onClick="mouseClickTr(this)"
							onMouseOver="mouseOverTr(this,'over')"
							onMouseOut="mouseOverTr(this,'out')">
							<td>
								<%=reserveVo.getReserveId()%>
							</td>
							<td>
								<%=reserveVo.getfoodId()%>
							</td>
							<td>
								<%=reserveVo.getUserId()%>
							</td>
							<td>
								<%=reserveVo.getPrice()%>
							</td>
							<td>
								<%=reserveVo.getTotal()%>
							</td>
							<td>
								<%=reserveVo.getStatus()%>
							</td>
                            <td>
								<%=reserveVo.getStartTime()%>
							</td>
							<td>
								<%=reserveVo.getOverTime()%>
							</td>
						</tr>
						<%
							}
						%>
					</table>
					<table align="center" width="750px" style="border: 1px solid #ccc">
						<tr>
							<td>
								Current [<%=currentPage%>/Totally<%=totalPage%>Page]
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="1"%>&pageNo=<%=1%>">First</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="1"%>&pageNo=<%=prevPage%>">Previous</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="1"%>&pageNo=<%=nextPage%>">Next</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="1"%>&pageNo=<%=totalPage%>">Last</a>
							</td>
							<td>
								<a href="Admin.jsp">Return</a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
</html>