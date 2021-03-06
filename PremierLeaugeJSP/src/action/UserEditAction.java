package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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

public class UserEditAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name = request.getParameter("name");
		String team = request.getParameter("teamname");
		
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		
		// team 설정을 하지 않은 경우
		if (team == null || team.equals("")) { 
	    	request.setAttribute("errorMessage", "내 팀 정보를 입력하지 않았습니다!");
			try {

				RequestDispatcher rd = request.getRequestDispatcher("UserEditForm.do");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

	        return;
			    }
		
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO service = new MemberImpl(conn);
			MemberBean idList = service.selectList(sessionId);
			
			String id = idList.getId();
			String password = idList.getPassword();
			String email = idList.getEmail();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.selectByName(team);
			int teamid = tiList.getId();		
			
			MemberBean member = new MemberBean(id, password, name, email, teamid);
			
			service.edit(member);
			
			session.setAttribute("userId", id);
			session.setAttribute("team", teamid);
			
		} catch (SQLException ex) {
			System.out.println("Fail to connetcion. <br>");
			System.out.println("SQLException: " + ex.getMessage());
		}
		
		

	}
		

}
