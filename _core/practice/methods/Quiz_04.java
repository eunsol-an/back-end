package methods;

import java.util.Scanner;

public class Quiz_04 {

	static int num1, num2;
	static String op;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===== 계산기 =====");
		System.out.println("첫번째 숫자를 입력하세요 >");
		num1 = sc.nextInt();
		System.out.println("연산자를 입력하세요 >");
		op = sc.next();
		System.out.println("두번째 숫자를 입력하세요 >");
		num2 = sc.nextInt();
		
		switch (op) {
		case "+":
			addition();
			break;
		case "-":
			substraction();
			break;
		case "*":
			multiplication();
			break;
		case "/":
			division();
			break;
		case "%":
			modulus();
			break;
		default:
			break;
		}
	}

	private static void modulus() {
		System.out.println((double)num1 + " % " + num2 + " = " + (num1%num2));
		
	}

	private static void division() {
		System.out.println((double)num1 + " / " + num2 + " = " + (double)(num1/num2));
		
	}

	private static void multiplication() {
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		
	}

	private static void substraction() {
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		
	}

	private static void addition() {
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
	}

}
