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

public class TeamArticleAction implements Action{
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) {
      
      int id = Integer.parseInt(request.getParameter("team"));
      String team_name_eng=null;
      String team_name_kor=null;
      
      Connection conn = null;
      try {
         conn = ConnectionProvider.getConnection();
         
         LeagueTeamInfoDAO service2 = new LeagueTeamInfoImpl(conn);
         LeagueTeamInfoBean tiList = service2.select(id);
         team_name_eng = tiList.getName();
         request.setAttribute("teamInfoList", tiList);
      
      } catch (SQLException ex) {
         System.out.println("Fail to connection.");
      }
      switch(team_name_eng) {
      case "Arsenal" : 
    	  team_name_kor = "아스날";
    	  break;
      case "Aston Villa" : 
    	  team_name_kor = "아스톤빌라";
    	  break;
      case "Brighton" : 
    	  team_name_kor = "브라이튼";
    	  break;
      case "Burnley" : 
    	  team_name_kor = "번리";
    	  break;
      case "Chelsea" : 
    	  team_name_kor = "첼시";
    	  break;
      case "Crystal Palace" : 
    	  team_name_kor = "크리스탈 펠리스";
    	  break;
      case "Everton" : 
    	  team_name_kor = "에버튼";
    	  break;
      case "Fulham" : 
    	  team_name_kor = "풀햄";
    	  break;
      case "Leeds" : 
    	  team_name_kor = "리즈 유나이티드";
    	  break;
      case "Leicester" : 
    	  team_name_kor = "레스터 시티";
    	  break;
      case "Liverpool" : 
    	  team_name_kor = "리버풀";
    	  break;
      case "Manchester City" : 
    	  team_name_kor = "맨체스터 시티";
    	  break;
      case "Manchester United " : 
    	  team_name_kor = "맨체스터 유나이티드";
    	  break;
      case "Newcastle United " : 
    	  team_name_kor = "뉴캐슬 유나이티드";
    	  break;
      case "Sheffield United" : 
    	  team_name_kor = "쉐필드 유나이티드";
    	  break;
      case "Southampton" : 
    	  team_name_kor = "사우스햄튼";
    	  break;
      case "Tottenham Hotspur" : 
    	  team_name_kor = "토트넘 핫스퍼";
    	  break;
      case "West Bromwich" : 
    	  team_name_kor = "웨스트 브롬위치";
    	  break;
      case "West Ham" : 
    	  team_name_kor = "웨스트 햄";
    	  break;
      case "Wolverhampton Wanderers" : 
    	  team_name_kor = "움버햄튼";
    	  break;
      }
      ArrayList<TeamArticleBean> news_list = new ArrayList<TeamArticleBean>();
       String team_name = "맨체스터 유나이티드";
       int[] i_arr = {0, 11, 15, 19, 23, 27};
       
        Path path = Paths.get("E:/project/EPL-Info/chromedriver_win32/chromedriver.exe"); 
        System.setProperty("webdriver.chrome.driver", path.toString());
   
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");          
        options.addArguments("--disable-popup-blocking");    
        options.addArguments("--disable-default-apps");    
        
        ChromeDriver driver = new ChromeDriver( options );
  	  
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(0));
        
        String search_input=null;

         driver.get("https://www.google.co.kr/");  
      
          try {Thread.sleep(1000);} catch (InterruptedException e) {}
         
          WebElement search_space = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));         
         search_space.click();
         search_space = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
         
         search_space.sendKeys(team_name_eng);
         
         try {Thread.sleep(1000);} catch (InterruptedException e) {}
         WebElement search = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[2]/center/input[1]"));           
         search.click();
         
      
         List<WebElement> el1 = driver.findElements(By.className("hide-focus-ring"));
       
       for (int i = 0; i < el1.size(); i++) {
          if(el1.get(i).getText().equals("뉴스")) {
             el1.get(i).click();
             break;
          }
       }
       
         for(int i=1 ; i<=5; i++) {
            WebElement news_link_ElementType = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[" + i + "]/g-card/div/div/div[2]/a"));
             String news_link_StringType = news_link_ElementType.getAttribute("href");
             
             WebElement news_title_ElementType = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[" + i + "]/g-card/div/div/div[2]/a/div/div[2]/div[2]"));
             String news_title_StringType = news_title_ElementType.getText();
             
           //*[@id="rso"]/div[1]/g-card/div/div/div[2]/a/div/div[2]/div[2]
           //*[@id="rso"]/div[1]/g-card/div/div/div[2]/a/div/div[2]/div[3]/div[1]/text()
           //*[@id="rso"]/div[1]/g-card/div/div/div[2]/a/div/div[2]/div[3]
             WebElement news_content_ElementType = driver.findElement(By.xpath(" //*[@id=\"rso\"]/div[" + i + "]/g-card/div/div/div[2]/a/div/div[2]/div[3]"));
             String news_content_StringType = news_content_ElementType.getText();
             
             WebElement image_link_ElementType = driver.findElement(By.xpath("//*[@id=\"dimg_" + i_arr[i] + "\"]"));
             String image_link_StringType = image_link_ElementType.getAttribute("src");
             
             TeamArticleBean bean = new TeamArticleBean(team_name_eng, news_link_StringType, news_title_StringType, news_content_StringType,image_link_StringType);
             news_list.add(bean);
         }
       
        
        for(TeamArticleBean i : news_list) {
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