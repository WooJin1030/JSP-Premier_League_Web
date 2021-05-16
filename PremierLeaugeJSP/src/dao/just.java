package dao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class just {

	public static void main(String[] args) {
		
		String date = new Date().toString();
		// System.out.println(date);
		
		String dateArr[] = date.split(" ");
		String month = dateArr[1];
		String day = dateArr[2];
		String year = dateArr[5];
	
		String monthNumber = null;
		
		switch(month) {
		case "January": 
			monthNumber = "01";
			break;
		case "February": 
			monthNumber = "02";
			break;
		case "March": 
			monthNumber = "03";
			break;
		case "April": 
			monthNumber = "04";
			break;
		case "May": 
			monthNumber = "05";
			break;
		case "June": 
			monthNumber = "06";
			break;
		case "July": 
			monthNumber = "07";
			break;
		case "August": 
			monthNumber = "08";
			break;
		case "September": 
			monthNumber = "09";
			break;
		case "October": 
			monthNumber = "10";
			break;
		case "November": 
			monthNumber = "11";
			break;
		case "December": 
			monthNumber = "12";
			break;
		}
		
		String todayDate = day + "." + monthNumber + "." + year;
		System.out.println(todayDate);
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://heisenbug-premier-league-live-scores-v1.p.rapidapi.com/api/premierleague?team1=Leeds"))
				.header("x-rapidapi-key", "3fb0e2ffb0msh091247651585061p1ddfe3jsn1a702eb6c8a6")
				.header("x-rapidapi-host", "heisenbug-premier-league-live-scores-v1.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		
		try {
				try {
					HttpResponse<String> response;
					response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
					
					String leagueMatch = (String) response.body();
					// System.out.println(leagueMatch);
					
					JSONParser jsonParser = new JSONParser();     
					JSONObject jsonObj;

					jsonObj = (JSONObject) jsonParser.parse(leagueMatch);
					JSONArray matchArray = (JSONArray) jsonObj.get("matches");
					
		        	for(int i = 0 ; i < matchArray.size() ; i++){
		        		JSONObject tempObj = (JSONObject) matchArray.get(i);
		                // System.out.println(tempObj.get("when"));	                
		                // System.out.println(tempObj.get("referee"));
		                // System.out.println(tempObj.get("matchNumber"));
		                
		                JSONObject testDataObject = (JSONObject) tempObj.get("team1");
		                // System.out.println(testDataObject.get("teamName"));
		                // System.out.println(String.valueOf(testDataObject.get("teamScore")).getClass().getName());
//		                System.out.println(testDataObject.get("firstHalfScore"));
//		                
		                JSONObject testDataObject2 = (JSONObject) tempObj.get("team2");
//		                System.out.println(testDataObject2.get("teamName"));
//		                System.out.println(testDataObject2.get("teamScore"));
//		                System.out.println(testDataObject2.get("firstHalfScore"));
//		         
		        	} 
					
					// matchArray.forEach( match -> parseTestData( (JSONObject) match ) );
					
				} catch (IOException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				} catch (ParseException e) {
					e.printStackTrace();
		        
				}
		    
		}
	
}
