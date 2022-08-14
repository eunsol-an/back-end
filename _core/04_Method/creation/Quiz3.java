package creation;

import java.util.Scanner;
// 클래스를 벗어난 코드(실행)는 있을 수 없다!
public class Quiz3 {
	
	public static void main(String[] args) {
		// 숫자 야구 게임 -> 메서드로 분리해보기
		Scanner sc = new Scanner(System.in);
		// 중복 없는 3개의 랜덤 숫자 생성
		int[] rNumArr = makeRNumArr();
		// 유저한테 입력 받기
		int[] uNumArr = new int[3];
		int count = 0;
		boolean flag = true;
		
		// 게임 시작
		while (flag) {
			uNumArr = makeUNumArr(sc);
			count++;
			
			int[] stkAndBall = compareNum(rNumArr, uNumArr);
			
			flag = printResult(stkAndBall, count);
		}
		System.out.println("게임 종료!");
	}

	// 비교한 결과 출력
	private static boolean printResult(int[] stkAndBall, int count) {
		if(stkAndBall[0] == 0 && stkAndBall[1] == 0) {
			System.out.println("Out! 시도횟수 : " + count);
		} else if (stkAndBall[0] == 3) {
			System.out.println("3S!");
			return false;
		} else {
			System.out.println(stkAndBall[0] + "S " + stkAndBall[1] + "B " + "시도횟수 : " + count);
		}
		return true;
		
	}

	// 랜덤 숫자와 유저 숫자 비교
	private static int[] compareNum(int[] rNumArr, int[] uNumArr) {
		int[] stkAndBall = {0, 0};
		for (int i = 0; i < rNumArr.length; i++) {
			for (int j = 0; j < uNumArr.length; j++) {
				if (rNumArr[i] == uNumArr[j] && i == j) {
					stkAndBall[0]++;
				} else if (rNumArr[i] == uNumArr[j] && i != j) {
					stkAndBall[1]++;
				}
			}
		}
		return stkAndBall;
	}

	// 유저한테 입력받은 숫자
	private static int[] makeUNumArr(Scanner sc) {
//		Scanner sc = new Scanner(System.in);
		int[] uNumArr = new int[3];
		System.out.println("숫자 3개를 입력해주세요 >");
		String uNum = sc.next();
		String[] uNums = uNum.split("");
		for (int i = 0; i < uNums.length; i++) {
			uNumArr[i] = Integer.parseInt(uNums[i]);
		}
		for (int i : uNumArr) {
			System.out.print(i + " ");
		}
		return uNumArr;
	}

	// 중복 없는 3개의 랜덤 숫자 생성
	private static int[] makeRNumArr() {
		int[] rNumArr = new int[3];
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
		return rNumArr;
	}

}
