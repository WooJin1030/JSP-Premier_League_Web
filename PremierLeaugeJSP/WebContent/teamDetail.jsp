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
		
		<!-- 선택되 팀의 로고, 이름 -->
		<div class="teamDetail__title">
			<img src="${teamInfoList.logoUrl}"></img>
			<h1>${teamInfoList.name}</h1>
		</div>
		<hr>
		
		<!-- 팀정보 메뉴 -->
		<div class="teamDetail__selectBtn" style="background-color: ${teamInfoList.teamcolor}">
			<button class="mainBtn">Main</button>
			<button class="stadiumInfoBtn">Home Stadium</button>
			<a href="TeamPlayerAction.do?team=${id}" class="playerInfoBtn">
				<button>Players</button>
			</a>
			<a href="TeamArticleAction.do?team=${id}" class="playerInfoBtn">
				<button>Articles</button>
			</a>

			<hr>
		</div>
		
		<!-- 메인 정보 -->
		<div class="teamDetail__main">
			<ul>
				<li><h2>연고지:  ${teamInfoList.origin}</h2></li>
				<li><h2>설립연도:  ${teamInfoList.establishment}년</h2></li>
				<li><h2>애칭:  ${teamInfoList.nickname}</h2></li>
				<li><h2>회장:  ${teamInfoList.chairmanname}</h2></li>
				<li class="managerInfo">	
					<img src="${teamInfoList.managerimageurl}">
					<h2>감독:  ${teamInfoList.managername} </h2>
				</li>
				<li>
					<a href= ${teamInfoList.getOfficialsite()} >
						<h2>공식 웹사이트:  </h2>
						<h2 class="teamSite">${teamInfoList.officialsite}</h2>
					</a>
				</li>
			</ul>

		</div>
		
		
		<!-- 구장 정보 -->
		<div class="teamDetail__stadium hidden">	
			<ul>
				<li> 
					<img src="${teamInfoList.stadiumimageurl}" />
				</li>
				<li> 
					<h2>경기장명:  ${teamInfoList.stadiumname}</h2>
				</li>
				<li> 
					<h2>경기장 수용 인원:  ${teamInfoList.capacity}명</h2>
				</li>
				<li> 
					<h2>경기장 크기:  ${teamInfoList.fieldsize}</h2>
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