package com.myweb.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myweb.board.domain.BoardVO;
import com.myweb.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board/")
public class BoardController {

	@Autowired
	private BoardService bsv;
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno) {
		bsv.remove(bno);
		return "redirect:/board/list";
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO bvo) {
		bsv.modify(bvo);
		return "redirect:/board/detail?bno=" + bvo.getBno();
	}
	
	@GetMapping("/detail")
	public void detail(@RequestParam("bno") int bno, Model model) {
		model.addAttribute("bvo", bsv.getDetail(bno));
	}
	
	@GetMapping("/list")
	public void list(Model model) {
		model.addAttribute("list", bsv.getList());
	}
	
	@GetMapping("/register")
	public void register() {
	}
	
	@PostMapping("/register")
	public String register(BoardVO bvo) {
		bsv.register(bvo);
		return "redirect:/board/list";
	}
}
