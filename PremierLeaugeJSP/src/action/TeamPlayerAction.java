package action;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dao.PlayerManager.ArsenalPlayerManager;
import dao.PlayerManager.AstonVillaPlayerManager;
import dao.PlayerManager.BrightonPlayerManager;
import dao.PlayerManager.BurnleyPlayerManager;
import dao.PlayerManager.ChelseaPlayerManager;
import dao.PlayerManager.CrystalPalacePlayerManager;
import dao.PlayerManager.EvertonPlayerManager;
import dao.PlayerManager.FullhamPlayerManager;
import dao.PlayerManager.LeedsPlayerManager;
import dao.PlayerManager.LeicesterPlayerManager;
import dao.PlayerManager.LiverpoolPlayerManager;
import dao.PlayerManager.ManchesterCityPlayerManager;
import dao.PlayerManager.ManchesterUnitedPlayerManager;
import dao.PlayerManager.NewcastlePlayerManager;
import dao.PlayerManager.SheffieldPlayerManager;
import dao.PlayerManager.SouthhamptonPlayerManager;
import dao.PlayerManager.TottenhamPlayerManager;
import dao.PlayerManager.WestBromwichPlayerManager;
import dao.PlayerManager.WestHamPlayerManager;
import dao.PlayerManager.WolverhamptonPlayerManager;
import dto.LeagueTeamInfoBean;
import dto.LeaugePlayerBean;
import jdbc.ConnectionProvider;

public class TeamPlayerAction implements Action {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("team"));
		
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service2.select(id);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
		if(id == 9259) {		
			ManchesterCityPlayerManager service2= ManchesterCityPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(152,197,233)");
		} else if(id == 9260) {
			ManchesterUnitedPlayerManager service2= ManchesterUnitedPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(199,1,1)");
		} else if(id == 9240) {
			LeicesterPlayerManager service2= LeicesterPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(11,86,164)");
		} else if(id == 9427) {
			WestHamPlayerManager service2= WestHamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(125,43,58)");
		} else if(id == 9092) {
			ChelseaPlayerManager service2= ChelseaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,20,137)");
		} else if(id == 9249) {
			LiverpoolPlayerManager service2= LiverpoolPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(227,27,35)");
			
		} else if(id == 9406) {
			TottenhamPlayerManager service2= TottenhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(17,24,54)");
		} else if(id == 9158) {
			EvertonPlayerManager service2= EvertonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,46,133)");
		} else if(id == 9238) {
			LeedsPlayerManager service2= LeedsPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(29,65,137)");
		} else if(id == 9002) {
			ArsenalPlayerManager service2= ArsenalPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(240,0,0)");
		} else if(id == 9008) {
			AstonVillaPlayerManager service2= AstonVillaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(103,14,55)");
		} else if(id == 9446) {
			WolverhamptonPlayerManager service2= WolverhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(253,185,19)");
		} else if(id == 9127) {
			CrystalPalacePlayerManager service2= CrystalPalacePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(1,74,151)");
		} else if(id == 9363) {
			SouthhamptonPlayerManager service2= SouthhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(255,0,40)");
		} else if(id == 9287) {
			NewcastlePlayerManager service2= NewcastlePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,0,0)");
		} else if(id == 9065) {
			BrightonPlayerManager service2= BrightonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,84,166)");
		} else if(id == 9175) {
			FullhamPlayerManager service2= FullhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,0,0)");
		} else if(id == 9072) {
			BurnleyPlayerManager service2= BurnleyPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(129,32,76)");
		} else if(id == 9426) {
			WestBromwichPlayerManager service2= WestBromwichPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(0,47,104)");
		} else if(id == 9348) {
			SheffieldPlayerManager service2= SheffieldPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamcolor", "rgb(227,6,19)");		
		}
		
		
		
	}
		
}
