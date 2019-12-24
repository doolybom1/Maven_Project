package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) throws IOException {
		URL naver= new URL(naverURL);

		URLConnection naverOpen = naver.openConnection();
		naverOpen.connect();
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		
		String reader = "";
		while(true) {
			reader = buffer.readLine();
			if(reader == null) break;
			System.out.println(reader);
		}
		buffer.close();
	}		
}
