package classes;
class Ex06 {
	final double PI = 3.141593;
	
	double area(int a) {
		return (a*a*PI);
	}
	double area(int a, int b) {
		return (a*b);
	}
	double area(int a, int b, int c) {
		return ((double)(a+b)*c/2);
	}
}

public class Quiz_06 {

	public static void main(String[] args) {
		Ex06 myTool = new Ex06();
		System.out.println(myTool.area(3));
		System.out.println(myTool.area(4, 5));
		System.out.println(myTool.area(3, 4, 7));
	}

}
