package action;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

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
		
		String team = request.getParameter("team");
//		if (team.contains(" ")) {
//		  Scanner scan1 = new Scanner(System.in); 
//		  System.out.println("Enter your input value one"); 
//		  String x = scan1.next(); 
//		  System.out.println("Enter your input value two"); 
//		  String y = scan1.next(); 
//		  System.out.println("Please line one or two" + x+ y);
//		  scan1.close();
//		  
//		  team = x + "%20" + y;
//		}
		
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
					
					String leagueMatch = (String) response2.body();
					System.out.println(leagueMatch);
					
					JSONParser jsonParser = new JSONParser();     
					JSONObject jsonObj;

					jsonObj = (JSONObject) jsonParser.parse(leagueMatch);
					JSONArray matchArray = (JSONArray) jsonObj.get("matches");
					
		        	for(int i = 0 ; i < matchArray.size() ; i++){
		        		JSONObject tempObj = (JSONObject) matchArray.get(i);
		                String when = String.valueOf(tempObj.get("when"));	                
		                String referee = String.valueOf(tempObj.get("referee"));
		                int matchNumber = Integer.parseInt(String.valueOf(tempObj.get("matchNumber")));
		                
		                JSONObject testDataObject = (JSONObject) tempObj.get("team1");
		                String team1Name = String.valueOf(testDataObject.get("teamName"));
		                
		                
		                
		                try {
		                	int team1Score;
			                if(!String.valueOf(testDataObject.get("teamScore")).equals(null)) {
			                	team1Score = Integer.parseInt(String.valueOf(testDataObject.get("teamScore"))); 
			                } else {
			                	team1Score = -1;
			                }
			                
			                int team1FirstHalfScore;
			                
			                if(!String.valueOf(testDataObject.get("firstHalfScore")).equals(null)) {
			                	team1FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject.get("firstHalfScore")));  
			                } else {
			                	team1FirstHalfScore = -1;
			                }      
			                
			                JSONObject testDataObject2 = (JSONObject) tempObj.get("team2");
			                String team2Name = String.valueOf(testDataObject2.get("teamName"));
			                
			                int team2Score;
			                
			                if(!String.valueOf(testDataObject2.get("teamScore")).equals(null)) {
			                	team2Score = Integer.parseInt(String.valueOf(testDataObject2.get("teamScore")));  
			                } else {
			                	team2Score = -1;
			                }
			        	    
			                int team2FirstHalfScore;
			                
			                if(!String.valueOf(testDataObject2.get("firstHalfScore")).equals(null)) {
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
		
		HttpRequest request3 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team2=Liverpool"))
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
			                
			                if(!String.valueOf(testDataObject.get("teamScore")).equals(null)) {
			                	team1Score = Integer.parseInt(String.valueOf(testDataObject.get("teamScore")));  
			                } else {
			                	team1Score = -1;
			                }
			        	    
			                int team1FirstHalfScore;
			                
			                if(!String.valueOf(testDataObject.get("firstHalfScore")).equals(null)) {
			                	team1FirstHalfScore = Integer.parseInt(String.valueOf(testDataObject.get("firstHalfScore")));  
			                } else {
			                	team1FirstHalfScore = -1;
			                }
			          
			                JSONObject testDataObject2 = (JSONObject) tempObj.get("team2");
			                String team2Name = String.valueOf(testDataObject2.get("teamName"));
			                
			                int team2Score; 
			                if(!String.valueOf(testDataObject2.get("teamScore")).equals(null)) {
			                	team2Score = Integer.parseInt(String.valueOf(testDataObject2.get("teamScore")));  
			                } else {
			                	team2Score = -1;
			                }
			        	    
			                int team2FirstHalfScore;
			                if(!String.valueOf(testDataObject2.get("firstHalfScore")).equals(null)) {
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
		
		request.setAttribute("myTeamList", tList);
		
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


