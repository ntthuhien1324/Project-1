package server;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.JFrame;

import practice.sv.bai1.ReadFile;

public class bai3_server extends Thread{

	private JFrame frame;
	private ServerSocket serverSocket;
	private Socket server;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				bai3_server window = new bai3_server();
				window.frame.setVisible(true);
				
				int port = 6066;
				Thread t = new bai3_server(port);
				t.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	public bai3_server(int port) throws IOException {
		serverSocket = new ServerSocket(port);
		//Thiết lập giá trị timeout cho Server Socket đợi một Client
		serverSocket.setSoTimeout(100000); 		
	}
	
	public void run () {
		while (true) {
			try {
				System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
				server = serverSocket.accept();
				System.out.println("Just connected to " + server.getRemoteSocketAddress());
				
				ObjectInputStream input = new ObjectInputStream(server.getInputStream());
				List listSt = (List) input.readObject();
				System.out.println("Receive!");
				ReadFile.printData(listSt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Create the application.
	 */
	public bai3_server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
