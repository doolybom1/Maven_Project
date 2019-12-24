package com.biz.sec.exec;

import com.biz.sec.config.DBConnectionSEC;

public class IolistEx_01 {
	public static void main(String[] args) {
		
		DBConnectionSEC.getSqlSessionFactory().openSession(true);
		System.out.println("Test OK!!!");
	}
}
