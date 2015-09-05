package com.jurin_n.junit.restapi.test;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookResourceTest {


	@Test
	public void test() {
		//リクエスト＆レスポンス
		response = request.setResource("/hoge")
						  .setMethod("GET")
						  .setHeader("Content-Type","application/json")
						  .setHeader("Accept","application/json")
						  .setHeader("Date","xxxx")
						  .setHeader("Authorization","xxxx")
						  .setBody("/requestBody.json")
						  .getResponse();
		
		//検証
		assertThat(reponse.getHeader("Content-Type"),is("application/json"));
		assertThat(reponse.getStatusCode(),is(200));
		assertThat(reponse.getBody(),is(expectedBody("/expectedBody.json")));
	}

	
	@Test
	public void test2() {
		/* セットアップ */
		//リソース URI
		request.setResource("/hoge");
		//Httpメソッド
		request.setMethod("GET");
		//Httpヘッダ
		headers.put("Content-Type","application/json");
		headers.put("Accept","application/json");
		headers.put("Date","xxxx");
		headers.put("Authorization","xxxx");
		request.setHeaders(headers);
		//リクエストボディ
		request.setBody(getRequestBody("/requestBody.json"));
		
		/* リクエスト＆レスポンス */
		response = request.getResponse();
		
		/* 検証 */
		assertThat(reponse.getHeader("Content-Type"),is("application/json"));
		assertThat(reponse.getStatusCode(),is(200));
		assertThat(reponse.getBody(),is(expectedBody("/expectedBody.json")));
	}
}
