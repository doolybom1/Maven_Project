package com.biz.network.exec;

import java.io.IOException;
import java.net.InetAddress;

public class NetEx_01 {
	public static void main(String[] args) throws IOException {
		
		/*
		 * Inet.getByName()
		 * www.naver.com : Domain Name 을 DNS에게 조회하여 IP Address를 가져오는 메서드
		 */
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println(naver);
		
		
		InetAddress callor = InetAddress.getByName("callor.com");
		System.out.println(callor);
		
		// ip address 만 추출하는 메서드
		System.out.println(naver.getHostAddress());
		
		// domain만 추출하는 메서드
		System.out.println(naver.getHostName());
		
		InetAddress local = InetAddress.getLocalHost();
		InetAddress loopBack = InetAddress.getLoopbackAddress();
		
		System.out.println("local" + local);
		System.out.println("loopBack" + loopBack);
		
		
	}
}
