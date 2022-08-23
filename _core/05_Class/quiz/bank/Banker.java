package quiz.bank;

import java.util.Scanner;

public class Banker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		User me = null;
		User you = null;
		
		BankAccount acc1 = null;
		BankAccount acc2 = null;
		
		int menu = 0, money = 0;
		boolean flag = true;
		
		while (flag) {
			System.out.println("\n============ 뱅킹 시스템 ============");
			System.out.println("1.계좌개설 / 2.입금 / 3.출금 / ect.종료");
			menu = sc.nextInt();
			System.out.println("------------------------------------");
			
			switch (menu) {
			case 1:
				acc1 = new BankAccount(0);
				me = new User("eunsol", 10000, acc1);
				System.out.println("계좌 개설이 완료되었습니다.");
				System.out.println(me.toString());
				System.out.println(me.getAccount());
				viewBA(me);
				
				acc2 = new BankAccount(0);
				you = new User("you", 50000, acc2);
				System.out.println("계좌 개설이 완료되었습니다.");
				System.out.println(you.toString());
				System.out.println(you.getAccount());
				viewBA(you);
				break;
			case 2:
				System.out.println("입금할 금액 >");
				money = sc.nextInt();
				saving(me, money);
				break;
			case 3:
				System.out.println("출금할 금액 >");
				money = sc.nextInt();
				withdraw(me, money);
				break;

			default:
				System.out.println("============ 뱅킹 시스템 종료 ============");
				flag = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
		
//		User myBA = new User("eunsol", 30000, myAccNum);
//		User urBA = new User("ff", 2000, urAccNum);
//		
//		// 잔액 조회 기능 구현
//		viewBA(myBA);
//		viewBA(urBA);
//		
//		// 입금, 출금 기능 구현
//		saving(myBA, 40000);
//		withdraw(myBA, 10000);
//		
//		// 송금 기능 구현
//		viewBA(myBA);
//		viewBA(urBA);
//		remittance(myBA, urBA, 20000);
//		viewBA(myBA);
//		viewBA(urBA);
	}
	
	private static void remittance(User myBa, User urBa, int money) {
		myBa.setAccount(-money);
		urBa.setAccount(money);
		System.out.println(myBa.getName() + "님이 " + urBa.getName() + "님에게 " + money + "원을 송금하였습니다.");
	}

	private static void withdraw(User ba, int money) {
		ba.setAccount(-money);
		System.out.println(money + "원 출금 후 잔액 : " + ba.getAccount() + "원");
	}

	private static void saving(User ba, int money) {
		ba.setAccount(money);
		System.out.println(money + "원 입금 후 잔액 : " + ba.getAccount() + "원");
	}

	private static void viewBA(User ba) {
		System.out.println(ba.getName() + "님의 잔액을 조회합니다.");
		System.out.println("잔액 : " + ba.getAccount() + "원");
	}

}
