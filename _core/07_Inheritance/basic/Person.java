package basic;

public class Person {
	private int telNum;
	private String name;
	private String dept;
	private String addr;
	
	public Person() {
		System.out.println("This is Person Instance");
	}
	
	protected void printInfo() {
		System.out.println("telNum : " + telNum);
		System.out.println("name : " + name);
		System.out.println("dept : " + dept);
		System.out.println("addr : " + addr);
	}

	protected int getTelNum() {
		return telNum;
	}

	protected void setTelNum(int telNum) {
		this.telNum = telNum;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getDept() {
		return dept;
	}

	protected void setDept(String dept) {
		this.dept = dept;
	}

	protected String getAddr() {
		return addr;
	}

	protected void setAddr(String addr) {
		this.addr = addr;
	}

}
