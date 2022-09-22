package supplement;

public class Room {
	private String roomNum;
	private boolean empty;
	private User user;
	private String[] amenities;
	
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public Room(String roomNum, boolean empty, User user, String[] amenities) {
		this.roomNum = roomNum;
		this.empty = empty;
		this.user = user;
		this.amenities = amenities;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
	public boolean isEmpty() {
		return empty;
	}
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String[] getAmenities() {
		return amenities;
	}
	public void setAmenities(String[] amenities) {
		this.amenities = amenities;
	}
	
}
