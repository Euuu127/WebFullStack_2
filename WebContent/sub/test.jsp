
<%@page import="java.util.Random"%> //Java 임포트 중 ~
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>text jsp page</h1>
	<%  //여긴 Java 영역임
		Random random = new Random();
		int num = random.nextInt(100);
		String name = request.getParameter("name");
		String age = request.getParameter("age");
	%>
	
	<h1><%=num %></h1>
	<h1><%=name%></h1>
	<h1><%=age %></h1>
	

</body>
</html>