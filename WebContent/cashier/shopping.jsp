<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "hzyc.com.hw.model.GoodOnshelfInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>展示所有在架的商品</title>
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
	
	#cardNum,#cost,#newVip{
		text-align:center;
		margin-bottom: 10px;
	}
	
	#spend, #spend1, #yuan{
		color:red;
		font-size:30px;
	}
	
	#cardInfo{
		color:blue;
		font-size:12px;
	/* 	display: none; */
	}
	
	#discount{
		display:none;
	}
</style>
<script>

function valid(){
	var cardNumber = document.getElementById("cardNumber").value;
	//console.log(cardNumber);

	var req = new XMLHttpRequest();
	req.open("post", "JudgeCardNumberServlet", true);
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send("cardNumber="+cardNumber);
	
	req.onreadystatechange = function(){
		//用来监听state的状态的 一旦状态改变   函数就会调用
		if(req.readyState == 4){
			//可以接收响应文本了
			var res = req.responseText;
			//响应文本
			if(res == '0.0'){
				document.getElementById("cardInfo").innerHTML = "卡号错误!";
			}else{
				document.getElementById("cardInfo").innerHTML = "此卡打" + res + "折!";
				document.getElementById("discount").value = res;
				document.getElementById("finalCardId").value = cardNumber;
				//console.log(document.getElementById("discount").value)
			}
		} 
	}
/* 	console.log(document.getElementById("discount").value); */
}


var cost = 0;

function add(i){
	var elementName = "number" + i;
 	var number = document.getElementById(elementName).value;
	number  = parseInt(number) + 1;
	
	var tds = document.getElementsByTagName("td");
	
	/* 点击之后，数字框就会变成增加1之后的值 */
	if(number <= tds[5].innerHTML)
		document.getElementById(elementName).value = number; 
	
	
	/* 获取所有行数，注意这里index要从1开始，因为0行没有东西 */
	var trs = document.getElementsByTagName("tr");
	var tr = trs[i+1];
	
	
	/* cost + 获取这一行的所有td后，td[4] (商品单价) = 价格 */	
	var singlePrice = tr.getElementsByTagName("td")[4].innerHTML;
	cost += parseFloat(singlePrice);
	
	document.getElementById("spend").innerHTML = cost;
	var discount = document.getElementById("discount").value * 0.1;
	document.getElementById("spend1").innerHTML = Math.round(cost * discount * 100) /100;
	
}

function substract(k){
	var elementName = "number" + k;
 	var number = document.getElementById(elementName).value;
	number  = parseInt(number) - 1;

	if(number >= 0)
		document.getElementById(elementName).value = number;
	
	/* 获取所有行数，注意这里index要从1开始，因为0行没有东西 */
	var trs = document.getElementsByTagName("tr");
	var tr = trs[k+1];
	
	
	/* cost - 获取这一行的所有td后，td[4] (商品单价) = 价格 */	
	var singlePrice = tr.getElementsByTagName("td")[4].innerHTML;
	cost -= parseFloat(singlePrice);
	
	document.getElementById("spend").innerHTML = cost;
}

function getInfo(){
	//获取表格所有行数
	var trs = document.getElementsByTagName("tr");	
	var list = [];
	
	//从index 0开始遍历,因为input框的id是从0开始的，所以长度要比table的行数少2，因为还有一行是提交按钮
	for(var i = 0; i < trs.length - 2; i++ ){
		//获取数量input框的id
		var elementName = "number" + i;
		//如果购买的数量不是0，就添加到json数组里
		var count = document.getElementById(elementName).value;
		/* console.log(count); */
		if(count != 0){
			//从第index 1 行开始
			var tr = trs[i+1];
			/* console.log(tr); */
			var json = {};
			//goodsId
			var td0 = tr.getElementsByTagName("td")[0].innerHTML;
			//barcode
			var td1 = tr.getElementsByTagName("td")[1].innerHTML;
			//goods name
			var td2 = tr.getElementsByTagName("td")[2].innerHTML;
			//category
			var td3 = tr.getElementsByTagName("td")[3].innerHTML;
			//soldPrice
			var td4 = tr.getElementsByTagName("td")[4].innerHTML;
			//amount
			var td5 = tr.getElementsByTagName("td")[5].innerHTML;
	
			//totalCost
			var singleCost = td4 * count;
			/* console.log(document.getElementById("discount").value); */
			
			//打几折
			var discount = document.getElementById("discount").value * 0.1;
			
			//rest amount is 
			var restAmount = parseInt(td5) - count;
			
			json.goodsId = td0;
			json.barcode = td1;
			json.goodsName = td2;
			json.category = td3;
			json.soldPrice = td4;
			json.boughtCount = parseInt(count);
			json.restAmount = restAmount;
			json.singleCost = Math.round(singleCost * discount * 100) /100;
			
			list.push(json);
		} 
	}
  	 console.log(list); 
	
	 
 	var cardNum = document.getElementById("finalCardId").value
	var req = new XMLHttpRequest();
	req.open("post", "PayBillServlet", true);
    req.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
	req.send("data=" + JSON.stringify(list) + "&cardNum=" + cardNum); 
	
	/* console.log(JSON.stringify(list)); */
	
	
}
</script>
</head>
<body>
<div class="shower">
	购物/结账
</div>
<form action = ""> 
	<div id = "cardNum">
		<span id = "cardInfo"></span>
		<br>
		请输入会员卡号：<input type = "text" id = "cardNumber" name = "cardNumber" onblur = "valid()"/>
		<input type="button" onclick="valid()" value="查询" />
		<br>
	</div>
</form>

<input type = "text" hidden = "hidden" value = "0" name = "finalCardId" id = "finalCardId" />
<input type = "text" hidden = "hidden" value = "10" name = "discount" id = "discount" />
<div id = "newVip">
	<a href = "vip/newVip.jsp"><button>新建会员</button></a>
</div>
<div id = "cost">
	当前消费：<span id = "spend">0</span><span id = "yuan"> 元</span>
	 打折价： <span id = "spend1">0</span><span id = "yuan"> 元</span>
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
		<th height = "40px">购买</th>
	</tr>
	<%
		List<GoodOnshelfInfo> list = (ArrayList<GoodOnshelfInfo>)request.getAttribute("list");
		
		int length = list.size();
		/* GoodOnshelfInfo good: list */
		for(int i = 0; i < length; i++){
			GoodOnshelfInfo good = list.get(i);
	%>
	<tr>
		<td><%=good.getRestockId() %></td>
		<td><%=good.getBarcode() %></td>
		<td><%=good.getGoodsName() %></td>
		<td><%=good.getCategory() %></td>
		<td><%=good.getSoldPrice() %></td>
		<td><%=good.getCount() %></td>
		<td><img src = "goodspics/<%=good.getPicPath()%>" height = "35px"/></td>
		<td>
			<div id = "test">
			 	<input type = "image" src = "img/jian.png" style = "vertical-align:middle;" onclick = "substract(<%=i%>)"/> 
				<input type = "text" id = "number<%=i %>" value = "0" readonly = "readonly" style = "text-align:center;width:15px;vertical-align:middle;" />
				<input type = "image" src = "img/jia.png" style = "vertical-align:middle;" onclick = "add(<%=i%>)"/>
			</div>
		</td>
		
	</tr>
	<%
		}
	%>
	<tr>
		<td colspan = "8"><input type = "submit" value = "结账" onclick = "getInfo()"></td>
	</tr>
	
</table>

</body>
</html>