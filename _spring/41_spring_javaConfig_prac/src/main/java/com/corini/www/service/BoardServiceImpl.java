package com.corini.www.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.corini.www.domain.BoardVO;
import com.corini.www.repository.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO bdao;
	
	@Override
	public int write(BoardVO bvo) {
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
