package overloading;

public class CalculateArea {

	public static void main(String[] args) {
		// 메서드의 오버로딩 규칙
		// 1. 메서드이 파라미터 형태가 달라야 한다
		// - 파라미터의 타입과 순서가 달라야 함
		// 2. 메서드의 리턴 타입은 오버로딩에 영향을 주지 않는다
		// 즉, 메서드의 이름이 같아도 파라미터의 형태가 다르면
		// 다른 메서드로 인식하여 매핑된다
		int width = 100;
		double height = 40;
		// 1. 삼각형의 면적을 구하는 area 메서드를 만들어보세요
		
		int w = 50;
		int h = 40;
		// 2. 사각형의 면적을 구하는 area 메서드를 만들어보세요
		
//		double r = 2.5;
		int r = 3;
		final double PI = 3.141592;
		// 3. 원의 면적을 구하는 area 메서드를 만들어보세요
		
		System.out.println(area(width, height));
		System.out.println(area(w, h));
//		System.out.println(area(r, PI));
		area(PI, r);
	}

	private static double area(int width, double height) {
		return (width * height) / 2;
	}
	private static int area(int w, int h) {
		return w * h;
	}
	private static void area(double height, int width) {
		System.out.println((width * height) / 2);
	}
//	private static double area(double r, double PI) {
//		return r * r * PI;
//	}
	
	private static void test(int i, String s, boolean b, double d) {
		// 아래와 다른 메서드
	}
	private static void test(String s, boolean b, double d, int i) {
		// 위와 다른 메서드
	}
}
