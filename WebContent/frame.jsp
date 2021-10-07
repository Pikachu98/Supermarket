<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<frameset rows="160px,*"  border="2">
	<frame src = "title.jsp" />
	
	
	<frameset cols = "300px, *">
		<frame src = "left.jsp" name = "left"/>
		<frame src = "right.jsp" name = "right"/>
	</frameset>
</frameset>

</html>