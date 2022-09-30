package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.RepliesVO;
import repository.RepliesDAO;
import repository.RepliesDAOImpl;

public class RepliesServiceImpl implements RepliesService {
	private static Logger log = LoggerFactory.getLogger(RepliesServiceImpl.class);
	private RepliesDAO rdao;
	
	public RepliesServiceImpl() {
		rdao = new RepliesDAOImpl();
	}

	@Override
	public int post(RepliesVO rvo) {
		return rdao.insert(rvo);
	}

	@Override
	public List<RepliesVO> getList(int pno) {
		return rdao.selectList(pno);
	}

	@Override
	public int modify(RepliesVO rvo) {
		return rdao.update(rvo);
	}

	@Override
	public int remove(long rno) {
		return rdao.delete(rno);
	}

	@Override
	public int removeAll(int pno) {
		return rdao.deleteAll(pno);
	}

}
