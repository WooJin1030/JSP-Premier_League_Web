package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.BrightonPlayerData;
import dto.LeaugePlayerBean;

public class BrightonPlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static BrightonPlayerManager instance = new BrightonPlayerManager();
	
	public static BrightonPlayerManager getInstance(){
		return instance;
	}
	
	public BrightonPlayerManager() {
		
		BrightonPlayerData data = new BrightonPlayerData();
		JSONArray memberArray = data.getBrightonPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9065,
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
