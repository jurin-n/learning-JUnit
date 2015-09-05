package com.jurin_n.junit.restapi.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicHeader;

import com.jurin_n.junit.restapi.test.Response;

public class RestApiTest {
	Response response = null;
	org.apache.http.client.fluent.Response response2 = null;
	org.apache.http.client.fluent.Response responseTmp= null;
	
	protected Map<String, String> headers = new HashMap<>();
	String body;
	String resource;
	HttpMethod method;
	
	protected String getRequestBody(String source) throws IOException{
		String bodyTmp="";
		List<String> lines = Files.readAllLines(
				 Paths.get(
					System.getProperty("user.dir") + "/testdata/" + source)
				,StandardCharsets.UTF_8);
		for(String line : lines){
			bodyTmp += line;
		}
		
		return bodyTmp;
	}
	protected String expectedBody(String string) {
		// TODO Auto-generated method stub
		return "body";
	}
	
	protected Response send() throws ClientProtocolException, IOException {
		
	   	Header[] headersTmp = new Header[headers.size()];
	   	int index=0;
	   	for(String key : headers.keySet()){
	   		headersTmp[index]= new BasicHeader(key,headers.get(key));
	   		index++;
	   	}
	   	headersTmp[0]= new BasicHeader("Content-Type","application/json");
	   	headersTmp[1]= new BasicHeader("Accept","application/json");
	   	headersTmp[2]= new BasicHeader("Date","xxxx");
	   	headersTmp[3]= new BasicHeader("Authorization","xxxx");
    	
		responseTmp = Request
		        .Get("http://www.yahoo.co.jp/")
		        .setHeaders(headersTmp)
		        //.body(entity) //Getの場合、IllegalStateException
		        .execute();
		return null;
	}
}
