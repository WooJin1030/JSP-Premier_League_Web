package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
		System.out.println(name);
		
	}
}
