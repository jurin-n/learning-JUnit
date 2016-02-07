package com.jurin_n.junit.testdouble;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.is;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NetworkResourcesTest {
	private NetworkResources sut;

	@Before
	public void createNetworkResources(){
		sut = new NetworkResources();
	}
	
	@Test
	public void loadでネットワークから取得した文字列を返す() throws IOException {
		String expected = "Hello World";
		ByteArrayInputStream input 
				= new ByteArrayInputStream(expected.getBytes());
		NetworkLoader mockNetworkLoader = mock(NetworkLoader.class);
		when(mockNetworkLoader.getInput()).thenReturn(input);
		sut.loader = mockNetworkLoader;
		
		String actual = sut.load();
		
		assertThat(actual, is(expected));
	}

}
