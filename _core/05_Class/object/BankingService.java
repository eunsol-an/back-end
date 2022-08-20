package object;

class BankAccount {
	String owner = "";
	int accNum, deposit;
	
	void initialize(String owner, int accNum, int deposit) {
		this.owner = owner;
		this.accNum = accNum;
		this.deposit = deposit;
	}
	
	void getAccInfo() {
		System.out.println("예금주 : " + owner);
		System.out.println("계좌번호 : " + accNum);
		System.out.println("계좌잔액 : " + deposit);
	}
	
	void saving(int money) {
		this.deposit += money;
	}
	
	void withdraw(int money) {
		if(deposit < money) {
			System.out.println("잔액 부족으로 처리 불가입니다");
		} else {
			this.deposit -= money;
		}
	}
	
	
}

public class BankingService {

	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 계좌잔액(deposit)
		// 계좌현황조회, 입금, 출금을 할 수 있다 (메서드)
		
		BankAccount myAccount = new BankAccount();
		myAccount.initialize("은솔", 12345, 0);
		myAccount.getAccInfo();
		System.out.println("================");
		myAccount.saving(30000);
		myAccount.getAccInfo();
		System.out.println("================");
		myAccount.withdraw(20000);
		myAccount.getAccInfo();
		System.out.println("================");
		myAccount.withdraw(20000);
		myAccount.getAccInfo();
	}

}
