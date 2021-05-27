package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDAO;
import dao.CommentImpl;
import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.CommentBean;
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class DeleteCommentAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
	 	int id = Integer.parseInt(request.getParameter("id"));
	 	System.out.println(id);
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			CommentDAO service = new CommentImpl(conn);
			CommentBean cList = service.selectById(id);
			
			int teamid= cList.getTeamid();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tList = service2.selectTeamById(teamid);
			String teamname = tList.getName();
			
			service.delete(id);
			
			// String team = request.getParameter("team");
//			// If the team includes spacing, insert %20 in the middle.
//			if (team.contains(" ")) {
//				String[] teamArr = team.split(" ");
//				String part1 = teamArr[0];
//				String part2 = teamArr[1]; 
//				team = part1 + "%20" + part2;
//			} 
//			// get team's match info api
//			// case team is home
//			ArrayList<MyTeamBean> tList = new ArrayList<MyTeamBean>()
			
			response.sendRedirect("MyTeam.do?team=" + teamname);
			
		} catch (SQLException | IOException e) {
			System.out.println("Fail to connetcion. <br>");
			System.out.println("SQLException: " + e.getMessage());
		}
		
		
	}
}
