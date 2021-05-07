<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My team</title>
</head>
<body>

	<jsp:include page="header.jsp" />

	<c:forEach var="team" items="${myTeamList}">
		<div>
			<ul>
				<li>
					<h3>${team.getTeam1Name()}</h3>
					<h3>${team.getTeam1Score()}</h3>
					<h3>${team.getTeam2Name()}</h3>
					<h3>${team.getTeam2Score()}</h3>
				</li>
			</ul>
		</div>
	</c:forEach>
	
	<jsp:include page="footer.jsp" />

</body>
</html>