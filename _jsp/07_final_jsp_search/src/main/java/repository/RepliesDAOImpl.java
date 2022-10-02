package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.RepliesVO;
import orm.DataBaseBuilder;

public class RepliesDAOImpl implements RepliesDAO {
	private static Logger log = LoggerFactory.getLogger(RepliesDAOImpl.class);
	private static SqlSession sql;
	private final String NS = "RepliesMapper.";
	
	public RepliesDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(RepliesVO rvo) {
		int isUp = sql.insert(NS+"add", rvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<RepliesVO> selectList(int pno) {
		return sql.selectList(NS+"list", pno);
	}

	@Override
	public int update(RepliesVO rvo) {
		int isUp = sql.update(NS+"mod", rvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long rno) {
		int isUp = sql.delete(NS+"del", rno);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int deleteAll(int pno) {
		int isUp = sql.delete(NS+"delAll", pno);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
