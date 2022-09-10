
public class ThreadEx2 {
	static long startTime = 0L;
	public static void main(String[] args) {
		ThreaderA tha = new ThreaderA();
		ThreaderB thb = new ThreaderB();
		
		tha.setPriority(10);
		thb.setPriority(1);
		
		tha.start();
		thb.start();
		
		System.out.println(tha.getName() + ":" + tha.getPriority());
		System.out.println(thb.getName() + ":" + thb.getPriority());
		
//		startTime = System.currentTimeMillis();
//		try {
//			tha.join();
//			thb.join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(System.currentTimeMillis() - ThreadEx2.startTime);
		
		System.out.println("main end");

	}

}
