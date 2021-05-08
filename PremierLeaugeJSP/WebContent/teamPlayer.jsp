<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Player Info</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		
		<!-- 선택한 팀의 로고, 이름 -->
		<div class="teamDetail__title">
			<img src="${teamInfoList.logoUrl}"></img>
			<h1>${teamInfoList.name}</h1>
		</div>
		<hr>
		<div class="teamDetail__selectBtn" style="background-color: ${teamInfoList.teamcolor}">
				<button>Players</button>
			<hr>
		</div>
	
	<!-- 선택된 팀의 선수 정보 -->
	<div class="teamDetail__player">
		<div class="gk">
			<!-- 골키퍼 -->
			<h2 class="teamDetail__player__position">골키퍼</h2>
			<hr class="teamDetail__player__hr" />	
			<c:forEach var="player" items="${playerList}">
				<c:if test="${player.position eq 'G' }">
					<div class="teamDetail__player__GK">
						<ul>
							<li class="teamDetail__player__li">
								<h3>등번호: ${player.number}</h3>
								<h3>선수 이름: ${player.name}</h3>
								<h3>나이: ${player.age}</h3>
							</li>
						</ul>
					</div>
				</c:if>
			</c:forEach>	
		</div>
		
		<!-- 수비수 -->
		<div class="df">
			<h2 class="teamDetail__player__position">수비수</h2>
			<hr class="teamDetail__player__hr" />
			<c:forEach var="player" items="${playerList}">
				<c:if test="${player.position eq 'D' }">
					<div class="teamDetail__player__DF">
						<ul>
							
							<li class="teamDetail__player__li">
								<h3>등번호: ${player.number}</h3>
								<h3>선수 이름: ${player.name}</h3>
								<h3>나이: ${player.age}</h3>
								<h3>⚽: ${player.goals}</h3>
								<h3>도움 수: ${player.assists}</h3>
							</li>
							
						</ul>
					</div>
				</c:if>
			</c:forEach>	
		</div>
		
		<!-- 미드필더 -->
		<div class ="mf">
			<h2 class="teamDetail__player__position">미드필더</h2>	
			<hr class="teamDetail__player__hr" />
			<c:forEach var="player" items="${playerList}">
				<c:if test="${player.position eq 'M' }">								
					<div class="teamDetail__player__MF">
						<ul>
							
							<li class="teamDetail__player__li">
								<h3>등번호: ${player.number}</h3>
								<h3>선수 이름: ${player.name}</h3>
								<h3>나이: ${player.age}</h3>
								<h3>⚽: ${player.goals}</h3>
								<h3>도움 수: ${player.assists}</h3>
							</li>
							
						</ul>
					</div>
				</c:if>
			</c:forEach>
		</div>
		
		<!-- 공격수 -->
		<div class="fw">
			<h2 class="teamDetail__player__position">공격수</h2>
			<hr class="teamDetail__player__hr" />
			<c:forEach var="player" items="${playerList}">
				<c:if test="${player.position eq 'A' }">	
					
					<div class="teamDetail__player__FW">
						<ul>
							
							<li class="teamDetail__player__li">
								<h3>등번호: ${player.number}</h3>
								<h3>선수 이름: ${player.name}</h3>
								<h3>나이: ${player.age}</h3>
								<h3>⚽: ${player.goals}</h3>
								<h3>도움 수: ${player.assists}</h3>
							</li>
							
						</ul>
					</div>
				</c:if>
			</c:forEach>
		</div>		
		</div>
		<jsp:include page="footer.jsp" />
</body>
</html>