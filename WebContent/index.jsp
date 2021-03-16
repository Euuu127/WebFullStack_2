<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>index page</h1>
	<a href="./member/memberLogin.do">Member Login</a>
	
<!-- 	<form action="./member/memberLogin.do" method="get"> -->
	<form action="./sub/loginTest.jsp" method="get">
		<input type="text" name="id">
		<input type="password" name="pw">
		<button>login</button>
	</form>

	<h3><a href="./sub/test.jsp?name=mark&age=20">Go Test</a></h3> 
<!-- 	?기준 우측 parameter 좌측 url -->
	
</body>
</html>