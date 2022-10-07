package com.corini.www.repository;

import java.util.List;

import com.corini.www.domain.BoardVO;

public interface BoardDAO {
	int insert(BoardVO bvo);
	List<BoardVO> selectList();
	BoardVO selectOne(long bno);
	int update(BoardVO bvo);
	int delete(long bno);
}
