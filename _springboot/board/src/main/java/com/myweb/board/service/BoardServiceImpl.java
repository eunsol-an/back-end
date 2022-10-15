package com.myweb.board.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myweb.board.domain.entity.Board;
import com.myweb.board.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardRepository boardRepo;

	@Override
	public void register(Board board) {
		boardRepo.save(board);
	}

	@Override
	public List<Board> getList() {
		return boardRepo.findAllByOrderByBnoDesc();
	}

	@Override
	public Board getDetail(int bno) {
		Optional<Board> optional = boardRepo.findById(bno);
		if(optional.isPresent()) {
			Board board = optional.get();
			board.setReadcount(board.getReadcount() + 1);
			boardRepo.save(board);
			return board;
		}else {
			throw new NullPointerException();
		}
	}

	@Override
	public void modify(Board board) {
	}

	@Override
	public void remove(int bno) {
		boardRepo.deleteById(bno);
	}

	@Override
	public void modifyIsRemoved(Board board) {
	}

}
