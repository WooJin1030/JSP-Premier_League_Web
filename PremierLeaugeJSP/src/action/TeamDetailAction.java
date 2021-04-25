package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LeagueTableManager;
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
import dto.LeagueTableBean;
import dto.LeaugePlayerBean;
public class TeamDetailAction implements Action {


	public void execute(HttpServletRequest request, HttpServletResponse response) {
						
		LeagueTableManager service= LeagueTableManager.getInstance();
		List<LeagueTableBean> tList = service.getList();	
		
		int id = Integer.parseInt(request.getParameter("team"));
		
		if(id == 9259) {
			ManchesterCityPlayerManager service2= ManchesterCityPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Manchester City F.C.");
			request.setAttribute("imageUrl", "./img/맨체스터시티.png");
		} else if(id == 9260) {
			ManchesterUnitedPlayerManager service2= ManchesterUnitedPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Manchester United F.C.");
			request.setAttribute("imageUrl", "./img/맨유.png");
		} else if(id == 9240) {
			LeicesterPlayerManager service2= LeicesterPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Leicester City F.C.");
			request.setAttribute("imageUrl", "./img/레스터시티.png");
		} else if(id == 9427) {
			WestHamPlayerManager service2= WestHamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "West Ham United F.C.");
			request.setAttribute("imageUrl", "./img/웨스트햄.png");
		} else if(id == 9092) {
			ChelseaPlayerManager service2= ChelseaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Chelsea F.C.");
			request.setAttribute("imageUrl", "./img/첼시.png");
		} else if(id == 9249) {
			LiverpoolPlayerManager service2= LiverpoolPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Liverpool F.C.");
			request.setAttribute("imageUrl", "./img/리버풀.png");
		} else if(id == 9406) {
			TottenhamPlayerManager service2= TottenhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Tottenham Hotspur F.C.");
			request.setAttribute("imageUrl", "./img/토트넘.png");
		} else if(id == 9158) {
			EvertonPlayerManager service2= EvertonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Everton FC");
			request.setAttribute("imageUrl", "./img/에버튼.png");
		} else if(id == 9238) {
			LeedsPlayerManager service2= LeedsPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Leeds United");
			request.setAttribute("imageUrl", "./img/리즈.png");
		} else if(id == 9002) {
			ArsenalPlayerManager service2= ArsenalPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Arsenal F.C.");
			request.setAttribute("imageUrl", "./img/아스날.png");
		} else if(id == 9008) {
			AstonVillaPlayerManager service2= AstonVillaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Aston Villa F.C.");
			request.setAttribute("imageUrl", "./img/아스톤빌라.png");
		} else if(id == 9446) {
			WolverhamptonPlayerManager service2= WolverhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Wolverhampton Wanderers F.C.");
			request.setAttribute("imageUrl", "./img/울버햄튼.png");
		} else if(id == 9127) {
			CrystalPalacePlayerManager service2= CrystalPalacePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Crystal Palace F.C.");
			request.setAttribute("imageUrl", "./img/크리스탈펠리스.png");
		} else if(id == 9363) {
			SouthhamptonPlayerManager service2= SouthhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Southampton F.C.");
			request.setAttribute("imageUrl", "./img/사우스햄튼.png");
		} else if(id == 9287) {
			NewcastlePlayerManager service2= NewcastlePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Newcastle United F.C.");
			request.setAttribute("imageUrl", "./img/뉴캐슬.png");
		} else if(id == 9065) {
			BrightonPlayerManager service2= BrightonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Brighton & Hove Albion F.C.");
			request.setAttribute("imageUrl", "./img/브라이튼.png");
		} else if(id == 9175) {
			FullhamPlayerManager service2= FullhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Fulham F.C.");
			request.setAttribute("imageUrl", "./img/풀럼.png");
		} else if(id == 9072) {
			BurnleyPlayerManager service2= BurnleyPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Burnley F.C.");
			request.setAttribute("imageUrl", "./img/번리.png");
		} else if(id == 9426) {
			WestBromwichPlayerManager service2= WestBromwichPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "West Bromwich Albion F.C.");
			request.setAttribute("imageUrl", "./img/웨스트브롬.png");
		} else if(id == 9348) {
			SheffieldPlayerManager service2= SheffieldPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Sheffield United F.C.");
			request.setAttribute("imageUrl", "./img/섀필드.png");
		}
		
		request.setAttribute("leagueTable", tList);
		
		
	}
}	
