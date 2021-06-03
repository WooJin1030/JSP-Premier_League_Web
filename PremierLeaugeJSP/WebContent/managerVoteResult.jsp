<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote Result</title>
</head>
<body>
	<jsp:include page="header.jsp" />
		
		<hr />
		<br />
		
		<h1 class="manager__title">투표 결과</h1>
		
		<hr />
		
		<div class="result__container">
			<c:forEach var="team" items="${teamInfoList}">
				<div class="result__manager">
					<img src="${team.managerimageurl}" style="width:150px; height:150px;"/>
					<div class="result__meta">
						<span>${team.managername}</span>
						<c:choose>
							<c:when test="${team.managercount eq 0}">
								<ul>
									<li>
										<span>0표</span>
									</li>
									<li>
										<span>0%</span>
									</li>
									<li>
										<div style="width: 100%; height: 4px; background-color: gray;"> </div>
									</li>
								</ul>
							</c:when>
							<c:otherwise>
								<ul>
									<li>
										<span>${team.managercount}표</span>
									</li>
									<li>
										<span>${String.format("%.2f", (team.managercount / managerCount ) * 100 )}% </span>
									</li>
									<li class="result__meta__graph">
										<div style="width: 100%; height: 4px; background-color: gray;">
											<div style="width: ${String.format("%.2f", (team.managercount / managerCount ) * 100 )}%; height: 4px; background-color: orange;">
											</div>
										</div>
									</li>
								</ul>
								
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</c:forEach>
		</div>
	<jsp:include page="footer.jsp" />
</body>
</html>