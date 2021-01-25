<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生查询特定工作页面</title>
</head>
<body>
<h1>学生查询特定工作页面</h1>
	<form action="../findJobby" method="post">
		地点：<input type="radio" name="judge" value="addr" /><br/>
		职位：<input type="radio" name="judge" value="post" /><br/>
		薪水：<input type="radio" name="judge" value="salary" /><br/>
		查询内容：<input type="text" name="text" /><br/>
		<input type="submit" value="查询"/> 
	</form>
	<%-- <%
		if(request.getParameter("jobstemp")==null)
		{
			%>
				jobstemp为空
			<% 
		}
	%> --%>
	<c:forEach items="${jobstemp}" var="keyword" varStatus="id" begin="0">
					<div class="job">
						<table align="center">
						<tr>
							 <td>
								<a href="#"><c:out value="${keyword.getJobid()}" default="查询有误"></c:out></a>
							 </td>
						</tr>
						<tr>
							 <td>
								发布人id：<c:out value="${keyword.getQid()}" default="查询有误"></c:out>
							 </td>
						</tr>
						 <tr>
							 <td>
								企业名称：<c:out value="${keyword.getQname()}" default="查询有误"></c:out>
							 </td>
						</tr>
						 <tr>
							 <td>
								职位：<c:out value="${keyword.getPost()}" default="查询有误"></c:out>
							 </td>
						</tr>
						<tr>
							 <td>
								职位要求：<c:out value="${keyword.getPostneed()}" default="查询有误"></c:out>
							 </td>
							 
						</tr>
						<tr>
							  <td>
								地址：<c:out value="${keyword.getJobaddr()}" default="查询有误"></c:out>
							 </td>
						</tr>
						 <tr>
							 <td>
								薪水：<c:out value="${keyword.getSalary()}" default="查询有误"></c:out>
							 </td>
						</tr>
						<tr>
							 <td>
								发布时间：<c:out value="${keyword.getsTime()}" default="查询有误"></c:out>
							 </td>
						 </tr>
						 <tr>
							 <td>
								截止时间：<c:out value="${keyword.geteTime()}" default="查询有误"></c:out>
							 </td>
						 </tr>
					 </table>
					 </div>
			</c:forEach>
</body>
</html>