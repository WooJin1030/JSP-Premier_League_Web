package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberImpl;
import dto.MemberBean;
import jdbc.ConnectionProvider;

public class MemberJoinAction implements Action{
	
	PrintWriter out = null;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id= request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String team = request.getParameter("teamname");
		
		String teamid = null;
		
		switch(team) {
		case "ManchesterCity":
			teamid =  "9259";
			break;
		case "ManchesterUnited":
			teamid = "9260";
			break;
		case "Leicester":
			teamid = "9240";
			break;
		case "WestHam":
			teamid = "9427";
			break;
		case "Chelsea":
			teamid = "9092";
			break;
		case "Liverpool":
			teamid = "9249";
			break;
		case "Tottenham":
			teamid = "9406";
			break;
		case "Everton":
			teamid = "9158";
			break;
		case "Leeds":
			teamid = "9238";
			break;
		case "Arsenal":
			teamid = "9002";
			break;
		case "AstonVilla":
			teamid = "9008";
			break;
		case "Wolverhampton":
			teamid = "9446";
			break;
		case "CrystalPalace":
			teamid = "9127";
			break;
		case "Southhampton":
			teamid = "9363";
			break;
		case "Newcastle":
			teamid = "9287";
			break;
		case "Brighton":
			teamid = "9065";
			break;
		case "Fullham":
			teamid = "9175";
			break;
		case "Burnley":
			teamid = "9072";
			break;
		case "WestBromwich":
			teamid = "9426";
			break;
		case "Sheffield":
			teamid = "9348";
			break;
		}
		
		MemberBean member = new MemberBean(id, password, name, email, teamid);
		
		if (id == null || id.equals("")) {
			request.setAttribute("errorMessage", "id를 입력하지 않았습니다!");
			try {
				try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return;
	    } else if (name == null || name.equals("")) {
	    	request.setAttribute("errorMessage", "이름을 입력하지 않았습니다!");
			try {
				try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

	        return;
	    } else if (email == null || email.equals("")) {
	    	request.setAttribute("errorMessage", "이메일을 입력하지 않았습니다!");
			try {
				try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

	        return;
	    } else if (team == null || team.equals("")) {
	    	request.setAttribute("errorMessage", "내 팀 정보를 입력하지 않았습니다!");
			try {
				try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

	        return;
	    } else if (password.length() < 5) {
	    	request.setAttribute("errorMessage", "비밀번호는 5자리 이상 설정해야합니다.");
	        try {
	        	try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	        return;
		}
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			MemberDAO service = new MemberImpl(conn);
			MemberBean idList = service.selectList(id);
			
			if (idList == null) {
				service.insert(member); 
				
				try {
					RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			} else {
		
				request.setAttribute("errorMessage", "존재하는 id가 있습니다!");
				try {
					RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
					rd.forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException ex) {
			System.out.println("Fail to connetcion. <br>");
			System.out.println("SQLException: " + ex.getMessage());
		}
		
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
