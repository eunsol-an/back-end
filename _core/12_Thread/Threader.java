
public class Threader extends Thread{

	@Override
	public void run(){
		System.out.println(getName() + "start");
		for (int i = 0; i < 5; i++) {
			System.out.println(getName());
			try {
				Thread.sleep(100); // Thread 지연
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(getName() + "end");
	}
	
}
