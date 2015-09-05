package com.jurin_n.junit.restapi.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import static org.hamcrest.core.Is.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

public class BookResourceTest extends RestApiTest {
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
        if (response2 != null) {
        	response2.discardContent();
        }
	}
	
	//Apache Http Client Fluent APIつかった場合 
	//@Test
	public void test() throws IOException {
	   	/* セットアップ */
	   	// headers
	   	int i = 4; //何かの仕組みで配列インデックスを決める。
	   	Header[] headers = new Header[i];
    	headers[0]= new BasicHeader("Content-Type","application/json");
    	headers[1]= new BasicHeader("Accept","application/json");
    	headers[2]= new BasicHeader("Date","xxxx");
    	headers[3]= new BasicHeader("Authorization","xxxx");
	    	
    	//body
		HttpEntity entity = new StringEntity("body!",StandardCharsets.UTF_8);

		/* リクエスト送信、レスポンス取得 */
		response2 = Request
			        .Get("http://www.yahoo.co.jp/")
			        .setHeaders(headers)
			        //.body(entity) //Getの場合、IllegalStateException
			        .execute();
		/* 検証 */
		assertThat(
				response2.returnResponse().getHeaders("Content-Type")
				,is("application/json")
				);
		assertThat(
				response2.returnResponse().getStatusLine().getStatusCode()
				,is(200));
		assertThat(
				response2.returnContent().asString(StandardCharsets.UTF_8)
				,is(expectedBody("/expectedBody.json")));	
	}

	@Test
	public void testCase01() throws IOException {
	   	/* セットアップ */
	   	// resource
		resource = "/book";
		
	   	// method
		method = HttpMethod.GET;
		
	   	// headers
    	headers.put("Content-Type","application/json");
    	headers.put("Accept","application/json");
    	headers.put("Date","xxxx");
    	headers.put("Authorization","xxxx");
	    	
    	//body
    	body = getRequestBody("/case01_requestBody.json");

		/* リクエスト送信、レスポンス取得 */
    	response = send();
		
		/* 検証 */
		assertThat(
				response.getHeaders("Content-Type")
				,is("application/json")
				);
		assertThat(
				response.getStatusCode()
				,is(200));
		assertThat(
				response.body()
				,is(expectedBody("/expectedBody.json")));	
	}
}
