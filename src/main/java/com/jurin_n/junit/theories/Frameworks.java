package com.jurin_n.junit.theories;

public class Frameworks {
	public static boolean isSupport(
			  ApplicationServer appServer
			, Database db
			){
		switch(appServer){
		case GlassFish:
			return true;
		case Tomcat:
			return db == Database.MySQL || db == Database.Derby;
		case JBoss:
			return db == Database.DB2 || db == Database.PostgreSQL || db == Database.Derby;
		default:
			return false;
		}
	}
}
