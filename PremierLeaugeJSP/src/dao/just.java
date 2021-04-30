package dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class just {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team1=Liverpool"))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		try {
				response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
				String leagueMatch = (String) response.body();
				
				// System.out.println(leagueMatch);
				
//				JSONParser jsonParser = new JSONParser();     
//				JSONObject jsonObj = (JSONObject) jsonParser.parse(leagueTable);
//		        JSONArray memberArray = (JSONArray) jsonObj.get("records");
		        
		        
		        // System.out.println(getLeagueArray());
		      
//		        System.out.println("=====Members=====");
//		        	for(int i=0 ; i<memberArray.size() ; i++){
//		        		JSONObject tempObj = (JSONObject) memberArray.get(i);
//		                System.out.println(tempObj.get("team"));
//		                System.out.println(tempObj.get("played"));
//		                System.out.println(tempObj.get("win"));
//		                System.out.println(tempObj.get("draw"));
//		                System.out.println(tempObj.get("loss"));
//		                System.out.println(tempObj.get("goalsFor"));
//		                System.out.println(tempObj.get("goalsAgainst"));
//		                System.out.println(tempObj.get("points"));
//		                System.out.println("----------------------------");
//	 	            }
//				
//				JSONParser jsonParser = new JSONParser();     
//				JSONArray jsonArr;
//				JSONObject jsonObj = new JSONObject();
//				jsonArr = (JSONArray) jsonParser.parse(leaguePlayer);
//				jsonObj.put("jsonArr", jsonArr);
//				JSONArray member1Array = (JSONArray) jsonObj.get("jsonArr");
//				JSONObject tempObj = (JSONObject) member1Array.get(0);
//				JSONArray member2Array = (JSONArray) tempObj.get("squad");
//				
//				 for(int i=0 ; i<member2Array.size() ; i++){
//					 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
//					 	
//		                System.out.println(temp2Obj.get("number"));
//		                System.out.println(temp2Obj.get("name"));
//		                System.out.println(temp2Obj.get("position"));
//		                System.out.println(temp2Obj.get("age"));
//		                System.out.println(temp2Obj.get("goals"));
//		                System.out.println(temp2Obj.get("assists"));
//		                System.out.println("----------------------------");
//				 }
				 
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team2=Liverpool"))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response2;
		try {
				response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
				String leagueMatch2 = (String) response2.body();
				
				System.out.println(leagueMatch2);
				
//				JSONParser jsonParser = new JSONParser();     
//				JSONObject jsonObj = (JSONObject) jsonParser.parse(leagueTable);
//		        JSONArray memberArray = (JSONArray) jsonObj.get("records");
		        
		        
		        // System.out.println(getLeagueArray());
		      
//		        System.out.println("=====Members=====");
//		        	for(int i=0 ; i<memberArray.size() ; i++){
//		        		JSONObject tempObj = (JSONObject) memberArray.get(i);
//		                System.out.println(tempObj.get("team"));
//		                System.out.println(tempObj.get("played"));
//		                System.out.println(tempObj.get("win"));
//		                System.out.println(tempObj.get("draw"));
//		                System.out.println(tempObj.get("loss"));
//		                System.out.println(tempObj.get("goalsFor"));
//		                System.out.println(tempObj.get("goalsAgainst"));
//		                System.out.println(tempObj.get("points"));
//		                System.out.println("----------------------------");
//	 	            }
//				
//				JSONParser jsonParser = new JSONParser();     
//				JSONArray jsonArr;
//				JSONObject jsonObj = new JSONObject();
//				jsonArr = (JSONArray) jsonParser.parse(leaguePlayer);
//				jsonObj.put("jsonArr", jsonArr);
//				JSONArray member1Array = (JSONArray) jsonObj.get("jsonArr");
//				JSONObject tempObj = (JSONObject) member1Array.get(0);
//				JSONArray member2Array = (JSONArray) tempObj.get("squad");
//				
//				 for(int i=0 ; i<member2Array.size() ; i++){
//					 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
//					 	
//		                System.out.println(temp2Obj.get("number"));
//		                System.out.println(temp2Obj.get("name"));
//		                System.out.println(temp2Obj.get("position"));
//		                System.out.println(temp2Obj.get("age"));
//		                System.out.println(temp2Obj.get("goals"));
//		                System.out.println(temp2Obj.get("assists"));
//		                System.out.println("----------------------------");
//				 }
				 
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
	
	}

}
