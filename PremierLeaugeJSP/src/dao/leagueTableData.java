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
	        	
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            e.printStackTrace();
        }
		
	
		
		
	}
}