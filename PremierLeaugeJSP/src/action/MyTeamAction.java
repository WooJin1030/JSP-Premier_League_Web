package action;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.CommentDAO;
import dao.CommentImpl;
import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.CommentBean;
import dto.LeagueTeamInfoBean;
import dto.MyTeamBean;
import jdbc.ConnectionProvider;

public class MyTeamAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// get team name
		String teaminit = request.getParameter("team");
		String team = request.getParameter("team");
		
		// If the team includes spacing, insert %20 in the middle.
		if (team.equals("West Bromwich Albion")) {
			team = "West%20Bromwich%20Albion";
		}
		if (team.contains(" ")) {
			String[] teamArr = team.split(" ");
			String part1 = teamArr[0];
			String part2 = teamArr[1]; 
			team = part1 + "%20" + part2;
		} 
		// get team's match info api
		// case team is home
		ArrayList<MyTeamBean> tList = new ArrayList<MyTeamBean>();
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team1=" + team))
				.header("x-rapidapi-key", "api key")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		try {
				try {
					
					HttpResponse<String> response2;
					response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
					
					// get JSON to String
					String leagueMatch = (String) response2.body();
					// System.out.println(leagueMatch);
					
					JSONParser jsonParser = new JSONParser();     
					JSONObject jsonObj;
					
					// Parsing to Json Object
					jsonObj = (JSONObject) jsonParser.parse(leagueMatch);
					
					// get match's key and values from Json Object
					JSONArray matchArray = (JSONArray) jsonObj.get("matches");
					
		        	for(int i = 0 ; i < matchArray.size() ; i++){
		        		JSONObject tempObj = (JSONObject) matchArray.get(i);
		        		
		        		// when match
		                String when = String.valueOf(tempObj.get("when"));	             
		                String referee = String.valueOf(tempObj.get("referee"));
		                int matchNumber = Integer.parseInt(String.valueOf(tempObj.get("matchNumber")));
		                
		                // home team
		                JSONObject testDataObject = (JSONObject) tempObj.get("team1");
		                // home team name
		                String team1Name = String.valueOf(testDataObject.get("teamName"));
        
		                try {
		                	
		                	// home team score
		                	int team1Score;
			                // if temaScore is null or empty return -1
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
			                
			                // away
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
		
		// team away
		HttpRequest request3 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team2=" + team))
				.header("x-rapidapi-key", "api key")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		try {
				try {
					HttpResponse<String> response3;
					response3 = HttpClient.newHttpClient().send(request3, HttpResponse.BodyHandlers.ofString());
					
					String leagueMatch2 = (String) response3.body();
					// System.out.println(leagueMatch2);
					
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
		
		// tList sort by matchNumber
		Collections.sort(tList); 
		request.setAttribute("myTeamList", tList);
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		
		// team info DB
		// teamdata DB
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.selectByName(teaminit);
			System.out.println(teaminit);
			System.out.println(tiList);
			request.setAttribute("teamInfoList", tiList);
			
			CommentDAO service3 = new CommentImpl(conn);
			List<CommentBean> cList = service3.selectList();
			request.setAttribute("commentList", cList);
			
			
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
	}
}


