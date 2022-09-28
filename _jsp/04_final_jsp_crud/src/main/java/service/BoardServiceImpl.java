package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.BoardVO;
import repository.BoardDAO;
import repository.BoardDAOImpl;

public class BoardServiceImpl implements BoardService {
	private static Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	private BoardDAO bdao;
	
	public BoardServiceImpl() {
		bdao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO bvo) {
		return bdao.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		return bdao.selectList();
	}

	@Override
	public BoardVO getDetail(long bno) {
		return bdao.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		return bdao.update(bvo);
	}

	@Override
	public int remove(long bno) {
		return bdao.delete(bno);
	}

}
