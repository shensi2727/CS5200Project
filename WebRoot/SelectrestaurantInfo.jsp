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
		<title>查询商品信息</title>
		<link href="css/add.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		.text {
			width: 100px;
		}
		</style>
		<script language="javascript" type="text/javascript">
        function selectByCondition(){
             
	         var address= document.getElementById("address").value;
	         var price= document.getElementById("priceRange").value;
	        
             location.href="Viewrestaurant.action?address="+address+"&priceRange="+price;
         
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
						Restaurant Information
					</h4>
					<div class="box">
                    <table align="center" style="height: 10px">
						<tr>
							<td>
								Location:
							</td>
							<td>
								<select name="address" id="address">
								    <option value="0">-请选择-</option>
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
								&nbsp;&nbsp;价格范围:
							</td>
							<td>
								<select name="priceRange" id="priceRange">
					
									<option value="100-200">
										100-200元
									</option>
									<option value="200-300">
										200-300元
									</option>
									<option value="300-400">
										300-400元
									</option>
									<option value="500-600">
										500-600元
									</option>
									<option value="700-800">
										700-800元
									</option>
									<option value="800-6000">
										800元以上
									</option>
								</select>
							</td>
							<td>
								&nbsp;&nbsp;
								<input type="button" value="查询" class="buttonface"
									onClick="selectByCondition()" />
							</td>
						</tr>
					</table>

					</div>
					<table style="border: 1px solid #ccc" width="750" align="center">
						<tr>
							<td>
								编号
							</td>
							<td>
								名称
							</td>
							<td>
								类型
							</td>
							<td>
								价格
							</td>
							<td>
								地点
							</td>
							<td>
								数量
							</td>
						</tr>
						<%
						    for(int i=0; i<listVo.size(); i++){
						       restaurantVO restaurantVo = listVo.get(i);
						   
						%>
						<tr>
							<td>
								<%=restaurantVo.getrestaurantId() %>
							</td>
							<td>
								<%=restaurantVo.getrestaurantName() %>
							</td>
							<td>
								<%=restaurantVo.getStar() %>
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
						%>
					</table>

				</div>
			</div>
		</div>
	</body>
</html>
