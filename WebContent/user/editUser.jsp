<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	
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

	<% List<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>)request.getAttribute("list");
		HashMap<String, String> map = list.get(0);
	%>

	<form action = "EditUserServlet" method = "post">
		<table style="margin:0 auto">
			<tr>
				<td>id</td>
				<td colspan = "2"><input type = "text" readonly = "readonly" value = "<%=map.get("userId") %>"  name = "id"/></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td colspan = "2">
					<input type = "text" value = "<%=map.get("userName") %>" required="required" name = "name" />
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td colspan = "2">
					<input type = "text" value = "<%=map.get("password") %>" required="required" name = "password" />
				</td>
			</tr>
			<tr>
				<td>性别</td>  
				<%
					String gender = map.get("gender");
					if(gender.equals("1")){
				%>
					<td colspan = "2">
						<input type = "text" value = "女" required="required" name = "gender" />
					</td>
				
				<%		
					}else{
				%>
					<td colspan = "2">
							<input type = "text" value = "男" required="required" name = "gender" />
					</td>
				
				<% 		
					}
				%>
			</tr>
			<tr>
				<td>电话</td>
				<td colspan = "2">
					<input type = "text" value = "<%=map.get("phone") %>" required="required" name = "phone" />
				</td>
			</tr>
			<tr>              
				<td>邮箱</td>
				<td colspan = "2">
					<input type = "text" value = "<%=map.get("mail") %>" required="required" name = "mail" />
				</td>
			</tr>
			<tr>
				<td>所属商场</td>
				<td colspan = "2">
					<select name = "mart">
						<option>1</option>
						<option>2</option>
					</select>
				</td>
			</tr>
			<tr>
  				<td align="center"><input type="submit" value="提交" /></td>
  				<!-- 注意！此处应当把href放到button里，否则会被当作提交事件，进而跳转EditVipServlet里 -->
  				<td align = "center"><a href = "ShowAllUsersServlet"><button>取消</button></a></td> 	
  			</tr>
		</table>
	</form>
</body>
</html>