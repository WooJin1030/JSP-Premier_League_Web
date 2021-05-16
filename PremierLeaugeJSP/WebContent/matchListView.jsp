<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>최근 10경기 결과</title>
</head>
<body>
	
	<jsp:include page="header.jsp" />
	
	<div class="match">
	<div>
		<div align="center">
		<table class="match__table">
		<tr>
					<th>경기 날짜</th>   
					<th>홈팀</th>                             
					<th>점수</th>
					<th>원정팀</th>
		</tr>
			<c:forEach var="match" items="${leagueMatch}" begin="0" end="9">
			<c:set var="timetest" value="${match.getTime().substring(0,2)*60+match.getTime().substring(3)}"/>
            <c:set var="day" value="${match.getFormatted_date().substring(0,2) }"/>
            <c:set var="month" value="${match.getFormatted_date().substring(3,5) }"/>
            <c:set var="year" value="${match.getFormatted_date().substring(6) }"/>
		<tr>
					<c:if test="${timetest<\"900\"}">
	            	<tr>
		               	<td class="match__date">${match.getFormatted_date()}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>               	  	
	                </tr>
	            </c:if>
	            <c:if test="${timetest>=\"900\"}">
	 			<c:choose>
	 			<c:when test="${month eq \"01\" or \"03\" or \"05\" or \"07\" or \"08\" or \"10\" or \"12\" and day eq \"31\" }">
	 			<c:if test="${month eq \"12\" }">
	 			<tr>
		               	<td class="match__date">01.01.${year+1}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>       	
	            </tr>
	 			</c:if>
	 			<c:if test="${month ne \"12\" }">
	            <tr>
		               	<td class="match__date">01.${month+1}.${year}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>        	
	            </tr>
	            </c:if>
	            </c:when>
	            <c:when test="${month eq \"02\" and day eq \"28\" }">
	            <tr>
		               	<td class="match__date">01.${month+1}.${year}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>          	
	            </tr>
	            </c:when>
	            <c:when test="${month eq \"04\" or \"06\" or \"09\" or \"11\" and day eq \"30\" }">
	            <tr>
		               	<td class="match__date">01.${month+1}.${year}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>       	
	            </tr>
	            </c:when>
	            <c:otherwise>
	            <tr>
		               	<td class="match__date">${day+1}.${month}.${year}</td>
		               	<td class="match__home">${match.getLocalteam_name()}</td> 
		               	<td class="match__score">${match.getFt_score()}</td> 
		               	<td class="match__away">${match.getVisitorteam_name()}</td>       	
	            </tr>
	            </c:otherwise>
	            </c:choose>
	            </c:if>
			</tr>
			</c:forEach>
		</table>
		</div>
		</div>
	</div>
        
        <jsp:include page="footer.jsp" />
        
</body>
</html>