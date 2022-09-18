package hotel;

import java.util.List;
import java.util.Scanner;

public class HotelFront {
	private Scanner sc;
	private Service svc;
	private boolean flag;
	
	public HotelFront() {
		sc = new Scanner(System.in);
		svc = new HotelService();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while (flag) {
			System.out.println("================ Hotel Management System ================");
			System.out.println("1.Room Status / 2.Check In / 3.Check Out / 4. Room Detail");
			int menu = sc.nextInt();
			
			switch (menu) {
			case 1:
				roomStatus();
				break;
			case 2:
				checkIn();
				break;
			case 3:
				checkOut();
				break;
			case 4:
				roomDetail();
				break;

			default:
				flag = false;
				break;
			}
		}
		System.out.println("End the System");
		
	}

	private void roomDetail() {
		System.out.println("Room Number >");
		String rno = sc.next();
		RoomVO rvo = svc.roomDetail(rno);
		System.out.println(rvo);
		
	}

	private void checkOut() {
		System.out.println("Room Number >");
		String rno = sc.next();
		int isOk = svc.checkOut(rno);
		System.out.println("Check Out " + (isOk > 0 ? "Success" : "Fail"));
		
	}

	private void checkIn() {
		System.out.println("Room Number >");
		String rno = sc.next();
		System.out.println("Guest Name >");
		String name = sc.next();
		System.out.println("Guest Tel >");
		String tel = sc.next();
		System.out.println("Guest Age >");
		int age = sc.nextInt();
		System.out.println("Guest Gender 1.Female 2.Male");
		int gen = sc.nextInt();
		RoomVO roomInfo = new RoomVO(rno, (new GuestVO(name, tel, age, gen)));
		int isOk = svc.checkIn(roomInfo);
		System.out.println("Check In " + (isOk > 0 ? "Success" : "Fail"));
	}

	private void roomStatus() {
		List<RoomVO> list = svc.roomStatus();
		for (RoomVO rvo : list) {
			System.out.println(rvo);
		}
	}
}
