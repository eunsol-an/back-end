package classes;
class Student {
	String name = "김댕댕";
	int cls = 3;
	int num = 1;
	
	int langScore = 98;
	int enScore = 90;
	int mathScore = 89;
	
	int getTotal() {
		return (this.langScore+this.enScore+this.mathScore);
	}
	double getAvg() {
		return (double)(getTotal()/3);
	}
}

public class Quiz_04 {

	public static void main(String[] args) {
		Student me = new Student();
		System.out.println("안녕하세요 저는 1학년 " + me.cls +"반 " + me.num + "번 " + me.name + "입니다.");
		System.out.println("국어점수 : " + me.langScore);
		System.out.println("영어점수 : " + me.enScore);
		System.out.println("수학점수 : " + me.mathScore);
		System.out.println("총점 : " + me.getTotal());
		System.out.println("평균 : " + me.getAvg());

	}

}
