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
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050274-3e077e00-a6b2-11eb-83fe-58aaece8cfe6.png");
			request.setAttribute("teamcolor", "rgb(152,197,233)");
		} else if(id == 9260) {
			ManchesterUnitedPlayerManager service2= ManchesterUnitedPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Manchester United F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050238-38119d00-a6b2-11eb-823f-7539e716d1a4.png");
			request.setAttribute("teamcolor", "rgb(199,1,1)");
		} else if(id == 9240) {
			LeicesterPlayerManager service2= LeicesterPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Leicester City F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050253-3a73f700-a6b2-11eb-9748-7e20017f6c2c.png");
			request.setAttribute("teamcolor", "rgb(11,86,164)");
		} else if(id == 9427) {
			WestHamPlayerManager service2= WestHamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "West Ham United F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050262-3ba52400-a6b2-11eb-9298-3b7de530436b.png");
			request.setAttribute("teamcolor", "rgb(125,43,58)");
		} else if(id == 9092) {
			ChelseaPlayerManager service2= ChelseaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Chelsea F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050252-3a73f700-a6b2-11eb-9017-70300e33cc88.png");
			request.setAttribute("teamcolor", "rgb(0,20,137)");
		} else if(id == 9249) {
			LiverpoolPlayerManager service2= LiverpoolPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Liverpool F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050246-3942ca00-a6b2-11eb-9ff7-61ecde2a5acd.png");
			request.setAttribute("teamcolor", "rgb(227,27,35)");
			
		} else if(id == 9406) {
			TottenhamPlayerManager service2= TottenhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Tottenham Hotspur F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050271-3d6ee780-a6b2-11eb-86f7-e9380f8d8bb8.png");
			request.setAttribute("teamcolor", "rgb(17,24,54)");
		} else if(id == 9158) {
			EvertonPlayerManager service2= EvertonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Everton FC");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050273-3d6ee780-a6b2-11eb-92bc-fa42a5451cd8.png");
			request.setAttribute("teamcolor", "rgb(0,46,133)");
		} else if(id == 9238) {
			LeedsPlayerManager service2= LeedsPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Leeds United");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050259-3ba52400-a6b2-11eb-99a5-63fa8610bb26.png");
			request.setAttribute("teamcolor", "rgb(29,65,137)");
		} else if(id == 9002) {
			ArsenalPlayerManager service2= ArsenalPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Arsenal F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050257-3b0c8d80-a6b2-11eb-8488-7dc68f06383f.png");
			request.setAttribute("teamcolor", "rgb(240,0,0)");
		} else if(id == 9008) {
			AstonVillaPlayerManager service2= AstonVillaPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Aston Villa F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050276-3e077e00-a6b2-11eb-9c5c-5db8d4adaaa0.png");
			request.setAttribute("teamcolor", "rgb(103,14,55)");
		} else if(id == 9446) {
			WolverhamptonPlayerManager service2= WolverhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Wolverhampton Wanderers F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050255-3b0c8d80-a6b2-11eb-8625-bf17ce9c0482.png");
			request.setAttribute("teamcolor", "rgb(253,185,19)");
		} else if(id == 9127) {
			CrystalPalacePlayerManager service2= CrystalPalacePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Crystal Palace F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050263-3c3dba80-a6b2-11eb-9e4e-c5bf8762cab6.png");
			request.setAttribute("teamcolor", "rgb(1,74,151)");
		} else if(id == 9363) {
			SouthhamptonPlayerManager service2= SouthhamptonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Southampton F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050269-3cd65100-a6b2-11eb-86e3-b981982632f3.png");
			request.setAttribute("teamcolor", "rgb(255,0,40)");
		} else if(id == 9287) {
			NewcastlePlayerManager service2= NewcastlePlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Newcastle United F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050247-39db6080-a6b2-11eb-9a9d-60fad463ad18.png");
			request.setAttribute("teamcolor", "rgb(0,0,0)");
		} else if(id == 9065) {
			BrightonPlayerManager service2= BrightonPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Brighton & Hove Albion F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050243-38aa3380-a6b2-11eb-9aa6-f6ff7665d297.png");
			request.setAttribute("teamcolor", "rgb(0,84,166)");
		} else if(id == 9175) {
			FullhamPlayerManager service2= FullhamPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Fulham F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050280-3ea01480-a6b2-11eb-8434-8abc4ff34ef3.png");
			request.setAttribute("teamcolor", "rgb(0,0,0)");
		} else if(id == 9072) {
			BurnleyPlayerManager service2= BurnleyPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Burnley F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050265-3c3dba80-a6b2-11eb-87fd-ce7cdf38602f.png");
			request.setAttribute("teamcolor", "rgb(129,32,76)");
		} else if(id == 9426) {
			WestBromwichPlayerManager service2= WestBromwichPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "West Bromwich Albion F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050250-39db6080-a6b2-11eb-94dc-24d0a270b7b7.png");
			request.setAttribute("teamcolor", "rgb(0,47,104)");
		} else if(id == 9348) {
			SheffieldPlayerManager service2= SheffieldPlayerManager.getInstance();
			List<LeaugePlayerBean> pList = service2.getList();	
			request.setAttribute("playerList", pList);
			request.setAttribute("teamname", "Sheffield United F.C.");
			request.setAttribute("imageUrl", "https://user-images.githubusercontent.com/62231339/116050241-38aa3380-a6b2-11eb-93df-112b1f808f7e.png");
			request.setAttribute("teamcolor", "rgb(227,6,19)");		
		}
		
		request.setAttribute("leagueTable", tList);
		
		
	}
}	
