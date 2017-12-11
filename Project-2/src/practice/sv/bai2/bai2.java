package practice.sv.bai2;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import practice.sv.bai1.*;

public class bai2 {

	private JFrame frame;
	private JTextField textLink;
	private JButton btnBrowse, btnInsert, btnShow;
	private String fileID;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				bai2 window = new bai2();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bai2() {
		initialize();
		btnBrowse.addActionListener(e -> {
			JFileChooser fc = new JFileChooser();
			fc.showOpenDialog(null); // hiển thị Open Dialog
			File f = fc.getSelectedFile();
			fileID = f.getAbsolutePath(); // lấy đường dẫn file
			textLink.setText(fileID); // gán đường dẫn file vào textLink
		});
		btnInsert.addActionListener(e -> {
			List<Student> listStudent = ReadFile.listStudent(fileID);
			listStudent.stream().forEach(st -> {
				Student student=new Student(st.getLastName(),st.getFirstName(),
						st.getBirthDay(),st.getEmail());
				InsertStatement.insertInfo(student);
			});
		});
		btnShow.addActionListener(e -> {
			ArrayList<Student> listSt = (ArrayList<Student>) JDBCStatement.readData();
			ReadFile.printData(listSt);
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 303, 145);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(12, 13, 56, 16);
		frame.getContentPane().add(lblFile);
		
		textLink = new JTextField();
		textLink.setEnabled(true);
		textLink.setBounds(48, 10, 116, 22);
		frame.getContentPane().add(textLink);
		textLink.setColumns(10);
		
		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(180, 9, 97, 25);
		frame.getContentPane().add(btnBrowse);
		
		btnInsert = new JButton("Insert");
		btnInsert.setBounds(28, 59, 97, 25);
		frame.getContentPane().add(btnInsert);
		
		btnShow = new JButton("Show");
		btnShow.setBounds(155, 59, 97, 25);
		frame.getContentPane().add(btnShow);
	}
}
