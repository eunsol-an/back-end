package sort;

public class SelectionSort {

	public static void main(String[] args) {
		// 선택정렬
		// 전체 값 중에 특정한 목적값을 선택하여 정렬하는 기법
		// 동일한 값일 경우는 교환하지 않는다
		int[] intArr = new int[10];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int)(Math.floor(Math.random()*100)+1);
		}
		
		// 선택 정렬
		int minIdx, temp;
		for (int i = 0; i < intArr.length-1; i++) {
			minIdx = i;
//			int minVal = intArr[minIdx];
			for (int j = i+1; j < intArr.length; j++) {
				if(intArr[j] < intArr[minIdx]) {
//					minVal = intArr[j];
					minIdx = j;
				}
			}
			temp = intArr[minIdx];
			intArr[minIdx] = intArr[i];
			intArr[i] = temp;
			
		}
		for (int i : intArr) {
			System.out.print(i + " ");
		}
	}

}
