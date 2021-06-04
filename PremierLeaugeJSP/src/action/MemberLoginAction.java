package action;

import java.io.IOException;
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

public class MemberLoginAction implements Action {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String action = request.getParameter("action");
		
		// action login or logout
		if (action.equals("login")) { // login
			
			String id= request.getParameter("id");
			String password = request.getParameter("password");
			
			// check memeber db
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				MemberDAO service = new MemberImpl(conn);
				MemberBean idList = service.selectList(id);
				
				if(idList == null) { // id not in DB 
					request.setAttribute("errorMessage", "일치하는 id가 없습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("LoginView.do");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else if (!idList.getPassword().equals(password)) { // id in DB but incorrect pwd 	
					request.setAttribute("errorMessage", "비밀번호가 맞지 않습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("LoginView.do");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else {
					// success set session
					HttpSession session = request.getSession();
					
					session.setAttribute("userId", id);
					session.setAttribute("team", idList.getMyteam());
						
					try {
						RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
				}
				
			} catch (SQLException ex) {
				System.out.println("Fail to connetcion. <br>");
				System.out.println("SQLException: " + ex.getMessage());
			}

		} 
		
		// logout
		if (action.equals("logout")) {
			// destroy session
		    HttpSession session = request.getSession();  
            session.invalidate();  
            			
			try {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
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
