package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class VoteManagerResultAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		
		// get manager count
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service = new LeagueTeamInfoImpl(conn);
			List<LeagueTeamInfoBean> tiList = service.selectList();
		
			int managerCount = 0;
			
			for (LeagueTeamInfoBean i : tiList) {
				managerCount += i.getManagercount();
			}
			
			System.out.println(managerCount);
			Collections.sort(tiList); 
			
			request.setAttribute("teamInfoList", tiList);
			request.setAttribute("managerCount", managerCount);
		
		} catch (SQLException e) {
			System.out.println("Fail to connection.");
		}
	}
}
