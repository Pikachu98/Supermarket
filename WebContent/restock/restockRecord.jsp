<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进货记录</title>
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
	
	#container{
		text-align:center;
		margin-bottom: 30px; 
	}
	#containerTime{
		text-align:center;
	}

	#containerGood{
		text-align:center;
		display:none;
	}
</style>
<script>
function change(x){
	
	if(x == "good"){
		/* .style.display='none' */
		document.getElementById("containerTime").style.display = "none";
		document.getElementById("containerGood").style.display = "block";
	}
	if(x == "time"){
		/* .style.display='none' */
		document.getElementById("containerTime").style.display = "block";
		document.getElementById("containerGood").style.display = "none";
	}
}
</script>
</head>
<body>
<div class = "shower">
	进货记录
</div>


<form action = "SearchGoodsByDateServlet" method = "post">
<div id = "container">
	
		<div >选择查询条件：
			<select onchange = "change(this.options[this.selectedIndex].value)">
				<option value = "time">时间</option>
				<option value = "good">商品</option>
			</select>
		</div>
	<div id= "containerTime">
		<br>
		<div >请选择开始日期：<input type = "date" name = "startDate" /></div>
		<br>
		<div>请选择结束日期：<input type = "date" name = "endDate" /></div>
		<br>
		<div><a href = "searchGoodsByDateServlet"><button>查询</button></a></div>
	</div>

	<div id = "containerGood">
		<br>
		<div>请输入商品名：<input type = "text" name = "goodsName" /></div>
		<br>
		<div><a href = "searchGoodsByDateServlet"><button>查询</button></a></div>
	</div>
</div>	

<table  width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
	<tr>
		<th height = "40px">条形码</th>
		<th height = "40px">商品名</th>
		<th height = "40px">种类</th>
		<th height = "40px">数量</th>
		<th height = "40px">供应商</th>
		<th height = "40px">进价</th>
		<th height = "40px">进货员</th>
		<th height = "40px">进货日期</th>		
	</tr>	
	<%
		ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
	
		if(list.isEmpty()){
		%>
		<tr>
			<td colspan = "8">没有相关数据</td>
		</tr>
		<%
		}else{
			for(HashMap<String,String> map: list){
			%>
			<tr>
				<td><%=map.get("barcode") %></td>
				<td><%=map.get("goodsName") %></td>
				<td><%=map.get("category") %></td>
				<td><%=map.get("amount") %></td>
				<td><%=map.get("provider") %></td>
				<td><%=map.get("boughtPrice") %></td>
				<td><%=map.get("buyer") %></td>
				<td><%=map.get("date") %></td>
			</tr>
			<%		
			}
		}
	%>

</table>
</form>
</body>
</html>