package basic;

public class Professor extends Person {
	private String[] subjects;
	
	public Professor() {
		System.out.println("This is Professor Instance");
	}
	
	public void printSubjects() {
		System.out.println(super.getName() + " 교수의 강의과목 리스트");
		for (String sub : subjects) {
			System.out.println("강의과목 : " + sub);
		}
	}

	public String[] getSubjects() {
		return subjects;
	}

	public void setSubjects(String[] subjects) {
		this.subjects = subjects;
	}
	
}
