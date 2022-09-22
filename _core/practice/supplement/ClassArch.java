package supplement;

public class ClassArch {
	String prop1; // 속성 값, 특정시점의 상태값
	int prop2;
	boolean prop3;
	double prop4;
	
	public ClassArch() {
		System.out.println("생성자 실행됬어요~");
		makeSir();
	}
	public ClassArch(String p1, int p2, boolean p3, double p4) {
		this.prop1 = p1;
		this.prop2 = p2;
		this.prop3 = p3;
		this.prop4 = p4;
	}
	
	String makeSir() { // 특정시점의 상태값을 변경
		return prop1 + "님";
	}
	void addProp2(int num) {
		System.out.println("연산결과: " + (prop2 + num));
	}
}
