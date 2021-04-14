<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            height: 70%; 
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
            
        }

        .sidenav h3 {
            margin-top: 50%;
            margin-bottom: 32px;
            color: white;
            text-align: center;
        }

        .sidenav ul {
            font-size: 20px;
            margin-left: 4px;
            color: white;
            list-style: none;
            padding: 0;
        }

        .sidenav li {
            margin-bottom: 32px;
        }

	     .main {
        	position: absolute;
            margin-left: 220px; /* Same as the width of the sidebar */
            top: 200px;
            left: 200px;
        }

        /* On smaller screens, where height is less than 450px, change the style of the sidebar (less padding and a smaller font size) */
            /* @media screen and (max-height: 450px) {
                .sidenav {padding-top: 15px;}
                .sidenav a {font-size: 18px;}
        }
         */

        .main table {
            border-collapse: collapse;
            text-align: center;
            width: 800px;
        }

        .main table th,td {
            border: 1px solid gray;
        }

        .table__divide {
            max-height: 500px;
            overflow-y: scroll;
            width: 817px;
        }
        
        .main table .teamname {
           display: flex;
           align-items: center;
           justify-content: center;
        }

        .main table img {
            margin-right: 8px;
            width: 30px;
            height: 30px;
        } 
	
</style>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	
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
        <table class="main__table">
            <colgroup>
                <col width="8%">
                <col width="28%">
                <col width="8%">
                <col width="8%">
                <col width="8%">
                <col width="8%">
                <col width="8%">
                <col width="8%">
                <col width="8%">
                <col width="8%">   
            </colgroup>
            <thead>
                <tr>
                    <th>순위</th>
                    <th class=>팀명</th>
                    <th>경기</th>
                    <th>승점</th>
                    <th>승</th>
                    <th>무</th>
                    <th>패</th>
                    <th>득점</th>
                    <th>실점</th>
                    <th>득실차</th>
              </tr>
            </thead>

        </table>
        <div class="table__divide">
            <table class="main__table">
                <colgroup>
                    <col width="8%">
                    <col width="28%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">
                    <col width="8%">        
                </colgroup>
                <tbody>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                    <tr>
                        <td class="ranking">1</td>
                        <td class="teamname">
                            <img src="./img/맨체스터시티.png" alt="ManchesterCity">
                            <span>맨시티</span>
                        </td>
                        <td>32</td>
                        <td>74</td>
                        <td>23</td>
                        <td>5</td>
                        <td>4</td>
                        <td>67</td>
                        <td>23</td>
                        <td>44</td>
                    </tr>
                </tbody>         
            </table>
        </div>   
    </div>
</body>
</html>