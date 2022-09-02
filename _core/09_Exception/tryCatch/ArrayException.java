package tryCatch;

public class ArrayException {

	public static void main(String[] args) {
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		try {
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
			continueMethod();
		} finally {
			System.out.println("정상이든 에러이든 무조건 실행되는 영역");
		}

	}

	private static void continueMethod() {
		System.out.println("예외가 발생했으니.. 여기로 온 것이 아닌가...");
		
	}

}
