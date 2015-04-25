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
	    <script type="text/javascript" language="javascript">
	     function deleteReserve(reserveId)
	     {
	        var ydcx = 2;
	        if(confirm("Do you really want to delete？"))
	        {
	          window.location.href= "deleteReserve.action?ydcx="+ydcx+"&id="+reserveId;
	        }
	     }
	    </script>
	
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
						Delete Booking
					</h4>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								Booking ID
							</td>
							<td>
								FOOD ID
							</td>
							<td>
								Customer
							</td>
							<td>
								Book Price
							</td>
							<td>
								Total
							</td>
							<td>
								Status
							</td>
							<td>
								Start Time
							</td>
							<td>
								Leave Time
							</td>
							<td>&nbsp;&nbsp;Operation</td>
						</tr>
						<%
							ListIterator<ReserveVO> it = list.listIterator();
							while (it.hasNext()) {
								ReserveVO reserveVo = it.next();
								String reserveId = reserveVo.getReserveId();
						%>
						<tr onClick="mouseClickTr(this)"
							onMouseOver="mouseOverTr(this,'over')"
							onMouseOut="mouseOverTr(this,'out')">
							<td>
								<%=reserveId%>
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
							<td><input type="button" value="Delete" onClick="deleteReserve('<%=reserveId %>')" class="buttonface"></td>
						</tr>
						<%
							}
						%>
					</table>
					<table align="center" width="750px" style="border: 1px solid #ccc">
						<tr>
							<td>
								Current Page[<%=currentPage%>/Total<%=totalPage%>Page]
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="2"%>&pageNo=<%=1%>">First</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="2"%>&pageNo=<%=prevPage%>">Previous</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="2"%>&pageNo=<%=nextPage%>">Next</a>
							</td>
							<td>
								<a href="reserve.action?ydcx=<%="2"%>&pageNo=<%=totalPage%>">Last</a>
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