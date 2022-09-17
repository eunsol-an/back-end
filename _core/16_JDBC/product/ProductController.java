package product;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	// 상품등록, 상품리스트, 상품상세, 상품수정, 상품삭제
	// 데이터베이스 연동한 후 컨트롤러에서 모든 메뉴 분기 처리
	// 서비스는 컨트롤러에서 호출, DAO는 서비스가 호출
	private Scanner sc;
	private Service svc;
	private boolean flag;
	
	public ProductController() {
		sc = new Scanner(System.in);
		svc = new ProductService();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while (flag) {
			System.out.println("================== 상품 관리 시스템 ==================");
			System.out.println("1.상품등록 2.상품목록 3.상품상세 4.상품수정 5.상품삭제 Etc.종료");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				register();
				break;
			case 2:
				list();
				break;
			case 3:
				detail();
				break;
			case 4:
				edit();
				break;
			case 5:
				remove();
				break;

			default:
				flag = false;
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

	private void remove() {
		System.out.println("Product Number >");
		int pno = sc.nextInt();
		int isOk = svc.remove(pno);
		System.out.println("Product remove " + (isOk > 0 ? "success" : "fail"));
		
	}

	private void edit() {
		System.out.println("Product Number >");
		int pno = sc.nextInt();
		System.out.println("Product Name >");
		String pname = sc.next();
		System.out.println("Product price >");
		int price = sc.nextInt();
		System.out.println("Made by >");
		String madeby = sc.next();
		int isOk = svc.edit(new ProductVO(pno, pname, price, madeby));
		System.out.println("Product edit " + (isOk > 0 ? "success" : "fail"));
		
		
	}

	private void detail() {
		System.out.println("Product Number >");
		int pno = sc.nextInt();
		ProductVO pvo = svc.detail(pno);
		System.out.println(pvo);
	}

	private void list() {
		List<ProductVO> list = svc.list();
		for (ProductVO pvo : list) {
			System.out.println(pvo);
		}
	}

	private void register() {
		System.out.println("Product Name >");
		String pname = sc.next();
		System.out.println("Product price >");
		int price = sc.nextInt();
		System.out.println("Made by >");
		String madeby = sc.next();
		int isOk = svc.register(new ProductVO(pname, price, madeby));
		System.out.println("Product register " + (isOk > 0 ? "success" : "fail"));
	}
}
