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
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class VoteManagerAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String name= request.getParameter("manager");
		// System.out.println(name);
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("sessionId", sessionId);
		}
		
		// find manager and add a count
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service.selectByName(name);
			int count = tiList.getManagercount() + 1; 
			
			LeagueTeamInfoBean plusCount = new LeagueTeamInfoBean(tiList.getId(), tiList.getName(), tiList.getOrigin(), tiList.getEstablishment(), tiList.getNickname(), tiList.getLogoUrl(), tiList.getManagername(), tiList.getManagerimageurl(), tiList.getChairmanname(), tiList.getOfficialsite(), tiList.getStadiumname(), tiList.getStadiumimageurl(), tiList.getCapacity(), tiList.getFieldsize(), tiList.getTeamcolor(), count);
			service.edit(plusCount);
		
		} catch (SQLException e) {
			System.out.println("Fail to connection.");
		}
		
		
		try {
			RequestDispatcher rd = request.getRequestDispatcher("VoteManagerResult.do");
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}
}
