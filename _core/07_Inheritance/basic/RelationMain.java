package basic;

public class RelationMain {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println("-------------------------------");
		Student std = new Student();
		std.setTelNum(1234556);
		std.setName("eunsol");
		std.setDept("IT");
		std.setAddr("Incheon");
		std.setSubjects(new String[] {"HTML", "CSS", "JS", "JAVA"});
		
		std.printInfo();
		std.printSubjects();
		System.out.println("-------------------------------");
		
		Professor pf = new Professor();
		pf.setTelNum(232323);
		pf.setName("김교수");
		
		Staff staff = new Staff();
		staff.setTelNum(0);
		staff.setName("박스탭");
		
		Person newbee = new Student();
	}

}
