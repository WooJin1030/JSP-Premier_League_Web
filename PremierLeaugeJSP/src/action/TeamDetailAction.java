package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeaguePlayerManager;
import dao.LeagueTableManager;
import dto.LeagueTableBean;
import dto.LeaugePlayerBean;

public class TeamDetailAction implements Action {


	public void execute(HttpServletRequest request, HttpServletResponse response) {
						
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();	
		
		String id = request.getParameter("team");
		
		LeaguePlayerManager service2= LeaguePlayerManager.getInstance();
		List<LeaugePlayerBean> pList = service2.getList();	
		
		request.setAttribute("leagueTable", tList);
		request.setAttribute("playerList", pList);
		request.setAttribute("id", id);
		
		
	}
}	
