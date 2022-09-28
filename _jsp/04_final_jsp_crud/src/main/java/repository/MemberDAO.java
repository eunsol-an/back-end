package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {

	int insert(MemberVO mvo);
	List<MemberVO> selectList();
	MemberVO selectOne(String email);
	int update(MemberVO mvo);
	int delete(String email);
	MemberVO selectOne(MemberVO mvo);
}
