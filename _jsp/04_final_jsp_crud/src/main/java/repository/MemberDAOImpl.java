package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImpl implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImpl.class);
	private SqlSession sql;
	private final String NS = "MemberMapper."; // NS = NAMESAPCE 내가 정한 공간 이름
	
	public MemberDAOImpl() { // 싱글톤 패턴
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int isUp = sql.insert(NS+"reg", mvo); // 첫번째 파라미터는 내가 실행시킬 쿼리의 주소값
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(NS+"list");
	}

	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(NS+"detail", email);
	}

	@Override
	public int update(MemberVO mvo) {
		int isUp = sql.update(NS+"mod", mvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(String email) {
		int isUp = sql.delete(NS+"del", email);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(NS+"login", mvo);
	}


}
