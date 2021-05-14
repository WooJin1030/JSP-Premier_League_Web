<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Form</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<c:if test="${not empty errorMessage}">
		<div class="errorMessage">
			<span>${errorMessage}</span>
		</div>
	</c:if>
	
	<!-- join form -->
	<form method="POST" action="JoinAction.do">
		<input type="text" name="id" placeholder="enter your id" required>
		<input type="password" name="password" placeholder="enter your password" required>
		<input type="text" name="name" placeholder="enter your name" required>
		<input type="email" name="email" placeholder="enter your email" required>
		
		<label for="team-select">팀을 설정해주세요!</label>
		<select id="team-select" name="teamname">
		    <option value="">--Please choose an option--</option>
		    <c:forEach var="team" items="${teamInfoList}">
		    	<option value="${team.name}">${team.name}</option>
		    </c:forEach>
		</select>
		<input type="submit" value="회원가입">
	</form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>