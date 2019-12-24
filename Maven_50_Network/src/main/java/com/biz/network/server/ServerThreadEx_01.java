package com.biz.network.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import com.biz.network.ServerThreadV1;

public class ServerThreadEx_01 {
	public static void main(String[] args) throws IOException {
		
		ServerSocket server = new ServerSocket();
		InetSocketAddress iSocket = new InetSocketAddress(8085);
		server.bind(iSocket);
		
		ServerThreadV1 tServer = new ServerThreadV1(server);
		Thread tRun = new Thread(tServer);
		tRun.start();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Server>>");
			String strSend = scanner.nextLine();
			System.out.println("Server:" +  strSend);
		}

	}
}
