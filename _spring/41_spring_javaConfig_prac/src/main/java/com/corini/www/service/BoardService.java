package com.corini.www.service;

import java.util.List;

import com.corini.www.domain.BoardVO;

public interface BoardService {
	int write(BoardVO bvo);
	List<BoardVO> getList();
	BoardVO getDetail(long bno);
	int modify(BoardVO bvo);
	int remove(long bno);
}
