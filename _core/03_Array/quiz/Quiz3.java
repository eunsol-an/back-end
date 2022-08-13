package quiz;

import java.util.Scanner;

public class Quiz3 {

	public static void main(String[] args) {
		// 숫자 야구 게임

		// 중복 없는 3개의 랜덤 숫자 생성
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int[] rNumArr = new int[3];
		int[] uNumArr = new int[3];
		
		for (int i = 0; i < rNumArr.length; i++) {
			rNumArr[i] = (int)(Math.floor(Math.random()*9)+1);
			for (int j = 0; j < i; j++) {
				if (rNumArr[j] == rNumArr[i]) {
					i--;
					break;
				}
			}
			
		}

		for (int i = 0; i < rNumArr.length; i++) {
			System.out.print(rNumArr[i] + " ");
		}
		System.out.println();
		
		
		while (true) {
			int stk = 0, ball = 0;	
			System.out.println("숫자 3개를 입력해주세요 >");
			String uNum = sc.next();
			String[] uNums = uNum.split("");
			count++;
			for (int i = 0; i < uNums.length; i++) {
				uNumArr[i] = Integer.parseInt(uNums[i]);
			}
			for (int i : uNumArr) {
				System.out.print(i + " ");
			}
			
			for (int i = 0; i < rNumArr.length; i++) {
				for (int j = 0; j < uNumArr.length; j++) {
					if (rNumArr[i] == uNumArr[j] && i == j) {
						stk++;
					} else if (rNumArr[i] == uNumArr[j] && i != j) {
						ball++;
					}
				}
			}
			
			if(stk == 0 && ball == 0) {
				System.out.println("Out! 시도횟수 : " + count);
			} else if (stk == 3) {
				System.out.println("3S!");
				break;
			} else {
				System.out.println(stk + "S " + ball + "B " + "시도횟수 : " + count);
			}
		}
		System.out.println("게임 종료!");
	}

}
