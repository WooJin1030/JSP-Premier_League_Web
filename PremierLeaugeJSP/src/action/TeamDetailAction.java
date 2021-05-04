package action;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class TeamDetailAction implements Action {


	public void execute(HttpServletRequest request, HttpServletResponse response) {
				
		int id = Integer.parseInt(request.getParameter("team"));
		
		request.setAttribute("id", id);
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.select(id);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
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
