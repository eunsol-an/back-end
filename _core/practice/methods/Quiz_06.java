package methods;

import java.util.Scanner;

public class Quiz_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] nums = getNums(sc);
		int op = getOperator(sc);
		
		switch (op) {
		case 1:
			addition(nums);
			break;
		case 2:
			substraction(nums);
			break;
		case 3:
			multiplication(nums);
			break;
		case 4:
			division(nums);
			break;
		case 5:
			modulus(nums);
			break;
		default:
			break;
		}

	}

	private static void modulus(int[] nums) {
		System.out.println(nums[0] + " % " + nums[1] + " = " + (nums[0]%nums[1]));
		
	}

	private static void division(int[] nums) {
		System.out.println(nums[0] + " / " + nums[1] + " = " + (double)nums[0]/nums[1]);
		
	}

	private static void multiplication(int[] nums) {
		System.out.println(nums[0] + " * " + nums[1] + " = " + (nums[0]*nums[1]));
		
	}

	private static void substraction(int[] nums) {
		System.out.println(nums[0] + " - " + nums[1] + " = " + (nums[0]-nums[1]));
		
	}

	private static void addition(int[] nums) {
		System.out.println(nums[0] + " + " + nums[1] + " = " + (nums[0]+nums[1]));
		
	}

	private static int getOperator(Scanner sc) {
		System.out.println("연산자를 선택하세요 > 1.+ 2.- 3.* 4./ 5.%");
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