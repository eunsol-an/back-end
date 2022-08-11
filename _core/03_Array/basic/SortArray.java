package basic;

public class SortArray {

	public static void main(String[] args) {
		int[] intArr = new int[12];
		// intArr에 랜덤 정수를 넣고 순차정렬과 역정렬을 구현해 보세요
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int)(Math.floor(Math.random()*100)+1);
		}
		
		// 버블 정렬
		int temp = 0;
		for (int i = 0; i < intArr.length; i++) {
			for (int j = 1; j < intArr.length-i; j++) {
				if (intArr[j-1] > intArr[j]) {
					// 왼쪽이 더 크다면 자리를 바꿔줌(swap)
					temp = intArr[j-1];
					intArr[j-1] = intArr[j];
					intArr[j] = temp;
				}
			}
		}
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
	}

}
