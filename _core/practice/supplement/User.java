package supplement;

public class User {
	private String name;
	private int age;
	private String gen;
	private int grade;
	
	public User() {}
	// 특정 목적을 위해 초기값이 필요한상태로 만든다
	public User(String name, int age, String gen, int grade) {
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
