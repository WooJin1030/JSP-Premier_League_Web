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
<style>
        .sidenav {
            height: 55%; 
            width: 220px;
            position: fixed; 
            z-index: 1;
            top: 200px; 
            left: 0;
            background-color: rgb(55,0,60);
            overflow-x: hidden;
            padding-top: 20px;
            border-radius: 8px;
            margin-left: 4px;
            margin-top: 16px;
            overflow: hidden;
            
        }

        .sidenav h3 {
            margin-top: 50%;
            margin-bottom: 32px;
            color: white;
            text-align: center;
        }

        .sidenav ul {
            font-size: 20px;
            margin-left: 8px;
            color: white;
            list-style: none;
            padding: 0;
        }

        .sidenav li {
            margin-bottom: 32px;
        }

	     .main {
        	text-align: center;
            margin-left: 220px; 
            margin-top: 36px;
            top: 200px;
            min-height: 70vh;
            
        }

		.main__title {
			margin-bottom: 16px;
		}
		
        .main table {
        	margin: auto;
            border-collapse: collapse;
            text-align: center;
            width: 1000px;
        }

        .main table th,td {
            border: 1px solid gray;
        }
        

        .table__divide {
        	margin: auto;
            max-height: 400px;
            overflow-y: scroll;
            overflow-x: hidden;
            width: 1000px;
        }
        
  		.table__divide::-webkit-scrollbar {
    		width: 10px;
  		}
  		
	  	.table__divide::-webkit-scrollbar-thumb {
	    	background-color: purple;
	  	}
	  	
	  	.table__divide::-webkit-scrollbar-track {
	    	background-color: grey;
	  	}
	  	
        .main table .teamname {
           	display: flex;
           	align-items: center;
           	justify-content: flex-start;
        }
	
        .main table img {
            margin-right: 16px;
            margin-left: 8px;
            width: 30px;
            height: 30px;
        } 
		
		
		@media screen and (max-width: 1600px) {
			
			.main table {
				width: 800px;
			}
			
			.table__divide {
				width: 800px;
				max-height: 400px;
			}
			
		}
		
		@media screen and (max-width: 1200px) {
			.sidenav {
				display: none;
			}
				
	    	.main {
	        	text-align: center;
	            margin-left: 0px; 
	            margin-top: 36px;
	            top: 200px;
            
       		 }
       		 
       		 .head__teamlist {
       		 	margin-right: 16px;
       		 }
		}
		
		@media screen and (max-width: 1000px) {
			
	
			.main table {
				width: 600px;
			}
			
			.main table .teamname span {
				display: none;	
			}
			
			.main table .teamname {
				justify-content: center;	
			}
			
			.table__divide {
				width: 600px;
				max-height: 300px;
			}
			
		}
		
		
		@media screen and (max-width: 800px) {
		
			.sidenav {
				display: none;
			}
			
			.main {
	        	text-align: center;
	            margin-left: 0px; 
	            margin-top: 36px;
	            top: 200px;
            
       		 }
			
			.main table {
				width: 400px;
			}
			
			.table__divide {
				width: 400px;
				max-height: 300px;
			}
		}
		
		@media screen and (max-height: 800px) {

	
		}
		
		
		
		
		
</style>
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
	                	<td class="ranking">${team.getRank()}</td>
	                    <td class="teamname">
	                    	<c:if test = "${team.getTeam() eq 'Manchester City'}">
	                    	<img src="./img/맨체스터시티.png" alt="ManchesterCity">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Manchester United'}">
	                    	<img src="./img/맨유.png" alt="ManchesterUnited">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Leicester'}">
	                    	<img src="./img/레스터시티.png" alt="Leicester">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'West Ham'}">
	                    	<img src="./img/웨스트햄.png" alt="WestHam">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Chelsea'}">
	                    	<img src="./img/첼시.png" alt="Chelsea">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Liverpool'}">
	                    	<img src="./img/리버풀.png" alt="Liverpool">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Tottenham'}">
	                    	<img src="./img/토트넘.png" alt="Tottenham">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Everton'}">
	                    	<img src="./img/에버튼.png" alt="Everton">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Leeds'}">
	                    	<img src="./img/리즈.png" alt="Leeds">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Arsenal'}">
	                    	<img src="./img/아스날.png" alt="Arsenal">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Aston Villa'}">
	                    	<img src="./img/아스톤빌라.png" alt="AstonVilla">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Wolverhampton Wanderers'}">
	                    	<img src="./img/울버햄튼.png" alt="WolverhamptonWanderers">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Crystal Palace'}">
	                    	<img src="./img/크리스탈펠리스.png" alt="CrystalPalace">
	                    	</c:if>	
	                    	<c:if test = "${team.getTeam() eq 'Southampton'}">
	                    	<img src="./img/사우스햄튼.png" alt="Southampton">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Newcastle United'}">
	                    	<img src="./img/뉴캐슬.png" alt="NewcastleUnited">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Brighton'}">
	                    	<img src="./img/브라이튼.png" alt="Brighton">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Burnley'}">
	                    	<img src="./img/번리.png" alt="Burnley">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'Fulham'}">
	                    	<img src="./img/풀럼.png" alt="Fulham">
	                    	</c:if>
	                    	<c:if test = "${team.getTeam() eq 'West Bromwich Albion'}">
	                    	<img src="./img/웨스트브롬.png" alt="WestBromwichAlbion">
	                    	</c:if>
	         				<c:if test = "${team.getTeam() eq 'Sheffield United'}">
	                    	<img src="./img/섀필드.png" alt="SheffieldUnited">
	                    	</c:if>
	                    	<c:choose>
	                    		<c:when test = "${team.getTeam() eq 'West Bromwich Albion'}">
	                    		<span>West Bromwich</span>
	                    		</c:when>
	                    	
	             				<c:otherwise>
	             				<span>${team.getTeam()}</span>
	             				</c:otherwise>
	             			</c:choose>
   
	                    </td>
	                    <td>${team.getPlayed()}</td>               
	                    <td>${team.getWin()}</td>
	                    <td>${team.getDraw()}</td>
	                    <td>${team.getLoss()}</td>
	                    <td>${team.getGoalsFor()}</td>
	                    <td>${team.getGoalsAgainst()}</td>
	                    <td>${team.getPoints()}</td>
	                </tr>              
	             </c:forEach>
                </tbody>              
            </table>
        </div>   
    </div>
    
    <jsp:include page="footer.jsp" />
    
</body>
</html>