<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Team Article</title>
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
			<button>Articles</button>
		<hr>
	</div>
	
	<div class="team__article">
			<c:forEach var="news" items="${newsList}">
				<ul>
					<li class="article__li">
						<div class="article">
							<img src="${news.image_url}"></img>
							<div class="article__meta">
								<a href="${news.news_url}" class="article__title">${news.news_title}</a>
								<span>${news.news_abstract_content}</span>
							</div>
						</div>				
						
					</li>
				</ul>			
			</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>