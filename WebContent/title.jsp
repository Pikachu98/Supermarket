<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>超市系统</title>
<link href = "css/basic.css" rel = "stylesheet" type ="text/css" />
</head>
<body>
	<div id = "header">
		<div id = "title">超市系统</div><div id = "title_right"><a href = "index.jsp" target="_parent"><img src = "img/person.png" id = "person_pic" ></a></div>
		<div class = "clear"></div>
	</div>
	
	<div class = "logo_products">
		<div class = "container">
			<div class = "logo_product_left">
				<h1>
					<span>Qianwen</span>
					<br>
						   STORE
				</h1>
			</div>	
			
			<div class = "logo_product_left2">
				<ul class = "functions">
					<li>
						<a href = "restock/restockIndex.jsp" target = "left">进货管理</a>
						<i>/</i>
					</li>
					<li>
						<a href = "goodsManagement/goodsManagementIndex.jsp" target = "left">商品管理</a>
						<i>/</i>
					</li>
					<li>
						<a href = "sale/saleIndex.jsp" target = "left">销售管理</a>
						<i>/</i>
					</li>
					<li>
						<!-- 退换货应该在此下面【商品销售收银(用户能否打折)+退换货】 -->
						<a href = "cashier/cash.jsp" target = "left">收银系统</a>	
						<i>/</i>
					</li>
					<li>					
						<a href = "vip/vipIndex.jsp" target = "left">会员管理</a>
					</li>
				</ul>
			</div>
			
			<div class = "logo_product_left2">
				<ul class="phone_email">
					<li>
						<img src = "img/phone.png">
						<span style = "font-size:13px;margin-right:15px">18761807858</span>
					</li>
					<li>
						<img src = "img/mail.png">
						<span style = "font-size:13px">qianwenzhangnancy@gmail.com</span>
					</li>
				</ul>
			</div>
			
		</div>
	</div>	
</body>
</html>