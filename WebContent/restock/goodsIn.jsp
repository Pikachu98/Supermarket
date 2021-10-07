<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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

<script>
	function validBarcode(){
		var barcode = document.getElementById("id").value;
		console.log(barcode);
		if(barcode.length == 13){
			var info = document.getElementById("barcodeInfo");
			for(var i = 0; i < barcode.length; i++){
				if(true){
					info.innerText = "条形码只能是数字";
					document.getElementById("button").setAttribute("disabled", true);
				}
			}
		}else{
			var info = document.getElementById("barcodeInfo");
			info.innerText = "条形码格式不对,要有13位";
			document.getElementById("button").removeAttribute("disabled");
		}
	}
</script>
</head>
<body>
<div class="shower">
	输入进货信息
</div>
	<form action = "../AddGoodServlet" method = "post">
		<table style="margin:0 auto">
			<tr>
				<td>条形码</td>
				<td colspan = "2"><input type = "text" required="required" id ="id" name = "barcode"/></td>
				<td><span id = "barcodeInfo"></span></td>
			</tr>
			<tr>
				<td>商品名</td>
				<td colspan = "2"><input type = "text" required="required" name = "name"/></td>
			</tr>
			<tr>
				<td>种类</td>
				<td>
	  				<select name="category">          
	  					<option>饮料</option>
	  					<option>八宝粥</option>
	  					<option>香肠</option>
	  					<option>罐头</option>
	  					<option>花生瓜子</option>
	  					<option>洗漱用品</option>
	  				</select>
  				</td>
			</tr>
			<tr>
	  			<td>数量</td>
	  			<td>
	  				<input type="number" required="required" name="amount" min="1" />
	  			</td>
  			</tr>
  			<tr>
  				<td>供应商</td>
  				<td><input type="text"  required="required" name="provider"/></td>
  			</tr>
  			<tr>
	  			<td>进价</td>
	  			<td>
	  				 <input type="number" required="required" name="boughtPrice" min="0.1" step="0.1" />
	  			</td>
  			</tr>
  			<!-- 标价应该交给商品管理员处理 -->
<!--   			<tr>                          
	  			<td>标价</td>
	  			<td>
	  				 <input type="number" required="required" name="soldPrice" min="0.1" step="0.1" />
	  			</td>
  			</tr> -->
  			<tr>
	  			<td>进货员</td>
	  			<td>
	  				 <input type="text" required="required" name="buyer" min="0.1" step="0.1" />
	  			</td>
  			</tr>
  			<tr>
	  			<td>购买日期</td>
	  			<td>
	  				 <input type="date" required="required" name="boughtDate" min="0.1" step="0.1" />
	  			</td>
  			</tr>
  			<tr>
	  			<td>过期日期</td>
	  			<td>
	  				 <input type="date" required="required" name="expiration" min="0.1" step="0.1" />
	  			</td>
  			</tr>
  			
  			<tr>
	  			<td colspan = "3" align = "center"><input type="submit" value="提交" id="button" /></td>
	  			
  			</tr>
  		</table>
  	</form>
</body>
</html>