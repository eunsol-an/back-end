package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		// 테스트에 참여할 인원수를 입력하세요 > 3
		// 1번째 사람의 이름을 입력하세요 >
		// 1번째 사람의 국어점수 입력 >
		// 1번째 사람의 영어점수 입력 >
		// 1번째 사람의 수학점수 입력 >
		// ......
		// 3번째 사람의 수학점수 입력 >
		
		// 이름 국어 영어 수학 총점 평균
		// aaa 88  99  87  ?  ?
		// ....

		Scanner sc = new Scanner(System.in);
		System.out.println("테스트에 참여할 인원수를 입력하세요 >");
		int num = sc.nextInt();
//		String[] names = new String[num];
		String[][] scoreArr = new String[num][6];
		for (int i = 0; i < scoreArr.length; i++) {
			System.out.println("차례대로 이름, 국어, 영어, 수학 점수를 입력하세요 >");
			System.out.println((i+1) + "번 째 사람의 정보를 입력하세요 >");
			for (int j = 0; j < 4; j++) {
				String val = sc.next();
				scoreArr[i][j] = val;
				
			}
			int lang = Integer.parseInt(scoreArr[i][1]);
			int en = Integer.parseInt(scoreArr[i][2]);
			int math = Integer.parseInt(scoreArr[i][3]);
			int total = lang + en + math;
//			System.out.println(total);
			scoreArr[i][4] = Integer.toString(total);
			double avrg = (double)total/3;
//			System.out.println(avrg);
			scoreArr[i][5] = Double.toString(avrg);
		}
		// 소수점 2째자리까지 조정
		DecimalFormat df = new DecimalFormat("#.##");
//		df.format(); // 이런식으로 표현
		
		System.out.println("이름 국어 영어 수학 총점 평균");
		for (int i = 0; i < scoreArr.length; i++) {
			for (int j = 0; j < scoreArr[i].length; j++) {
				System.out.print(scoreArr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
