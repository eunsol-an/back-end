package methods;

import java.util.Scanner;

public class Quiz_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("확인하고 싶은 피보나치 수열의 자리수 입력 >");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print(fibo(i) + " ");
		}
	}

	private static int fibo(int i) {
		if (i == 0 || i == 1) {
			return 1;
		} else {
			return fibo(i-2) + fibo(i-1);
		}
	}
}
