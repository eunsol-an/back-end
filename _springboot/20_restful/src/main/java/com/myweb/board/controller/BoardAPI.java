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

import com.myweb.board.domain.BoardVO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class BoardAPI {

	@Autowired
	private BoardService bsv;
	
	@GetMapping("")
	public List<BoardVO> list() {
		return bsv.getList();
	}
	
	@PostMapping("/register")
	public void register(@RequestBody BoardVO bvo) {
		bsv.register(bvo);
	}
	
	@GetMapping("/{bno}")
	public BoardVO detail(@PathVariable("bno") int bno) {
		return bsv.getDetail(bno);
	}
	
	@PutMapping("/{bno}")
	public void modify(@RequestBody BoardVO bvo) {
		bsv.modify(bvo);
	}
	
	@PatchMapping("/{bno}")
	public void remove(@RequestBody BoardVO bvo) {
		bsv.modifyIsRemoved(bvo);
	}
}
