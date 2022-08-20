package object;

class BankAccount2 {
	String owner;
	int accNum, deposit;
	
//	void initialize(String owner, int accNum, int deposit) {
//		this.owner = owner;
//		this.accNum = accNum;
//		this.deposit = deposit;
//	}
	
	void getAccInfo() {
		System.out.println("예금주 : " + getOwner());
		System.out.println("계좌번호 : " + getAccNum());
		System.out.println("계좌잔액 : " + getDeposit());
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

	// setters
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	
	// getters
	public String getOwner() {
		return this.owner;
	}
	public int getAccNum() {
		return this.accNum;
	}
	public int getDeposit() {
		return this.deposit;
	}
}

public class BankingService2 {

	public static void main(String[] args) {
		// BankAccount 클래스를 정의한다
		// BankAccount에는 예금주(owner), 계좌번호(accNum), 계좌잔액(deposit) 세팅하는 메서드
		// 위의 정보를 조회할 수 있는 메서드
		// 계좌현황조회(변경), 입금, 출금을 할 수 있다 (메서드)
		
		BankAccount2 myAccount = new BankAccount2();
//		myAccount.initialize("은솔", 12345, 0);
		myAccount.setOwner("니니");
		myAccount.setAccNum(1234);
		myAccount.setDeposit(0);
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
