package com.gigamog.HttpUtil.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponse extends JsonBase{

	@Expose
	@SerializedName("code")
	private Integer status;
	
	@Expose
	@SerializedName("message")
	private String detail;
	
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
