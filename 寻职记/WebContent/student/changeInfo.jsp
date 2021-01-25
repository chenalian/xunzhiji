<%@page import="Bao.Student"%>
<%@page import="Bao.Enterprice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	  <li class=""><a href="user.jsp"><span class="glyphicon glyphicon-user">个人主页</span></a></li>
	  <li><a href="../SearchJobs"><span class="glyphicon glyphicon-search">搜索工作</span></a></li>
	  <li><a href=""><span class="glyphicon glyphicon-edit">修改个人信息</span></a></li>
	  <li><a href="../findapplystate"><span class="glyphicon glyphicon-envelope">查看简历提交状态</span></a></li>
	  <li><a href="../QueryJobByPage"><span class="glyphicon glyphicon-home">回到主页</span></a></li>
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
						修改个人信息
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
								<table class="table table-bordered table-hover">
									<form role="form" action="../changeInfo" method="post">
										<thead>
										</thead>
										<tbody>
											<tr>
												<td width="90%" align="center">
													昵称:<input type="text" name="unicheng"/>
												</td>
												<td width="10%" align="left">
													<span class="glyphicon glyphicon-edit"></span>
												</td>
											</tr>
											<tr>
												<td width="90%" align="center">
													<input type="file" name="utouxiang"/>
												</td>
												<td width="10%" align="left">
													<span class="glyphicon glyphicon-edit"></span>
												</td>
											</tr>
											<tr>
												<td width="90%" align="center">
													电话:<input type="text" name="utel"/>
												</td>
												<td width="10%" align="left">
													<span class="glyphicon glyphicon-edit"></span>
												</td>
											</tr>
											
											<tr>
												<td width="90%" align="center">
													邮箱:<input type="text" name="umail"/>
												</td>
												<td width="10%" align="left">
													<span class="glyphicon glyphicon-edit"></span>
												</td>
											</tr>
										</tbody>
									</form>
							</table>
						</div>
				</td>
			</tr>
		</tbody>
	</table>
 </body>
 </html>