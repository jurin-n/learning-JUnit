package com.jurin_n.junit.testdouble.stub_example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.core.Is.is;

public class RandomsTest {

	@Test
	public void testAを返す() {
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		Randoms sut = new Randoms();
		
		//スタブ設定
		sut.generator = new RandomNumberGenerator(){
			@Override
			public int nextInt(){
				return 0;
			}
		};
		assertThat(sut.choice(options),is("A"));
	}

	@Test
	public void testBを返す() {
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		Randoms sut = new Randoms();
		
		//スタブ設定
		sut.generator = new RandomNumberGenerator(){
			@Override
			public int nextInt(){
				return 1;
			}
		};
		assertThat(sut.choice(options),is("B"));
	}
}
