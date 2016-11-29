package com.gigamog.HttpUtil;

import javax.ws.rs.core.Response;

import com.gigamog.HttpUtil.pojo.JsonBase;
import com.google.gson.Gson;



public class Resp {
	
	private Response r;
	
	public Resp(Response r) {
		this.r = r;
	}
	
	public int getStatus() {
		return r.getStatus();
	}
	public String getBody() {
		return (String)r.getEntity();
	}
	
	
	public Response getResponseObject() {
		return r;
	}
	
	
	public JsonBase getBodyJson(Class<? extends JsonBase> cls) {
		JsonBase obj;
		Gson gson = new Gson();
		obj = gson.fromJson(getBody(), cls);
		return obj;
	}
	
}
