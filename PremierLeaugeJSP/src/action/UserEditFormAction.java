package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dao.MemberDAO;
import dao.MemberImpl;
import dto.LeagueTeamInfoBean;
import dto.MemberBean;
import jdbc.ConnectionProvider;

public class UserEditFormAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// get session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		

		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO service = new MemberImpl(conn);
			MemberBean mList = service.selectList(sessionId);

			request.setAttribute("memberInfo", mList);
			
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			List<LeagueTeamInfoBean> tiList = service2.selectList();
			
			request.setAttribute("teamInfoList", tiList);
			

			
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
	}

}
