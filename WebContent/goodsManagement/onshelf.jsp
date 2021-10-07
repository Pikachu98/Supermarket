<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
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
	td{
		text-align:center;
		height:25px;
	}
</style>
</head>
<body>
<div class="shower">
	商品上架管理
</div>
	<%
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("one");
		
		
	%>
	
	<!-- 获取上架数量，根据这个数字修改剩余库存量(goods_info子表) 同时，将这些信息存储在shelf表里
		shelf表： id, goods_name, sold_price, count, picture
	 -->
	<form action = "EditOnshelfServlet" method ="post" enctype = "multipart/form-data">
		<table style = "margin: 0 auto;">
			<tr>
				<td>存储ID</td>
				<td colspan = "2"><input style = "color:red;" type = "text" readonly = "readonly"  name = "stock_id" value = "<%=list.get(0).get("stock_id") %>"/></td>
			</tr>
			<tr>
				<td>商品条形码</td>
				<td colspan = "2"><input style = "color:red;" type = "text" readonly = "readonly"  name = "barcode" value = "<%=list.get(0).get("barcode") %>"/></td>
			</tr>
		 	<tr>
				<td>商品名称</td>
				<td colspan = "2"><input style = "color:red;" type = "text" readonly = "readonly" color = "red" name = "goodsName" value = "<%=list.get(0).get("goodsName") %>"/></td>
			</tr>
			<tr>
				<td>商品种类</td>
				<td colspan = "2"><input style = "color:red;" type = "text" readonly = "readonly" color = "red" name = "category" value = "<%=list.get(0).get("category") %>"/></td>
			</tr>
			<tr>
				<td>库存剩余</td>
				<td colspan = "2"><input style = "color:red;" type = "text" name = "restockAmount" color = "red" readonly = "readonly"  value = "<%=list.get(0).get("amount") %>"/></td>
			</tr>
			<tr>
				<td>上架数量</td>
				<td colspan = "2"><input type = "number" name = "count" required="required" min = "1" max = "<%=list.get(0).get("amount") %> step ="1" name= "count"/></td>
			</tr>

			<tr>
				<td>进货价</td>
				<td colspan = "2"><input style = "color:red;" type = "text" readonly = "readonly" color = "red" name = "boughtPrice" value = "<%=list.get(0).get("boughtPrice") %>" /></td>
			</tr>
			
			<tr>
				<td>上架价格</td>
				<td colspan = "2"><input type = "number" required = "required" min = "0.1" step = "0.1" name = "soldPrice" /></td>
			</tr>  
			
			
			
			<tr>
				<td>宣传图</td>
				<td><input type = "file" name = "picPath"/></td>
			</tr>
			<tr>
				<td></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center"><input type = "submit" value = "提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>