
public class ThreadEx1 {

	public static void main(String[] args) {
		Threader t1 = new Threader(); // Thread 클래스를 상속
		Runnable t2 = new Threaderble();
		Thread t3 = new Thread(t2); // Runnable 인터페이스를 구현
		
		t3.setPriority(10);
		
		t1.start(); // thread 실행
		t3.start(); // thread 실행
		
		System.out.println("main end"); // main 종료
	}

}
