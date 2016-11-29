package com.gigamog.HttpUtil.pojo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public abstract class JsonBase{

	public JsonBase(){
		
	}
	

	public JsonElement toJson(){
		Gson gson = new Gson();
		JsonElement test = gson.toJsonTree(this);
		return test;
	}
	
	public String toPrettyJsonString(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(this.toString());
		return gson.toJson(je);
	}
	
	@Override
	public String toString(){
		Gson gson = new Gson();
		JsonElement test = gson.toJsonTree(this);
		return test.toString();
	}
	
	public byte[] toJsonBytes(){
		return this.toJson().toString().getBytes();
	}
	
    protected String ifNullBlank(String input){
    	String returnValue = "";
    	if(input != null){
    		returnValue = input;
    	}
    	return returnValue;
    }


}
