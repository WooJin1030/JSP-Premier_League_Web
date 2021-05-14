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

public class MemberJoinAction implements Action{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// information from join form
		String id= request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String team = request.getParameter("teamname");
			
		// join error control
		if (team == null || team.equals("")) { // team 설정을 하지 않은 경우
	    	request.setAttribute("errorMessage", "내 팀 정보를 입력하지 않았습니다!");
			try {

				RequestDispatcher rd = request.getRequestDispatcher("JoinView.do");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}

	        return;
	    } else if (password.length() < 5) { // 비밀번호가 5자리 미만인 경우
	    	request.setAttribute("errorMessage", "비밀번호는 5자리 이상 설정해야합니다.");
			try {
				RequestDispatcher rd = request.getRequestDispatcher("JoinView.do");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	        return;
		}

		 // check in member DB
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			MemberDAO service = new MemberImpl(conn);
			MemberBean idList = service.selectList(id);
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.selectByName(team);
			int teamid = tiList.getId();		
			
			MemberBean member = new MemberBean(id, password, name, email, teamid);
			
			if (idList == null) { // id not in DB
				service.insert(member); 						
				try {
					RequestDispatcher rd = request.getRequestDispatcher("LoginView.do");
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

			} else { // id already exists 
				request.setAttribute("errorMessage", "존재하는 id가 있습니다!");
				try {
					RequestDispatcher rd = request.getRequestDispatcher("JoinView.do");
					rd.forward(request, response);
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException ex) {
			System.out.println("Fail to connetcion. <br>");
			System.out.println("SQLException: " + ex.getMessage());
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
