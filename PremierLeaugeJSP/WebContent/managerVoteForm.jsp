<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<hr />
	<br />
	
	<h1 class="manager__title">최고의 감독에 투표하세요!</h1>
		
	<form method="POST" action="VoteManager.do">
		<c:forEach var="manager" items="${teamInfoList}">
		
	 		<div class="manager__form">
			    <input type="radio" name="manager" id="${manager.name}" value="${manager.name}">
			    	<img src="${manager.logoUrl}" style="width: 40px; height: 40px" class="form__teamLogo"/>
			    <label for="${manager.name}">${manager.name} : ${manager.managername}
			    	<img src="${manager.managerimageurl}" style="width:150px; height:150px;" class="form__managerUrl" />
			    </label>
	  		</div>
	  		
	  	</c:forEach>
	    <input type="submit" value="투표하기!" class="form__submit" />
	</form>
	
	<jsp:include page="footer.jsp" />
</body>
</html>