package com.jurin_n.junit.theories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class ParaeterizedTest {
	@DataPoint
	public static int INT_PARAM_1 = 3;
	@DataPoint
	public static int INT_PARAM_2 = 4;

	public ParaeterizedTest(){
		System.out.println(this.getClass().getSimpleName() + "初期化");
	}
	
	@Theory
	public void test(int param,int param2) {
		System.out.println("param = " + param + ",param2 = " + param2);
	}
}
