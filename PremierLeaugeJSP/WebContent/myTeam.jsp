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
					<h3>${team.matchNumber}</h3>
					<br />
					<h3>${team.team1Name}</h3>
					<h3>${team.team1Score}</h3>
					<h3>${team.team2Name}</h3>
					<h3>${team.team2Score}</h3>
					<br />
				</li>
			</ul>
		</div>
	</c:forEach>
	
	<jsp:include page="footer.jsp" />

</body>
</html>