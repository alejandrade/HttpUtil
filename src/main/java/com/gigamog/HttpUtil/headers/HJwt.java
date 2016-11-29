package com.gigamog.HttpUtil.headers;

import org.apache.http.message.BasicHeader;

public class HJwt extends BasicHeader {

	private String jwt = "";
	public String getJwt() {
		return jwt;
	}
	
	public HJwt(String jwt) {
		super("Authorization", "JWT " + jwt);
		this.jwt = jwt;
	}

}
