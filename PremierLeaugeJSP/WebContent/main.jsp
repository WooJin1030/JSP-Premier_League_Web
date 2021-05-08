<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Home</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	    <div class="sidenav">
	        <h3 class="sidenav__text">
	            최근 3경기 결과
	        </h3>
	        <ul class="sidenav__game">
	            <li><span>셰필드 0 : 3 아스널</span></li>
	            <li><span>토트넘 1 : 3 맨유</span></li>
	            <li><span>웨스트햄 3 : 2 레스터</span></li>
	        </ul>
    </div>

	
    <div class="main">
    	
    	<div class="main__title">
    		<h1>
    			2020-2021 프리미어리그 순위
    		</h1>
    	</div>
    	
        <table class="main__table">
            <colgroup>
                <col width="9%">
                <col width="28%">
                <col width="9%">
                <col width="9%">
                <col width="9%">
                <col width="9%">
                <col width="9%">
                <col width="9%">
                <col width="9%">  
            </colgroup>
            <thead>
                <tr>
                    <th>순위</th>
                    <th>팀명</th>
                    <th>경기수</th>
                    <th>승</th>
                    <th>무</th>
                    <th>패</th>
                    <th>득점</th>
                    <th>실점</th>
                    <th>승점</th>
              </tr>
            </thead>

        </table>
        <div class="table__divide">
        	
            <table class="main__table">
                <colgroup>
                    <col width="9%">
                    <col width="28%">
                    <col width="9%">
                    <col width="9%">
                    <col width="9%">
                    <col width="9%">
                    <col width="9%">
                    <col width="9%">
                    <col width="9%">
        
                </colgroup>
                <tbody>
                
                <c:forEach var="team" items="${leagueTable}">
	            	<tr>
	                	<td class="ranking">${team.rank}</td>
	                    <td class="teamname">
	                    	<c:if test = "${team.team eq 'Manchester City'}">
	                    	<img src="./img/logos/맨체스터시티.png" alt="ManchesterCity">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Manchester United'}">
	                    	<img src="./img/logos/맨유.png" alt="ManchesterUnited">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Leicester'}">
	                    	<img src="./img/logos/레스터시티.png" alt="Leicester">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'West Ham'}">
	                    	<img src="./img/logos/웨스트햄.png" alt="WestHam">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Chelsea'}">
	                    	<img src="./img/logos/첼시.png" alt="Chelsea">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Liverpool'}">
	                    	<img src="./img/logos/리버풀.png" alt="Liverpool">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Tottenham'}">
	                    	<img src="./img/logos/토트넘.png" alt="Tottenham">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Everton'}">
	                    	<img src="./img/logos/에버튼.png" alt="Everton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Leeds'}">
	                    	<img src="./img/logos/리즈.png" alt="Leeds">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Arsenal'}">
	                    	<img src="./img/logos/아스날.png" alt="Arsenal">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Aston Villa'}">
	                    	<img src="./img/logos/아스톤빌라.png" alt="AstonVilla">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Wolverhampton Wanderers'}">
	                    	<img src="./img/logos/울버햄튼.png" alt="WolverhamptonWanderers">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Crystal Palace'}">
	                    	<img src="./img/logos/크리스탈펠리스.png" alt="CrystalPalace">
	                    	</c:if>	
	                    	<c:if test = "${team.team eq 'Southampton'}">
	                    	<img src="./img/logos/사우스햄튼.png" alt="Southampton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Newcastle United'}">
	                    	<img src="./img/logos/뉴캐슬.png" alt="NewcastleUnited">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Brighton'}">
	                    	<img src="./img/logos/브라이튼.png" alt="Brighton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Burnley'}">
	                    	<img src="./img/logos/번리.png" alt="Burnley">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Fulham'}">
	                    	<img src="./img/logos/풀럼.png" alt="Fulham">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'West Bromwich Albion'}">
	                    	<img src="./img/logos/웨스트브롬.png" alt="WestBromwichAlbion">
	                    	</c:if>
	         				<c:if test = "${team.team eq 'Sheffield United'}">
	                    	<img src="./img/logos/섀필드.png" alt="SheffieldUnited">
	                    	</c:if>
	                    	<c:choose>
	                    		<c:when test = "${team.team eq 'West Bromwich Albion'}">
	                    		<span>West Bromwich</span>
	                    		</c:when>
	                    		
	                    		<c:when test = "${team.team eq 'Wolverhampton Wanderers'}">
	                    		<span>Wolverhampton</span>
	                    		</c:when>
	                    		
	                    		
	             				<c:otherwise>
	             				<span>${team.team}</span>
	             				</c:otherwise>
	             			</c:choose>
   
	                    </td>
	                    <td>${team.played}</td>               
	                    <td>${team.win}</td>
	                    <td>${team.draw}</td>
	                    <td>${team.loss}</td>
	                    <td>${team.goalsFor}</td>
	                    <td>${team.goalsAgainst}</td>
	                    <td>${team.points}</td>
	                </tr>              
	             </c:forEach>
                </tbody>              
            </table>
        </div>   
    </div>
    
    <jsp:include page="footer.jsp" />
    
</body>
</html>