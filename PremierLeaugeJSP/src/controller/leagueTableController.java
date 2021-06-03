package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AddCommentAction;
import action.DeleteCommentAction;
import action.HomeAction;
import action.MemberJoinAction;
import action.MemberJoinFormAction;
import action.MemberLoginAction;
import action.MyTeamAction;
import action.TeamArticleAction;
import action.TeamDetailAction;
import action.TeamPlayerAction;
import action.UserEditAction;
import action.UserEditFormAction;
import action.VoteManagerAction;
import action.VoteManagerFormAction;
import action.VoteManagerResultAction;

public class leagueTableController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Action action = null;
		
		if(command.equals("/HomeAction.do")) {
			action = new HomeAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/MatchListAction.do")) {
			action = new HomeAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("matchListView.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/TeamDetail.do")) {
			action = new TeamDetailAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("teamDetail.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/TeamPlayerAction.do")) {
			action = new TeamPlayerAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("teamPlayer.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/TeamArticleAction.do")) {
			action = new TeamArticleAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("teamArticle.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/LoginView.do")) {
			RequestDispatcher rd = request.getRequestDispatcher("loginForm.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/LoginAction.do")) {
			action = new MemberLoginAction();
			action.execute(request, response);
			
		}
		
		if(command.equals("/JoinView.do")) {
			action = new MemberJoinFormAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("joinForm.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/JoinAction.do")) {
			action = new MemberJoinAction();
			action.execute(request, response);
		}
		
		if(command.equals("/MyTeam.do")) {
			action = new MyTeamAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("myTeam.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/UserEditForm.do")) {
			action = new UserEditFormAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("userEditForm.jsp");
			rd.forward(request, response);
		}
		if(command.equals("/UserEditAction.do")) {
			action = new UserEditAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		if(command.equals("/AddCommentAction.do")) {
			action = new AddCommentAction();
			action.execute(request, response);
		}
		if(command.equals("/DeleteCommentAction.do")) {
			action = new DeleteCommentAction();
			action.execute(request, response);
		}
		if(command.equals("/VoteManagerForm.do")) {
			action = new VoteManagerFormAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("managerVoteForm.jsp");
			rd.forward(request, response);
		}
		
		if(command.equals("/VoteManager.do")) {
			action = new VoteManagerAction();
			action.execute(request, response);
		}
		
		if(command.equals("/VoteManagerResult.do")) {
			action = new VoteManagerResultAction();
			action.execute(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher("managerVoteResult.jsp");
			rd.forward(request, response);
		}
		
	}
}
