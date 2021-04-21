<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Team Detail</title>

<style>
	.teamDetail__title {
		display: flex;
		justify-content: center;
	}
	
	.teamDetail__title img {
		margin-right: 16px;
	}
	
	.teamDetail__selectBtn {
		text-align: center;
		
	}
	
	hr {
		margin: 32px 0;
	}
	
	.teamDetail__selectBtn button {
		font-size: 24px;
		transition: all 300ms ease-in;
	}
	
	.teamDetail__selectBtn button:hover {
		transform: scale(1.1);
		color: gray;
	}
	
	.teamDetail__main {
		text-align: center;
	}
	
	.teamDetail__main .main__img {
		width: 150px;
		height: 150px;
	}
	
	.teamDetail__player {
	
		display:flex;
		justify-content: center;
		 
	}
	
	.hidden {
		display: none;
	}
	
</style>

</head>


<body>
	<jsp:include page="header.jsp" />
		
		<div class="teamDetail__title">
			<img src="./img/맨체스터시티.png"></img>
			<h1>맨체스터 시티 FC(Manchester City Football Club)</h1>
		</div>
		<hr>
		<div class="teamDetail__selectBtn">
			<button class="main">Main</button>
			<button class="playerInfo">Players</button>
			<button class="stadiumInfo">Home Stadium</button>
			<hr>
		</div>
		
		<div class="teamDetail__main">
			<ul>
				<li>
					<img src="./img/맨체스터시티.png" class="main__img">
				</li>
				<li><h3>연고지:  Manchester</h3></li>
				<li><h3>설립연도:  1880년, 세인트 마크스</h3></li>
				<li><h3>애칭:  블루스, 블루문, 시티즌, 샤크팀</h3></li>
				  
				<li>	
					<a href="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EC%B9%BC%EB%91%94+%EC%95%8C+%EB%AC%B4%EB%B0%94%EB%9D%BC%ED%81%AC">
						<h3>회장:  칼둔 알 무바라크 </h3>
					</a>
				</li>
				<li>
					<a href="https://search.naver.com/search.naver?where=nexearch&sm=top_sug.pre&fbm=0&acr=1&acq=%ED%8E%A9+%EA%B3%BC&qdt=0&ie=utf8&query=%ED%8E%A9+%EA%B3%BC%EB%A5%B4%EB%94%94%EC%98%AC%EB%9D%BC">
						 <h3>감독:  펩 과르디올라</h3>
					</a>
				</li>	
				<li>
					<a href="https://www.mancity.com/">
						<h3>공식 웹사이트</h3>
					</a>
				</li>
			</ul>	
		</div>
		
		<div class="teamDetail__player hidden">
			
			<div class="teamDetail__player__GK">
				<ul>
					<h2>골키퍼</h2>
					<li>
						<span>13</span>
						<span>Zack Steffen</span>
					</li>
					
					<li>
						<span>31</span>
						<span>Ederson</span>
					</li>
					
					<li>
						<span>33</span>
						<span>Sott Carson</span>
					</li>
					
					<li>
						<span>49</span>
						<span>Arijanet Muric</span>
					</li>
					
				</ul>
			</div>
			
			<div class="teamDetail__player__DF">
				<ul>
					<h2>수비수</h2>
					<li>
						<span>2</span>
						<span>Kyle Walker</span>
					</li>
					
					<li>
						<span>3</span>
						<span>Ruben Dias</span>
					</li>
					
					<li>
						<span>5</span>
						<span>John Stones</span>
					</li>
					
					<li>
						<span>6</span>
						<span>Nathan Ake</span>
					</li>
					
					<li>
						<span>12</span>
						<span>Angeliño</span>
					</li>
					
					<li>
						<span>14</span>
						<span>Aymeric Laporte</span>
					</li>
					<li>
						<span>22</span>
						<span>Benjamin Mendy</span>
					</li>
					<li>
						<span>27</span>
						<span>João Cancelo</span>
					</li>
					<li>
						<span>34</span>
						<span>Phillippe Sandler</span>
					</li>
					<li>
						<span>50</span>
						<span>Eric Garcia</span>
					</li>

				</ul>
			</div>
			
	
			<div class="teamDetail__player__MF">
				<ul>
					<h2>미드필더</h2>
					<li>
						<span>8</span>
						<span>Ilkay Gundogan</span>
					</li>
					
					<li>
						<span>11</span>
						<span>Oleksandr Zinchenko</span>
					</li>
					
					<li>
						<span>16</span>
						<span>Rodrigo</span>
					</li>
					
					<li>
						<span>17</span>
						<span>Kevin De Bruyne</span>
					</li>
					
					<li>
						<span>20</span>
						<span>Bernardo Silva</span>
					</li>
					
					<li>
						<span>25</span>
						<span>Fernandinho</span>
					</li>
					<li>
						<span>26</span>
						<span>Riyad Mahrez</span>
					</li>
					<li>
						<span>47</span>
						<span>Phil Foden</span>
					</li>
					<li>
						<span></span>
						<span>Patrik Roberts</span>
					</li>
				</ul>
			</div>
			
			<div class="teamDetail__player__FW">
				<ul>
					<h2>공격수</h2>
					<li>
						<span>7</span>
						<span>Raheem Sterling</span>
					</li>
					
					<li>
						<span>9</span>
						<span>Gabriel Jesus</span>
					</li>
					
					<li>
						<span>10</span>
						<span>Sergio Agüero</span>
					</li>
					
					<li>
						<span>21</span>
						<span>Ferran Torres</span>
					</li>	
				</ul>
			</div>
				
		</div>
		
		<!-- <li><a href="#">에티하드 스타디움</a></li> -->
			
	<jsp:include page="footer.jsp" />
	
	<script type="text/javascript">
		
	const mainPage = document.querySelector(".teamDetail__main");
	const playerPage = document.querySelector(".teamDetail__player");
	const mainBtn = document.querySelector(".main");
	const playerBtn = document.querySelector(".playerInfo");
	
	function showPlayer() {
		mainPage.classList.add("hidden");
		playerPage.classList.remove("hidden");
	}
	
	function showMain() {
		mainPage.classList.remove("hidden");
		playerPage.classList.add("hidden");
	}
	
	mainBtn.addEventListener("click", showMain);
	playerBtn.addEventListener("click", showPlayer);

</script>
	
</body>
</html>