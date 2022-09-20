package classes;

import java.text.DecimalFormat;

class Ex03 {
	double base = 5.0;
	double height = 3.5;
	
	double getArea() {
		return (base*height)/2;
	}
	double getHypotenuse() {
		return Math.sqrt(base*base+height*height);
	}
	double getPerimeter() {
		return (base+height+getHypotenuse());
	}
}
public class Quiz_03 {

	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#.##");
		Ex03 ob = new Ex03();
		System.out.println("삼각형의 넓이 : " + df.format(ob.getArea()));
		System.out.println("빗변길이 : " + df.format(ob.getHypotenuse()));
		System.out.println("둘레길이 : " + df.format(ob.getPerimeter()));
		
		System.out.printf("삼각형의 넓이 : %.2f\n", ob.getArea()); // 이런 방법도 있음

	}

}
