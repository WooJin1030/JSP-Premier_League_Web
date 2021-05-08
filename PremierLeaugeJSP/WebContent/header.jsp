<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>header</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">    
</head>
<body>
	    <nav class="head">
	    	<!-- home logo -->
        	<a href ="HomeAction.do" class="head__logo">
            	<img src="https://user-images.githubusercontent.com/62231339/116050281-3ea01480-a6b2-11eb-9127-bf7bec2ef439.png" alt="EplIcon" />
        	</a>
        	<!-- header team's icon -->
	        <div class="head__teamlist">
	            <a href="TeamDetail.do?team=9002">
	                <img src="https://user-images.githubusercontent.com/62231339/116050257-3b0c8d80-a6b2-11eb-8488-7dc68f06383f.png" alt="Arsenal" />
	            </a>
	            <a href="TeamDetail.do?team=9008">
	                <img src="https://user-images.githubusercontent.com/62231339/116050276-3e077e00-a6b2-11eb-9c5c-5db8d4adaaa0.png" alt="AstonVilla" />
	            </a> 
	            <a href="TeamDetail.do?team=9065">
	                <img src="https://user-images.githubusercontent.com/62231339/116050243-38aa3380-a6b2-11eb-9aa6-f6ff7665d297.png" alt="Brighton" />      
	            </a> 
	            <a href="TeamDetail.do?team=9072">
	                <img src="https://user-images.githubusercontent.com/62231339/116050265-3c3dba80-a6b2-11eb-87fd-ce7cdf38602f.png" alt="Burnley" />                
	            </a> 
	            <a href="TeamDetail.do?team=9092">
	                <img src="https://user-images.githubusercontent.com/62231339/116050252-3a73f700-a6b2-11eb-9017-70300e33cc88.png" alt="Chelsea" />                
	            </a> 
	            <a href="TeamDetail.do?team=9127">
	                <img src="https://user-images.githubusercontent.com/62231339/116050263-3c3dba80-a6b2-11eb-9e4e-c5bf8762cab6.png" alt="Crystal Palace" />  
	            </a> 
	            <a href="TeamDetail.do?team=9158">
	                <img src="https://user-images.githubusercontent.com/62231339/116050273-3d6ee780-a6b2-11eb-92bc-fa42a5451cd8.png" alt="Everton" />               
	            </a> 
	            <a href="TeamDetail.do?team=9175">
	                <img src="https://user-images.githubusercontent.com/62231339/116050280-3ea01480-a6b2-11eb-8434-8abc4ff34ef3.png" alt="Fullham" />               
	            </a> 
	            <a href="TeamDetail.do?team=9238">
	                <img src="https://user-images.githubusercontent.com/62231339/116050259-3ba52400-a6b2-11eb-99a5-63fa8610bb26.png" alt="Leeds" />              
	            </a> 
	            <a href="TeamDetail.do?team=9240">
	                <img src="https://user-images.githubusercontent.com/62231339/116050253-3a73f700-a6b2-11eb-9748-7e20017f6c2c.png" alt="Leicester" />               
	            </a> 
	            <a href="TeamDetail.do?team=9249">
	                <img src="https://user-images.githubusercontent.com/62231339/116050246-3942ca00-a6b2-11eb-9ff7-61ecde2a5acd.png" alt="Liverpool" />        
	            </a> 
	            <a href="TeamDetail.do?team=9259">
	                <img src="https://user-images.githubusercontent.com/62231339/116050274-3e077e00-a6b2-11eb-83fe-58aaece8cfe6.png" alt="ManchesterCity" />      
	            </a> 
	            <a href="TeamDetail.do?team=9260">
	                <img src="https://user-images.githubusercontent.com/62231339/116050238-38119d00-a6b2-11eb-823f-7539e716d1a4.png" alt="ManchesterUnited" />      
	            </a> 
	            <a href="TeamDetail.do?team=9287">
	                <img src="https://user-images.githubusercontent.com/62231339/116050247-39db6080-a6b2-11eb-9a9d-60fad463ad18.png" alt="Newcastle" />      
	            </a> 
	            <a href="TeamDetail.do?team=9348">
	                <img src="https://user-images.githubusercontent.com/62231339/116050241-38aa3380-a6b2-11eb-93df-112b1f808f7e.png" alt="SheffieldUnited" />      
	            </a> 
	            <a href="TeamDetail.do?team=9363">
	                <img src="https://user-images.githubusercontent.com/62231339/116050269-3cd65100-a6b2-11eb-86e3-b981982632f3.png" alt="Southhampton" />     
	            </a> 
	            <a href="TeamDetail.do?team=9406">
	                <img src="https://user-images.githubusercontent.com/62231339/116050271-3d6ee780-a6b2-11eb-86f7-e9380f8d8bb8.png" alt="Tottenham" />     
	            </a> 
	            <a href="TeamDetail.do?team=9426">
	                <img src="https://user-images.githubusercontent.com/62231339/116050250-39db6080-a6b2-11eb-94dc-24d0a270b7b7.png" alt="WestBromwich" />     
	            </a> 
	            <a href="TeamDetail.do?team=9427">
	                <img src="https://user-images.githubusercontent.com/62231339/116050262-3ba52400-a6b2-11eb-9298-3b7de530436b.png" alt="WestHam" />    
	            </a> 
	            <a href="TeamDetail.do?team=9446">
	                <img src="https://user-images.githubusercontent.com/62231339/116050255-3b0c8d80-a6b2-11eb-8625-bf17ce9c0482.png" alt="Wolverhampton" />               
	            </a>   
        	</div>
        </nav>
        
        <!-- user header -->
        
        <c:if test="${sessionState eq 'none'}">
        <div class="head__userPage">
       		<a href="LoginView.do" class="head__loginBtn">
                Login              
            </a> 
            <a href="JoinView.do" class="head__joinBtn">
                Join              
            </a>   
       	</div>
       	</c:if>
       	<c:if test="${sessionState eq 'loggedIn'}">
        <div class="head__userPage">
       		<a href="LoginAction.do?action=logout" class="head__loginBtn">
                Logout             
            </a>
            <c:if test="${!empty memberTeam.name}">
	            <a href="MyTeam.do?team=${memberTeam.name}" class="head__loginBtn">
	           		<img src="${memberTeam.logoUrl}">
	            </a> 
	        </c:if>
       	</div>
       	</c:if>
</body>
</html>