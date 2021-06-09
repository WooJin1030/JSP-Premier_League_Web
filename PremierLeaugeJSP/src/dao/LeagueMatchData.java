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

public class leagueMatchData {

private static JSONArray matchArray = new JSONArray();
	
	public static JSONArray getMatchArray() {
		return matchArray;
	}

	public static void setMatchArray(JSONArray matchArray) {
		leagueMatchData.matchArray = matchArray;
	}
	
	public leagueMatchData() throws IOException, InterruptedException {
		
		String date = new Date().toString();
		// System.out.println(date);
		
		String dateArr[] = date.split(" ");
		String month = dateArr[1];
		String day = dateArr[2];
		String year = dateArr[5];
		
		System.out.println(month);
		
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
		case "Jun": 
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
				.uri(URI.create("https://data.football-api.com/v3/matches?comp_id=1204&from_date=30.04.2021&to_date=" + todayDate + "&Authorization=api key"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.body());
	
	try {
		response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		
		String leagueMatch = response.body();
		System.out.println(leagueMatch);
		
		JSONParser jsonParser = new JSONParser();     
		JSONArray matchArray = (JSONArray) jsonParser.parse(leagueMatch);
		System.out.println(matchArray);
		
		for(int i=matchArray.size()-1 ; i>=0 ; i--){
		 	JSONObject temp2Obj = (JSONObject) matchArray.get(i);		 	
//		 	System.out.println(temp2Obj.get("formatted_date"));
//          System.out.println(temp2Obj.get("visitorteam_name"));
//          System.out.println(temp2Obj.get("localteam_name"));
//          System.out.println(temp2Obj.get("ft_score"));
//          System.out.println(temp2Obj.get("time"));
//          System.out.println("----------------------------");
	 }

        setMatchArray(matchArray);
		
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