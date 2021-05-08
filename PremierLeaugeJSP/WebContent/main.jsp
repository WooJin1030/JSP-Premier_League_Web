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
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050274-3e077e00-a6b2-11eb-83fe-58aaece8cfe6.png" alt="ManchesterCity">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Manchester United'}">
	                    		<img src=https://user-images.githubusercontent.com/62231339/116050238-38119d00-a6b2-11eb-823f-7539e716d1a4.png alt="ManchesterUnited">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Leicester'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050253-3a73f700-a6b2-11eb-9748-7e20017f6c2c.png" alt="Leicester">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'West Ham'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050262-3ba52400-a6b2-11eb-9298-3b7de530436b.png" alt="WestHam">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Chelsea'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050252-3a73f700-a6b2-11eb-9017-70300e33cc88.png" alt="Chelsea">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Liverpool'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050246-3942ca00-a6b2-11eb-9ff7-61ecde2a5acd.png" alt="Liverpool">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Tottenham'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050271-3d6ee780-a6b2-11eb-86f7-e9380f8d8bb8.png" alt="Tottenham">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Everton'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050273-3d6ee780-a6b2-11eb-92bc-fa42a5451cd8.png" alt="Everton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Leeds'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050259-3ba52400-a6b2-11eb-99a5-63fa8610bb26.png" alt="Leeds">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Arsenal'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050257-3b0c8d80-a6b2-11eb-8488-7dc68f06383f.png" alt="Arsenal">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Aston Villa'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050276-3e077e00-a6b2-11eb-9c5c-5db8d4adaaa0.png" alt="AstonVilla">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Wolverhampton Wanderers'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050255-3b0c8d80-a6b2-11eb-8625-bf17ce9c0482.png" alt="WolverhamptonWanderers">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Crystal Palace'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050263-3c3dba80-a6b2-11eb-9e4e-c5bf8762cab6.png" alt="CrystalPalace">
	                    	</c:if>	
	                    	<c:if test = "${team.team eq 'Southampton'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050269-3cd65100-a6b2-11eb-86e3-b981982632f3.png" alt="Southampton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Newcastle United'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050247-39db6080-a6b2-11eb-9a9d-60fad463ad18.png" alt="NewcastleUnited">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Brighton'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050243-38aa3380-a6b2-11eb-9aa6-f6ff7665d297.png" alt="Brighton">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Burnley'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050265-3c3dba80-a6b2-11eb-87fd-ce7cdf38602f.png" alt="Burnley">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'Fulham'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050280-3ea01480-a6b2-11eb-8434-8abc4ff34ef3.png" alt="Fulham">
	                    	</c:if>
	                    	<c:if test = "${team.team eq 'West Bromwich Albion'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050250-39db6080-a6b2-11eb-94dc-24d0a270b7b7.png" alt="WestBromwichAlbion">
	                    	</c:if>
	         				<c:if test = "${team.team eq 'Sheffield United'}">
	                    		<img src="https://user-images.githubusercontent.com/62231339/116050241-38aa3380-a6b2-11eb-93df-112b1f808f7e.png" alt="SheffieldUnited">
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