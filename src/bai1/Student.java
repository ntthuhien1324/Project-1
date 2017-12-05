package bai1;

public class Student {
	String ho, ten, ngaysinh, email;

	public Student(String ho, String ten, String ngaysinh, String email) {
		super();
		this.ho = ho;
		this.ten = ten;
		this.ngaysinh = ngaysinh;
		this.email = email;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//@Override
	public String toString() {
		return "Student [ho=" + ho + ", ten=" + ten + ", ngaysinh=" + ngaysinh + ", email=" + email + "]";
	}
}
