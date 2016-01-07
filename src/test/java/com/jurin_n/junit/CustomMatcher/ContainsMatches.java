package com.jurin_n.junit.CustomMatcher;

import java.util.Map;

import org.hamcrest.*;
import org.junit.internal.matchers.TypeSafeMatcher;

public class ContainsMatches extends TypeSafeMatcher<Map<String, String>> {
	private Map<String, String> expected;
	
	public ContainsMatches(Map<String, String> expected){
		this.expected = expected;
	}
	
	@Override
	public void describeTo(Description desc) {
		desc.appendText("<"+ expected.toString() +">");
	}

	@Override
	public boolean matchesSafely(Map<String, String> actual) {
		boolean b1 = actual.get("CALLPRGID").equals(expected.get("CALLPRGID"));
		boolean b2 = actual.get("MSG_CD").equals(expected.get("MSG_CD"));
		return b1 && b2;
	}
	
	@Factory
	public static <T> Matcher<Map<String, String>> containsPrgidAndMsg(Map<String, String> map){
		return new ContainsMatches(map);
	}
}
