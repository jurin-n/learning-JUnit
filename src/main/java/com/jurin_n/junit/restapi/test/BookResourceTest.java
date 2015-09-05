package com.jurin_n.junit.restapi.test;

import java.io.IOException;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class BookResourceTest extends RestApiTest {
	@Test
	public void testCase01() throws IOException {
	   	/* セットアップ */
	   	// resource
		resource = "/expose";
		
	   	// method
		method = HttpMethod.GET;
		
	   	// headers
    	headers.put("Content-Type","*");
    	headers.put("Accept","*");
    	headers.put("Date","xxxx");
    	headers.put("Authorization","xxxx");
	    	
    	//body
    	body = getResourceFile("/case01_requestBody.json");

		/* リクエスト送信、レスポンス取得 */
    	response = send();
		
		/* 検証 */
    	assertThat(
				response.getHeader("Content-Type")
				,is("application/json")
				);
		assertThat(
				response.getStatusCode()
				,is(200));
		assertThat(
				response.getBody()
				,is(getResourceFile("/case01_expectedBody.json")));	
	}
}
