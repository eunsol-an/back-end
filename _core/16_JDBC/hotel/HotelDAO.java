package hotel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements DAO {
	private Connection conn;
	private PreparedStatement pst;
	private String query;
	
	public HotelDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}

	@Override
	public List<RoomVO> select() {
		query = "select * from room";
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			List<RoomVO> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new RoomVO(
						rs.getString("rno"),
						rs.getInt("is_empty"),
						rs.getString("check_in_time"),
						rs.getString("check_out_time"),
						new GuestVO(
								rs.getString("guest_name"),
								rs.getString("guest_tel"),
								rs.getInt("guest_age"),
								rs.getInt("guest_gen")
								)
						));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RoomVO selectOne(String rno) {
		query = "select * from room where rno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, rno);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return new RoomVO(
						rs.getString("rno"),
						rs.getInt("is_empty"),
						rs.getString("check_in_time"),
						rs.getString("check_out_time"),
						new GuestVO(
								rs.getString("guest_name"),
								rs.getString("guest_tel"),
								rs.getInt("guest_age"),
								rs.getInt("guest_gen")
								)
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertOrUpdate(RoomVO roomInfo) {
		if (selectOne(roomInfo.getRno()) != null) {
			if (selectOne(roomInfo.getRno()).getIsEmpty() == 0) {
				query = "update room set is_empty=?, check_in_time=now(), check_out_time=null,"
						+ "guest_name=?, guest_tel=?, guest_age=?, guest_gen=? where rno=?";
				try {
					pst = conn.prepareStatement(query);
					pst.setInt(1, 1);
					pst.setString(2, roomInfo.getGuest().getName());
					pst.setString(3, roomInfo.getGuest().getTel());
					pst.setInt(4, roomInfo.getGuest().getAge());
					pst.setInt(5, roomInfo.getGuest().getGen());
					pst.setString(6, roomInfo.getRno());
					return pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(roomInfo.getRno() + "호는 사용중입니다.");
			}
		} else {
			query = "insert into room(rno, guest_name, guest_tel, guest_age, guest_gen, "
					+ "is_empty, check_out_time) values(?,?,?,?,?,?,?)";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, roomInfo.getRno());
				pst.setString(2, roomInfo.getGuest().getName());
				pst.setString(3, roomInfo.getGuest().getTel());
				pst.setInt(4, roomInfo.getGuest().getAge());
				pst.setInt(5, roomInfo.getGuest().getGen());
				pst.setInt(6, 1);
//				pst.setDate(7, new java.sql.Date(System.currentTimeMillis()));
				pst.setDate(7, null);
				return pst.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public int update(String rno) {
		if (selectOne(rno) != null) {
			if (selectOne(rno).getIsEmpty() == 1) {
				query = "update room set is_empty=?, check_out_time=now(),"
						+ "guest_name=?, guest_tel=?, guest_age=?, guest_gen=? where rno=?";
				try {
					pst = conn.prepareStatement(query);
					pst.setInt(1, 0);
					pst.setString(2, "");
					pst.setString(3, "");
					pst.setInt(4, 0);
					pst.setInt(5, -1);
					pst.setString(6, rno);
					return pst.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(rno + "호는 빈 방입니다.");
			}
		} else {
			System.out.println(rno + "호는 빈 방입니다.");
		}
		return 0;
	}

}
