package dao.PlayerData;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FullhamPlayerData {
	
	
	private static JSONArray FullhamPlayerArray = new JSONArray();
	
	public static JSONArray getFullhamPlayerArray() {
		return FullhamPlayerArray;
	}

	public static void setLeagueArray(JSONArray FullhamPlayerArray) {
		FullhamPlayerData.FullhamPlayerArray = FullhamPlayerArray;
	}
	
	public FullhamPlayerData() {
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://data.football-api.com/v3/teams/9175?Authorization=0aBDqt7O7T8bpQWX6MH0o9WmWJRmC9GF5vBlbMf5"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			
			String leaguePlayer = (String) response.body();
			
			JSONParser jsonParser = new JSONParser();     
			JSONArray jsonArr;
			JSONObject jsonObj = new JSONObject();
		
			jsonArr = (JSONArray) jsonParser.parse(leaguePlayer);
			jsonObj.put("jsonArr", jsonArr);
			
			// System.out.println(jsonObj);
			
			JSONArray member1Array = (JSONArray) jsonObj.get("jsonArr");
			JSONObject tempObj = (JSONObject) member1Array.get(0);
			
			JSONArray member2Array = (JSONArray) tempObj.get("squad");
			
	        setLeagueArray(member2Array);
	        
	        // System.out.println(getLeagueArray());
	      
//			 for(int i=0 ; i<member2Array.size() ; i++){
//				 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
//	                System.out.println(temp2Obj.get("number"));
//	                System.out.println(temp2Obj.get("name"));
//	                System.out.println(temp2Obj.get("position"));
//	                System.out.println(temp2Obj.get("age"));
//	                System.out.println(temp2Obj.get("goals"));
//	                System.out.println(temp2Obj.get("assists"));
//	                System.out.println("----------------------------");
//	            }
			
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