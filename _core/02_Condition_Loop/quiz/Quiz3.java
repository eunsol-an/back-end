package quiz;

import java.util.Iterator;

public class Quiz3 {

	public static void main(String[] args) {
		// Q3. 아래와 같은 출력문을 만들어보세요
		// ABCDEFGHIJKLMNOPQRSTUVWXYZ
		// ABCDEFGHIJKLMNOPQRSTUVWXY
		// ABCDEFGHIJKLMNOPQRSTUVWX
		// ABCDEFGHIJKLMNOPQRSTUVW
		// ABCDEFGHIJKLMNOPQRSTUV
		// ABCDEFGHIJKLMNOPQRSTU
		// ABCDEFGHIJKLMNOPQRST
		// ABCDEFGHIJKLMNOPQRS
		// ABCDEFGHIJKLMNOPQR
		// ...
		// AB
		// A
		
		// a = 65
		
		// 아스키 코드를 int 타입으로 사용한 방법
//		for (int i = 0; i < 26; i++) {
//			for (int j = 65; j < (91 - i); j++) {
//				System.out.print((char)j);
//			}
//			System.out.println();
//		}
		
		// 아스키 코드를 char 그 자체로 사용한 방법
//		for (char i = 'Z'; i >= 'A'; i--) {
//			for (char j = 'A'; j <= i; j++) {
//				System.out.print(j);
//			}
//			System.out.println();
//		}
		
		// 문자열 메서드 substring을 사용한 방법
		String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(0, (str.length()-i)));
		}

	}

}
