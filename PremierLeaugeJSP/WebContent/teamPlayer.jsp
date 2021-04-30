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
	
		<div class="teamDetail__title">
			<img src="${teamInfoList.getLogoUrl()}"></img>
			<h1>${teamInfoList.getName()}</h1>
		</div>
		<hr>
		<div class="teamDetail__selectBtn" style="background-color: ${teamInfoList.getTeamcolor()}">
				<button>Players</button>
			</a>
			<hr>
		</div>
	
	<div class="teamDetail__player">
			<div class="gk">
				<h2 class="teamDetail__player__position">골키퍼</h2>
				<hr class="teamDetail__player__hr" />		
				<c:forEach var="player" items="${playerList}">
					<c:if test="${player.getPosition() eq 'G' }">
						<div class="teamDetail__player__GK">
							<ul>
								<li class="teamDetail__player__li">
									<h3>등번호: ${player.getNumber()}</h3>
									<h3>선수 이름: ${player.getName()}</h3>
									<h3>나이: ${player.getAge()}</h3>
								</li>
							</ul>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="df">
				<h2 class="teamDetail__player__position">수비수</h2>
				<hr class="teamDetail__player__hr" />
					<c:forEach var="player" items="${playerList}">
						<c:if test="${player.getPosition() eq 'D' }">
							<div class="teamDetail__player__DF">
								<ul>
									
									<li class="teamDetail__player__li">
										<h3>등번호: ${player.getNumber()}</h3>
										<h3>선수 이름: ${player.getName()}</h3>
										<h3>나이: ${player.getAge()}</h3>
										<h3>⚽: ${player.getGoals()}</h3>
										<h3>도움 수: ${player.getAssists()}</h3>
									</li>
									
								</ul>
							</div>
						</c:if>
					</c:forEach>	
			</div>
			<div class ="mf">
				<h2 class="teamDetail__player__position">미드필더</h2>	
				<hr class="teamDetail__player__hr" />
				<c:forEach var="player" items="${playerList}">
					<c:if test="${player.getPosition() eq 'M' }">
									
						<div class="teamDetail__player__MF">
							<ul>
								
								<li class="teamDetail__player__li">
									<h3>등번호: ${player.getNumber()}</h3>
									<h3>선수 이름: ${player.getName()}</h3>
									<h3>나이: ${player.getAge()}</h3>
									<h3>⚽: ${player.getGoals()}</h3>
									<h3>도움 수: ${player.getAssists()}</h3>
								</li>
								
							</ul>
						</div>
					</c:if>
				</c:forEach>
			</div>
			<div class="fw">
				<h2 class="teamDetail__player__position">공격수</h2>
				<hr class="teamDetail__player__hr" />
					<c:forEach var="player" items="${playerList}">
						<c:if test="${player.getPosition() eq 'A' }">	
							
							<div class="teamDetail__player__FW">
								<ul>
									
									<li class="teamDetail__player__li">
										<h3>등번호: ${player.getNumber()}</h3>
										<h3>선수 이름: ${player.getName()}</h3>
										<h3>나이: ${player.getAge()}</h3>
										<h3>⚽: ${player.getGoals()}</h3>
										<h3>도움 수: ${player.getAssists()}</h3>
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