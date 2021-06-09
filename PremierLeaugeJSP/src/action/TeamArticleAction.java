package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dao.LeagueTeamInfoDAO;
import dao.LeagueTeamInfoImpl;
import dto.*;
import jdbc.ConnectionProvider;

public class TeamArticleAction implements Action {
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
	   
	// teamdata DB
	   
		int teamid = Integer.parseInt(request.getParameter("team"));
		
		Connection conn = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			LeagueTeamInfoDAO service = new LeagueTeamInfoImpl(conn);
			LeagueTeamInfoBean tiList = service.select(teamid);
			request.setAttribute("teamInfoList", tiList);
		
		} catch (SQLException ex) {
			System.out.println("Fail to connection.");
		}
		
   
      int id = Integer.parseInt(request.getParameter("team"));
      String team_name_eng = null;
      String team_name_kor = null;

      try {
         conn = ConnectionProvider.getConnection();

         LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
         LeagueTeamInfoBean tiList = service2.select(id);
         team_name_eng = tiList.getName();
         request.setAttribute("teamInfoList", tiList);

      } catch (SQLException ex) {
         System.out.println("Fail to connection.");
      }
      switch (team_name_eng) {
      case "Arsenal":
         team_name_kor = "아스날";
         break;
      case "Aston Villa":
         team_name_kor = "아스톤 빌라";
         break;
      case "Brighton":
         team_name_kor = "브라이튼";
         break;
      case "Burnley":
         team_name_kor = "번리";
         break;
      case "Chelsea":
         team_name_kor = "첼시";
         break;
      case "Crystal Palace":
         team_name_kor = "크리스탈 펠리스";
         break;
      case "Everton":
         team_name_kor = "에버튼";
         break;
      case "Fulham":
         team_name_kor = "풀럼";
         break;
      case "Leeds":
         team_name_kor = "리즈";
         break;
      case "Leicester":
         team_name_kor = "레스터";
         break;
      case "Liverpool":
         team_name_kor = "리버풀";
         break;
      case "Manchester City":
         team_name_kor = "맨체스터 시티";
         break;
      case "Manchester United":
         team_name_kor = "멘체스터 유나이티드";
         break;
      case "Newcastle United":
         team_name_kor = "뉴캐슬 유나이티드";
         break;
      case "Sheffield United":
         team_name_kor = "쉐필드 유나이티드";
         break;
      case "Southampton":
         team_name_kor = "사우스 햄튼";
         break;
      case "Tottenham":
         team_name_kor = "토트넘 핫스퍼";
         break;
      case "West Bromwich Albion":
         team_name_kor = "웨스트 브롬위치";
         break;
      case "West Ham":
         team_name_kor = "웨스트햄";
         break;
      case "Wolverhampton Wanderers":
         team_name_kor = "울범햄튼";
         break;
      }
      ArrayList<TeamArticleBean> news_list = new ArrayList<TeamArticleBean>();
      Path path = Paths.get(
    		  "E:/project/EPL-Info/chromedriver_win32/chromedriver.exe");
      System.setProperty("webdriver.chrome.driver", path.toString());

      
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--start-maximized");
      options.addArguments("--disable-popup-blocking");
      options.addArguments("--disable-default-apps");
      //added option
      // options.addArguments("headless");

      ChromeDriver driver = new ChromeDriver(options);

      
      List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

      driver.switchTo().window(tabs.get(0));
      
      for(int search_num=1; search_num<=2 ; search_num++) {
         String input_keyword;
         
         if(search_num==1) input_keyword = team_name_kor;
         else input_keyword = team_name_eng;
         
         driver.get("https://www.naver.com/");
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
         
         
         WebElement search_space = driver.findElement(By.id("query"));
         search_space.sendKeys(input_keyword);
         search_space.click();

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
         }
         
         WebElement search = driver.findElement(By.className("ico_search_submit"));
         search.click();

         List<WebElement> el1 = driver.findElements(By.className("menu"));
         for (int i = 0; i < el1.size(); i++) {
            if (el1.get(i).getText().equals("뉴스")) {
               el1.get(i).click();
               break;
            }
         }
         List<WebElement> el2 = driver.findElements(By.className("news_tit"));
         List<WebElement> el3 = driver.findElements(By.className("dsc_wrap"));
         List<WebElement> el4 = driver.findElements(By.className("api_get"));

         for (int i = 0; i <= 4; i++) {

            String news_link_StringType = el2.get(i).getAttribute("href");
            String news_title_StringType = el2.get(i).getAttribute("title");

            String news_content_StringType = el3.get(i).getText();

            String image_link_StringType = el4.get(i).getAttribute("src");

            TeamArticleBean bean = new TeamArticleBean(team_name_eng, news_link_StringType, news_title_StringType,
                  news_content_StringType, image_link_StringType);
            news_list.add(bean);
         }
      }
      
      for (TeamArticleBean i : news_list) {
         System.out.println(i.toString());
      }

      driver.close();

      try {
         Thread.sleep(5000);
      } catch (InterruptedException e) {
         e.printStackTrace();
      } finally {
         driver.quit();
      }

      request.setAttribute("newsList", news_list);

   }

}