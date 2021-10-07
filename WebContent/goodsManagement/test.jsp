<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
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
<!-- <img src = "../goodspics/1596678607819.jpg" /> -->


<div id= "containerTime">
	<div >
		选择查询条件：
		<select onchange = "change(this.options[this.selectedIndex].value)">
			<option value = "time">时间</option>
			<option value = "good">商品</option>
			
		</select>
	</div>
	<br>
	<div >请选择开始日期：<input type = "date" name = "startDate" /></div>
	<br>
	<div>请选择结束日期：<input type = "date" name = "endDate" /></div>
	<br>
	<div><a href = "searchGoodsByDateServlet"><button>查询</button></a></div>
</div>

<div id = "containerGood">
	<div>请输入商品名：<input type = "text" name = "goodsName" /></div>
</div>
</body>
</html>