package server;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JFrame;

public class bai3_server extends Thread{

	private JFrame frame;
	private ServerSocket serverSocket;

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
