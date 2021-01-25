<%@page import="Bao.Student"%>
<%@page import="Bao.Enterprice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<!-- saved from url=(0068)http://demo.sc.chinaz.com//Files/DownLoad/webjs1/201409/jiaoben2826/ -->
<html lang="en" class="no-js"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK"> 
   
   <!-- 新 Bootstrap 核心 CSS 文件 --> 
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 --> 
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script> 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 --> 
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	  <title>学生个人页面</title> 
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</style>
</head> 

<body>
	
	<ul class="nav nav-tabs">
	  
	  <li class=""><a href="administrator/user.jsp"><span class="glyphicon glyphicon-user">个人主页</span></a></li>
	  <li><a href="QueryJobs"><span class="glyphicon glyphicon-fire">审核商家发布的工作</span></a></li>
	  <li><a href=""><span class="glyphicon glyphicon-leaf">审核商家和学生注册</span></a></li>
	  <li><a href="QueryJobByPage"><span class="glyphicon glyphicon-home">回到主页</span></a></li>
	</ul>
<table class="table table-bordered table-hover">
		<thead>
			<tr >
				<th >
					<div align="center">
					用户头像
					</div>
				</th>
				<th>
					<div align="center">
						用户详细信息
					</div>
				</th>
				
			</tr>
		</thead>
		
		<tbody>
			<tr height="600px">
				<td width="30%" >
					<div class="center-block" align="center" style="font-size:30px; align:50px;">
						<img src="/images/<%=request.getSession().getAttribute("uid") %>.png" height="300px" width="300px"/>
						<!--  取出用户的头像-->
					</div>
				</td>
				<td width="70%" >
						<div class="center-block" align="center" style="font-size:20px;">
							<h1>审核学生</h1>
								<form  action="PassStudents" method="post" id="">
									<table class="table table-bordered table-hover">
										<thead>
											<tr>
												<th><span class="glyphicon glyphicon-user">身份证号码</span></th>
												<th><span class="glyphicon glyphicon-tint">姓名</span></th>
												<th><span class="glyphicon glyphicon-picture">学历</span></th>
												<th><span class="glyphicon glyphicon-hdd">学校</span></th>
												<th><span class="glyphicon glyphicon-thumbs-up">PASS</span></th>
												<th><span class="glyphicon glyphicon-thumbs-down">NPASS</span></th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${students}" var="keyword" varStatus="id" begin="0">
										<tr>
											<td>
											<c:out value="${keyword.getUident()}" default="查询有误"></c:out>
											</td>
											<td>
											<c:out value="${keyword.getUname()}" default="查询有误"></c:out>
											</td>
											<td>
											<c:out value="${keyword.getUxueli()}" default="查询有误"></c:out>
											</td>
											<td>
											<c:out value="${keyword.getUschool()}" default="查询有误"></c:out>
											</td>
											<td><input type="radio" name="${keyword.getUid()}" value="tg"/></td>
											<td><input type="radio" name="${keyword.getUid()}" value="btg"/></td>
										</tr>
										</c:forEach>
										<!-- <tr cosplan="1" align="center">
											<td><input type="submit" value="审核" /></td>
										</tr> -->
										
										</tbody>
									</table>
									<script>
										
									function chufa()
							 		{
							 			//alert(1);
							 			var temp=document.getElementById("form");
										temp.submit();
							 		}
									function chufa2()
								 		{
								 			//alert(1);
								 			var temp=document.getElementById("form1");
											temp.submit();
								 		}
									</script>
									<button class="btn btn-link" onClick="chufa()"> <span class="glyphicon glyphicon-send" style="font-size: 30px">Response</span></button>
								</form>
								<h1>审核企业</h1>
								<form  action="PassEnterprices" method="post" id="form2">
									<table class="table table-bordered table-hover">
										<thead>
											<tr>
												<th><span class="glyphicon glyphicon-user">企业名称</span></th>
												<th><span class="glyphicon glyphicon-picture">企业营业执照</span></th>
												<th><span class="glyphicon glyphicon-tint">企业地址</span></th>
												<th><span class="glyphicon glyphicon-envelope">企业邮箱</span></th>
												<th><span class="glyphicon glyphicon-thumbs-up">PASS</span></th>
												<th><span class="glyphicon glyphicon-thumbs-down">NPASS</span></th>
											</tr>
										</thead>
										<tbody>
										<c:forEach items="${enterprices}" var="keyword" varStatus="id" begin="0">
										<tr>
											<td>
												<c:out value="${keyword.getUname()}" default="查询有误"></c:out>
											</td>
											<td>
												<c:out value="${keyword.getUlicense()}" default="查询有误"></c:out>
											</td>
											<td>
												<c:out value="${keyword.getUaddr()}" default="查询有误"></c:out>
											</td>
											<td>
												<c:out value="${keyword.getUmail()}" default="查询有误"></c:out>
											</td>
											<td><input type="radio" name="${keyword.getUid()}" value="tg"/></td>
											<td><input type="radio" name="${keyword.getUid()}" value="btg"/></td>
										</tr>
										</c:forEach>
										<!-- <tr cosplan="1" align="center">
											<td><input type="submit" value="审核" /></td>
										</tr> -->
										
										</tbody>
									</table>
									<button class="btn btn-link" onClick="chufa2()"> <span class="glyphicon glyphicon-plane" style="font-size: 30px">Response</span></button>
								</form>
						</div>
				</td>
			</tr>
		</tbody>
	</table>
 </body>
 </html>