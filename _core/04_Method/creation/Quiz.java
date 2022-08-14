package creation;

public class Quiz {

	public static void main(String[] args) {
		// 랜덤으로 정수 5개를 배열에 담는 메서드
		// 그 배열을 전달 받아 평균 연산하는 메서드
		// 정수 5개와 연산 결과를 출력하는 메서드
		// main 메서드에는 어떠한 연산식도 있으면 안됨
		// 메서드간 데이터 전달 및 호출만 있어야 함
		
		printResult(calcAvrg(makeRnumArr()));
		
	}
	
	private static int[] makeRnumArr() {
		int[] rNumArr = new int[5];
		for (int i = 0; i < rNumArr.length; i++) {
			rNumArr[i] = (int)(Math.floor(Math.random()*10));
			System.out.print(rNumArr[i] + " ");
		}
		return rNumArr;
	}

	private static double calcAvrg(int[] arr) {
		int total = 0;
		double avrg = 0;
		for (int i : arr) {
			total += i;
		}
		System.out.println("총합 : " + total);
		avrg = (double)total / arr.length;
		return avrg;
	}

	private static void printResult(double result) {
		System.out.println("평균값 : " + result);
		
	}


}
