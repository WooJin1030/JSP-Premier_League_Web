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
	
	<c:if test="${sessionState eq \"none\"}">
		<jsp:forward page="LoginView.do"/>
	</c:if>
	

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
	

	<!--   
	<div class="myteam__title" style="background-color: red">
		<img src=""></img>
		<h1>name</h1>
	</div>
	<div class="myteam">
		<ul>
			<li>
				<h3 class="myteam__matchNumber">Match Day 1</h3>
				<div class="myteam__gameInfo">
					<h3 class="myteam__homeTeam">홈팀   hometeam</h3>
					<h3 class="myteam__homeTeamScore">1  : </h3>
					<h3 class="myteam__awayTeamScore">1</h3>
					<h3 class="myteam__awayTeam">awayteam    어웨이 팀 </h3>
					
					<img src="" />
	
				<br />
				</div>
				<span class="myteam__win">Win!</span>
			</li>
		</ul>
	</div>
	-->
	
	<div class="comment__container">
		<form class="comment__form" name="addComment" action="AddCommentAction.do" method="post">
			<input class="comment" type="text" name="comment" placeholder="코멘트를 입력하세요."/>
			<input class="form__submit" type="submit" value="입력" />
			
		</form>
		
		<ul class="comment__ul">
			<c:forEach var="comment" items="${commentList}">
				<c:if test="${comment.teamid eq teamInfoList.getId()}">
				<li>
					<span>${comment.text}</span>
					<c:if test="${comment.sessionid eq sessionId}">
					<a href="DeleteCommentAction.do?id=${comment.id}" role="button" class="comment__btn">X</a>
					</c:if>
				</li>
				</c:if>
			</c:forEach>
		</ul>
		
	</div>
		
	
	<jsp:include page="footer.jsp" />
	
	<script type="text/javascript">
		
	const form = document.querySelector("form");
	
	function handleSubmit() {
		const ul = document.querySelector(".comment__ul");
		ul.innerHTML = "";
	}
	
	form.addEventListener("submit", handleSubmit);
	
	</script>

</body>
</html>