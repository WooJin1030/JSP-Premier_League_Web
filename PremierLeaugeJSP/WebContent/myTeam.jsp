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
	
	
		<div class="myteam__title" style="background-color: ${teamInfoList.teamcolor}">
			<img src="${teamInfoList.logoUrl}"></img>
			<h1>${teamInfoList.name}</h1>
		</div>
		<hr>

	<c:forEach var="team" items="${myTeamList}">
		<div class="myteam">
			<ul>
				<li>
					<h3 class="myteam__matchNumber">Match Day ${team.matchNumber}</h3>
					
					<!-- 아직 진행되지 않은 경기 -->
					<c:if test="${team.team1Score eq -1}">
						<div class="myteam__scheduled">
							<h3 class="myteam__scheduled-home">홈팀   ${team.team1Name}</h3>					
							<h3 class="myteam__scheduled-away">어웨이 팀    ${team.team2Name} </h3>
							<span>아직 경기 전입니다!</span>
						</div>
						
					</c:if>
					
					<!-- 진행된 경기 -->
					<c:if test="${team.team1Score ne -1}">
						<div class="myteam__gameInfo">
							<c:if test="${teamInfoList.name eq team.team1Name}">
								<img src="${teamInfoList.logoUrl}" />
							</c:if>
							<h3 class="myteam__homeTeam">홈팀   ${team.team1Name}</h3>
							<h3 class="myteam__homeTeamScore">${team.team1Score}  : </h3>
							<h3 class="myteam__awayTeamScore">${team.team2Score}</h3>
							<h3 class="myteam__awayTeam">${team.team2Name}    어웨이 팀 </h3>
							<c:if test="${teamInfoList.name eq team.team2Name}">
								<img src="${teamInfoList.logoUrl}" />
							</c:if>
						<br />
						</div>
					<!-- 승/패 정보 -->
					<c:choose>
						<c:when test="${teamInfoList.name eq team.team1Name}">
						<c:if test="${team.team1Score > team.team2Score}">
							<span class="myteam__win">Win!</span>
						</c:if>
						<c:if test="${team.team1Score == team.team2Score}">
							<span class="myteam__draw">Draw!</span>	
						</c:if>
						<c:if test="${team.team1Score < team.team2Score}">
							<span class="myteam__lost">Lose!</span>	
						</c:if>
						</c:when>
						<c:when test="${teamInfoList.name eq team.team2Name}">
						<c:if test="${team.team1Score < team.team2Score}">
							<span class="myteam__win">Win!</span>
						</c:if>
						<c:if test="${team.team1Score == team.team2Score}">
							<span class="myteam__draw">Draw!</span>	
						</c:if>
						<c:if test="${team.team1Score > team.team2Score}">
							<span class="myteam__lost">Lose!</span>	
						</c:if>
						</c:when>
					</c:choose>
					</c:if>
				</li>
			</ul>
		</div>
	</c:forEach>
	
	<jsp:include page="footer.jsp" />

</body>
</html>