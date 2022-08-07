package conditions;

import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		// 영어로 계절을 입력하면(대소문자 구분하지 않음)
		// 한국어로 번역하여 출력하는 프로세스 만들어보세요
		// switch case 문으로 작성
		
		Scanner sc = new Scanner(System.in);
		System.out.println("계절을 영어로 입력하세요 >");
		String season = sc.next().toLowerCase();
//		String key = season.toLowerCase();
		String result = "";
		
		switch (season) {
		case "spring":
			result = "봄";
			break;
		case "summer":
			result = "여름";
			break;
		case "fall":
		case "autumn":
			result = "가을";
			break;
		case "winter":
			result = "겨울";
			break;
		default:
			result = "어디 사시는 거죠?";
			break;
		}
		System.out.println("한국어로 번역하면? " + result);
	}

}
