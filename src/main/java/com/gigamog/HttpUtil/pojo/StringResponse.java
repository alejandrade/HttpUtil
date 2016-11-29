package com.gigamog.HttpUtil.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StringResponse extends JsonBase {
	
	@Expose
	@SerializedName("string_response")
	private String response = "Response String";
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String r) {
		response = r;
	}
	
	@Override
	public String toString() {
		return response;
	}
}
