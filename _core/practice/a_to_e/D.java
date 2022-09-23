package a_to_e;

public class D {
	private E e = new E();
	private int x;
	
	public D() {
		x = e.getX();
		System.out.println("D를 거쳤습니다");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	

}
