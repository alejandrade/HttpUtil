package com.gigamog.HttpUtil.headers;

import org.apache.http.message.BasicHeader;

public class HApiKey extends BasicHeader {

	private String key = "";
	public String getKey() {
		return key;
	}
	
	
	public HApiKey(String key) {
		super("Authorization", "APIKEY " + key);
		this.key = key;
	}

}
