package dao;

import java.util.ArrayList;
import java.util.List;

import dto.LeagueTableBean;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class LeagueTableManager {
	private List<LeagueTableBean> tList = new ArrayList<LeagueTableBean>();
	
	private static LeagueTableManager instance = new LeagueTableManager();
	
	public static LeagueTableManager getInstance(){
		return instance;
	}
	
	public LeagueTableManager() {
		
		leagueTableData data = new leagueTableData();
		JSONArray memberArray = data.getLeagueArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			tList.add(new LeagueTableBean( 
					i + 1,
					tempObj.get("team").toString(),
					Integer.parseInt(tempObj.get("played").toString()), 
					Integer.parseInt(tempObj.get("win").toString()), 
					Integer.parseInt(tempObj.get("draw").toString()), 
					Integer.parseInt(tempObj.get("loss").toString()), 
					Integer.parseInt(tempObj.get("goalsFor").toString()), 
					Integer.parseInt(tempObj.get("goalsAgainst").toString()), 
					Integer.parseInt(tempObj.get("points").toString())));
		}
		
	}

	public List<LeagueTableBean> getList() {
		return tList;
	}
	
	public void setList(List<LeagueTableBean> list) {
		this.tList = list;
	}
	
	
}
