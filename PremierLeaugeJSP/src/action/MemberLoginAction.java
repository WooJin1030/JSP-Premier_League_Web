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
		
		// action이 login / logout인지 판단
		if (action.equals("login")) { // login인 경우
			
			String id= request.getParameter("id");
			String password = request.getParameter("password");
			
			// memeber db확인
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				MemberDAO service = new MemberImpl(conn);
				MemberBean idList = service.selectList(id);
				
				if(idList == null) { // db에 일치하는 id가 없을 때 
					request.setAttribute("errorMessage", "일치하는 id가 없습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else if (!idList.getPassword().equals(password)) { // db에 일치하는 id가 있지만 비밀번호가 틀린 경우 	
					request.setAttribute("errorMessage", "비밀번호가 맞지 않습니다!");
					
					try {
						RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
						rd.forward(request, response);
					} catch (ServletException | IOException e) {
						e.printStackTrace();
					}
					
				} else {
					// 로그인에 성공한 경우 -> 세션 설정
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
		// logout인 경우
		if (action.equals("logout")) {
			// 세션 해제
		    HttpSession session = request.getSession();  
            session.invalidate();  
            			
			try {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		// 세션 정보 확인
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
