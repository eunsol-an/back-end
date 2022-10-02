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
		int isUp = bdao.updateReadCount(bno, 1);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isUp > 0 ? bdao.selectOne(bno) : null;
	}

	@Override
	public int modify(BoardVO bvo) {
		int isUp = bdao.updateReadCount(bvo.getBno(), -2);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return isUp > 0 ? bdao.update(bvo) : null;
	}

	@Override
	public int remove(long bno) {
		return bdao.delete(bno);
	}

	@Override
	public int removeFile(long bno) {
		return bdao.updateFile(bno);
	}

	@Override
	public String getImgFileName(long bno) {
		return bdao.selectFileName(bno);
	}

	@Override
	public List<BoardVO> search(String keyword, String range) {
		return bdao.selectList(keyword, range);
	}

}
