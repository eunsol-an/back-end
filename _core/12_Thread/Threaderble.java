
public class Threaderble implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "start");
		for (int i = 0; i < 5; i++) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(100); // Thread 지연
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "end");

	}

}
