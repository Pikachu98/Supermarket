<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "hzyc.com.hw.model.GoodOnshelfInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示所有下架的商品</title>
<style>
	td{
		text-align:center;
		height: 35px;
	}
	.shower{
		margin:0 auto;
		width:100%;
		height: 30px;
	    font-size: 0.9em;
	    background-color: #FA1818;
	    color: #fff;
	    text-align: center;
	    line-height: 30px;
	    margin-bottom: 60px;
	}
</style>
</head>
<body>
<div class="shower">
	下架商品
</div>
<table width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
	<tr>
		<th height = "40px">ID</th>
		<th height = "40px">条形码</th>
		<th height = "40px">商品名</th>
		<th height = "40px">类别</th>
		<th height = "40px">售价</th>
		<th height = "40px">数量</th>
		<th height = "40px">图片</th>
		<!-- <th height = "40px">下架</th> -->
	</tr>
	<%
		List<GoodOnshelfInfo> list = (ArrayList<GoodOnshelfInfo>)request.getAttribute("list");
		
		for(GoodOnshelfInfo good: list){
	%>
	<tr>
		<td><%=good.getRestockId() %></td>
		<td><%=good.getBarcode() %></td>
		<td><%=good.getGoodsName() %></td>
		<td><%=good.getCategory() %></td>
		<td><%=good.getSoldPrice() %></td>
		<td><%=good.getCount() %></td>
		<td><img src = "goodspics/<%=good.getPicPath()%>" height = "35px"/></td>
		<%-- <td><a href = "RemoveGoodFromShelfServlet?id=<%=good.getRestockId() %>"><button>下架</button></a></td> --%>
	</tr>
	<%
		}
	%>
</table>
</body>
</html>