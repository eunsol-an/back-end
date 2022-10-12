package com.myweb.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.board.domain.BoardVO;
import com.myweb.board.repository.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper boardMapper;

	@Override
	public int register(BoardVO bvo) {
		return boardMapper.insert(bvo);
	}

	@Override
	public List<BoardVO> getList() {
		return boardMapper.selectList();
	}

	@Override
	public BoardVO getDetail(int bno) {
		return boardMapper.selectOne(bno);
	}

	@Override
	public int modify(BoardVO bvo) {
		return boardMapper.update(bvo);
	}

	@Override
	public int remove(int bno) {
		return boardMapper.delete(bno);
	}

}
