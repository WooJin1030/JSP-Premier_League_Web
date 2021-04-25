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
				.uri(URI.create("https://data.football-api.com/v3/teams/9260?Authorization=0aBDqt7O7T8bpQWX6MH0o9WmWJRmC9GF5vBlbMf5"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		
	
			try {
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
				
		      
				 for(int i=0 ; i<member2Array.size() ; i++){
					 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
					 	
//					 	int number;
//					 	if ((String)temp2Obj.get("number") == JSONObject("null")) {
//					 		number = 0;
//					 	} else {
//					 		number = Integer.parseInt(temp2Obj.get("number").toString());
//					 	}
					 	
		                System.out.println(temp2Obj.get("number"));
		               // System.out.println(Integer.parseInt((String)tempObj.get("number")));
//		                System.out.println(temp2Obj.get("name"));
//		                System.out.println(temp2Obj.get("position"));
//		                System.out.println(temp2Obj.get("age"));
//		                System.out.println(temp2Obj.get("goals"));
//		                System.out.println(temp2Obj.get("assists"));
//		                System.out.println("----------------------------");
				 }
				 
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
	}

}
