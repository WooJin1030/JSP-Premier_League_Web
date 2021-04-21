<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>header</title>
<style>
        * {
            margin: 0;
            box-sizing: border-box;
        }

        button {
            outline: none;
            background-color: transparent;
            border: none;
            cursor: pointer;
        }
        
		
		a {
			border: none;
			color: black;
			text-decoration: none;
		}
		
		ul {
			list-style: none;
		}
		
        .head {
            display: flex;
            align-items: center;
            justify-content: center;
            width: 100%;
        }
        
        .head__logo img{
            width: 250px;
            height: 200px;
        }

        .head__teamlist {
            background-color: rgb(55,0,60);
            padding: 18px;
            border-radius: 30px;
        }
        .head__teamlist a img {
            width: 40px;
            height: 40px;
            margin-right: 16px;
            transition: all 300ms ease-in;
        }
        
        .head__teamlist a img:hover {
        	transform: scale(1.1);
        }
        
       @media screen and (max-width: 1600px) {
       		
       		.head__logo img {
       			width: 200px;
       			height: 150px;
       		}
       
			.head__teamlist img {
				width: 30px;
				height: 30px;
			}
        }
        
        @media screen and (max-width: 800px) {
        	.head__teamlist {
        		display:none;
        	}
        }
        
        
</style>        
</head>
<body>
	    <nav class="head">
        	<button class="head__logo">
            	<img src="./img/epl icon.png" alt="EplIcon" />
        	</button>
	        <div class="head__teamlist">
	            <a href="#">
	                <img src="./img/아스날.png" alt="Arsenal" />
	            </a>
	            <a href="#">
	                <img src="./img/아스톤빌라.png" alt="AstonVilla" />
	            </a> 
	            <a href="#">
	                <img src="./img/브라이튼.png" alt="Brighton" />      
	            </a> 
	            <a href="#">
	                <img src="./img/번리.png" alt="Burnley" />                
	            </a> 
	            <a href="#">
	                <img src="./img/첼시.png" alt="Chelsea" />                
	            </a> 
	            <a href="#">
	                <img src="./img/크리스탈펠리스.png" alt="Crystal Palace" />  
	            </a> 
	            <a href="#">
	                <img src="./img/에버튼.png" alt="Everton" />               
	            </a> 
	            <a href="#">
	                <img src="./img/풀럼.png" alt="Fullham" />               
	            </a> 
	            <a href="#">
	                <img src="./img/리즈.png" alt="Leeds" />              
	            </a> 
	            <a href="#">
	                <img src="./img/레스터시티.png" alt="Leicester" />               
	            </a> 
	            <a href="#">
	                <img src="./img/리버풀.png" alt="Liverpool" />        
	            </a> 
	            <a href="#">
	                <img src="./img/맨체스터시티.png" alt="ManchesterCity" />      
	            </a> 
	            <a href="#">
	                <img src="./img/맨유.png" alt="ManchesterUnited" />      
	            </a> 
	            <a href="#">
	                <img src="./img/뉴캐슬.png" alt="Newcastle" />      
	            </a> 
	            <a href="#">
	                <img src="./img/섀필드.png" alt="SheffieldUnited" />      
	            </a> 
	            <a href="#">
	                <img src="./img/사우스햄튼.png" alt="Southhampton" />     
	            </a> 
	            <a href="#">
	                <img src="./img/토트넘.png" alt="Tottenham" />     
	            </a> 
	            <a href="#">
	                <img src="./img/웨스트브롬.png" alt="WestBromwich" />     
	            </a> 
	            <a href="#">
	                <img src="./img/웨스트햄.png" alt="WestHam" />    
	            </a> 
	            <a href="#">
	                <img src="./img/울버햄튼.png" alt="Wolverhampton" />               
	            </a>      
        	</div>
        </nav>
</body>
</html>