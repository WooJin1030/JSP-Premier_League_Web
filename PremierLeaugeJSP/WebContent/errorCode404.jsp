<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<% response.setStatus(HttpServletResponse.SC_OK); %> <%-- 이것은 현재 페이지가 정상적으로 응답되는 페이지임을 지정하는 코드다. 이 코드를 생략하면 웹 브라우저는 자체적인 에러 페이지를 표시한다. --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>errorCode 404</title>
<link rel="stylesheet" type="text/css" href="./css/style.css"> 
<script src="https://kit.fontawesome.com/d355f46a66.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="error__container">
	<h1 class="error__title">404 에러</h1>
	<div class="error__metaContainer">
		<span class="error__content">요청한 페이지는 존재하지 않습니다!! - 이 에러는 클라이언트가 요청한 문서를 찾지 못한 경우에 발생합니다.</span>
		<span class="error__content">URL을 다시 잘 보고 주소가 올바로 입력되었는지를 확인하시길 바랍니다.</span>
	</div>
</div>

<div class="error__refreshContainer">
	<h3 class="refresh__title">홈 화면으로 돌아갑니다.</h3>
	<a href="HomeAction.do">
		<button>
			<i class="fas fa-redo"></i>
		</button> 
	</a>
</div>

</body>
</html>