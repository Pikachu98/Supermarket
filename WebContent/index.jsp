<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style>

	body{
		background: url('img/bgp.jpg');
		background-size: cover;
	}
	#wrapper{
		width:400px;
		height:305px;
		background-color: #fff;
		position:absolute;
		top:130px;
		left:335px;
		text-align: center;
	}
	/* #wrapper2{
		width:300px;
		height:300px;
		background-color: #000;
		position:absolute;
		top:130px;
		left:700px;
	} */
	
	input[type="text"] , input[type="password"]{
		width:270px;
		height:35px;
		border-radius: 3px;
		margin:20px 0 10px 0;
		border:1px solid #aaaaaa;
	}
	input[type="button"] {
		width:240px;
		height:40px; 
		background-color: #fd8632;
		color:#FFF;
		font-size:18px;
		border:0;
		margin-top:16px;
	}
	#title{
		font-size:24px;
		color:#666;
		height:68px;
		line-height: 80px;
	}
	#info{
		color:red;
		height:6px;
		font-size:12px;
	}
	#foot{
		margin-top:10px;
		font-size:14px;
		text-align: center;
	}
	#foot a{
		/*去掉a标签下的下划线*/
		text-decoration: none;
		color:#444;
	}
</style>
<script>
	function valid(){
		
		var username = document.getElementById("username").value;
		var pwd = document.getElementById("pwd").value;
		var infoDiv  = document.getElementById("info");
		if(username == ''){
			//innerText
			infoDiv.innerHTML = "<span>账号不能为空</span>";
		}else if(pwd == ''){
			infoDiv.innerHTML = "<span>密码不能为空</span>";
		}else{
			//1.创建XMLHttpRequest对象
			var req = new XMLHttpRequest();
			//2.打开通道三个参数      1.method 2.后台地址   3.是否异步
			req.open( "post", "LoginServlet" , true);
			//3.设置协议的请求头部  
			req.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//4.发送   post方式把数据发送到后台
			req.send("userInput="+username+"&pwd="+pwd);
			
			//ajax去接收服务器响应
			//当state的状态改变时会调用onreadystatechange属性指定的处理函数
			req.onreadystatechange = function(){
				//用来监听state的状态的 一旦状态改变   函数就会调用
				if(req.readyState == 4){
					//可以接收响应文本了
					var res = req.responseText;
					//响应文本
					if(res == '0'){
						infoDiv.innerHTML = "用户名(手机号/邮箱)或密码错误!";
					}else if(res == '1'){
						//
						location.href="user/userIndex.jsp";
					}else if(res == '2'){
						location.href = "frame.jsp";
					}
				}
			}
		}
		
	}
</script>
</head>
<body>

 	<div id="wrapper">
 		<div id="title">
 			账号密码登录
 		</div>
 		<!--  提示的文本  都通过js动态写到这个div中 -->
 		<div id="info">
 			
 		</div>
 		<form action="">
 			<input type="text" placeholder="手机号/邮箱" id="username"/>
 			<br />
 			<input type="password" placeholder="密码" id="pwd"/>
 			<br />
 			<input type="button" onclick="valid()" value="登录" />
 		 </form>
 		 <div id="foot">
 			 <a href="" >忘记密码</a>
 		</div>
 	</div>
 	<!-- <div id="wrapper2"></div> -->
</body>
</html>