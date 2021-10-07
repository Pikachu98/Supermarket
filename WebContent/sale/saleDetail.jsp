<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>    
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
	    margin-bottom: 30px; 
	}
	
	.container{
		text-align:center;
		margin-bottom: 30px; 
	}
</style>
</head>
<body>
<div class = "shower">
	购买详情
</div>

<table  width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
	<tr>
		<th height = "40px">ID</th>
		<th height = "40px">商品名</th>
		<th height = "40px">单价</th>
		<th height = "40px">购买数量</th>		
		<th height = "40px">单项消费</th>
		<th height = "40px">退货</th>
	
	</tr>	
	<%
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
	
		for(HashMap<String,String> map: list){
			
	%>
	<tr>
		<td><%=map.get("order_id") %></td>
		<td><%=map.get("goods_name") %></td>
		<td><%=map.get("sold_price") %></td>
		<td><%=map.get("bought_count") %></td>
		<td><%=map.get("single_cost") %></td>
		<td><a href = "SearchSingleSaleServlet?orderid=<%=map.get("order_id") %>"><button>退 / 换货</button></a></td>
	</tr>
	<%		
		}
	%>

</table>

</body>
</html>