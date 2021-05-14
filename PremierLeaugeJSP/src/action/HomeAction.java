package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueMatchManager;
import dao.LeagueTableManager;
import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dao.MemberDAO;
import dao.MemberImpl;
import dto.LeagueMatchBean;
import dto.LeagueTableBean;
import dto.LeagueTeamInfoBean;
import dto.MemberBean;
import jdbc.ConnectionProvider;

public class HomeAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// league Table
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();
		request.setAttribute("leagueTable", tList);
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
		}
				
		
		// member info (DB)
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO service2 = new MemberImpl(conn);
			MemberBean idList = service2.selectList(sessionId);
			
			LeagueMatchManager service3 = LeagueMatchManager.getInstance();
			List<LeagueMatchBean> vList = service3.getList();
			request.setAttribute("leagueMatch", vList);
			
			if(idList != null) {
				// members db join to team data db
				LeagueTeamInfoDAO service4 = new LeagueTeamInfoImpl(conn);
				LeagueTeamInfoBean mtList = service4.selectMemberTeam(idList.getMyteam());
				
				request.setAttribute("memberTeam", mtList);
			}

	
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
	}

	
}
