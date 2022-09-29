package repository;

import java.util.List;

import domain.RepliesVO;

public interface RepliesDAO {
	public int insert(RepliesVO rvo);
	public List<RepliesVO> selectList(int pno);
	public int update(RepliesVO rvo);
	public int delete(long rno);
	public int deleteAll(int pno);
}
