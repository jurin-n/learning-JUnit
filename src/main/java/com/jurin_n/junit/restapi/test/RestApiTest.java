package com.jurin_n.junit.restapi.test;

import java.util.HashMap;

public class RestApiTest {
	protected HashMap<String,String> headers;
	protected HttpRequest request;
	protected HttpResponse response;
	protected String getRequestBody(String source){
		return "body";
	}
	protected String expectedBody(String string) {
		// TODO Auto-generated method stub
		return "body";
	}
}
