<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>    
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.text.DateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
		<th height = "40px">id</th>
		<th height = "40px">购物时间</th>
		<th height = "40px">总消费金额</th>
		<th height = "40px">购物人</th>
		<th height = "40px">详情</th>
	
	</tr>	
	<%
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
	
		for(HashMap<String,String> map: list){
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String sd = sdf.format(new Date(Long.parseLong(map.get("shopping_date"))));
	%>
	<tr>
		<td><%=map.get("shopping_id") %></td>
		<td><%=sd %></td>
		<td><%=map.get("total_cost") %></td>
		<td><%=map.get("name") %></td>
		<td><a href = "SearchSalesDetailServlet?shoppingid=<%=map.get("shopping_id") %>"><button>详情</button></a></td>
	</tr>
	<%		
		}
	%>

</table>
</body>
</html>