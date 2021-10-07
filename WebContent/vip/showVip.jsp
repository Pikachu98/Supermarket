<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="hzyc.com.hw.model.Vip"%>
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
</style>
</head>
<body>
<div class="shower">
	会员管理
</div>

<div class = "banner_right">
	<table width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
		<tr>
			<th height = "40px">卡号</th>
			<th height = "40px">姓名</th>
			<th height = "40px">会员折扣(折)</th>
			<th height = "40px">总消费</th>
			<th height = "40px">总积分</th>
			<th height = "40px">创建时间</th>
			<th height = "40px">修改/删除</th>
		</tr>
				
		<%
			ArrayList<Vip> list = (ArrayList<Vip>)request.getAttribute("vips");
			
			if(list != null && list.size() > 0){
				for(Vip v: list){
		%>
		<tr>
				<td><%=v.getId() %></td>
				<td><%=v.getName() %></td>
				<td><%=v.getAuthority() %></td>
				<td><%=v.getCost() %></td>
				<td><%=v.getIntegral() %></td>
				<td><%=v.getCreatedDate() %></td>
		 <% 
			String id = v.getId();
		 	String realId = null;
			for(int i = 1; i < (id.length() - 1); i ++){
				if(id.charAt(i) == '0' && id.charAt(i+1) != '0'){
					realId = id.substring(i+1);
					break;
				}
			}
		
		%> 
				<td>
					<a href = "SearchVipServlet?id=<%=realId%>"><button>修改</button></a>
					<a href = "RemoveVipServlet?id=<%=realId%>"><button>删除</button></a>
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