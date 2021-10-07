<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
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
	新建用户
</div>


	<form action = "../CreateUserServlet" method = "post">
		<table style="margin:0 auto">
			<tr>
				<td>姓名</td>
				<td colspan = "2">
					<input type = "text" required="required" name = "name" />
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td colspan = "2">
					<input type = "text"  required="required" name = "password" />
				</td>
			</tr>
			<tr>
				<td>性别</td>  
					<td colspan = "2">
							<select>
							<option>男</option>
							<option>女</option>
							</select>
					</td>
		
			</tr>
			<tr>
				<td>电话</td>
				<td colspan = "2">
					<input type = "number"  required="required" name = "phone" />
				</td>
			</tr>
			<tr>              
				<td>邮箱</td>
				<td colspan = "2">
					<input type = "text"  required="required" name = "mail" />
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
  				<td align="center"><input type="submit" value="修改" /></td>
  						 
  			</tr>
		</table>
	</form>
</body>

</html>