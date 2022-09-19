package methods;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String item;
		int qty, price;
		
		System.out.println("품명을 입력하세요 >");
		item = sc.next();
		System.out.println("수량을 입력하세요 >");
		qty = sc.nextInt();
		System.out.println("금액을 입력하세요 >");
		price = sc.nextInt();
		
		compute(item, qty, price);

	}

	private static void compute(String item, int qty, int price) {
		System.out.println("품명 : " + item);
		System.out.println("금액 : " + (qty*price));
		
	}

}
