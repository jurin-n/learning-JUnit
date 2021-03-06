package com.jurin_n.junit.restapi.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jurin_n.junit.restapi.test.Response;

public class RestApiTest {
	Response response = null;
	org.apache.http.client.fluent.Response responseTmp= null;
	final String baseUri;
	String resource;
	HttpMethod method;

	protected Map<String, String> headers = new HashMap<>();
	String body;
	ObjectMapper mapper = new ObjectMapper();

	protected RestApiTest(){
		super();
		Reader fr;
		try {
			fr = new FileReader(
				  System.getProperty("user.dir")
				+ "/src/main/resources/rest_api_test.properties"
					);
			Properties p = new Properties();
			p.load(fr);
			baseUri = p.getProperty("baseUri");

		} catch (IOException e) {
			throw new IllegalStateException(
					"rest_api_test.propertiesが読み込めません。");
		}
	}

	protected String getResourceFile(String source) throws IOException{
		String bodyTmp = "";
		List<String> lines = Files.readAllLines(
				 Paths.get(
				  System.getProperty("user.dir") + "/testdata/" + source)
				, StandardCharsets.UTF_8);
		for (String line : lines) {
			bodyTmp += line;
		}

		//bodyTmpには整形したJSONが入る可能性がある。
		//assertするため改行やスペースなど除去。
		JsonNode jn = mapper.readTree(bodyTmp);
		return mapper.writeValueAsString(jn);
	}

	protected final Response send() 
			throws ClientProtocolException, IOException {
		String uri = baseUri + resource;

	   	Header[] headersTmp = new Header[headers.size()];
	   	int index = 0;
	   	for (String key : headers.keySet()) {
	   		headersTmp[index] = new BasicHeader(key ,headers.get(key));
	   		index++;
	   	}
		switch (method) {
			case GET:
			   	responseTmp = Request
			   			.Get(uri)
			   			.setHeaders(headersTmp)
			   			.execute();
				break;
			case POST:
			   	responseTmp = Request
			   			.Post(uri)
			   			.setHeaders(headersTmp)
			   			.body(
			   				new StringEntity(
			   					  body
			   					, StandardCharsets.UTF_8)
					   	)
			   			.execute();
				break;
			case PUT:
			   	responseTmp = Request
			   			.Put(uri)
			   			.setHeaders(headersTmp)
			   			.body(
					   		new StringEntity(
						   		  body
						   		, StandardCharsets.UTF_8)
					   			)
			   			.execute();
				break;
			case DELETE:
			   	responseTmp = Request
			   			.Delete(uri)
			   			.setHeaders(headersTmp)
			   			.execute();
				break;
		}

		HttpResponse httpResponse = responseTmp.returnResponse();
        if (responseTmp != null) {
        	responseTmp.discardContent();
        }

		int statusCode = httpResponse.getStatusLine().getStatusCode();
		String responseBody
			= EntityUtils.toString(
					  httpResponse.getEntity()
					, StandardCharsets.UTF_8);
		Header[] responseHeadersTmp = httpResponse.getAllHeaders();
		HashMap<String, String> responseHeaders = new HashMap<>();
		for (int i = 0; i < responseHeadersTmp.length; i++) {
			responseHeaders.put(
					  responseHeadersTmp[i].getName()
					, responseHeadersTmp[i].getValue());
		}
		return new Response(
				  statusCode
				, responseHeaders
				, responseBody
				);
	}
}
