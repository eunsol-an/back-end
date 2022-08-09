package loops;

public class WhileEx {

	public static void main(String[] args) {
		// 1부터 20까지 합 구하기 while 이용하기
		int num = 1;
		int resultNum = 0;
		while(num <= 20) {
			resultNum += num;
			num++;
		}
		System.out.println(resultNum);
			
		// 1부터 100까지 홀수의 합 구하기 do while 이용하기
		int num2 = 1;
		int resultNum2 = 0;
		do {
			if(num2 % 2 == 1) {
				resultNum2 += num2;
			}
			num2++;
		} while (num2 < 101);
		System.out.println(resultNum2);
	}

}
