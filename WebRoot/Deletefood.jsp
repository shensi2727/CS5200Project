<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>

<%@ page import="com.hnkj.hm.vo.foodVO"%>
<%@ page import="com.hnkj.hm.bean.PageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=GBK">
		<title></title>
		<link href="css/add.css" style="text/css" rel="stylesheet">
        <script src="js/list.js" type="text/javascript" language="javascript"></script>
	    <script type="text/javascript" language="javascript">
	     function deletefood(foodId)
	     {
	        var kfcx = 2;
	        if(confirm("Confirm？"))
	        {
	          window.location.href= "deletefood.action?kfcx="+kfcx+"&id="+foodId;
	        }
	     }
	    </script>
	</head>
	<body>
	<body>
		<%
			ArrayList<foodVO> list = (ArrayList) request.getAttribute("list");
			PageBean pb = (PageBean) request.getAttribute("pagebean");
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
						Delete Food
					</h4>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								Food ID
							</td>
							<td>
								NAME
							</td>
							<td>
							    Status
							</td>
							<td>
							   Available
							</td>
							<td>
								Price
							</td>
							<td>
								Discount
							</td>
							<td>
							    Operation
							</td>
						</tr>
						<%
							ListIterator<foodVO> it = list.listIterator();
							while (it.hasNext()) {
								foodVO foodvo= it.next();
								String foodId = foodvo.getfoodId();
								String isAvailable = foodvo.getAvailable();
								if(isAvailable.equals("Y")){
									isAvailable = "Yes";
								}
								if(isAvailable.equals("N")){
								    isAvailable = "No";	
								}
						%>
						<tr onClick="mouseClickTr(this)" onMouseOver="mouseOverTr(this,'over')" onMouseOut="mouseOverTr(this,'out')">
							<td>
								<%=foodId%>
							</td>
							<td>
								<%=foodvo.getfoodName()%>
							</td>
							<td>
							   <%=foodvo.getStatus() %>
							</td>
							<td>
							   <%=isAvailable %>
							</td>
							<td>
								<%=foodvo.getPrice()%>
							</td>
							<td>
								<%=foodvo.getDiscountPrice()%>
							</td>
							<td>
							<input type="button" value="Delete" class="buttonface" onClick="deletefood('<%=foodId %>')">
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
								Current Page[<%=currentPage%>/Totally<%=totalPage%>Page]
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="2"%>&pageNo=<%=1%>">First</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="2"%>&pageNo=<%=prevPage%>">Pre</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="2"%>&pageNo=<%=nextPage%>">Next</a>
							</td>
							<td>
								<a href="food_info.action?kfcx=<%="2"%>&pageNo=<%=totalPage%>">Last</a>
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