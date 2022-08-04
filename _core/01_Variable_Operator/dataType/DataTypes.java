package dataType;

import java.util.Scanner;

public class DataTypes {

	public static void main(String[] args) {

		System.out.println("기본 데이터 타입(Primitive Data Type");
		System.out.println("-----자주 사용하는 기본 자료형-----");
		System.out.println("정수형 : int : 32bit");
		System.out.println("itn 보다 큰 정수형 : long : 64bit : 리터럴 표기법 사용");
		System.out.println("실수형 : float(32bit)-리터럴 표기법 사용, double(64bit)");
		System.out.println("참거짓 : boolean");
		System.out.println("2byte 문자 : char : 홑따옴표 사용");
		System.out.println("-----알아두면 좋은 기본 자료형-----");
		System.out.println("1byte 숫자 : byte : 파일전송에 많이 사용"); // -128 ~ 127
		
		int num = 2147000000; // 약 -21억 4천 7백만 ~ 21억 4천 7백만
		long numL = 21470000000L; // 64bit 정수
		double numDb = 0.0; // 64bit 실수
		float numF = 0.0f;
		boolean flag = false; //true or false
		char ch = 'A'; // 대문자 1개까지
		
		String str = "원래 참조자료형 하지만 사용빈도가 높기 때문에 기본자료형처럼 사용가능하게 만듬";
		String strObj = new String("참조자료형 사용법");
				
		char ch1 = 65; // A
		char ch2 = 97; // a
		System.out.println(ch1);
		System.out.println(ch2);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("아스키 코드를 입력해 볼까요? >");
		int codeNum = sc.nextInt();
		char ch3 = (char)codeNum;
		
		System.out.println(ch3);
		
		// 자바에서 null은 기초자료형처럼 출력이 됩니다
		// 단 null은 dataType이 null 객체이기 때문에 값은 null이라고 출력은 되지만
		// 모든 산술, 비교(==은 제외), 논리 연산은 불가능합니다
		System.out.println(null + "aaa");
		
	}

}
