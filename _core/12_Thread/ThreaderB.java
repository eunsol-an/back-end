
public class ThreaderB extends Thread{
	@Override
	public void run() {
		System.out.println(getName() + "start");
		for (int i = 0; i < 50; i++) {
			System.out.println("|");
		}
		System.out.println(getName() + "end");
	}
}
