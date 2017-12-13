package client;

import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import practice.sv.bai1.ReadFile;

import javax.swing.JButton;
import javax.swing.JFileChooser;



public class bai3_client {

	private JFrame frame;
	private JTextField textLink;
	private JButton btnBrowse, btnSentRequest;
	private String filePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai3_client window = new bai3_client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bai3_client() {
		initialize();
		//nút Browse
		btnBrowse.addActionListener(e -> {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null);	//hiển thị Open Dialog
			File f = fc.getSelectedFile();
			filePath = f.getAbsolutePath(); //lấy đường dẫn file
			textLink.setText(filePath); //gán đường dẫn file vào textLink
		});
		
		//nút Sent Request
		btnSentRequest.addActionListener(e -> {
			String host = "localhost";
			int port = 6066;
			Socket client = new ConnectServer().connectServer(host, port);
			List listst =ReadFile.listStudent(filePath);
			try {
				ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
				output.writeObject(listst);
				System.out.println("Sent!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 321, 156);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(12, 28, 56, 16);
		frame.getContentPane().add(lblFile);
		
		textLink = new JTextField();
		textLink.setBounds(67, 25, 116, 22);
		frame.getContentPane().add(textLink);
		textLink.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(202, 24, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		btnSentRequest = new JButton("Sent Request");
		btnSentRequest.setBounds(67, 70, 116, 25);
		frame.getContentPane().add(btnSentRequest);
	}
}
