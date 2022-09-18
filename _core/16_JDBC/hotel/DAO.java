package hotel;

import java.util.List;

public interface DAO {
	List<RoomVO> select();
	RoomVO selectOne(String rno);
	int insertOrUpdate(RoomVO roomInfo);
	int update(String rno);
}
