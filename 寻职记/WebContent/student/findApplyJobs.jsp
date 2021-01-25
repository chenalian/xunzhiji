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
	<%
			// 获取用户信息
			Student user=(Student)request.getSession().getAttribute("user");
	%>
	<ul class="nav nav-tabs">
	  <li class=""><a href="student/user.jsp"><span class="glyphicon glyphicon-user">个人主页</span></a></li>
	  <li><a href="SearchJobs"><span class="glyphicon glyphicon-search">搜索工作</span></a></li>
	  <li><a href="student/changeInfo.jsp"><span class="glyphicon glyphicon-edit">修改个人信息</span></a></li>
	  <li><a href=""><span class="glyphicon glyphicon-envelope">查看简历提交状态</span></a></li>
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
						简历提交状态
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
						<div class="center-block" align="center" style="font-size:30px;">
									
									<!-- 查询自己提交的简历情况 -->
									<table class="table table-bordered table-hover">
										<thead>
											<tr>
												
												
												
												<th> 
												 <span class="glyphicon glyphicon-tree-conifer">Job</span>
												</th>
												<th> 
													<span class="glyphicon glyphicon-tree-deciduous">enterprice</span>
												</th>
												<th>
													<span class="glyphicon glyphicon-folder-open">student</span>
													
												</th>
												
												<th>
													<span class="glyphicon glyphicon-heart">state</span>
													
												</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${applyjobs}" var="keyword1" varStatus="id" begin="0">	
													<tr>
														 <td>
																<c:out value="${keyword1.getJobid()}" default="查询有误"></c:out>
															
														 </td>
														 <td>
																<c:out value="${keyword1.getQid()}" default="查询有误"></c:out>
															
														 </td>
														  <td>
																<c:out value="${keyword1.getUid()}" default="查询有误"></c:out>
															
														 </td>
														 <td>
														 		<c:if test="${keyword1.getState()eq '0' }">企业未读</c:if>
														 		<c:if test="${keyword1.getState()eq '1' }"><p style="color:red">简历通过</p></c:if>
														 		<c:if test="${keyword1.getState()eq '2' }">简历不通过</c:if>
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