package conditions;

import java.util.Scanner;

public class RSPGame {

	public static void main(String[] args) {
		// 가위바위보 게임 만들기
		// 1. 컴퓨터가 랜덤으로 가위바위보 선택
		// 2. 나도 가위바위보를 입력
		// 3. 승무패 결과 출력
		
		System.out.println("게임 시작!");
		int com = (int)(Math.floor(Math.random()*3)); //가위:0, 바위:1, 보:2
		Scanner sc = new Scanner(System.in);
		System.out.println("가위바위보를 입력하세요 >");
		String user = sc.next();
		
		int userNum = user.equals("가위") ? 0 : user.equals("바위") ? 1 : 2;
		String result = "";
		
		if(com == userNum) {
			result = "무";
		} else {
			if(com == 0) {
				result = userNum == 1 ? "승" : "패";
			} else if(com == 1) {
				result = userNum == 0 ? "패" : "승";
			} else {
				result = userNum == 1 ? "패" : "승";
			}
		}
		
		System.out.println(result);
		System.out.println("게임 종료!");
	}

}
