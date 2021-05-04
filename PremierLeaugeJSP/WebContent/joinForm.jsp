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
	<span>${errorMessage}</span>
	</c:if>
	
	<form method="POST" action="JoinAction.do">
		<input type="text" name="id" placeholder="enter your id">
		<input type="password" name="password" placeholder="enter your password">
		<input type="text" name="name" placeholder="enter your name">
		<input type="email" name="email" placeholder="enter your email">
		
		<label for="team-select">팀을 설정해주세요!</label>
		<select id="team-select" name="teamname">
		    <option value="">--Please choose an option--</option>
		    <option value="Arsenal">Arsenal</option>
		    <option value="AstonVilla">AstonVilla</option>
		    <option value="Brighton">Brighton</option>
		    <option value="Burnley">Burnley</option>
		    <option value="Chelsea">Chelsea</option>
		    <option value="CrystalPalace">CrystalPalace</option>
		    <option value="Everton">Everton</option>
		    <option value="Fullham">Fullham</option>
		    <option value="Leeds">Leeds</option>
		    <option value="Leicester">Leicester</option>
		    <option value="Liverpool">Liverpool</option>
		    <option value="ManchesterCity">ManchesterCity</option>
		    <option value="ManchesterUnited">ManchesterUnited</option>
		    <option value="Newcastle">Newcastle</option>
		    <option value="Sheffield">Sheffield</option>
		    <option value="Southhampton">Southhampton</option>
		    <option value="Tottenham">Tottenham</option>
		    <option value="WestBromwich">WestBromwich</option>
		    <option value="WestHam">WestHam</option>
		    <option value="Wolverhampton">Wolverhampton</option>
		</select>
		<input type="submit" value="회원가입">
	</form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>