package domain;
public class ProductVO {
	private int pno;
	private String pname;
	private double price;
	private String regdate;
	private String madeby;
	
	public ProductVO() {}

	// Register
	public ProductVO(String pname, double price, String madeby) {
		this.pname = pname;
		this.price = price;
		this.madeby = madeby;
	}

	// List
	public ProductVO(int pno, String pname, double price) {
		this.pno = pno;
		this.pname = pname;
		this.price = price;
	}
	
	// Modify
	public ProductVO(int pno, String pname, double price, String madeby) {
		this(pno, pname, price);
		this.madeby = madeby;
	}

	// Detail
	public ProductVO(int pno, String pname, double price, String regdate, String madeby) {
		this(pno, pname, price, madeby);
		this.regdate = regdate;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getMadeby() {
		return madeby;
	}

	public void setMadeby(String madeby) {
		this.madeby = madeby;
	}

}
