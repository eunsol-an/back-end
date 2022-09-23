package a_to_e;

public class C {
	private D d = new D();
	private int x;
	
	public C() {
		x = d.getX();
		System.out.println("C를 거쳤습니다");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
}
