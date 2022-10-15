package com.myweb.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myweb.board.domain.dto.BoardDTO;
import com.myweb.board.domain.entity.Board;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardAPI {

	@Autowired
	private BoardService bsv;
	
	// Read
	@GetMapping("")
	public List<Board> list() {
		return bsv.getList();
	}
	
	// Create
	@PostMapping("/register")
	public void register(@RequestBody Board board) {
		bsv.register(board);
	}
	
	// Read Detail
	@GetMapping("/{bno}")
	public Board detail(@PathVariable("bno") int bno) {
		return bsv.getDetail(bno);
	}
	
	// Update
	@PutMapping("/{bno}")
	public void modify(@RequestBody Board board) {
		bsv.modify(board);
	}
	
	// Delete
	@DeleteMapping("/{bno}")
	public void delete(@PathVariable("bno") int bno) {
		bsv.remove(bno);
	}
	
	@PatchMapping("/{bno}")
	public void remove(@RequestBody Board board) {
		bsv.modifyIsRemoved(board);
	}
}
