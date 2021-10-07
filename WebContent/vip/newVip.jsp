<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>new vip</title>
<link href = "../css/basic.css" rel="stylesheet" type = "text/css" />
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


<body>
<div class="shower">
	新建会员用户
</div>

 <form action="../AddVipServlet" method="post" >
  	<table style="margin:0 auto">
  		<tr>
  			<td>会员卡主名: </td>
  			<td><input type="text"  required="required" name="name"/></td>
  		</tr>
  		<tr>
  			<td colspan = "2" height = "30px"></td>
  		</tr>
  		<tr>
  			<td colspan = "2"></td>
  		</tr>
  		<tr>
  			<td align="center" colspan="2"><input type="submit" /></td>	 
  		</tr>
  	</table>
  </form>
</body>
</html>