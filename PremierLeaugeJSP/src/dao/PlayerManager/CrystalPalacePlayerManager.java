package dao.PlayerManager;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.CrystalPalacePlayerData;
import dto.LeaugePlayerBean;

public class CrystalPalacePlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static CrystalPalacePlayerManager instance = new CrystalPalacePlayerManager();
	
	public static CrystalPalacePlayerManager getInstance(){
		return instance;
	}
	
	public CrystalPalacePlayerManager() {
		
		CrystalPalacePlayerData data = new CrystalPalacePlayerData();
		JSONArray memberArray = data.getCrystalPalacePlayerArray();
		
		for(int i = 0 ; i < memberArray.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray.get(i);
			
			pList.add(new LeaugePlayerBean( 
					null,
					9127,
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
