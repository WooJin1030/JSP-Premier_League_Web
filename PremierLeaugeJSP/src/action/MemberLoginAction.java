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

public class MemberLoginAction implements Action {
	
	PrintWriter out = null;
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String action = request.getParameter("action");
		
		
		if (action.equals("login")) {
			
			String id= request.getParameter("id");
			String password = request.getParameter("password");
			
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				MemberDAO service = new MemberImpl(conn);
				MemberBean idList = service.selectList(id);
				
				if(idList == null) {
					request.setAttribute("errorMessage", "일치하는 id가 없습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else if (!idList.getPassword().equals(password)) {	
					request.setAttribute("errorMessage", "비밀번호가 맞지 않습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else {
					System.out.println("환영합니다!" + id + "님");
					
					HttpSession session = request.getSession();
					
					session.setAttribute("userId", id);
					session.setAttribute("team", idList.getMyteam());
					// session.setAttribute("userPW", password);
					
					System.out.println("Welcome " + id);
						
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
		
		if (action.equals("logout")) {
		    HttpSession session = request.getSession();  
            session.invalidate();  
            
			// System.out.println("Session Delete~");
			System.out.println("logout");
			
			
			try {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
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
