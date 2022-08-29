package basic;

public class Staff extends Person {
	private String job;
	
	public Staff() {
		System.out.println("This is Staff Instance");
	}
	public void printJob() {
		System.out.println(super.getName() + " 직원의 업무는 " + job);
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	
}
