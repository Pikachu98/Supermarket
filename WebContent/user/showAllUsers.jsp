<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>    
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
	    margin-bottom: 60px;
	}
</style>
</head>
<body>
<div class="shower">
	用户管理
</div>

<div class = "banner_right">
	<table width = "100%" border="1" cellpadding="0" cellspacing="0" style="table-layout:fixed">
		<tr>
			<th height = "40px">ID</th>
			<th height = "40px">姓名</th>
			<th height = "40px">密码</th>
			<th height = "40px">性别</th>
			<th height = "40px">电话</th>
			<th height = "40px">邮箱</th>
			<th height = "40px">商场代码</th>
			<th height = "40px">修改/删除</th>
		</tr>
				
		<%
			List<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
			
			if(list != null && list.size() > 0){
				for(HashMap<String, String> map: list){
		%>
		<tr>
				<td><%=map.get("userId") %></td>
				<td><%=map.get("userName") %></td>
				<td><%=map.get("password") %></td>
				<%String gender =  map.get("gender");
					String gr = null;
					if(gender.equals("1")){
						gr = "女";
					}else{
						gr = "男";
					}
				%>
				<td><%=gr %></td>
				<td><%=map.get("phone") %></td>
				<td><%=map.get("mail") %></td>
				<td><%=map.get("userId") %></td>
				<td>
					<a href = "SearchUserServlet?id=<%=map.get("userId") %>"><button>修改</button></a>
					<a href = "RemoveUserServlet?id=<%=map.get("userId") %> "><button>删除</button></a>
				</td>
		</tr>
			
		 <% 
				}
			}else{
		%>
			<tr>
				<td colspan="6">当前没有数据</td>
			</tr>
		<%}
		%>
				
				
	</table>

</body>
</html>