package hotel;

import java.util.List;

public class HotelService implements Service{
	private DAO dao;
	
	public HotelService() {
		dao = new HotelDAO();
	}

	@Override
	public List<RoomVO> roomStatus() {
		return dao.select();
	}

	@Override
	public int checkIn(RoomVO roomInfo) {
		return dao.insertOrUpdate(roomInfo);
	}

	@Override
	public int checkOut(String rno) {
		return dao.update(rno);
	}

	@Override
	public RoomVO roomDetail(String rno) {
		return dao.selectOne(rno);
	}

}
