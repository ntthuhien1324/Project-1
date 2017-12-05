package bai1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class bai1 {

	private JFrame frame;
	private JTextField textLink;
	private JButton btnBrowse, btnUpload;
	String filename, line;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
				try {
					bai1 window = new bai1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
		});
	}

	/**
	 * Create the application.
	 */
	public bai1() {
		initialize();
		
		//nút Browse
		btnBrowse.addActionListener(e -> {
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(null);	//hiển thị Open Dialog
				File f = fc.getSelectedFile();
				filename = f.getAbsolutePath(); //lấy đường dẫn file
				textLink.setText(filename); //gán đường dẫn file vào textLink
			});
		
		//nút Upload
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<Student> listStudent = new ArrayList<Student>();
					FileInputStream fis = new FileInputStream(filename); //đọc dữ liệu theo định dạng byte
					InputStreamReader isr = new InputStreamReader(fis); //chuyển byte sang kí tự
					BufferedReader br = new BufferedReader(isr); //đọc văn bản dựa trên kí tự
					
					//bỏ dòng đầu tiên - header
					line = br.readLine();//đọc theo dòng
					String [] st;
					
					while ((line = br.readLine()) != null) {
						st = line.split(",");//cắt chuỗi
						listStudent.add(new Student(st[0], st[1], st[2], st[3]));
					}
					
					//đóng luồng dữ liệu
					br.close();
					isr.close();
					fis.close();
					
					//xuất dữ liệu
					for (Student st1 : listStudent) {
						System.out.println(st1.toString());
					}
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		frame.setBounds(100, 100, 322, 148);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(12, 17, 56, 16);
		frame.getContentPane().add(lblFile);
		
		textLink = new JTextField();
		textLink.setEnabled(false);	//không cho edit text
		textLink.setBounds(50, 14, 116, 22);
		frame.getContentPane().add(textLink);
		textLink.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(192, 13, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		btnUpload = new JButton("Upload");
		btnUpload.setBounds(50, 57, 97, 25);
		frame.getContentPane().add(btnUpload);
	}
}
