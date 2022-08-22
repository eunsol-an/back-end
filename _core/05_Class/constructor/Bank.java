package constructor;

public class Bank {

	public static void main(String[] args) {
		BankAccount myBA = new BankAccount("댕댕", 3299, 0.0);
		System.out.println(myBA.getAccNum());
		
		BankAccount anonyBA = new BankAccount(3452, 10000.0);
		System.out.println(anonyBA.getAccNum());
		
//		myBA.accNum; private 접근제한자는 외부에서 접근 불가능
	}

}
