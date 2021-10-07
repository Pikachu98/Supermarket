<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>    
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


<body>
<div class="shower">
	退/换货原因填报
</div>
<!-- 退货数量
退货原因 -->

 <form action="BackGoodsServlet" method="post" >
  	<table style="margin:0 auto">
  	<%
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
	
		
			
	%>
		<tr>
  			<td>请选择退货还是换货: </td>
  			<td>
  				<select name = "type">
  					<option>退货</option>
  					<option>换货</option>
  				</select>
  			</td>
  		</tr>
  	
  	  	<tr>
  	  		<!-- 作为外键存储 -->
  			<td>订单ID: </td>
  			<td><input type = "text" readonly="readonly" name = "orderId" value = "<%=list.get(0).get("order_id") %>">
  			</td>
  		</tr>	
  		<tr>
  			<td>条形码: </td>
  			<td><input type="text"  readonly="readonly" name="barcode" value = "<%=list.get(0).get("barcode") %>"/>  				
  			</td>
  		</tr>
  		<tr>
  			<td>商品名: </td>
  			<td><input type="text"  readonly="readonly" name="name" value = "<%=list.get(0).get("goods_name") %>"/></td>
  		</tr>
		<tr>
  			<td>购买数量: </td>
  			<td><input type="text"  readonly="readonly" name="boughtCount" value = "<%=list.get(0).get("bought_count") %>"/></td>
  		</tr>
  		<tr>
  			<td>退/换货数量: </td>
  			<td><input type="number" min = "1" step = "1" max = "<%=list.get(0).get("bought_count") %>" required="required" name="changeCount"/></td>
  		</tr>
  		<tr>
  			<td>退/换货原因: </td>
  			<td><input type="text"  required="required" name="reason"/></td>
  		</tr>
  		<tr>
  			<td>经手人: </td>
  			<td><input type="text"  required="required" name="processor"/></td>
  		</tr>
  		<tr>
  			<td align="center" colspan="2"><input type="submit" /></td>	 
  		</tr>
 
  	</table>
  </form>
</body>
</html>