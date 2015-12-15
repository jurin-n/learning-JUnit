package com.jurin_n.refactoring;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class FileReaderTest {

	private FileReader sut;
	
	@Before
	public void setUp(){
		try {
			String name = this.getClass().getPackage().getName();
			String packageName = name.replace('.', '/');
			sut = new FileReader(
					"./src/test/resources/" + packageName + "/FileReaderTest_data.txt");
		} catch (FileNotFoundException e) {
			throw new RuntimeException("テストファイルがopenできないorz");
		}
	}
	
	@Test
	public void test() {
		try {
			assertThat("文字aを取得できる",(char)sut.read() ,is('a'));
			assertThat("ファイルの最後は-1!",sut.read() ,is(-1));
		} catch (IOException e) {
			fail();
		}
	}
	
	@After
	public void tearDown(){
		try {
			sut.close();
		} catch (IOException e) {
			throw new RuntimeException("テストファイルがcloseできないorz");
		}
	}
}
