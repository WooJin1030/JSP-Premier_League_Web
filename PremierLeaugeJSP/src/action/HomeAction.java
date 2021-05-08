package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTableManager;
import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dao.MemberDAO;
import dao.MemberImpl;
import dto.LeagueTableBean;
import dto.LeagueTeamInfoBean;
import dto.MemberBean;
import jdbc.ConnectionProvider;

public class HomeAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 리그 순위 테이블 정보
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();
		request.setAttribute("leagueTable", tList);
		
		// 세션 정보
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
		}
				
		
		// 회원 정보 (DB)
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO service2 = new MemberImpl(conn);
			MemberBean idList = service2.selectList(sessionId);
			// System.out.println(idList);
			
			if(idList != null) {
				// 회원정보의 myteam db 와 팀정보 db를 join 시킴
				LeagueTeamInfoDAO service3 = new LeagueTeamInfoImpl(conn);
				LeagueTeamInfoBean mtList = service3.selectMemberTeam(idList.getMyteam());
				
				request.setAttribute("memberTeam", mtList);
				System.out.println(mtList);
			}

		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
	}

	
}
