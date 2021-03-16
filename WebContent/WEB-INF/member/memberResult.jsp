<%@page import="com.DKMK.s1.member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String result = (String)request.getAttribute("r"); //오브젝트 타입으로 나오니까 string으로 형변환
	MemberDTO memberDTO = (MemberDTO)request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member result page</h1>
	<h1><%= result %></h1>
	<%
		if(memberDTO != null) {%>
	
	
	<h1>ID : <%=memberDTO.getId() %></h1>
	<h1>Email : <%=memberDTO.getEmail() %></h1>
	
	<% } %>
</body>
</html>