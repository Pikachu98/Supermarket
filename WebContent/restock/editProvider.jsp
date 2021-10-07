<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="hzyc.com.hw.model.Provider"%>

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
	修改供应商信息
</div>

	<% Provider v = (Provider)request.getAttribute("pro"); %>

	<form action = "EditProviderServlet" method = "post">
		<table style="margin:0 auto">
			<tr>
				<td>ID</td>
				<td colspan = "2"><input type = "text" readonly = "readonly" value = "<%=v.getProviderId() %>"  name = "id"/></td>
			</tr>
			<tr>
				<td>供应商名称</td>
				<td colspan = "2">
					<input type = "text" value = "<%=v.getProviderName() %>" required="required" name = "name" />
				</td>
			</tr>
			<tr>
				<td>供应商地址</td>
				<td colspan = "2"><input type = "text"  value = "<%=v.getProviderAddress() %>" required="required"  name = "address"/></td>
			</tr>
			<tr>
				<td>联系人</td>
				<td colspan = "2"><input type = "text"  value = "<%=v.getContact() %>" required="required"  name = "contactName"/></td>
			</tr>
			<tr>
				<td>电话</td>
				<td colspan = "2"><input type = "text"  value = "<%=v.getContactNum() %>" required="required"  name = "contactNum"/></td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td colspan = "2"><input type = "text"  value = "<%=v.getContactEmail() %>" required="required"  name = "contactEmail"/></td>
			</tr>
			<tr>
  				<td align="center"><input type="submit" value="修改" /></td>
  					<!-- 注意！此处应当把href放到button里，否则会被当作提交事件，进而跳转EditVipServlet里 -->
  				<td align = "center"><a href = "ShowProviderServlet"><button>取消</button></a></td> 			 
  			</tr>
		</table>
	</form>
</body>
</html>