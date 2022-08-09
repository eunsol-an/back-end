package quiz;

import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// Q2. 음수나 0을 입력할때까지 숫자를 계속 입력받고
		// 음수나 0이 입력되면 지금까지 입력된 수의 총합과 평균을 구하세요
		
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int count = 0;
		while (true) {
			System.out.println("숫자를 입력하세요 >");
			int num = sc.nextInt();
			if (num > 0) {
				result += num;
				count++;
			} else {
				System.out.println("지금까지 입력된 수의 총합 : " + result);
				System.out.println("지금까지 입력된 수의 평균 : " + (double)(result/count));
				break;
			}
		}
	}

}
