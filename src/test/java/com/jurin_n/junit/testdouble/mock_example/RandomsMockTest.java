package com.jurin_n.junit.testdouble.mock_example;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Test;

import com.jurin_n.junit.testdouble.stub_example.RandomNumberGenerator;
import com.jurin_n.junit.testdouble.stub_example.Randoms;

public class RandomsMockTest {

	@Test
	public void testAを返す() {
		List<String> options = new ArrayList<String>();
		options.add("A");
		options.add("B");
		Randoms sut = new Randoms();
		
		//モック設定
		final AtomicBoolean isCallNextIntMethod = new AtomicBoolean();
		sut.generator = new RandomNumberGenerator(){
			@Override
			public int nextInt(){
				isCallNextIntMethod.set(true);
				return 0;
			}
		};
		assertThat(sut.choice(options),is("A"));
		assertThat(isCallNextIntMethod.get(),is(true));
	}

}
