package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.ManchesterUnitedPlayerData;
import dto.LeaugePlayerBean;

public class ManchesterUnitedPlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static ManchesterUnitedPlayerManager instance = new ManchesterUnitedPlayerManager();
	
	public static ManchesterUnitedPlayerManager getInstance(){
		return instance;
	}
	
	public ManchesterUnitedPlayerManager() {
		
		ManchesterUnitedPlayerData data = new ManchesterUnitedPlayerData();
		JSONArray memberArray = data.getManchesterUnitedPlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9260,
					(String)tempObj.get("number"), 
					tempObj.get("name").toString(), 
					tempObj.get("position").toString(), 
					(String)tempObj.get("age"),
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
