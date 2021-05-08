package dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dto.LeagueMatchBean;

public class LeagueMatchManager {
	private List<LeagueMatchBean> vList = new ArrayList<LeagueMatchBean>();
	
	private static LeagueMatchManager instance = new LeagueMatchManager();
	
	public static LeagueMatchManager getInstance(){
		return instance;
	}
	
	public LeagueMatchManager() {
		
		
		try {
			
			LeagueMatchData data = null;
			data = new LeagueMatchData();
			JSONArray matchArray = data.getMatchArray();
			
			for(int i = 0 ; i < matchArray.size(); i++) {
				JSONObject tempObj = (JSONObject) matchArray.get(i);	
				vList.add(new LeagueMatchBean( 
						(String)tempObj.get("formatted_date"), 
						(String)tempObj.get("visitorteam_name"),
						(String)tempObj.get("localteam_name"),
						(String)tempObj.get("ft_score")));
			}
			
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public List<LeagueMatchBean> getList() {
		return vList;
	}
	
	public void setList(List<LeagueMatchBean> list) {
		this.vList = list;
	}
}
