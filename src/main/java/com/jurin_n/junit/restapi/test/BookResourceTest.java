package com.jurin_n.junit.restapi.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.core.Is.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

public class BookResourceTest extends RestApiTest {
	@Before
	public void setUp(){
		
	}
	
	@After
	public void tearDown(){
        if (response != null) {
            response.discardContent();
        }
	}
	
	//Apache Http Client Fluent APIつかった場合 
	@Test
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
		response = Request
			        .Get("http://www.yahoo.co.jp/")
			        .setHeaders(headers)
			        //.body(entity) //Getの場合、IllegalStateException
			        .execute();
		/* 検証 */
		assertThat(
				 response.returnResponse().getHeaders("Content-Type")
				,is("application/json")
				);
		assertThat(
				 response.returnResponse().getStatusLine().getStatusCode()
				,is(200));
		assertThat(
				 response.returnContent().asString(StandardCharsets.UTF_8)
				,is(expectedBody("/expectedBody.json")));	
	}
}
