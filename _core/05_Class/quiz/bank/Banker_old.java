package quiz.bank;

public class Banker_old {

	public static void main(String[] args) {
		// 은행계좌 개설하기 2개 (myBA, urBA)
		BankAccount myAccNum = new BankAccount(0);
		BankAccount urAccNum = new BankAccount(0);
		User myBA = new User("eunsol", 30000, myAccNum);
		User urBA = new User("ff", 2000, urAccNum);
		
		// 잔액 조회 기능 구현
		viewBA(myBA);
		viewBA(urBA);
		
		// 입금, 출금 기능 구현
		saving(myBA, 40000);
		withdraw(myBA, 10000);
		
		// 송금 기능 구현
		viewBA(myBA);
		viewBA(urBA);
		remittance(myBA, urBA, 20000);
		viewBA(myBA);
		viewBA(urBA);
	}
	
	private static void remittance(User myBa, User urBa, int money) {
		myBa.setAccount(-money);
		urBa.setAccount(money);
		System.out.println(myBa.getName() + "님이 " + urBa.getName() + "님에게 " + money + "원을 송금하였습니다.");
		System.out.println("==========================");
	}

	private static void withdraw(User ba, int money) {
		ba.setAccount(-money);
		System.out.println(money + "원 출금 후 잔액 : " + ba.getAccount() + "원");
		System.out.println("==========================");
	}

	private static void saving(User ba, int money) {
		ba.setAccount(money);
		System.out.println(money + "원 입금 후 잔액 : " + ba.getAccount() + "원");
		System.out.println("==========================");
	}

	private static void viewBA(User ba) {
		System.out.println(ba.getName() + "님의 잔액을 조회합니다.");
		System.out.println("잔액 : " + ba.getAccount() + "원");
		System.out.println("==========================");
	}

}
