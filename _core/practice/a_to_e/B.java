package a_to_e;

public class B {
	private C c = new C();
	private int x;
	
	public B() {
		x = c.getX();
		System.out.println("B를 거쳤습니다");
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}
