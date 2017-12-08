package practice.sv.bai1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {
	public static List<Student> listStudent (String filename) {
		ArrayList<Student> listSt = new ArrayList<Student>();
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			
			fis = new FileInputStream(filename); //đọc dữ liệu theo định dạng byte
			isr = new InputStreamReader(fis); //chuyển byte sang kí tự
			br = new BufferedReader(isr); //đọc văn bản dựa trên kí tự
			
			//bỏ dòng đầu tiên - header
			String line = br.readLine();//đọc theo dòng
			String [] st;
			
			while ((line = br.readLine()) != null) {
				st = line.split(",");//cắt chuỗi
				listSt.add(new Student(st[0], st[1], st[2], st[3]));
			}	
			
			//xuất dữ liệu
//			Comparator<Student> comparator = (o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
//			listSt.sort(comparator);
//			listSt.forEach(st1 -> System.out.println(st1.toString()));
			return listSt;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				//đóng luồng dữ liệu
				br.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return listSt = null;
	}
	
	public static void printData (List listSt){
		//xuất dữ liệu
		Comparator<Student> comparator = (o1, o2) -> o1.getFirstName().compareToIgnoreCase(o2.getFirstName());
		listSt.sort(comparator);
		listSt.forEach(st1 -> System.out.println(st1.toString()));
	}
}

