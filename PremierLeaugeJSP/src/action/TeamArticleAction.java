package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import dto.*;

public class TeamArticleAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// int id = Integer.parseInt(request.getParameter("team"));
		
		
		ArrayList<TeamArticleBean> news_list = new ArrayList<TeamArticleBean>();
    	String team_name = "맨체스터 유나이티드";
    	int[] i_arr = {0, 1, 4, 5, 6, 7};
    	
    	
        // 현재 package의 workspace 경로, Windows는 [ chromedriver.exe ]
        Path path = Paths.get("E:/project/EPL-Info/chromedriver_win32/chromedriver.exe");  // 현재 package의
        // WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", path.toString());
        // WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        
        // WebDriver 객체 생성
        ChromeDriver driver = new ChromeDriver( options );
        // 빈 탭 생성
        //driver.executeScript("window.open('about:blank','_blank');");
        // 탭 목록 가져오기
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        // 첫번째 탭으로 전환
        driver.switchTo().window(tabs.get(0));
        
        
        // 웹페이지 요청
        driver.get("https://www.naver.com/");  
        //브라우저 이동시 생기는 로드시간을 기다린다.
      	//HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기
      	try {Thread.sleep(1000);} catch (InterruptedException e) {}
        
        // 검색
      	WebElement search_space = driver.findElement(By.className("input_text"));			// (1). 네이버 홈에서 검색창을 찾아서 클릭하기
        search_space.click();
        search_space = driver.findElement(By.className("input_text"));				// (2). 검색창에 "team_name"넣기
        search_space.sendKeys(team_name);
        WebElement search = driver.findElement(By.className("ico_search_submit"));			        // (3). 검색하기 클릭
        search.click();
        WebElement news = driver.findElement(By.xpath("//*[@id=\"lnb\"]/div[1]/div/ul/li[2]/a"));			        // (4). 뉴스 탭으로 전환
        news.click();
        
        // 상위 <다섯개 기사 & 기사 이미지> 링크 가져와서, news_list에 add
        for(int i=1 ; i<=5; i++) {
        	WebElement news_link_ElementType = driver.findElement(By.xpath("//*[@id=\"sp_nws" + i_arr[i] + "\"]/div/div/a"));
            String news_link_StringType = news_link_ElementType.getAttribute("href");
            //System.out.println("news link[" + i_arr[i] + "] is : " + news_link_StringType);
            
            WebElement image_link_ElementType = driver.findElement(By.xpath("//*[@id=\"sp_nws" + i_arr[i] + "\"]/div/a/img"));
            String image_link_StringType = image_link_ElementType.getAttribute("src");
            //System.out.println("image link[" + i_arr[i] +"] is : " + image_link_StringType);
            //System.out.println();
            TeamArticleBean bean = new TeamArticleBean(team_name, news_link_StringType, image_link_StringType);
            news_list.add(bean);
        }
        
        for(TeamArticleBean i : news_list) {
        	System.out.println(i.toString());
        }
        
        
        // 탭 종료
        driver.close();
      
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
        
        request.setAttribute("newsList", news_list);
		
		
		
	}

}
