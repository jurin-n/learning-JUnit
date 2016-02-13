package com.jurin_n.junit.theories;

import static org.junit.Assert.*;
import static org.junit.Assume.*;
import static org.hamcrest.CoreMatchers.is;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class FrameworksTest {
	
	@RunWith(Theories.class)
	public static class DataPointsを使ったやり方{	
		//TODO @TheoryのためassumeTrue or assumeFalseに関係なく実行されてしまうので対策がしたい。
		//@Rule
		public TestWatcher testWatcher = new TestWatcher(){
			@Override
			protected void starting(Description description){
				Logger.getAnonymousLogger().info(
						description.getMethodName() + " start");
			}
			
			@Override
			protected void finished(Description description){
				Logger.getAnonymousLogger().info(
						description.getMethodName() + " finished");
			}
		};
		
		@DataPoints
		public static ApplicationServer[] APP_SERVER_PARAMS
							= ApplicationServer.values();
		
		@DataPoints
		public static Database[] DATABASE_PARAMS = Database.values();
		static Map<String, Boolean> SUPPORTS = new HashMap<>();
		
		@BeforeClass
		public static void setUpClass() throws IOException{
			Path path = Paths.get(
					"src/test/resources/com/jurin_n/junit/theories/support.txt"
					);
			List<String> lines 
				= Files.readAllLines(path, Charset.forName("UTF-8")); //Shift-JISの場合は、MS932 指定？
			for(String line:lines){
				//TODO line.splitをWindowsとMacどちらでも動くようにする。現在はMac (Unix系OS)のみ。
				String[] params = line.split("\t");
				SUPPORTS.put(params[0] + "-" + params[1], Boolean.valueOf(params[2]));
			}
		}
		
		@Theory
		public void isSupportはtrueを返す(
				ApplicationServer appServer, Database db
				) {
			assumeTrue(isSupport(appServer,db));
			String desc = ", AppServer:" + appServer + ", DB:" + db;
			System.out.println(desc);
			assertThat(desc, Frameworks.isSupport(appServer, db), is(true));
		}
		
		@Theory
		public void isSupportはfalseを返す(
				ApplicationServer appServer, Database db
				) {
			assumeTrue(!isSupport(appServer,db));
			String desc = ", AppServer:" + appServer + ", DB:" + db;
	
			System.out.println(desc);
			assertThat(desc, Frameworks.isSupport(appServer, db), is(false));
		}
		
		private boolean isSupport(ApplicationServer appServer, Database db){
			return SUPPORTS.get(appServer.toString() + "-" + db.toString());
		}
	}

	@RunWith(Theories.class)
	public static class DataPointsとFixtureを組み合わせて使ったやり方{
		@Rule
		public TestWatcher testWatcher = new TestWatcher(){
			@Override
			protected void starting(Description description){
				Logger.getAnonymousLogger().info(
						description.getMethodName() + " start");
			}
			
			@Override
			protected void finished(Description description){
				Logger.getAnonymousLogger().info(
						description.getMethodName() + " finished");
			}
		};
		
		@DataPoints
		public static Fixture2[] FIXTURES;
		
		@BeforeClass
		public static void setUpFixture2() throws IOException{
			Path path = Paths.get(
					"src/test/resources/com/jurin_n/junit/theories/support.txt"
					);
			List<String> lines 
				= Files.readAllLines(path, Charset.forName("UTF-8")); //Shift-JISの場合は、MS932 指定？
			FIXTURES = new Fixture2[lines.size()];
			int index = 0;
			for(String line:lines){
				//TODO line.splitをWindowsとMacどちらでも動くようにする。現在はMac (Unix系OS)のみ。
				String[] params = line.split("\t");
				FIXTURES[index] = new Fixture2(
						 ApplicationServer.valueOf(params[0])
						,Database.valueOf(params[1])
						,Boolean.valueOf(params[2]));
				index++;
			}
		}
		
		/*
			doingSomeOperationGeneratesSomeResult
			(なんらかの処理を行うとなんらかの結果が発生する)
	
			someResultOccursUnderSomeCondition
			(なんらかの条件下ではなんらかの結果が発生する)
		*/
		@Theory
		public void アプリケーションサーバとデータベースを渡すとサポート可否を返す(Fixture2 p) {
			String desc = ", p.AppServer:" + p.appServer + ", p.DB:" + p.db;
			System.out.println("[testing・・・]" + desc);
			assertThat(desc, Frameworks.isSupport(p.appServer, p.db), is(p.expected));
		}
	}
}

//TODO 同一パッケージ内のべつのテストでFixtureクラスを定義してるのでFixture2にした。Fixtureの作り方工夫できないか検討。
class Fixture2{
	final ApplicationServer appServer;
	final Database db;
	final boolean expected;
	Fixture2(ApplicationServer appServer,Database db,boolean expected){
		this.appServer = appServer;
		this.db = db;
		this.expected = expected;
	}
}
