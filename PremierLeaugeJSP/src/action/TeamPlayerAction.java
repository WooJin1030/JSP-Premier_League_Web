package action;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.LeagueTeamInfoBean;
import dto.LeaugePlayerBean;
import jdbc.ConnectionProvider;

public class TeamPlayerAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// get id from select team
		int id = Integer.parseInt(request.getParameter("team"));
		
		// teamdata DB
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.select(id);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
		
		// Invoke different api depending on id
		// get api about players in the team
		ArrayList<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://data.football-api.com/v3/teams/" + id + "?Authorization=0aBDqt7O7T8bpQWX6MH0o9WmWJRmC9GF5vBlbMf5"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response2;
		
		try {
			response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
			
			// get JSON to String
			String leaguePlayer = (String) response2.body();
				
			// String to Json Array
			JSONParser jsonParser = new JSONParser();     
			JSONArray member1Array = (JSONArray) jsonParser.parse(leaguePlayer);
			
			JSONObject tempObj = (JSONObject) member1Array.get(0);
			
			// get squad's key and values from Json Object
			JSONArray member2Array = (JSONArray) tempObj.get("squad");
	      
			 for(int i = 0 ; i < member2Array.size() ; i++){
				 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
				 	// player backnumber
	                String number = (String) temp2Obj.get("number");
	                // player name
	                String name = (String) temp2Obj.get("name");
	                // position
	                String position = (String) temp2Obj.get("position");
	                // age
	                String age = (String) temp2Obj.get("age");
	                // goals
	                int goals = Integer.parseInt((String) temp2Obj.get("goals"));
	                // assists
	                int assists = Integer.parseInt((String) temp2Obj.get("assists"));
	                
	                pList.add(new LeaugePlayerBean(null, id, number, name, position, age, goals, assists));
	                
	            }
			 
			 request.setAttribute("playerList", pList);
			
		} catch (IOException | InterruptedException | ParseException e) {
			e.printStackTrace();
		} 
		
		// session info
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
