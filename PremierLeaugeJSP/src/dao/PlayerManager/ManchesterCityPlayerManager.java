package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.ManchesterCityPlayerData;
import dto.LeaugePlayerBean;

public class ManchesterCityPlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static ManchesterCityPlayerManager instance = new ManchesterCityPlayerManager();
	
	public static ManchesterCityPlayerManager getInstance(){
		return instance;
	}
	
	public ManchesterCityPlayerManager() {
		
		ManchesterCityPlayerData data = new ManchesterCityPlayerData();
		JSONArray memberArray = data.getManchesterCityPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9259,
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
