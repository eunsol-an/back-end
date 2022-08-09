package loops;

public class GuGuDan {

	public static void main(String[] args) {
		// 구구단을 찍어보자 => 중첩 반복문으로!
		// \t 탭효과
		// System.out.println(); 엔터효과
		// 2 * 1 = 2	3 * 1 = 3.......9 * 1 = 9
		// ......................................
		// ......................................
		// 2 * 9 = 18...................9 * 9 = 81
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + " * " + i + " = " + (j*i) + "\t");
			}
			System.out.println();
		}
	}
}
