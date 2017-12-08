package practice.sv.bai1;

import java.awt.EventQueue;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		btnUpload.addActionListener(e ->{
			List listst =ReadFile.listStudent(filename);
			ReadFile.printData(listst);
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
