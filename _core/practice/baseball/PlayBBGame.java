package baseball;

import java.util.Scanner;

public class PlayBBGame {
	Scanner sc = new Scanner(System.in);
	private int[] rNumArr = new int[3];
	private int[] uNumArr = new int[3];
	private int count = 0, limit = 0, regCnt = 0;
	private String nickname = "";
	private boolean flag = true;
	private User[] users;
	
	public PlayBBGame() {
		users = initUserCount();
		while (flag) {
			gameProccess(choiceMenu());
		}
		System.out.println("프로그램 종료");
	}

	private User[] initUserCount() {
		System.out.println("랭킹 최대 인원 >");
		limit = sc.nextInt();
		return new User[limit];
	}

	private void gameProccess(int menu) {
		switch (menu) {
		case 1:
			playGame();
			break;
		case 2:
			veiwRanking();
			break;
		default:
			flag = false;
			System.out.println("============== 숫자 야구 게임 종료 ==============");
			break;
		}
		
	}

	private void veiwRanking() {
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null) {
				System.out.print((i+1) + ". ");
				users[i].printUser();
			}
		}
	}

	private void playGame() {
		if (regCnt < limit) {
			inputNickname();
			rNumArr = makeRnumArr();
			count = 0;
			
			while (flag) {
				uNumArr = makeUnumArr();
				count++;
				int[] stkAndBall = compareNum(rNumArr, uNumArr);
				flag = printResult(stkAndBall, count);
			}
			System.out.println("게임 종료!");
			flag = true;
		} else {
			System.out.println("최대 랭킹 인원수를 초과했습니다.");
		}
	}
	
	private void inputNickname() {
		System.out.println("닉네임 입력 >");
		nickname = sc.next();
		System.out.println(nickname + "님, 게임을 시작합니다.");
		
	}

	private boolean printResult(int[] stkAndBall, int count) {
		if(stkAndBall[0] == 0 && stkAndBall[1] == 0) {
			System.out.println("Out! 시도횟수 : " + count);
		} else if (stkAndBall[0] == 3) {
			System.out.println("3S!");
			saveRanking();
			return false;
		} else {
			System.out.println(stkAndBall[0] + "S " + stkAndBall[1] + "B " + "시도횟수 : " + count);
		}
		return true;
		
	}
	
	private void saveRanking() {
		users[regCnt] = new User(nickname, count);
		regCnt++;
	}

	private int[] compareNum(int[] rNumArr, int[] uNumArr) {
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

	private int[] makeUnumArr() {
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

	private int choiceMenu() {
		System.out.println("\n============== 숫자 야구 게임 메뉴 ==============");
		System.out.println("1.게임시작 / 2.랭킹보기 / etc.종료");
		int menu = sc.nextInt();
		System.out.println("---------------------------------------");
		return menu;
	}

	private int[] makeRnumArr() {
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
