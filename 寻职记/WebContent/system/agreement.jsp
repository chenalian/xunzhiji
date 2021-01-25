<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  #img{z-index:-1;position:absolute;width:100%;height:100%;}
  .a{position:absolute;left:50%;top:50%;transform:translate(-50%,-50%);
     background-color:#FFFFFF;opacity:0.7;
	 width:600px;height:800px;}
</style>
</head>
<body scoll="no">
  <img alt="no" src="../images/2.jpg" id="img" />
  <div class="a">
  			<form name="form" action="return checkuser" method="post" >  
			<h1>寻职记协议</h1><br/>
			同意：<input type="checkbox" id="xieyi" name="xieyi" /><br/>
			
			学生：<input type="radio" name="state" value="student" /><br/>
			企业:<input type="radio" name="state" value="enterprice"/><br/>
			
			<input type="button" value="提交" onClick="checkuser(form.state.value)"/>
		</form>
  </div>
</body>
</html>
<script type="text/javascript">
	function checkuser(str)
	{
		if(str=="")
		{
			alert("请选择注册用户类型");
			
		}
		else if(!document.getElementById("xieyi").checked)
		{
			alert("请同意寻职记协议");
		}
		else{
			//alert(str);
			window.location.href="register.jsp?state="+str;
		}
	}
</script>