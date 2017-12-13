package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectServer {
	public Socket connectServer(String host, int port) {
		Socket client = null;
		try {
			System.out.println("Connecting to " + host + " on port " + port);
			client = new Socket(host, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress()); //Trả về địa chỉ của Socket từ xa
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
}
