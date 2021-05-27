package action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDAO;
import dao.CommentImpl;
import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.CommentBean;
import dto.LeagueTeamInfoBean;
import jdbc.ConnectionProvider;

public class AddCommentAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// session info
		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");
		int team = (int) session.getAttribute("team");
		
		Random rand = new Random();
		String text = request.getParameter("comment");
		String sessionid = sessionId;
		int id = rand.nextInt(100000);
		int teamid = team;
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		
		CommentBean comment = new CommentBean(id, teamid, sessionid, text, date, time);
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			CommentDAO service = new CommentImpl(conn);
			service.insert(comment);
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn); 
			LeagueTeamInfoBean tList = service2.select(teamid);
			String teamname = tList.getName();
			
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
