package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {
	private static SqlSessionFactory sqlSessionFactory;
	
	static {
		
		String saltPass = System.getenv().get("BIZ");
		String configFile = "com/biz/sec/config/mybatis-cofing.xml";
		InputStream is = null;
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String userName = "ToXXyJ0kpRDo1Hzhlgp5Rw==";
		String password = "glEcG0oOGlGAM+euGXLpBA==";
		// java에서 어떤 setting 값듫을 모아서 어떤 설정을 하는 용도로 사용한다.
		// setting 값들을 쉽게 관리할 수 있도록 도와주는 class
		Properties pros = new Properties();
		
		/*
		 * DBMS에 접근할 username과 password를 실제 값으로 적용하고 프로젝트 실행할 것
		 */
		pros.put("username", pbEnc.decrypt(userName));
		pros.put("password", pbEnc.decrypt(password));
		
		
		try {
			is = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = builder.build(is,pros);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
