package com.biz.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.biz.network.server.ServerSubThreadV1;

public class ServerThreadV2 implements Runnable {

	ServerSocket server = null;

	public ServerThreadV2(ServerSocket server) {
	}

	public void run() {
		Socket client = null;
		
		try {
			while (true) {
				int id = (int) Math.random() * 100;
				client = this.server.accept();
				
				ServerSubThreadV1 ss = new ServerSubThreadV1(client, id);
				Thread tRun = new Thread(ss);
				tRun.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
