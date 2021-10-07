<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	商品库存情况明细
</div>
<table width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
	<tr>
		<th height = "40px">条形码</th>
		<th height = "40px">商品名</th>
		<th height = "40px">数量</th>
		<th height = "40px">进价</th>
		<th height = "40px">过期日期</th>
		<th height = "40px">距离过期(天)</th>
		<th height = "40px">上架处理</th>
	</tr>
	
	<% 
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("info");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(date);
		int days;
		for(HashMap<String, String> map: list){
			String expiration = map.get("expirationDate");
			
			try {
				Date date1 = sdf.parse(today);
				Date date2 = sdf.parse(expiration);
				
				days = (int)((date2.getTime() - date1.getTime()) / 1000 / 60 / 60 /24);
				
			
			
	%>
	<!-- 如果商品距离过期小于等于10天，则对管理者进行提示 -->
		<tr>
			<td><%=map.get("barcode") %></td>
			<td><%=map.get("goodsName") %></td>
			<td><%=map.get("amount") %></td>
			<td><%=map.get("boughtPrice") %></td>
			<td><%=map.get("expirationDate") %></td>
			<%if (days <= 10 ){%>
				<td><font size="3" color="red" size ="5">仅剩<% out.print(days); %>天，尽快上架！</font></td>
			<%}else{%>
				<td><% out.print(days); %></td>
			<%}%>
			<td><a href = "SearchGoodStockServlet?id=<%=map.get("stock_id") %>"><button>上架</button></a>
				<!-- <a href = "outshelf.jsp"><button>下架</button></a></td> -->
		</tr>
	<%
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	%>
</table>
</body>
</html>