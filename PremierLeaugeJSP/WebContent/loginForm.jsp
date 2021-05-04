<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<c:if test="${not empty errorMessage}">
	<span>${errorMessage}</span>
	</c:if>
	
	<form method="POST" action="LoginAction.do?action=login">
		<input type="text" name="id" placeholder="enter your id">
		<input type="password" name="password" placeholder="enter your password">
		<input type="submit" value="로그인">
	</form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>