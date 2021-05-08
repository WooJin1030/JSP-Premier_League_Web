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
		
		// 선택한 팀의 id를 불러옴
		int id = Integer.parseInt(request.getParameter("team"));
		
		// 팀정보 DB를 불러옴
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.select(id);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
		
		// 팀의 id에 따라 다른 api를 불러옴
		// 팀의 선수정보에 대한 api 불러옴
		ArrayList<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
		
		HttpRequest request2 = HttpRequest.newBuilder()
				.uri(URI.create("https://data.football-api.com/v3/teams/" + id + "?Authorization=0aBDqt7O7T8bpQWX6MH0o9WmWJRmC9GF5vBlbMf5"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response2;
		
		try {
			response2 = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
			
			// JSON은 String형태로 불러옴
			String leaguePlayer = (String) response2.body();
				
			// String을 Json Array로 파싱
			JSONParser jsonParser = new JSONParser();     
			JSONArray member1Array = (JSONArray) jsonParser.parse(leaguePlayer);
			
			JSONObject tempObj = (JSONObject) member1Array.get(0);
			
			// Json Object에서 squad 키와 value를 뽑아낸다.
			JSONArray member2Array = (JSONArray) tempObj.get("squad");
	      
			 for(int i = 0 ; i < member2Array.size() ; i++){
				 	JSONObject temp2Obj = (JSONObject) member2Array.get(i);
				 	// 선수의 등번호
	                String number = (String) temp2Obj.get("number");
	                // 선수의 이름
	                String name = (String) temp2Obj.get("name");
	                // 선수의 포지션
	                String position = (String) temp2Obj.get("position");
	                // 선수 나이
	                String age = (String) temp2Obj.get("age");
	                // 선수 득점 수
	                int goals = Integer.parseInt((String) temp2Obj.get("goals"));
	                // 선수 도움 수
	                int assists = Integer.parseInt((String) temp2Obj.get("assists"));
	                
	                pList.add(new LeaugePlayerBean(null, id, number, name, position, age, goals, assists));
	                
	            }
			 
			 request.setAttribute("playerList", pList);
			
		} catch (IOException | InterruptedException | ParseException e) {
			e.printStackTrace();
		} 
		
		// 세션 정보
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
