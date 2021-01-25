<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>聊天室</h1>
		<h2>企业回复学生页面</h2>
		<table border="1">
			<tr>
					<td>
						<!-- 将文件中的信息读取发送到该页面 -->
							接收消息：
						<textarea style="overflow-x:scroll" rows="10" cols=40" id="tishi">
							
						</textarea>
					</td >
						
						
					<td>发送消息
					<form  metnod="post" name="form1" id="form1">
						<input type="text" name="message" id="message"/><br/>
						接收id:<input type="text" name="fabuid" id="fabuid" readonly="readonly" value="<%=request.getParameter("fabuid") %>" /> 
						<input type="button" value="提交" onClick="sendinfo()">
					</form>
					</td>
			</tr>
		</table>
</body>
</html>
<script> 
	//action="../AddChatInfo?fabuid=form1.fabuid.value&message=form1.message.value"
	var xmlhttp=null;
	function sendinfo(){ 
		var message = document.getElementById("message");
		//alert(message.value);
		if(message.value=="")
		{ 
			alert("发送信息不能为空"); 
			return false; 
		}  
		else{ 
			// 开始发送信息
			// ../AddChatInfo?fabuid=form1.fabuid.value&message=form1.message.value
					
			//document.getElementById("message").value="";// 清空发送信息		
					
			var fabuid=document.getElementById("fabuid").value;
			var message=document.getElementById("message").value;
			
			
			
			document.getElementById("message").value="";// 清空发送信息		
			// 异步的方式将信息发送到服务器存储
			//createRequest('../CheckStudentuid?uid='+encodeURIComponent(str));// 通过该函数异步将信息发送到服务器
			createRequest('../AddChatInfo?fabuid='+fabuid+'&message='+message);// 通过该函数异步将信息发送到服务器
			//alert("creatquest");
			createRequest("");
			//document.getElementById("form1").submit(); 
			
		} 
	}
	 function createRequest(url)
	 {
		// alert("到达createRequest");
		 if (window.XMLHttpRequest)
		 {
		     //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		     xmlhttp=new XMLHttpRequest();
		 }
		 else
		 {
		     // IE6, IE5 浏览器执行代码
		     xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 if(!xmlhttp)
			 {
			 //alert("xmlhttp不能创造");
			 return false;
			 }
		 //xmlhttp.onreadystatechange=getResult;//调用返回结果处理函数
		 xmlhttp.open('GET',url,true);//创建与服务器的连接
		 xmlhttp.send(null);//向服务器发送请求
	 }
	 function receive()// 接收信息
	{
		//alert("没过5s中开始刷新一次")
		 
		 // 接收人的id
		
		var qid=document.getElementById("fabuid").value;
		
		createRequesttwo('../RecevieInfo?qid='+qid);
	}
	 function createRequesttwo(url)
	 {
		// alert("到达createRequest");
		 if (window.XMLHttpRequest)
		 {
		     //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		     xmlhttp=new XMLHttpRequest();
		 }
		 else
		 {
		     // IE6, IE5 浏览器执行代码
		     xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		 }
		 if(!xmlhttp)
			 {
			 //alert("xmlhttp不能创造");
			 return false;
			 }
		 xmlhttp.onreadystatechange=getResult;//调用返回结果处理函数
		 xmlhttp.open('GET',url,true);//创建与服务器的连接
		 xmlhttp.send(null);//向服务器发送请求
	 }
	 function getResult()
	 {
		// alert("到达getResult");
		 if( xmlhttp.readyState==4)
		 {
		 	if(xmlhttp.status==200){
		 		//alert("服务器返回的数据："+xmlhttp.responseText);
		 		if(xmlhttp.responseText!=''){
				 	document.getElementById("tishi").innerHTML=document.getElementById("tishi").innerHTML+"\n"+xmlhttp.responseText;// 设置提示内容
		 		}
			 	//alert(xmlhttp.responseText);
			 	document.getElementById("tishi").style.display="block";
			}
		 	else{
		 		alert("您所请求的页面有错误");
		 	}
		 }
		 else{
			 //alert("存在错误");
		 }
	 }
	window.setInterval(receive,3000); // 美过1S中读取聊天信息
</script>