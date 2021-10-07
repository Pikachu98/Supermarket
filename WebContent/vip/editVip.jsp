<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="hzyc.com.hw.model.Vip"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href = "../css/basic.css" rel="stylesheet" type = "text/css" />
<style>
/* 	a {
		text-decoration:none;
	}
	a:visited {
		text-decoration:none;
	}
	a:hover {
		text-decoration:none;
	}
	a:link {
		text-decoration:none;
	} */
	
	a {
   		text-decoration: none;
   		color:black;
	}
	/*正常的未被访问过的链接*/
	a:link {
	    text-decoration: none;
	}
	/*已经访问过的链接*/
	a:visited {
	    text-decoration: none;
	}
	/*鼠标划过(停留)的链接*/
	a:hover {
	    text-decoration: none;
	}
	/* 正在点击的链接*/
	a:active {
	    text-decoration: none;
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
	修改会员信息
</div>

	<% Vip v = (Vip)request.getAttribute("user"); %>

	<form action = "EditVipServlet" method = "post">
		<table style="margin:0 auto">
			<tr>
				<td>卡号</td>
				<td colspan = "2"><input type = "text" readonly = "readonly" value = "<%=v.getId() %>"  name = "id"/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td colspan = "2">
					<input type = "text" value = "<%=v.getName() %>" required="required" name = "name" />
				</td>
			</tr>
			<tr>
				<td>优惠折扣(折)</td>
				<td colspan = "2"><input type = "text"  disabled = "disabled" value = "<%=v.getAuthority() %>"  name = "discount"/></td>
			</tr>
			<tr>
				<td>消费金额</td>
				<td colspan = "2"><input type = "text"  disabled = "disabled" value = "<%=v.getCost() %>"  name = "cost"/></td>
			</tr>
			<tr>
				<td>积分</td>
				<td colspan = "2"><input type = "text"  disabled = "disabled" value = "<%=v.getIntegral() %>"  name = "integral"/></td>
			</tr>
			<tr>
				<td>创建日期</td>
				<td colspan = "2"><input type = "text"  disabled = "disabled" value = "<%=v.getCreatedDate() %>"  name = "date"/></td>
			</tr>
			<tr>
  				<td align="center"><input type="submit" value="修改" /></td>
  					<!-- 注意！此处应当把href放到button里，否则会被当作提交事件，进而跳转EditVipServlet里 -->
  				<td align = "center"><button><a href = "VipShowServlet">取消</a></button></td> 			 
  			</tr>
		</table>
	</form>
</body>
</html>