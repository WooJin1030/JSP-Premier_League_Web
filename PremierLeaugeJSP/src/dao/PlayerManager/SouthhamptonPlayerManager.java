package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.SouthamptonPlayerData;
import dto.LeaugePlayerBean;

public class SouthhamptonPlayerManager{
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static SouthhamptonPlayerManager instance = new SouthhamptonPlayerManager();
	
	public static SouthhamptonPlayerManager getInstance(){
		return instance;
	}
	
	public SouthhamptonPlayerManager() {
		
		SouthamptonPlayerData data = new SouthamptonPlayerData();
		JSONArray memberArray = data.getSouthamptonPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9363,
					(String)tempObj.get("number"), 
					tempObj.get("name").toString(), 
					tempObj.get("position").toString(), 
					Integer.parseInt(tempObj.get("age").toString()), 
					Integer.parseInt(tempObj.get("goals").toString()), 
					Integer.parseInt(tempObj.get("assists").toString()))); 			
		}
	}

	public List<LeaugePlayerBean> getList() {
		return pList;
	}
	
	public void setList(List<LeaugePlayerBean> list) {
		this.pList = list;
	}
	
	
}

