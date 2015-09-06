package com.jurin_n.junit.restapi.test;

import java.util.HashMap;

public class Response {

	private final int statusCode;
	private final HashMap<String,String> headers;
	private final String body;
	
	public Response(
			  int statusCode
			, HashMap<String, String> headers
			, String body){
		this.statusCode = statusCode;
		this.headers = (HashMap<String,String>)headers.clone();
		this.body = body;
	}

	public final String getHeader(String key) {
		return headers.get(key);
	}

	public final int getStatusCode() {
		return statusCode;
	}

	public final String getBody() {
		return body;
	}
}
