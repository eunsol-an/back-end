package supplement;

public class Hotel {

	public static void main(String[] args) {
		Room[] rooms = new Room[10];
		
		for (int i = 0; i < rooms.length; i++) {
			rooms[i] = new Room(i+"호", true, null, null);
		}
		
		for (Room room : rooms) {
			System.out.println(room); // 출력결과는? 주소값
			System.out.println(room.getRoomNum()); // 출력결과는? 0호실 ~ 9호실
		}
		
		rooms[0].setUser(new User());
		System.out.println(rooms[0].getUser()); // 출력결과는? 주소값
		
		User user1 = new User("kim", 34, "m", 0);
		User user2 = new User("lee", 25, "f", 1);
		User user3 = new User("park", 47, "f", 3);
		
		rooms[1].setUser(user1);
		rooms[2].setUser(user2);
		rooms[3].setUser(user3);
		
		System.out.println(rooms[3].getUser()); // 출력결과는? 주소값
		System.out.println(rooms[3].getUser().getName());
	}

}
