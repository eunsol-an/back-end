package hotel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Hotel {
	private Room[][] rooms;
	public Scanner sc = new Scanner(System.in);
	
	// 호텔 생성
	public void makeHotel() {
		int floor, room;
		String roomNum;
		
		System.out.println("====================== 호텔 생성 =====================");
		System.out.println("호텔 층 입력 >");
		floor = sc.nextInt();
		System.out.println("층당 객실 수 입력 >");
		room = sc.nextInt();
		
		rooms = new Room[floor][room];
		for (int i = 0; i < floor; i++) {
			for (int j = 0; j < room; j++) {
				roomNum = (i + 1) + (j < 9 ? "0" : "") + (j + 1);
				Room oneRoom = new Room(roomNum);
				rooms[i][j] = oneRoom;
			}
		}
		System.out.println("===================== 호텔 생성 완료 ====================");
	}

	// 호텔 관리 메뉴
	public void goFrontDest() {
		int menu = 0;
		boolean flag = true;
		
		while (flag) {
			System.out.println("\n====================== 호텔 관리 메뉴 =====================");
			System.out.println("1:객실현황 2:입실 3:퇴실 4:객실상세조회 5:투숙객조회 Etc:종료");
			System.out.println("-------------------------------------------------------------");
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> 메뉴 선택 >>>>>>>>>>>>>>>>>>>>>>>>>>");
			menu = sc.nextInt();
			
			flag = choiceMenu(menu);
		}
		System.out.println("저희 호텔을 이용해주셔서 감사합니다.");
		System.out.println("프로그램을 종료합니다");
	}

	// 메뉴 선택
	private boolean choiceMenu(int menu) {		
		switch (menu) {
		case 1:
			viewRoomStatus();
			return true;
		case 2:
			checkIn();
			return true;
		case 3:
			checkOut();
			return true;
		case 4:
			viewRoomStatusDetail();
			return true;
		case 5:
			viewUserDetail();
			return true;

		default:
			return false;
		}
	}
	
	// 호실의 인덱스 번호 추출
	private int[] getRoomsIdx(String roomNum) {
		int[] roomsIdx = new int[2];
		
		if (roomNum.length()  > 3) {
			roomsIdx[0] = Integer.parseInt(roomNum.substring(0, 2))-1;
			roomsIdx[1] = Integer.parseInt(roomNum.substring(2))-1;
		} else {
			roomsIdx[0] = Integer.parseInt(roomNum.substring(0, 1))-1;
			roomsIdx[1] = Integer.parseInt(roomNum.substring(1))-1;
		}
		return roomsIdx;
	}
	
	// 시간 설정
	private String getTime() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
	
	// 1. 객실 현황
	private void viewRoomStatus() {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j].getRoomNum() + "호 :\t");
				System.out.print((rooms[i][j].isEmpty() == true ? "빈 방" : "사용중") + "\t");
			}
			System.out.println();
		}
	}
	
	// 2. 입실
	private void checkIn() {
		int floorIdx, roomIdx;
		String roomNum;
		
		System.out.println("입실할 방 호수를 입력 >");
		roomNum = sc.next();
		floorIdx = getRoomsIdx(roomNum)[0];
		roomIdx = getRoomsIdx(roomNum)[1];
		
		if (rooms[floorIdx][roomIdx].isEmpty()) {
			rooms[floorIdx][roomIdx].setUser(userInfo());
			rooms[floorIdx][roomIdx].setCheckInTime(getTime());
			rooms[floorIdx][roomIdx].setCheckOutTime("");
			rooms[floorIdx][roomIdx].setEmpty(false);
			System.out.println(roomNum + "호 입실이 완료되었습니다.");
		} else {
			System.out.println(roomNum + "호는 사용중 입니다. 다른 호실을 선택해주세요.");
		}	
	}
	
	// 고객 정보 입력
	private User[] userInfo() {
		String name;
		int age, count;
		char gen;
		User[] users;
		
		System.out.println("입실 할 인원을 입력 >");
		count = sc.nextInt();
		users = new User[count];
		for (int i = 0; i < users.length; i++) {
			System.out.println((i + 1) + "번째 고객 정보를 입력해주세요.");
			System.out.println((i + 1) + "번째 고객 성함 입력 >");
			name = sc.next();
			System.out.println((i + 1) + "번째 고객 나이 입력 >");
			age = sc.nextInt();
			System.out.println((i + 1) + "번째 고객 성별 입력 >");
			gen = sc.next().charAt(0);
			User oneUser = new User(name, age, gen);
			users[i] = oneUser;
		}
		return users;
	}
	
	// 3. 퇴실
	private void checkOut() {
		int floorIdx, roomIdx;
		String roomNum;
		
		System.out.println("퇴실할 방 호수를 입력 > ");
		roomNum = sc.next();
		floorIdx = getRoomsIdx(roomNum)[0];
		roomIdx = getRoomsIdx(roomNum)[1];
		
		if (rooms[floorIdx][roomIdx].isEmpty()) {
			System.out.println(roomNum + "호는 빈 방 입니다. 다른 호실을 선택해주세요.");
		} else {
			rooms[floorIdx][roomIdx].setUser(null);
			rooms[floorIdx][roomIdx].setCheckOutTime(getTime());
			rooms[floorIdx][roomIdx].setEmpty(true);
			System.out.println(roomNum + "호 퇴실이 완료되었습니다.");
		}	
	}
	
	// 4. 객실 상세 조회
	private void viewRoomStatusDetail() {
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[i].length; j++) {
				System.out.print(rooms[i][j].getRoomNum() + "호\t");
				System.out.print((rooms[i][j].isEmpty() == true ? "빈 방" : "사용중") + "\t");
				System.out.print("입실시간 : " + rooms[i][j].getCheckInTime() + "\t");
				System.out.println("퇴실시간 : " + rooms[i][j].getCheckOutTime());
			}
			System.out.println();
		}
	}
	
	// 5. 투숙객 조회
	private void viewUserDetail() {
		int floorIdx, roomIdx;
		String roomNum;
		User[] users;
		
		System.out.println("몇 호실의 투숙객을 조회하시겠습니까?");
		roomNum = sc.next();
		floorIdx = getRoomsIdx(roomNum)[0];
		roomIdx = getRoomsIdx(roomNum)[1];
		
		if (rooms[floorIdx][roomIdx].isEmpty()) {
			System.out.println("빈 방은 조회할 수 없습니다.");
		} else {
			users = rooms[floorIdx][roomIdx].getUser();
			
			System.out.println(roomNum + "호 투숙객 정보입니다.");
			for (int i = 0; i < users.length; i++) {
				System.out.print("이름: " + users[i].getName() + "\t");
				System.out.print("나이: " + users[i].getAge() + "\t");
				System.out.print("성별: " + users[i].getGen());
				System.out.println();
			}
		}
	}	
}
