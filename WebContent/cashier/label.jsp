<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function add(){
		var number = document.getElementById("number").value;
		number  = parseInt(number) + 1;
	/* 	console.log(number); */

		document.getElementById("number").value = number;
	}
	
	function substract(){
		var number = document.getElementById("number").value;
		number  = parseInt(number) - 1;
	/* 	console.log(number); */
		if(number >= 0)
			document.getElementById("number").value = number;
	}
</script>
</head>
<body>

<input type = "number" min = "0" step ="1" max = "45">
<div id = "test">
 	<input type = "image" src = "../img/jian.png" style = "vertical-align:middle;" onclick = "substract()"/> 
	<input type = "text" id = "number" value = "0" readonly = "readonly" style = "text-align:center;width:15px;vertical-align:middle;" />
	<input type = "image" src = "../img/jia.png" style = "vertical-align:middle;" onclick = "add()"/>
</div>
</body>
</html>