package classes;

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("별탑을 몇층으로 만들까요? >");
		int n = sc.nextInt();
		
		printStars(n);

	}

	private static void printStars(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
