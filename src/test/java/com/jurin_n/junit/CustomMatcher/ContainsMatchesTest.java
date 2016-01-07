package com.jurin_n.junit.CustomMatcher;

import static org.junit.Assert.*;
import static com.jurin_n.junit.CustomMatcher.ContainsMatches.*;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class ContainsMatchesTest {

	public static class XXXの場合{
		@Test
		public void test() {
			Map<String, String> actual = new HashMap<>();
			actual.put("CALLPRGID", "test");
			actual.put("MSG_CD", "12345");
			
			Map<String, String> expected = new HashMap<>();
			expected.put("CALLPRGID", "test");
			expected.put("MSG_CD", "12345");
		
			assertThat(actual ,is(containsPrgidAndMsg(expected)));
		}
	}
	
	public static class あああの場合{
		Map<String, String> actual;
		Map<String, String> expected;
		
		@Before
		public void create(){
			actual = new HashMap<>();			
			expected = new HashMap<>();
		}
		
		@Test
		public void test() {

			actual.put("CALLPRGID", "test1");
			actual.put("MSG_CD", "12345");
			
			expected.put("CALLPRGID", "test");
			expected.put("MSG_CD", "12345");
		
			assertThat(actual ,is(containsPrgidAndMsg(expected)));
		}
	}
}
