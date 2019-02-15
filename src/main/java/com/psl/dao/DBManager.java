package com.psl.dao;

import java.util.HashMap;
import java.util.Map;

import com.psl.model.URL;

public class DBManager {
	private Map<String, URL> map = new HashMap<String, URL>();
	
	public void saveURL(URL url, String key){
		map.put(key, url);
	}
	
	public String getURL(String key) {
		return map.get(key).getUrl();
	}
}
