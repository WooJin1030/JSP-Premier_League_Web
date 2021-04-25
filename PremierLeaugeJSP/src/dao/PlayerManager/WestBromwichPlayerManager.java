package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.WestBromwichPlayerData;
import dto.LeaugePlayerBean;

public class WestBromwichPlayerManager{
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static WestBromwichPlayerManager instance = new WestBromwichPlayerManager();
	
	public static WestBromwichPlayerManager getInstance(){
		return instance;
	}
	
	public WestBromwichPlayerManager() {
		
		WestBromwichPlayerData data = new WestBromwichPlayerData();
		JSONArray memberArray = data.getWestBromwichPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9426,
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

