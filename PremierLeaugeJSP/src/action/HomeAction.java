package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeagueTableManager;
import dto.LeagueTableBean;

public class HomeAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();	
		
		request.setAttribute("leagueTable", tList);
		
	}
	
}
