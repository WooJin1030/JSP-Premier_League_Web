package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class MemberJoinFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
		}
				
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			List<LeagueTeamInfoBean> tiList = service2.selectList();
			
			request.setAttribute("teamInfoList", tiList);
			
		} catch (SQLException ex) {
			System.out.println("Fail to connetcion. <br>");
			System.out.println("SQLException: " + ex.getMessage());
		}
		
	}
}
