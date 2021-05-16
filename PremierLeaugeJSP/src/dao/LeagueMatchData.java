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

public class leagueMatchData {

private static JSONArray matchArray = new JSONArray();
	
	public static JSONArray getMatchArray() {
		return matchArray;
	}

	public static void setMatchArray(JSONArray matchArray) {
		leagueMatchData.matchArray = matchArray;
	}
	
	public leagueMatchData() throws IOException, InterruptedException {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data.football-api.com/v3/matches?comp_id=1204&from_date=30.04.2021&to_date=07.05.2021&Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b"))
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
		 	
		 	System.out.println(temp2Obj.get("formatted_date"));
            System.out.println(temp2Obj.get("visitorteam_name"));
            System.out.println(temp2Obj.get("localteam_name"));
            System.out.println(temp2Obj.get("ft_score"));
            System.out.println(temp2Obj.get("time"));
            System.out.println("----------------------------");
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