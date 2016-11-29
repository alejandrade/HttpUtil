package com.gigamog.HttpUtil.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SimpleResponse extends JsonBase{
	
	@Expose
	@SerializedName("response_message")
	private String responseMessage;
	
	@Expose
	@SerializedName("error")
	private ErrorResponse error;
	

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
