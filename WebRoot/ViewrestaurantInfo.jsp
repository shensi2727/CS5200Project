<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.ListIterator"%>

<%@ page import="com.hnkj.hm.dao.impl.restaurantDAO"%>
<%@ page import="com.hnkj.hm.vo.restaurantVO"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title></title>
		<link href="css/add.css" rel="stylesheet" type="text/css" />
	
		<script language="javascript" type="text/javascript">
        function selectByCondition(){
        
             var id= document.getElementById("restaurantId").value;
             var name= document.getElementById("restaurantName").value;
	         var address= document.getElementById("address").value;
	         var price= document.getElementById("priceRange").value;
	        
             location.href="Viewrestaurant.action?restaurantId="+id+"&restaurantName"+name+"&address="+address+"&priceRange="+price;
         
        }
		
		function back()
		{
           window.location.href = "./Admin.jsp";
		}
        </script>
	</head>

	<body>
		<%
			ArrayList<restaurantVO> listVo = (ArrayList)request.getAttribute("restaurantVoList");
		    System.out.println("listvo: "+listVo);
		%>
		<div id="brand"></div>
		<div id="page">
			<div id="header">
			</div>
			<div id="content">
				<div id="main">
					<h4>
						Restaurant Search
					</h4>
					<div class="box">
                    <table align="center" style="width:750px; height:10px">
						<tr>
							<td>
								ID:
							</td>
							<td>
								<input type="text" name="restaurantId" id="restaurantId" class="inputControls" />
							</td>
							<td>
								Name:
							</td>
							<td>
								<input type="text" name="restaurantName" id="restaurantName" class="inputControls" />
							</td>
							<td>
								Location:
							</td>
							<td>
								<select name="address" id="address">
								    <option value="0">-Select-</option>
									<%
										restaurantDAO restaurantdao = new restaurantDAO();
										List<String> list = restaurantdao.findrestaurantById("2");
										ListIterator<String> it = list.listIterator();

										while (it.hasNext()) {
											String address = it.next().toString();
									%>
									<option value="<%=address%>"><%=address%></option>
									<%
										}
									%>
								</select>
							</td>
							<td>
								&nbsp;&nbsp;range of price :
							</td>
							<td>
								<select name="priceRange" id="priceRange">
					
									<option value="100,300">
										100-300 $
									</option>
									<option value="300,600">
										300-600 $
									</option>
									<option value="600,800">
										600-800 $
									<option value="800,6000">
										800$ above
									</option>
								</select>
							</td>
							<td>
								&nbsp;
								<input type="button" value="Search" class="buttonface"
									onClick="selectByCondition()" />
								&nbsp;
								<input type="button" value="Return" class="buttonface" onClick="back()"/>
							</td>
						</tr>
					</table>

					</div>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Type
							</td>
							<td>
								Price Avg
							</td>
							<td>
								Location
							</td>
							<td>
								Seat Quantity
							</td>
						</tr>
						<%
						if(null != listVo){
						    for(int i=0; i<listVo.size(); i++){
						       restaurantVO restaurantVo = listVo.get(i);
						       String star = restaurantVo.getStar();
						%>
						<tr>
							<td>
								<%=restaurantVo.getrestaurantId() %>
							</td>
							<td>
								<%=restaurantVo.getrestaurantName() %>
							</td>
							<td>
								<%
								   if(star.equals("1")){
								     star = "Michelin-One-Star";
								   }
								   else if(star.equals("2")){
								     star = "Michelin-Two-Star";
								   }
								   else if(star.equals("3")){
								     star = "Michelin-Three-Star";
								   }
								   else if(star.equals("4")){
								     star = "Michelin-Four-Star";
								   }
								   else if(star.equals("5")){
								     star = "Michelin-Five-Star";
								   }
								%>
								<%=star%>
							</td>
							<td>
								<%=restaurantVo.getPrice() %>
							</td>
							<td>
								<%=restaurantVo.getAddress() %>
							</td>
							<td>
								<%=restaurantVo.getQuantity() %>
							</td>
						</tr>
						<%
						  }
						 }
						%>
					</table>

				</div>
			</div>
		</div>
	</body>
</html>
