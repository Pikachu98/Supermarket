<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="hzyc.com.hw.model.Provider"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href = "../css/basic.css" rel="stylesheet" type = "text/css" />
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
	    margin-bottom: 60px;
	}
	#containerTime{
		text-align:center;
	}
</style>
</head>
<body>
<div class="shower">
	供应商管理
</div>

<div class = "banner_right">
	<div id= "containerTime">
			<br>
			<div >请输入供应商名称：<input type = "text" name = "searchName" /></div>
			<br>
			<div><a href = "SearchProviderByNameServlet"><button>查询</button></a></div>
			<br>
	</div>
	<table width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
		<tr>
			<th height = "40px">供应商ID</th>
			<th height = "40px">供应商名称</th>
			<th height = "40px">供应商地址</th>
			<th height = "40px">联系人</th>
			<th height = "40px">电话</th>
			<th height = "40px">邮箱</th>
			<th height = "40px">修改/删除</th>
		</tr>
				
		<%
			ArrayList<Provider> list = (ArrayList<Provider>)request.getAttribute("pro");
			
			if(list != null && list.size() > 0){
				for(Provider v: list){
		%>
		<tr>
				<td><%=v.getProviderId() %></td>
				<td><%=v.getProviderName() %></td>
				<td><%=v.getProviderAddress() %></td>
				<td><%=v.getContact() %></td>
				<td><%=v.getContactNum() %></td>
				<td><%=v.getContactEmail() %></td>

				<td>
					<a href = "SearchProviderServlet?id=<%=v.getProviderId() %>"><button>修改</button></a>
				<%-- 	<a href = "RemoveVipServlet?id=<%=v.getProviderId() %>"><button>删除</button></a> --%>
				</td>
		</tr>
		<%
				}
			}else{
		%>
			<tr>
				<td colspan="6">当前没有数据</td>
			</tr>
		<%	}
		%>
				
				
	</table>
</div>
</body>
</html>