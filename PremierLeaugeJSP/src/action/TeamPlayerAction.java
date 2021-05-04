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
		
		int id = Integer.parseInt(request.getParameter("team"));
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.select(id);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
		
		ArrayList<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://data.football-api.com/v3/teams/" + id + "?Authorization=0aBDqt7O7T8bpQWX6MH0o9WmWJRmC9GF5vBlbMf5"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response2;
		
		try {
			response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
			response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
			
			String leaguePlayer = (String) response2.body();
			
			JSONParser jsonParser = new JSONParser();     
			JSONArray jsonArr;
			JSONObject jsonObj = new JSONObject();
		
			jsonArr = (JSONArray) jsonParser.parse(leaguePlayer);
			jsonObj.put("jsonArr", jsonArr);
			
			// System.out.println(jsonObj);
			
			JSONArray member1Array = (JSONArray) jsonObj.get("jsonArr");
			JSONObject tempObj = (JSONObject) member1Array.get(0);
			
			JSONArray member2Array = (JSONArray) tempObj.get("squad");
	        // System.out.println(getLeagueArray());
	      
			 for(int i = 0 ; i < member2Array.size() ; i++){
				 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
	                String number = (String) temp2Obj.get("number");
	                String name = (String) temp2Obj.get("name");
	                String position = (String) temp2Obj.get("position");
	                String age = (String) temp2Obj.get("age");
	                int goals = Integer.parseInt((String) temp2Obj.get("goals"));
	                int assists = Integer.parseInt((String) temp2Obj.get("assists"));
	                
	                pList.add(new LeaugePlayerBean(null, id, number, name, position, age, goals, assists));
	                
	            }
			 
			 request.setAttribute("playerList", pList);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
            e.printStackTrace();
        }
		
		
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
