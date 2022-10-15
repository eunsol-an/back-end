package com.myweb.board.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myweb.board.domain.entity.Board;

public interface BoardRepository extends CrudRepository<Board, Integer> {
	List<Board> findAllByOrderByBnoDesc();
}
