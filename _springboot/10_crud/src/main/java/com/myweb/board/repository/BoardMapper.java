package com.myweb.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myweb.board.domain.BoardVO;

@Mapper
public interface BoardMapper {
	int insert(BoardVO bvo);
	List<BoardVO> selectList();
	BoardVO selectOne(int bno);
	int update(BoardVO bvo);
	int delete(int bno);
}
