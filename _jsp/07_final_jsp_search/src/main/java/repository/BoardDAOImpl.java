package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public int updateFile(long bno) {
		int isUp = sql.update(NS+"delFile", bno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public String selectFileName(long bno) {
		return sql.selectOne(NS+"fileName", bno);
	}

	@Override
	public int updateReadCount(long bno, int qty) {
		Map<String, Long> map = new HashMap<>();
		map.put("bno", bno);
		map.put("qty", (long) qty);
		int isUp = sql.update(NS+"rcUp", map);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<BoardVO> selectList(String keyword, String range) {
		Map<String, String> searchMap = new HashMap<>();
		searchMap.put("keyword", keyword);
		searchMap.put("range", range);
		return sql.selectList(NS+"seacrh", searchMap);
	}

}
