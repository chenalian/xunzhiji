<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page isELIgnored="false"%><!--引用EL-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!--引用JSTL-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
	<%
		String name=request.getParameter("state");
		//response.getWriter().print(name);
		if(name.equals("student"))
		{
			%><c:import url="studentR.jsp"></c:import><%
		}
		else if(name.equals("enterprice")){
			%><c:import url="enterpriceR.jsp" ></c:import><% 
		}
		//else response.getWriter().print(name);
	%>
</body>
</html>