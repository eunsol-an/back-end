package hotel;

public class RoomVO {
	private String rno;
	private int isEmpty;
	private String checkIn;
	private String checkOut;
	private GuestVO guest;
	
	public RoomVO() {
		// TODO Auto-generated constructor stub
	}
	
	

	public RoomVO(String rno, GuestVO guest) {
		super();
		this.rno = rno;
		this.guest = guest;
	}

	public RoomVO(String rno, int isEmpty, String checkIn, GuestVO guest) {
		super();
		this.rno = rno;
		this.isEmpty = isEmpty;
		this.checkIn = checkIn;
		this.guest = guest;
	}

	public RoomVO(String rno, int isEmpty, String checkIn, String checkOut, GuestVO guest) {
		super();
		this.rno = rno;
		this.isEmpty = isEmpty;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.guest = guest;
	}

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public int getIsEmpty() {
		return isEmpty;
	}

	public void setIsEmpty(int isEmpty) {
		this.isEmpty = isEmpty;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public GuestVO getGuest() {
		return guest;
	}

	public void setGuest(GuestVO guest) {
		this.guest = guest;
	}

	@Override
	public String toString() {
		return "RoomVO [rno=" + rno + ", isEmpty=" + (isEmpty > 0 ? "사용중" : "사용가능") + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", guest=" + guest + "]";
	}

	
}
