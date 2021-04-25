package dao;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.PlayerData.ArsenalPlayerData;
import dao.PlayerData.AstonVillaPlayerData;
import dao.PlayerData.BrightonPlayerData;
import dao.PlayerData.BurnleyPlayerData;
import dao.PlayerData.ChelseaPlayerData;
import dao.PlayerData.CrystalPalacePlayerData;
import dao.PlayerData.EvertonPlayerData;
import dao.PlayerData.FullhamPlayerData;
import dao.PlayerData.LeedsPlayerData;
import dao.PlayerData.LeicesterPlayerData;
import dao.PlayerData.LiverpoolPlayerData;
import dao.PlayerData.ManchesterCityPlayerData;
import dao.PlayerData.ManchesterUnitedPlayerData;
import dao.PlayerData.NewcastlePlayerData;
import dao.PlayerData.SheffieldPlayerData;
import dao.PlayerData.SouthamptonPlayerData;
import dao.PlayerData.TottenhamPlayerData;
import dao.PlayerData.WestBromwichPlayerData;
import dao.PlayerData.WestHamPlayerData;
import dao.PlayerData.WolverhamptonPlayerData;
import dto.LeaugePlayerBean;

public class LeaguePlayerManager {
	
	private List<LeaugePlayerBean> pList = new ArrayList<LeaugePlayerBean>();
	
	private static LeaguePlayerManager instance = new LeaguePlayerManager();
	
	public static LeaguePlayerManager getInstance(){
		return instance;
	}
	
	public LeaguePlayerManager() {
		
//		ManchesterCityPlayerData data1 = new ManchesterCityPlayerData();
//		JSONArray memberArray1 = data1.getManchesterCityPlayerArray();
//		
//		for(int i = 0 ; i < memberArray1.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray1.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number").toString())) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9259,
//					number,
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
		
//		ManchesterUnitedPlayerData data2 = new ManchesterUnitedPlayerData();
//		JSONArray memberArray2 = data2.getManchesterUnitedPlayerArray();
//		
//		for(int i = 0 ; i < memberArray2.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray2.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9260,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		LeicesterPlayerData data3 = new LeicesterPlayerData();
//		JSONArray memberArray3 = data3.getLeicesterPlayerArray();
//		
//		for(int i = 0 ; i < memberArray3.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray3.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9240,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		WestHamPlayerData data4 = new WestHamPlayerData();
//		JSONArray memberArray4 = data4.getWestHamPlayerArray();
//		
//		for(int i = 0 ; i < memberArray4.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray4.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9427,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		ChelseaPlayerData data5 = new ChelseaPlayerData();
//		JSONArray memberArray5 = data5.getChelseaPlayerArray();
//		
//		
//		for(int i = 0 ; i < memberArray5.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray5.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9092,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		LiverpoolPlayerData data6 = new LiverpoolPlayerData();
//		JSONArray memberArray6 = data6.getLiverpoolPlayerArray();
//		
//		for(int i = 0 ; i < memberArray6.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray6.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9249,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		TottenhamPlayerData data7 = new TottenhamPlayerData();
//		JSONArray memberArray7 = data7.getTottenhamPlayerArray();
//		
//		for(int i = 0 ; i < memberArray7.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray7.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9406,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		EvertonPlayerData data8 = new EvertonPlayerData();
//		JSONArray memberArray8 = data8.getEvertonPlayerArray();
//		
//		for(int i = 0 ; i < memberArray8.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray8.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9158,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		LeedsPlayerData data9 = new LeedsPlayerData();
//		JSONArray memberArray9 = data9.getLeedsPlayerArray();
//		
//		for(int i = 0 ; i < memberArray9.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray9.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9238,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
		ArsenalPlayerData data10 = new ArsenalPlayerData();
		JSONArray memberArray10 = data10.getArsenalPlayerArray();
		
		for(int i = 0 ; i < memberArray10.size(); i++) {
			JSONObject tempObj = (JSONObject) memberArray10.get(i);
			
			int number = 0;
			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
			pList.add(new LeaugePlayerBean( 
					null,
					9002,
					number, 
					tempObj.get("name").toString(), 
					tempObj.get("position").toString(), 
					Integer.parseInt(tempObj.get("age").toString()), 
					Integer.parseInt(tempObj.get("goals").toString()), 
					Integer.parseInt(tempObj.get("assists").toString()))); 			
		}
//		
//		AstonVillaPlayerData data11 = new AstonVillaPlayerData();
//		JSONArray memberArray11 = data11.getAstonVillaPlayerArray();
//		
//		for(int i = 0 ; i < memberArray11.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray11.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9008,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		WolverhamptonPlayerData data12 = new WolverhamptonPlayerData();
//		JSONArray memberArray12 = data12.getWolverhamptonPlayerArray();
//		
//		for(int i = 0 ; i < memberArray12.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray12.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9446,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		CrystalPalacePlayerData data13 = new CrystalPalacePlayerData();
//		JSONArray memberArray13 = data13.getCrystalPalacePlayerArray();
//		
//		for(int i = 0 ; i < memberArray13.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray13.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9127,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		SouthamptonPlayerData data14 = new SouthamptonPlayerData();
//		JSONArray memberArray14 = data14.getSouthamptonPlayerArray();
//		
//		for(int i = 0 ; i < memberArray14.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray14.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9363,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		NewcastlePlayerData data15 = new NewcastlePlayerData();
//		JSONArray memberArray15 = data15.getNewcastlePlayerArray();
//		
//		for(int i = 0 ; i < memberArray15.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray15.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9287,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		BrightonPlayerData data16 = new BrightonPlayerData();
//		JSONArray memberArray16 = data16.getBrightonPlayerArray();
//		
//		for(int i = 0 ; i < memberArray16.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray16.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9065,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		FullhamPlayerData data17 = new FullhamPlayerData();
//		JSONArray memberArray17 = data17.getFullhamPlayerArray();
//		
//		for(int i = 0 ; i < memberArray17.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray17.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9175,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		BurnleyPlayerData data18 = new BurnleyPlayerData();
//		JSONArray memberArray18 = data18.getBurnleyPlayerArray();
//		
//		for(int i = 0 ; i < memberArray18.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray18.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9072,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		WestBromwichPlayerData data19 = new WestBromwichPlayerData();
//		JSONArray memberArray19 = data19.getWestBromwichPlayerArray();
//		
//		for(int i = 0 ; i < memberArray19.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray19.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9476,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
//		SheffieldPlayerData data20 = new SheffieldPlayerData();
//		JSONArray memberArray20 = data20.getSheffieldPlayerArray();
//		
//		for(int i = 0 ; i < memberArray20.size(); i++) {
//			JSONObject tempObj = (JSONObject) memberArray20.get(i);
//			
//			int number = 0;
//			
//			if(!"null".equals(tempObj.get("number"))) {
//				number =  Integer.parseInt(tempObj.get("number").toString());
//			} 
//			
//			pList.add(new LeaugePlayerBean( 
//					null,
//					9348,
//					number, 
//					tempObj.get("name").toString(), 
//					tempObj.get("position").toString(), 
//					Integer.parseInt(tempObj.get("age").toString()), 
//					Integer.parseInt(tempObj.get("goals").toString()), 
//					Integer.parseInt(tempObj.get("assists").toString()))); 			
//		}
//		
		
	}

	public List<LeaugePlayerBean> getList() {
		return pList;
	}
	
	public void setList(List<LeaugePlayerBean> list) {
		this.pList = list;
	}
	
	
}
