package classes;

import java.util.Scanner;

class Store {
	String[] item = new String[3];
	
	public Store() {
		
	}
	
	void setItems(String[] items) {
		this.item = items;
	}
	void viewItems() {
		for (int i = 0; i < item.length; i++) {
			System.out.println((i+1) + "번 아이템 : " + item[i]);
		}
	}
	String getItem(int a) {
		return item[a-1];
	}
}

public class Quiz_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		Store carhartt = new Store();
		Store covernat = new Store();
		Store lmc = new Store();
		String[] cartItems = {"티셔츠", "바지", "백팩"};
		String[] covnItems = {"맨투맨", "모자", "니트"};
		String[] lmcItems = {"키링", "벨트", "자켓"};
		
		carhartt.setItems(cartItems);
		covernat.setItems(covnItems);
		lmc.setItems(lmcItems);
		
		while (flag) {
			System.out.println("======= 상점에 오신 걸 환영합니다. =======");
			System.out.println("메뉴를 선택해주세요 > 1.아이템 리스트  2.아이템 구입");
			int menuNum = sc.nextInt();
			System.out.println("어떤 상점의 아이템을 보시겠습니까?");
			System.out.println("1.칼하트 2.커버낫 3.LMC");
			int shopNum = sc.nextInt();
			
			switch (shopNum) {
			case 1:
				if (menuNum == 1) {
					carhartt.viewItems();
				} else if (menuNum == 2) {
					System.out.println("몇 번의 아이템을 구입 하시겠습니까?");
					int itemNum = sc.nextInt();
					System.out.println(itemNum + "번 아이템 " + carhartt.getItem(itemNum) + "을(를) 구입하셨습니다.");
					System.out.println("이용해주셔서 감사합니다.");
				}
				break;
			case 2:
				if (menuNum == 1) {
					covernat.viewItems();
				} else if (menuNum == 2) {
					System.out.println("몇 번의 아이템을 구입 하시겠습니까?");
					int itemNum = sc.nextInt();
					System.out.println(itemNum + "번 아이템 " + covernat.getItem(itemNum) + "을(를) 구입하셨습니다.");
					System.out.println("이용해주셔서 감사합니다.");
				}
				break;
			case 3:
				if (menuNum == 1) {
					lmc.viewItems();
				} else if (menuNum == 2) {
					System.out.println("몇 번의 아이템을 구입 하시겠습니까?");
					int itemNum = sc.nextInt();
					System.out.println(itemNum + "번 아이템 " + lmc.getItem(itemNum) + "을(를) 구입하셨습니다.");
					System.out.println("이용해주셔서 감사합니다.");
				}
				break;
			default:
				System.out.println("저희 상점을 이용해주셔서 감사합니다.");
				flag = false;
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		
	}
}
