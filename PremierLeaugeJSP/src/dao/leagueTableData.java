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

public class leagueTableData {
	
	
	private static JSONArray leagueArray = new JSONArray();
	
	public static JSONArray getLeagueArray() {
		return leagueArray;
	}

	public static void setLeagueArray(JSONArray leagueArray) {
		leagueTableData.leagueArray = leagueArray;
	}
	
	public leagueTableData() {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague/table"))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			// System.out.println(response.body());
			// System.out.println(response.body().getClass().getName());
			
			String leagueTable = response.body();
			System.out.println(leagueTable);
			
			JSONParser jsonParser = new JSONParser();     
			JSONObject jsonObj = (JSONObject) jsonParser.parse(leagueTable);
	        JSONArray memberArray = (JSONArray) jsonObj.get("records");
	        
	        setLeagueArray(memberArray);
	        
	        // System.out.println(getLeagueArray());
	      
//	        System.out.println("=====Members=====");
//	        	for(int i=0 ; i<memberArray.size() ; i++){
//	        		JSONObject tempObj = (JSONObject) memberArray.get(i);
//	                System.out.println(tempObj.get("team"));
//	                System.out.println(tempObj.get("played"));
//	                System.out.println(tempObj.get("win"));
//	                System.out.println(tempObj.get("draw"));
//	                System.out.println(tempObj.get("loss"));
//	                System.out.println(tempObj.get("goalsFor"));
//	                System.out.println(tempObj.get("goalsAgainst"));
//	                System.out.println(tempObj.get("points"));
//	                System.out.println("----------------------------");
// 	            }
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	
		
		
	}
}