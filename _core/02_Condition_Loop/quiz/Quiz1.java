package quiz;

import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		// Q1. 3자리 이상의 정수 L, 2자리 이하의 정수 a, b를 입력받아
		// L까지의 a, b의 배수 개수를 구하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.println("3자리 이상의 정수를 입력하세요 >");
		int L = sc.nextInt();
		System.out.println("2자리 이하의 정수를 2개 입력하세요 >");
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int aCount = 0;
		int bCount = 0;
		for (int i = 1; i <= L; i++) {
			if(i % a == 0) {
				aCount++;
			}
			if(i % b == 0) {
				bCount++;
			}
		}
		System.out.println("L까지의 a의 배수 : " + aCount);
		System.out.println("L까지의 b의 배수 : " + bCount);
	}

}
