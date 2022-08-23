package quiz.bank;

public class User {
	private String name;
	private int cashAmount;
	private BankAccount account;
	
	public User(String name, int cashAmount, BankAccount account) {
		this.name = name;
		this.account = account;
		this.account.setBalance(cashAmount);
	}

	public String getName() {
		return name;
	}

	public int getAccount() {
		return this.account.getBalance();
	}

	public void setAccount(int money) {
		this.account.setBalance(money);
	}

	public String toString() {
		return "User [name=" + name + ", cashAmount=" + cashAmount + "]";
	}
	
	
}
