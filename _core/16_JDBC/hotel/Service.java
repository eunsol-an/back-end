package hotel;

import java.util.List;

public interface Service {
	List<RoomVO> roomStatus();
	int checkIn(RoomVO roomInfo);
	int checkOut(String rno);
	RoomVO roomDetail(String rno);
}
