package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.BurnleyPlayerData;
import dto.LeaugePlayerBean;

public class BurnleyPlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static BurnleyPlayerManager instance = new BurnleyPlayerManager();
	
	public static BurnleyPlayerManager getInstance(){
		return instance;
	}
	
	public BurnleyPlayerManager() {
		
		BurnleyPlayerData data = new BurnleyPlayerData();
		JSONArray memberArray = data.getBurnleyPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9072,
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
