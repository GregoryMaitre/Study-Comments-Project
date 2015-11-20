package Controller;


import com.google.gson.Gson;

import Model.Data;

public class JSONManager {
	
	private static JSONManager instance = null;
	private Gson gson;
	private JSONManager() {
		gson = new Gson();
	}
	
	public static JSONManager getInstance() {
		if (instance == null) {
			instance = new JSONManager();
		}
		
		return instance;
	}
	
	public String toJson(Data data) {
		return gson.toJson(data);
	}
	
	public Data toData(String json) {
		return gson.fromJson(json, Data.class);
	}
}
