package action;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dto.MyTeamBean;

public class MyTeamAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 자기가 설정한 팀 이름을 받아온다.
		String team = request.getParameter("team");
		
		// team이 띄어쓰기를 포함한 경우에는 가운데에 %20을 삽입한다.
		if (team.contains(" ")) {
			String[] teamArr = team.split(" ");
			String part1 = teamArr[0];
			String part2 = teamArr[1]; 
		  team = part1 + "%20" + part2;
		}
		
		// api에서 팀 전체의 정보를 가져운다.
		// 팀이 홈인 경우
		ArrayList<MyTeamBean> tList = new ArrayList<MyTeamBean>();
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team1=" + team))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		try {
				try {
					
					HttpResponse<String> response2;
					response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
					
					// Json을 String으로 받아온다.
					String leagueMatch = (String) response2.body();
					System.out.println(leagueMatch);
					
					JSONParser jsonParser = new JSONParser();     
					JSONObject jsonObj;
					
					// Json Object로 파싱한다.
					jsonObj = (JSONObject) jsonParser.parse(leagueMatch);
					
					// Json Object에서 matches 키와 value들을 Json Array로 만든다.
					JSONArray matchArray = (JSONArray) jsonObj.get("matches");
					
		        	for(int i = 0 ; i < matchArray.size() ; i++){
		        		JSONObject tempObj = (JSONObject) matchArray.get(i);
		        		
		        		// 경기 시간
		                String when = String.valueOf(tempObj.get("when"));
		                // 심판 정보
		                String referee = String.valueOf(tempObj.get("referee"));
		                // 매치 넘버
		                int matchNumber = Integer.parseInt(String.valueOf(tempObj.get("matchNumber")));
		                
		                // 홈팀
		                JSONObject testDataObject = (JSONObject) tempObj.get("team1");
		                // 홈팀 이름
		                String team1Name = String.valueOf(testDataObject.get("teamName"));
        
		                try {
		                	
		                	// 홈팀 득접
		                	int team1Score;
			                // temaScore가 null이거나 비어있는 경우에는 -1(아직 경기를 하지 않을 경우)
			                if(String.valueOf(testDataObject.get("teamScore")) != "null" && !String.valueOf(testDataObject.get("teamScore")).isEmpty()) {			                	
			                	team1Score = Integer.parseInt(String.valueOf(testDataObject.get("teamScore")));
			                } else { 
			                	team1Score = -1; 
			                }
			                
			                // 홈틴 전반전 득점
			                int team1FirstHalfScore;
			                
			                if(String.valueOf(testDataObject.get("firstHalfScore")) != "null" && !String.valueOf(testDataObject.get("firstHalfScore")).isEmpty()) {
			                	team1FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject.get("firstHalfScore"))); 
			                } else {
			                	team1FirstHalfScore = -1;
			                }
			                
			                // 어웨이팀
			                JSONObject testDataObject2 = (JSONObject) tempObj.get("team2");
			                String team2Name = String.valueOf(testDataObject2.get("teamName"));
			                
			                // 어웨이팀 득점
			                int team2Score; 
			                if(String.valueOf(testDataObject2.get("teamScore")) != "null" && !String.valueOf(testDataObject2.get("teamScore")).isEmpty()) {
			                	team2Score = Integer.parseInt(String.valueOf(testDataObject2.get("teamScore")));  
			                } else {		                	
			                	team2Score = -1;
			                }
			                
			                // 어웨이팀 전반전 득점
			                int team2FirstHalfScore;
			                if(String.valueOf(testDataObject2.get("firstHalfScore")) != "null" && !String.valueOf(testDataObject2.get("firstHalfScore")).isEmpty()) {
			                	team2FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject2.get("firstHalfScore")));
			                } else {
			                	team2FirstHalfScore = -1;
			                }
			        	    
			                tList.add(new MyTeamBean(when, referee, matchNumber, team1Name, team1Score, team1FirstHalfScore, team2Name, team2Score, team2FirstHalfScore));
			                
		                } catch(NumberFormatException e) {
		                	e.printStackTrace();
		                }

		        	} 
					
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}

				} catch (ParseException e) {
					e.printStackTrace();	        
				}
		
		// 팀이 어웨이인 경우
		HttpRequest request3 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team2=" + team))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		try {
				try {
					HttpResponse<String> response3;
					response3 = HttpClient.newHttpClient().send(request3, HttpResponse.BodyHandlers.ofString());
					
					String leagueMatch2 = (String) response3.body();
					System.out.println(leagueMatch2);
					
					JSONParser jsonParser2 = new JSONParser();     
					JSONObject jsonObj2;

					jsonObj2 = (JSONObject) jsonParser2.parse(leagueMatch2);
					JSONArray matchArray2 = (JSONArray) jsonObj2.get("matches");
					
		        	for(int i = 0 ; i < matchArray2.size() ; i++){
		        		JSONObject tempObj = (JSONObject) matchArray2.get(i);
		                String when = String.valueOf(tempObj.get("when"));
		                String referee = String.valueOf(tempObj.get("referee"));
		                int matchNumber = Integer.parseInt(String.valueOf(tempObj.get("matchNumber")));
		                
		                JSONObject testDataObject = (JSONObject) tempObj.get("team1");
		                String team1Name = String.valueOf(testDataObject.get("teamName"));
		                
		                try {
		                	
		                	int team1Score;
			                
			                if(String.valueOf(testDataObject.get("teamScore")) != "null" && !String.valueOf(testDataObject.get("teamScore")).isEmpty()) {			                	
			                	team1Score = Integer.parseInt(String.valueOf(testDataObject.get("teamScore")));
			                } else { 
			                	team1Score = -1; 
			                }
			                	
			                int team1FirstHalfScore;
			                
			                if(String.valueOf(testDataObject.get("firstHalfScore")) != "null" && !String.valueOf(testDataObject.get("firstHalfScore")).isEmpty()) {
			                	team1FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject.get("firstHalfScore"))); 
			                } else {
			                	team1FirstHalfScore = -1;
			                }
			                
			                JSONObject testDataObject2 = (JSONObject) tempObj.get("team2");
			                String team2Name = String.valueOf(testDataObject2.get("teamName"));
			                
			                int team2Score; 
			                if(String.valueOf(testDataObject2.get("teamScore")) != "null" && !String.valueOf(testDataObject2.get("teamScore")).isEmpty()) {
			                	team2Score = Integer.parseInt(String.valueOf(testDataObject2.get("teamScore")));  
			                } else {		                	
			                	team2Score = -1;
			                }
			                
			                int team2FirstHalfScore;
			                if(String.valueOf(testDataObject2.get("firstHalfScore")) != "null" && !String.valueOf(testDataObject2.get("firstHalfScore")).isEmpty()) {
			                	team2FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject2.get("firstHalfScore")));
			                } else {
			                	team2FirstHalfScore = -1;
			                }
			        	    
			                tList.add(new MyTeamBean(when, referee, matchNumber, team1Name, team1Score, team1FirstHalfScore, team2Name, team2Score, team2FirstHalfScore));
			                
		                } catch(NumberFormatException e) {
		                	e.printStackTrace();
		                }
		        	} 
									
				} catch (IOException | InterruptedException e) {
					e.printStackTrace();
				}

				} catch (ParseException e) {
					e.printStackTrace();	        
				}
		
		// tList를 matchNumber로 정렬(오름차순)
		Collections.sort(tList); 
		request.setAttribute("myTeamList", tList);
		
		// 세션정보
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		
	}
}


