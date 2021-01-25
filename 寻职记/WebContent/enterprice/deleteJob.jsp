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
	  <title>企业删除工作页面</title> 
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</style>
</head> 

<body>
	<%
			// 获取用户信息
			Enterprice user=(Enterprice)request.getSession().getAttribute("user");
	%>
	<ul class="nav nav-tabs">
	  <li class=""><a href="enterprice/user.jsp"><span class="glyphicon glyphicon-user">个人主页</span></a></li>
	  <li><a href="enterprice/publishJob.jsp"><span class="glyphicon glyphicon-pencil">发布工作</span></a></li>
	  <li><a href=""><span class="glyphicon glyphicon-trash">删除工作</span></a></li>
	  <li><a href="QrecevieJL"><span class="glyphicon glyphicon-envelope">信箱</span></a></li>
	  <li><a href="enterprice/changeInfo.jsp"><span class="glyphicon glyphicon-edit">修改个人信息</span></a></li>
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
						删除工作
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
						<div class= "center-block" align="center" style="font-size:30px;">
							<table class="table table-hover" align="center">
								<thead>	
									<tr>
											<th>
												<span class="glyphicon glyphicon-tree-conifer">工作id</span>
											</th>
											<th>
												<span class="glyphicon glyphicon-tree-deciduous">工作</span>
											</th>
											<th>
												<span class="glyphicon glyphicon-flag">企业</span>
											</th>
											<th>
												删除
											</th>
									</tr>
								</thead>
							<tbody>
								<c:forEach items="${jobsByid}" var="keyword" varStatus="id" begin="0">
										<tr>
											 <td>
												<c:out value="${keyword.getJobid() }" default="查询有误"></c:out>				 	
											 </td>
											<td>
												<c:out value="${keyword.getPost() }" default="查询有误"></c:out>						 	
											 </td>
											 <td>
												<c:out value="${keyword.getQname() }" default="查询有误"></c:out>						 	
											 </td>
											<td>
												<a href="QDeleteJobs?jobidtemp=${keyword.getJobid()}"><span class="glyphicon glyphicon-trash"></span></a>
											</td>
										</tr>
									</c:forEach>
							</tbody>	
							</table>
						</div>
				</td>
			</tr>
		</tbody>
	</table>
 </body>
 </html>