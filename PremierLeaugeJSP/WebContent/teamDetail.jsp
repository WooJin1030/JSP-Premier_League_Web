<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Team Detail</title>

</head>
<body>
	<jsp:include page="header.jsp" />
		
		<div class="teamDetail__title">
			<img src="${teamInfoList.getLogoUrl()}"></img>
			<h1>${teamInfoList.getName()}</h1>
		</div>
		<hr>
		<div class="teamDetail__selectBtn" style="background-color: ${teamInfoList.getTeamcolor()}">
			<button class="mainBtn">Main</button>
			<button class="stadiumInfoBtn">Home Stadium</button>
			<a href="TeamPlayerAction.do?team=${id}" role="button">Players</a>

			<hr>
		</div>
		
		<div class="teamDetail__main">
			<ul>
				<li><h3>연고지:  ${teamInfoList.getOrigin()}</h3></li>
				<li><h3>설립연도:  ${teamInfoList.getEstablishment()}년</h3></li>
				<li><h3>애칭:  ${teamInfoList.getNickname()}</h3></li>
				<li><h3>회장:  ${teamInfoList.getChairmanname()}</h3></li>
				<li>	
					<img src="${teamInfoList.getManagerimageurl()}">
						<h3>감독:  ${teamInfoList.getManagername()} </h3>
				</li>
				<li>
					<a href= ${teamInfoList.getOfficialsite()} >
						<h3>공식 웹사이트</h3>
					</a>
				</li>
			</ul>

		</div>
		
		
		
		<div class="teamDetail__stadium hidden">	
			<ul>
				<li> 
					<img src="${teamInfoList.getStadiumimageurl()}" />
				</li>
				<li> 
					<h3>경기장명:  ${teamInfoList.getStadiumname()}</h3>
				</li>
				<li> 
					<h3>경기장 수용 인원:  ${teamInfoList.getCapacity()}</h3>
				</li>
				<li> 
					<h3>경기장 크기:  ${teamInfoList.getFieldsize()}</h3>
				</li>
			</ul>
			
			
			
		</div>
		
			
	<jsp:include page="footer.jsp" />
	
	<script type="text/javascript">
		
	const mainPage = document.querySelector(".teamDetail__main");
	const stadiumPage = document.querySelector(".teamDetail__stadium");
	
	const mainBtn = document.querySelector(".mainBtn");
	const stadiumBtn = document.querySelector(".stadiumInfoBtn");

	
	function showMain() {
		mainPage.classList.remove("hidden");
		stadiumPage.classList.add("hidden");
	}
	
	function showStadium() {
		mainPage.classList.add("hidden");
		stadiumPage.classList.remove("hidden");
	}
	
	mainBtn.addEventListener("click", showMain);
	stadiumBtn.addEventListener("click", showStadium);

</script>
	
</body>
</html>