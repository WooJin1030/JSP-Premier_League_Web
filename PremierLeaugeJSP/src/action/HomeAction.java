package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LeagueTableManager;

import dto.LeagueTableBean;

public class HomeAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();
		request.setAttribute("leagueTable", tList);
	
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		String teamId = (String) session.getAttribute("team");
		
		if (sessionId == null || sessionId.equals("")) {
			request.setAttribute("sessionState", "none");
		} else {
			request.setAttribute("sessionState", "loggedIn");
			request.setAttribute("teamId", teamId);
		}
	}
	
}
