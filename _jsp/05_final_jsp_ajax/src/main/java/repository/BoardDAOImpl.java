package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import orm.DataBaseBuilder;

public class BoardDAOImpl implements BoardDAO {
	private static Logger log = LoggerFactory.getLogger(BoardDAOImpl.class);
	private SqlSession sql;
	private final String NS = "BoardMapper.";

	public BoardDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	
	@Override
	public int insert(BoardVO bvo) {
		int isUp = sql.insert(NS+"reg", bvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<BoardVO> selectList() {
		return sql.selectList(NS+"list");
	}

	@Override
	public BoardVO selectOne(long bno) {
		return sql.selectOne(NS+"detail", bno);
	}

	@Override
	public int update(BoardVO bvo) {
		int isUp = sql.update(NS+"mod", bvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long bno) {
		int isUp = sql.delete(NS+"del", bno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
