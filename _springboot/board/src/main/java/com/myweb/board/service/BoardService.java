package com.myweb.board.service;

import java.util.List;

import com.myweb.board.domain.entity.Board;

public interface BoardService {
	void register(Board board);
	List<Board> getList();
	Board getDetail(int bno);
	void modify(Board board);
	void remove(int bno);
	void modifyIsRemoved(Board board);
}
