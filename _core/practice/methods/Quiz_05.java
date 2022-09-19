package methods;

import java.util.Scanner;

public class Quiz_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = getNums(sc);
		int op = getOperator(sc);
		
		switch (op) {
		case 1:
			addition(nums[0], nums[1]);
			break;
		case 2:
			substraction(nums[0], nums[1]);
			break;
		case 3:
			multiplication(nums[0], nums[1]);
			break;
		case 4:
			division(nums[0], nums[1]);
			break;
		case 5:
			modulus(nums[0], nums[1]);
			break;
		default:
			break;
		}
	}

	private static void modulus(int num1, int num2) {
		System.out.println(num1 + " % " + num2 + " = " + ((double)num1%num2));
		
	}

	private static void division(int num1, int num2) {
		System.out.println(num1 + " / " + num2 + " = " + ((double)num1/num2));
		
	}

	private static void multiplication(int num1, int num2) {
		System.out.println(num1 + " * " + num2 + " = " + (num1*num2));
		
	}

	private static void substraction(int num1, int num2) {
		System.out.println(num1 + " - " + num2 + " = " + (num1-num2));
		
	}

	private static void addition(int num1, int num2) {
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
	}

	private static int getOperator(Scanner sc) {
		System.out.println("연산자를 번호로 선택하세요 > 1.+ 2.- 3.* 4./ 5.%");
		int op = sc.nextInt();
		return op;
	}

	private static int[] getNums(Scanner sc) {
		int[] nums = new int[2];
		for (int i = 0; i < nums.length; i++) {
			System.out.println((i+1) + "번째 숫자를 입력하세요 >");
			nums[i] = sc.nextInt();
		}
		return nums;
		
	}

}
