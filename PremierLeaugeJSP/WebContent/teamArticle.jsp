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
	
	<div class="team__article">
			<c:forEach var="news" items="${newsList}">
				<ul>
					<li class="teamDetail__player__li">
						<h3>제목: ${news.news_title}</h3>
						<img src="${news.image_url}"></img>
						
						<a href="${news.news_url}">${news.news_title}</a>
						<span>${news.news_abstract_content}</span>
					</li>
				</ul>			
			</c:forEach>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>